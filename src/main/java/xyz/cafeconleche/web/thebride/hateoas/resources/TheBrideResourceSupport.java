package xyz.cafeconleche.web.thebride.hateoas.resources;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import xyz.cafeconleche.web.thebride.dto.Persona;

public class TheBrideResourceSupport extends ResourceSupport {
	
	@JsonInclude(Include.NON_NULL)
	private Persona persona;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
