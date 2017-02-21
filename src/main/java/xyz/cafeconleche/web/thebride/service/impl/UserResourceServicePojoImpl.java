package xyz.cafeconleche.web.thebride.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.thebride.dto.User;
import xyz.cafeconleche.web.thebride.hateoas.assemblers.UserResourceAssembler;
import xyz.cafeconleche.web.thebride.hateoas.resources.UserResourceSupport;
import xyz.cafeconleche.web.thebride.service.UserResourceService;
import xyz.cafeconleche.web.thebride.service.UserService;

@Service
public class UserResourceServicePojoImpl implements UserResourceService {

	@Autowired
	private UserService userService;
	@Autowired
	private UserResourceAssembler userResourceAssembler;

	@Override
	public UserResourceSupport list() {
		List<User> users = userService.list();

		UserResourceSupport userResourceSupport = userResourceAssembler.toResource(users);
		return userResourceSupport;
	}

	@Override
	public UserResourceSupport getByUsername(String username) {
		User user = userService.getByUserName(username);
		UserResourceSupport userResourceSupport = getUserResourceSupport(user);
		return userResourceSupport;
	}

	@Override
	public boolean isUserExist(String username) {
		User user = userService.getByUserName(username);
		if (user != null) {
			return true;
		}
		return false;
	}

	@Override
	public UserResourceSupport add(User user) {
		user = userService.add(user);
		UserResourceSupport userResourceSupport = getUserResourceSupport(user);
		return userResourceSupport;
	}

	@Override
	public UserResourceSupport update(User user) {
		user = userService.update(user);
		UserResourceSupport userResourceSupport = getUserResourceSupport(user);
		return userResourceSupport;
	}

	@Override
	public UserResourceSupport delete(String username) {
		User user = userService.getByUserName(username);
		if (user == null) {
			return null;
		}
		UserResourceSupport userResourceSupport = getUserResourceSupport(user);
		return userResourceSupport;
	}

	private UserResourceSupport getUserResourceSupport(User user) {
		return userResourceAssembler.toResource(user);
	}

}
