package xyz.cafeconleche.web.thebride.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.cafeconleche.web.thebride.hateoas.resources.SocialResourceSupport;
import xyz.cafeconleche.web.thebride.service.SocialResourceService;

@RestController
@RequestMapping("/{username}/timeline")
public class TimelineController {

	@Autowired
	private SocialResourceService socialResourceService;
	
	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	public ResponseEntity<SocialResourceSupport> list(
			@PathVariable String username, 
			@RequestParam String source) {
	
		if("user".equals(source)) {
			SocialResourceSupport resourceSupport = socialResourceService.getUserTimeline(username);
			
			System.out.println("resourceSupport.getUserTimeline(): " + resourceSupport.getUserTimeline());
			
			if(resourceSupport.getUserTimeline() == null) {
				System.out.println("no user timeline for: " + username);
			}
			
			return new ResponseEntity<>(resourceSupport, HttpStatus.OK);
		} else if("time".equals(source)) {
			SocialResourceSupport resourceSupport = socialResourceService.getTimeline(username);
			
			System.out.println("resourceSupport.getTimeline(): " + resourceSupport.getTimeline());
			
			if(resourceSupport.getTimeline() == null) {
				System.out.println("no timeline for: " + username);
			}
			
			return new ResponseEntity<>(resourceSupport, HttpStatus.OK);
		} 
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
