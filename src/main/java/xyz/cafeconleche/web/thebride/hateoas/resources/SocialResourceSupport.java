package xyz.cafeconleche.web.thebride.hateoas.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import xyz.cafeconleche.web.thebride.dto.Post;

public class SocialResourceSupport extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private List<Post> userTimeline;

	@JsonInclude(Include.NON_NULL)
	private List<Post> timeline;

	@JsonInclude(Include.NON_NULL)
	private Post post;

	public List<Post> getUserTimeline() {
		return userTimeline;
	}

	public void setUserTimeline(List<Post> userTimeline) {
		this.userTimeline = userTimeline;
	}

	public List<Post> getTimeline() {
		return timeline;
	}

	public void setTimeline(List<Post> timeline) {
		this.timeline = timeline;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
