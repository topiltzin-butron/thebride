package xyz.cafeconleche.web.thebride.service;

import xyz.cafeconleche.web.thebride.dto.Post;
import xyz.cafeconleche.web.thebride.hateoas.resources.SocialResourceSupport;

public interface SocialResourceService {

	SocialResourceSupport getUserTimeline(String username);

	SocialResourceSupport getTimeline(String username);
	
	SocialResourceSupport add(Post post);

	SocialResourceSupport get(Post post);

	SocialResourceSupport update(Post post);
	
	SocialResourceSupport delete(Post post);
	
}
