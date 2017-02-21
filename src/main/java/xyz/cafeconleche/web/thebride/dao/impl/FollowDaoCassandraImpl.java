package xyz.cafeconleche.web.thebride.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import xyz.cafeconleche.web.thebride.dao.FollowDao;

@Repository
public class FollowDaoCassandraImpl implements FollowDao {

	@Autowired
	private CassandraAdminOperations cassandraTemplate;
	
	@Override
	public List<String> getFollowing(String username) {
		
		Statement select = QueryBuilder.select("friend")
				.from("following")
				.where(QueryBuilder.eq("username", username));
		
		List<String> following = cassandraTemplate.select(select, String.class);
		return following;
	}

	@Override
	public List<String> getFollowers(String username) {
		Statement select = QueryBuilder.select("follower")
				.from("followers")
				.where(QueryBuilder.eq("username", username));
		
		List<String> following = cassandraTemplate.select(select, String.class);
		return following;
	}

}
