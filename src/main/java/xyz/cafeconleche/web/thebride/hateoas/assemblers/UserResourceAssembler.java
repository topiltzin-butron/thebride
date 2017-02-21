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
import xyz.cafeconleche.web.thebride.dto.User;
import xyz.cafeconleche.web.thebride.hateoas.resources.UserResourceSupport;

@Service
public class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResourceSupport>{

	public UserResourceAssembler() {
		super(SocialController.class, UserResourceSupport.class);
	}
	
	public UserResourceSupport toResource(List<User> users) {
		
		UserResourceSupport resourceSupport = new UserResourceSupport();
		resourceSupport.setUsers(users);
		
		Link addLink = ControllerLinkBuilder.linkTo(methodOn(SocialController.class).add(new User())).withRel("add");
		resourceSupport.add(addLink);
		
		return resourceSupport;
	}
	
	@Override
	public UserResourceSupport toResource(User user) {
		System.out.println("user: " + user);
		UserResourceSupport resourceSupport = createResourceWithId(user.getUsername(), user);
		resourceSupport.setUser(user);
		
		Link followingLink = ControllerLinkBuilder.linkTo(methodOn(FollowingController.class).list(user.getUsername())).withRel("following");
		resourceSupport.add(followingLink);
		
		Link followersLink = ControllerLinkBuilder.linkTo(methodOn(FollowerController.class).list(user.getUsername())).withRel("followers");
		resourceSupport.add(followersLink);
		
		Link userTimelineLink = ControllerLinkBuilder.linkTo(methodOn(TimelineController.class).list(user.getUsername(), "user")).withRel("userTimeline");
		resourceSupport.add(userTimelineLink);
		
		Link timelineLink = ControllerLinkBuilder.linkTo(methodOn(TimelineController.class).list(user.getUsername(), "time")).withRel("timeline");
		resourceSupport.add(timelineLink);
		
		return resourceSupport;
	}

}
