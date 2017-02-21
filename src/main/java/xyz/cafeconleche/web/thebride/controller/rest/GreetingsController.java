package xyz.cafeconleche.web.thebride.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import xyz.cafeconleche.web.thebride.dto.Greeting;
import xyz.cafeconleche.web.thebride.hateoas.assemblers.GreetingResourceAssembler;
import xyz.cafeconleche.web.thebride.hateoas.resources.GreetingResourceSupport;
import xyz.cafeconleche.web.thebride.service.GreetingResourceService;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@ExposesResourceFor(Greeting.class)
@RestController("greetingsRestController")
public class GreetingsController {
	
//	@Autowired
//	private GreetingResourceAssembler assembler;
	
	@Autowired
	private GreetingResourceService greetingResourceService;
	
	
//	@RequestMapping("/greeting")
//	public @ResponseBody Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
//		
//		System.out.println("greeting");
//		
//		Greeting greeting = new Greeting();
//		greeting.setId(1);
//		greeting.setContent("Hello " + name);
//		
//		return greeting;
//	}
	
	@RequestMapping("/greeting")
	public GreetingResourceSupport greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name){
		
//		Greeting greeting = new Greeting();
//		greeting.setId(1);
//		greeting.setContent("Hello " + name);
//		
//		Link link = linkTo(methodOn(GreetingsController.class).greeting(name)).withSelfRel();
//		GreetingResourceSupport resourceSupport = assembler.toResource(greeting);
//		resourceSupport.add(link);
		GreetingResourceSupport resourceSupport = greetingResourceService.hello(name);
		
		return resourceSupport;
	}

}
