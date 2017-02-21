package xyz.cafeconleche.web.thebride.hateoas.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import xyz.cafeconleche.web.thebride.dto.User;

public class UserResourceSupport extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private List<User> users;
	@JsonInclude(Include.NON_NULL)
	private User user;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
