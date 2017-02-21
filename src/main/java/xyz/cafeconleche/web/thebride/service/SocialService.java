package xyz.cafeconleche.web.thebride.service;

import java.util.List;

import xyz.cafeconleche.web.thebride.dto.Post;

public interface SocialService {

	List<Post> getUserTimeline(String username);

	List<Post> getTimeline(String username);
	
	Post add(Post post);

	Post get(Post post);

	Post update(Post post);
	
	Post delete(Post post);
	
}
