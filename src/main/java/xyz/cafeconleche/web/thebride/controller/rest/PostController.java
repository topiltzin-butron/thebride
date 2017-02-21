package xyz.cafeconleche.web.thebride.controller.rest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.cafeconleche.web.thebride.dto.Post;
import xyz.cafeconleche.web.thebride.hateoas.resources.SocialResourceSupport;
import xyz.cafeconleche.web.thebride.service.SocialResourceService;

@RestController
@RequestMapping("/{username}/post")
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class PostController {

	@Autowired
	private SocialResourceService socialResourceService;
	
	@RequestMapping(value = "/{postId}", method = RequestMethod.GET)
	public ResponseEntity<SocialResourceSupport> get(
			@PathVariable String username, 
			@PathVariable UUID postId) {

		Post post = new Post();
		post.setUsername(username);
		post.setPostId(postId);
		
		SocialResourceSupport resourceSupport = socialResourceService.get(post);
		return new ResponseEntity<>(resourceSupport, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
	public ResponseEntity<SocialResourceSupport> add(
			@PathVariable String username, 
			@RequestBody String body) {

		Post post = new Post();
		post.setUsername(username);
		post.setBody(body);
		
		SocialResourceSupport resourceSupport = socialResourceService.add(post);
		return new ResponseEntity<>(resourceSupport, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{postId}", method = RequestMethod.PUT)
	public ResponseEntity<SocialResourceSupport> update(
			@PathVariable String username,
			@PathVariable UUID postId,
			@RequestBody String body) {

		Post post = new Post();
		post.setPostId(postId);
		post.setUsername(username);
		post.setBody(body);
		
		SocialResourceSupport resourceSupport = socialResourceService.update(post);
		return new ResponseEntity<>(resourceSupport, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
	public ResponseEntity<SocialResourceSupport> delete(
			@PathVariable String username,
			@PathVariable UUID postId) {

		Post post = new Post();
		post.setPostId(postId);
		post.setUsername(username);
		
		SocialResourceSupport resourceSupport = socialResourceService.delete(post);
		return new ResponseEntity<>(resourceSupport, HttpStatus.NO_CONTENT);
	}
	
}
