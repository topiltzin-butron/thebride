package xyz.cafeconleche.web.thebride.dao.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.utils.UUIDs;

import xyz.cafeconleche.web.thebride.dao.FollowDao;
import xyz.cafeconleche.web.thebride.dao.SocialDao;
import xyz.cafeconleche.web.thebride.dto.Post;
import xyz.cafeconleche.web.thebride.dto.Timeline;
import xyz.cafeconleche.web.thebride.dto.UserTimeline;

@Repository
public class SocialDaoCassandraImpl implements SocialDao {

	@Autowired
	private CassandraAdminOperations cassandraTemplate;
	
	@Autowired
	private FollowDao followDao;

	@Override
	public List<Post> getUserTimeline(String username) {
		
		Statement select = QueryBuilder.select()
				.from("user_timeline")
				.where(QueryBuilder.eq("username", username));

		List<UserTimeline> timelineItems = cassandraTemplate.select(select, UserTimeline.class);

		List<UUID> postIds = timelineItems.stream().map(item -> item.getPostId()).collect(Collectors.toList());

		List<Post> posts = getPosts(username, postIds);

		return posts;
	}

	@Override
	public List<Post> getTimeline(String username) {
		
		List<String> following = followDao.getFollowing(username);
		
		Statement select = QueryBuilder.select()
				.from("timeline")
				.where(QueryBuilder.in("username", following));

		List<Timeline> timelineItems = cassandraTemplate.select(select, Timeline.class);
		List<UUID> postIds = timelineItems.stream().map(item -> item.getPostId()).collect(Collectors.toList());

		List<Post> posts = getPosts(username, postIds);

		return posts;
	}

	private List<Post> getPosts(String username, List<UUID> postIds) {

		Statement select = QueryBuilder.select()
				.from("posts")
				.where(QueryBuilder.in("post_id", postIds));

		List<Post> posts = cassandraTemplate.select(select, Post.class);

		return posts;
	}

	private UserTimeline addPostUserTimeline(final Post post) {
		UserTimeline userTimeline = new UserTimeline();
		userTimeline.setUsername(post.getUsername());
		userTimeline.setTime(UUIDs.timeBased());
		userTimeline.setPostId(post.getPostId());
		userTimeline = cassandraTemplate.insert(userTimeline);
		return userTimeline;
	}
	
	private Timeline addPostTimeline(final Post post) {
		Timeline timeline = new Timeline();
		timeline.setUsername(post.getUsername());
		timeline.setTime(UUIDs.timeBased());
		timeline.setPostId(post.getPostId());
		timeline = cassandraTemplate.insert(timeline);
		return timeline;
	}
	
	@Override
	public Post add(Post post) {
		
		post.setPostId(UUID.randomUUID());
		post = cassandraTemplate.insert(post);
		
		// add to user timeline
		addPostUserTimeline(post);
		
		// add to timeline
		addPostTimeline(post);
		
		return post;
	}
	
	@Override
	public Post get(Post post) {
		
		Statement select = QueryBuilder.select()
				.from("posts")
				.where(QueryBuilder.eq("post_id", post.getPostId()));
		
		Post temp = cassandraTemplate.selectOne(select, Post.class);
		
		if (temp != null && post.getUsername() != null) {
			
			if (!post.getUsername().equals(temp.getUsername())) {
				return null;
			}
			
		}
		
		return temp;
	}

	@Override
	public Post update(Post post) {

		Post temp = get(post);
		
		if (temp == null ) {
			
			System.out.println("post doesn't exist: " + post.getPostId());
			return null;
		}
		
		if (!post.getUsername().equals(temp.getUsername())) {
			
			System.out.println("post: " + post.getPostId() + " doesn't belong to: " + post.getUsername());
			return null;
		}
		
		post = cassandraTemplate.update(post);
		
		return post;
	}
	
	@Override
	public Post delete(Post post) {
		
		Post temp = get(post);
		
		if (temp == null ) {
			
			System.out.println("post doesn't exist: " + post.getPostId());
			return null;
		}
		
		if (!post.getUsername().equals(temp.getUsername())) {
			
			System.out.println("post: " + post.getPostId() + " doesn't belong to: " + post.getUsername());
			return null;
		}
		
		post = cassandraTemplate.delete(post);
		return post;
	}

}
