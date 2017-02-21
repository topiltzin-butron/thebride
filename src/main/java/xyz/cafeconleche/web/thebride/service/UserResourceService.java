package xyz.cafeconleche.web.thebride.service;

import xyz.cafeconleche.web.thebride.dto.User;
import xyz.cafeconleche.web.thebride.hateoas.resources.UserResourceSupport;

public interface UserResourceService {

	UserResourceSupport list();

	UserResourceSupport getByUsername(String username);
	
	boolean isUserExist(String username);
	
	UserResourceSupport add(User user);
	
	UserResourceSupport update(User user);
	
	UserResourceSupport delete(String username);
	
}
