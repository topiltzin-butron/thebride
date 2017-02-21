package xyz.cafeconleche.web.thebride.hateoas.resources;

import org.springframework.hateoas.ResourceSupport;

public class HalResourceSupport extends ResourceSupport {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
