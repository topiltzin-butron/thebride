package xyz.cafeconleche.web.thebride.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.thebride.hateoas.assemblers.FollowResourceAssembler;
import xyz.cafeconleche.web.thebride.hateoas.resources.FollowResourceSupport;
import xyz.cafeconleche.web.thebride.service.FollowResourceService;
import xyz.cafeconleche.web.thebride.service.FollowService;

@Service
public class FollowingResourceServicePojoImpl implements FollowResourceService {

	@Autowired
	private FollowService followingService;
	@Autowired
	private FollowResourceAssembler resourceAssembler;
	
	@Override
	public FollowResourceSupport getFollowing(String username) {
		
		List<String> following = followingService.getFollowing(username);
		
		FollowResourceSupport resourceSupport = resourceAssembler.toResources(username, following, true); 
		return resourceSupport;
	}

	@Override
	public FollowResourceSupport getFollowers(String username) {
		List<String> followers = followingService.getFollowers(username);
		
		FollowResourceSupport resourceSupport = resourceAssembler.toResources(username, followers, false); 
		return resourceSupport;
	}
	
	

}
