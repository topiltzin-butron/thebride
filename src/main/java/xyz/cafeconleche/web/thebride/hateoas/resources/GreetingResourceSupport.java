package xyz.cafeconleche.web.thebride.hateoas.resources;

import org.springframework.hateoas.ResourceSupport;

import xyz.cafeconleche.web.thebride.dto.Greeting;

public class GreetingResourceSupport extends ResourceSupport {

	private Greeting greeting;

	public Greeting getGreeting() {
		return greeting;
	}

	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}

}
