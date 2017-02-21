package xyz.cafeconleche.web.thebride.hateoas.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.thebride.controller.rest.FollowerController;
import xyz.cafeconleche.web.thebride.controller.rest.FollowingController;
import xyz.cafeconleche.web.thebride.controller.rest.SocialController;
import xyz.cafeconleche.web.thebride.controller.rest.TimelineController;
import xyz.cafeconleche.web.thebride.hateoas.resources.FollowResourceSupport;

@Service
public class FollowResourceAssembler extends ResourceAssemblerSupport<String, FollowResourceSupport>{

	public FollowResourceAssembler() {
		super(SocialController.class, FollowResourceSupport.class);
	}
	
	public FollowResourceSupport toResources(String username, List<String> entities, boolean isFollowing) {
		FollowResourceSupport resourceSupport = new FollowResourceSupport();
		if(isFollowing) { 
			
			Link selfLink = ControllerLinkBuilder.linkTo(methodOn(FollowingController.class).list(username)).withRel("self");
			Link followerLink = ControllerLinkBuilder.linkTo(methodOn(FollowerController.class).list(username)).withRel("followers");
			
			resourceSupport.setFollowing(entities);
			resourceSupport.add(selfLink);
			resourceSupport.add(followerLink);
			
		} else {
			Link selfLink = ControllerLinkBuilder.linkTo(methodOn(FollowerController.class).list(username)).withRel("self");
			Link followingLink = ControllerLinkBuilder.linkTo(methodOn(FollowingController.class).list(username)).withRel("following");

			resourceSupport.setFollowers(entities);
			resourceSupport.add(selfLink);
			resourceSupport.add(followingLink);
		}
		
		Link userLink = ControllerLinkBuilder.linkTo(methodOn(SocialController.class).get(username)).withRel("user");
		resourceSupport.add(userLink);
		

		Link userTimelineLink = ControllerLinkBuilder.linkTo(methodOn(TimelineController.class).list(username, "user")).withRel("userTimeline");
		resourceSupport.add(userTimelineLink);
		
		Link timelineLink = ControllerLinkBuilder.linkTo(methodOn(TimelineController.class).list(username, "time")).withRel("timeline");
		resourceSupport.add(timelineLink);

		return resourceSupport;
	}

	@Override
	public FollowResourceSupport toResource(String entity) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
