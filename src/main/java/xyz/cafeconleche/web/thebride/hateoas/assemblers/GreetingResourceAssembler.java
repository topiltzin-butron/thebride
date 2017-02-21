package xyz.cafeconleche.web.thebride.hateoas.assemblers;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.thebride.controller.rest.GreetingsController;
import xyz.cafeconleche.web.thebride.dto.Greeting;
import xyz.cafeconleche.web.thebride.hateoas.resources.GreetingResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Service
public class GreetingResourceAssembler extends ResourceAssemblerSupport<Greeting, GreetingResourceSupport> {

	public GreetingResourceAssembler() {
		super(GreetingsController.class, GreetingResourceSupport.class);
	}

	@Override
	public GreetingResourceSupport toResource(Greeting greeting) {
		 
		GreetingResourceSupport resourceSupport = new GreetingResourceSupport();
		resourceSupport.setGreeting(greeting);
//		ControllerLinkBuilder greetingLink = ControllerLinkBuilder.linkTo(methodOn(GreetingsController.class).greeting(greeting.getContent());
		

//		resourceSupport.add(greetingLink);
		
		return resourceSupport;
	}	
	
}
