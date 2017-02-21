package xyz.cafeconleche.web.thebride.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.thebride.dto.Post;
import xyz.cafeconleche.web.thebride.hateoas.assemblers.SocialResourceAssembler;
import xyz.cafeconleche.web.thebride.hateoas.resources.SocialResourceSupport;
import xyz.cafeconleche.web.thebride.service.SocialResourceService;
import xyz.cafeconleche.web.thebride.service.SocialService;

@Service
public class SocialResourceServicePojoImpl implements SocialResourceService {

	@Autowired
	private SocialService socialService;
	@Autowired
	private SocialResourceAssembler socialResourceAssembler;

	@Override
	public SocialResourceSupport getUserTimeline(String username) {
		List<Post> posts = socialService.getUserTimeline(username);

		SocialResourceSupport resourceSupport = socialResourceAssembler.toResource(username, posts, true);
		return resourceSupport;
	}

	@Override
	public SocialResourceSupport getTimeline(String username) {
		List<Post> posts = socialService.getTimeline(username);
		SocialResourceSupport resourceSupport = socialResourceAssembler.toResource(username, posts, false);
		return resourceSupport;
	}

	@Override
	public SocialResourceSupport add(Post post) {
		
		post = socialService.add(post);
		SocialResourceSupport resourceSupport = socialResourceAssembler.toResource(post);
		
		return resourceSupport;
	}

	@Override
	public SocialResourceSupport get(Post post) {
		post = socialService.get(post);
		
		SocialResourceSupport resourceSupport = socialResourceAssembler.toResource(post);
		return resourceSupport;
	}

	@Override
	public SocialResourceSupport update(Post post) {
		post = socialService.update(post);
		
		if(post != null){
			SocialResourceSupport resourceSupport = socialResourceAssembler.toResource(post);
			return resourceSupport;			
		}
		
		return null;
	}

	@Override
	public SocialResourceSupport delete(Post post) {
		post = socialService.delete(post);
		
		if(post != null){
			SocialResourceSupport resourceSupport = socialResourceAssembler.toResource(post);
			return resourceSupport;			
		}
		
		return null;
	}

}
