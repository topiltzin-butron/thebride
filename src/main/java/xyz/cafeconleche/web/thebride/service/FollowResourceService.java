package xyz.cafeconleche.web.thebride.service;

import xyz.cafeconleche.web.thebride.hateoas.resources.FollowResourceSupport;

public interface FollowResourceService {

	FollowResourceSupport getFollowing(String username);
	
	FollowResourceSupport getFollowers(String username);
	
}
