package xyz.cafeconleche.web.thebride.service;

import xyz.cafeconleche.web.thebride.hateoas.resources.GreetingResourceSupport;

public interface GreetingResourceService {

	GreetingResourceSupport hello(String name);
	
}
