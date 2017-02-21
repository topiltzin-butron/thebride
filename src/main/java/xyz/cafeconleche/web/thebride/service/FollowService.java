package xyz.cafeconleche.web.thebride.service;

import java.util.List;

public interface FollowService {

	List<String> getFollowing(String username);

	List<String> getFollowers(String username);
	
}
