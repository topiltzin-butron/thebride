package xyz.cafeconleche.web.thebride.dao;

import java.util.List;

public interface FollowDao {

	List<String> getFollowing(String username);

	List<String> getFollowers(String username); 
	
}
