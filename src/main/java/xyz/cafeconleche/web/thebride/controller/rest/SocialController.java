package xyz.cafeconleche.web.thebride.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.cafeconleche.web.thebride.dto.User;
import xyz.cafeconleche.web.thebride.hateoas.resources.UserResourceSupport;
import xyz.cafeconleche.web.thebride.service.UserResourceService;

@RestController
@RequestMapping("/users")
@EnableHypermediaSupport(type = { HypermediaType.HAL })
public class SocialController {

	@Autowired
	private UserResourceService userResourceService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<UserResourceSupport> list() {

		UserResourceSupport resourceSupport = userResourceService.list();
		if (resourceSupport == null || resourceSupport.getUsers() == null) {
			return new ResponseEntity<UserResourceSupport>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<UserResourceSupport>(resourceSupport, HttpStatus.OK);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public ResponseEntity<UserResourceSupport> get(@PathVariable String username) {

		System.out.println("username: " + username);
		UserResourceSupport resourceSupport = userResourceService.getByUsername(username);
		if (resourceSupport == null || resourceSupport.getUser() == null) {
			return new ResponseEntity<UserResourceSupport>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<UserResourceSupport>(resourceSupport, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserResourceSupport> add(@RequestBody User user) {

		boolean exist = userResourceService.isUserExist(user.getUsername());
		if (exist) {
			return new ResponseEntity<UserResourceSupport>(HttpStatus.CONFLICT);
		}

		UserResourceSupport resourceSupport = userResourceService.add(user);
		return new ResponseEntity<UserResourceSupport>(resourceSupport, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.PUT)
	public ResponseEntity<UserResourceSupport> update(@PathVariable String username, @RequestBody User user) {

		boolean exist = userResourceService.isUserExist(username);
		if (!exist) {
			return new ResponseEntity<UserResourceSupport>(HttpStatus.NOT_FOUND);
		}

		user.setUsername(username);

		UserResourceSupport resourceSupport = userResourceService.update(user);
		return new ResponseEntity<UserResourceSupport>(resourceSupport, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
	public ResponseEntity<UserResourceSupport> delete(@PathVariable String username) {
		boolean exist = userResourceService.isUserExist(username);
		if (!exist) {
			return new ResponseEntity<UserResourceSupport>(HttpStatus.NOT_FOUND);
		}

		UserResourceSupport resourceSupport = userResourceService.delete(username);
		return new ResponseEntity<UserResourceSupport>(resourceSupport, HttpStatus.NO_CONTENT);
	}

}
