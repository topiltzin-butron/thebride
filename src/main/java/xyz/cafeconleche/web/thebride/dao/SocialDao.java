package xyz.cafeconleche.web.thebride.dao;

import java.util.List;

import xyz.cafeconleche.web.thebride.dto.Post;

public interface SocialDao {

	List<Post> getUserTimeline(String username);
	
	List<Post> getTimeline(String username);
	
	Post add(Post post);

	Post get(Post post);

	Post update(Post post);
	
	Post delete(Post post);
	
}
