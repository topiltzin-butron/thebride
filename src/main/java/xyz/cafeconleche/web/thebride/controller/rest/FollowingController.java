package xyz.cafeconleche.web.thebride.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.cafeconleche.web.thebride.hateoas.resources.FollowResourceSupport;
import xyz.cafeconleche.web.thebride.service.FollowResourceService;

@RestController
@RequestMapping("/{username}/following")
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class FollowingController {

	@Autowired
	private FollowResourceService followingResourceService;
	
	@RequestMapping(value={"", "/"}, method=RequestMethod.GET)
	public ResponseEntity<FollowResourceSupport> list(@PathVariable String username) {
		
		FollowResourceSupport resourceSupport = followingResourceService.getFollowing(username);
		
		if(resourceSupport == null){
			return new ResponseEntity<FollowResourceSupport>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<FollowResourceSupport>(resourceSupport, HttpStatus.OK);
	}
	
}
