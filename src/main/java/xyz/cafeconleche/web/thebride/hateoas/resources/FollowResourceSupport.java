package xyz.cafeconleche.web.thebride.hateoas.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class FollowResourceSupport extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private List<String> following;
	@JsonInclude(Include.NON_NULL)
	private List<String> followers;

	public List<String> getFollowing() {
		return following;
	}

	public void setFollowing(List<String> following) {
		this.following = following;
	}

	public List<String> getFollowers() {
		return followers;
	}

	public void setFollowers(List<String> followers) {
		this.followers = followers;
	}

}
