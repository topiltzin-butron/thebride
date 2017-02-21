package xyz.cafeconleche.web.thebride.hateoas.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.thebride.controller.rest.FollowerController;
import xyz.cafeconleche.web.thebride.controller.rest.FollowingController;
import xyz.cafeconleche.web.thebride.controller.rest.PostController;
import xyz.cafeconleche.web.thebride.controller.rest.SocialController;
import xyz.cafeconleche.web.thebride.controller.rest.TimelineController;
import xyz.cafeconleche.web.thebride.dto.Post;
import xyz.cafeconleche.web.thebride.hateoas.resources.SocialResourceSupport;

@Service
public class SocialResourceAssembler extends ResourceAssemblerSupport<Post, SocialResourceSupport> {

	public SocialResourceAssembler() {
		super(SocialController.class, SocialResourceSupport.class);
	}
	
	public SocialResourceSupport toResource(String username, List<Post> posts, boolean isUserTimeline) {
		
		SocialResourceSupport resourceSupport = new SocialResourceSupport();
		if(isUserTimeline) {
			
			Link selfLink = ControllerLinkBuilder.linkTo(methodOn(TimelineController.class).list(username, "user")).withSelfRel();
			resourceSupport.setUserTimeline(posts);
			resourceSupport.add(selfLink);
			
		} else {
			Link selfLink = ControllerLinkBuilder.linkTo(methodOn(TimelineController.class).list(username, "time")).withSelfRel();
			resourceSupport.setTimeline(posts);
			resourceSupport.add(selfLink);
		}
		
		Link userLink = ControllerLinkBuilder.linkTo(methodOn(SocialController.class).get(username)).withRel("user");
		resourceSupport.add(userLink);
		
		Link followingLink = ControllerLinkBuilder.linkTo(methodOn(FollowingController.class).list(username)).withRel("following");
		resourceSupport.add(followingLink);
		
		Link followersLink = ControllerLinkBuilder.linkTo(methodOn(FollowerController.class).list(username)).withRel("followers");
		resourceSupport.add(followersLink);
		
		return resourceSupport;
	}
	
	@Override
	public SocialResourceSupport toResource(Post post) {

		SocialResourceSupport resourceSupport = new SocialResourceSupport();
		resourceSupport.setPost(post);
		
		Link selfLink = ControllerLinkBuilder.linkTo(methodOn(PostController.class).get(post.getUsername(), post.getPostId())).withSelfRel();
		resourceSupport.add(selfLink);
		
		Link userLink = ControllerLinkBuilder.linkTo(methodOn(SocialController.class).get(post.getUsername())).withRel("user");
		resourceSupport.add(userLink);
		
		Link userTimelineLink = ControllerLinkBuilder.linkTo(methodOn(TimelineController.class).list(post.getUsername(), "user")).withRel("userTimeline");
		resourceSupport.add(userTimelineLink);
		
		Link timelineLink = ControllerLinkBuilder.linkTo(methodOn(TimelineController.class).list(post.getUsername(), "time")).withRel("timeline");
		resourceSupport.add(timelineLink);
		
		return resourceSupport;
	}

}
