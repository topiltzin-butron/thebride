package xyz.cafeconleche.web.thebride.service;

import java.util.List;

import xyz.cafeconleche.web.thebride.dto.Persona;
import xyz.cafeconleche.web.thebride.hateoas.resources.TheBrideResourceSupport;

public interface TheBrideResourceService {

	List<TheBrideResourceSupport> list();

	TheBrideResourceSupport getById(String id);
	
	boolean isPersonaExist(String id, String name);
	
	TheBrideResourceSupport add(Persona persona);
	
	TheBrideResourceSupport update(Persona persona);
	
	TheBrideResourceSupport delete(String id);
	
}
