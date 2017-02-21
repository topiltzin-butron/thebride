package xyz.cafeconleche.web.thebride.service.impl;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.thebride.controller.rest.GreetingsController;
import xyz.cafeconleche.web.thebride.dto.Greeting;
import xyz.cafeconleche.web.thebride.hateoas.assemblers.GreetingResourceAssembler;
import xyz.cafeconleche.web.thebride.hateoas.resources.GreetingResourceSupport;
import xyz.cafeconleche.web.thebride.service.GreetingResourceService;

@Service
public class GreetingResourceServicePojoImpl implements GreetingResourceService {

	@Autowired
	private GreetingResourceAssembler greetingResourceAssembler;
	
	@Override
	public GreetingResourceSupport hello(String name) {
		
		// this from a service
		Greeting greeting = new Greeting();
		greeting.setId(1);
		greeting.setContent("Hola " + name);
		
		Link link = linkTo(methodOn(GreetingsController.class).greeting(name)).withSelfRel();
		GreetingResourceSupport resourceSupport = greetingResourceAssembler.toResource(greeting);
		resourceSupport.setGreeting(greeting);
		resourceSupport.add(link);
		
		return resourceSupport;
	}

}
