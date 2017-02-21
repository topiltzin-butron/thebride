package xyz.cafeconleche.web.thebride.controller.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.cafeconleche.web.thebride.hateoas.resources.HalResourceSupport;

@RestController
@RequestMapping("/halDefinitions")
@EnableHypermediaSupport(type = { HypermediaType.HAL })
public class HalDefinitionController {

	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public ResponseEntity<HalResourceSupport> get() {

		HalResourceSupport halResourceSupport = new HalResourceSupport();
		halResourceSupport.setMessage("Welcome to the HAL browser");
		
		Link greetingsLink = ControllerLinkBuilder.linkTo(methodOn(GreetingsController.class).greeting("World")).withRel("greeting");
		Link personasLink = ControllerLinkBuilder.linkTo(methodOn(TheBrideController.class).list()).withRel("theBride");
		Link socialUsersLink = ControllerLinkBuilder.linkTo(methodOn(SocialController.class).list()).withRel("socialUsers");

		halResourceSupport.add(greetingsLink);
		halResourceSupport.add(personasLink);
		halResourceSupport.add(socialUsersLink);
		
		return new ResponseEntity<HalResourceSupport>(halResourceSupport, HttpStatus.OK);
	}
	
}
