package xyz.cafeconleche.web.thebride.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.thebride.dto.Persona;
import xyz.cafeconleche.web.thebride.hateoas.assemblers.TheBrideResourceAssembler;
import xyz.cafeconleche.web.thebride.hateoas.resources.TheBrideResourceSupport;
import xyz.cafeconleche.web.thebride.service.TheBrideResourceService;
import xyz.cafeconleche.web.thebride.service.TheBrideService;

@Service
public class TheBrideResourceServicePojoImpl implements TheBrideResourceService {

	@Autowired
	private TheBrideService theBrideService;
	@Autowired
	private TheBrideResourceAssembler theBrideResourceAssembler;

	@Override
	public List<TheBrideResourceSupport> list() {
		// service
		List<Persona> personas = theBrideService.list();
		// wrap
//		TheBrideResourceSupport resourceSupport = theBrideResourceAssembler.listToResource(personas);
//		return resourceSupport;
		
		List<TheBrideResourceSupport> resourcesSupport = theBrideResourceAssembler.toResources(personas);
		return resourcesSupport;
	}

	@Override
	public TheBrideResourceSupport getById(String id) {
		// service
		Persona persona = theBrideService.getById(id);
		// wrap
//		getById
		TheBrideResourceSupport resourceSupport = theBrideResourceAssembler.toResource(persona);
		return resourceSupport;
	}

	@Override
	public TheBrideResourceSupport add(Persona persona) {
		System.out.println("TheBrideResourceService: " + persona);
		// service
		persona = theBrideService.add(persona);
		// wrap
		TheBrideResourceSupport resourceSupport = theBrideResourceAssembler.toResource(persona);
		return resourceSupport;
	}

	@Override
	public TheBrideResourceSupport update(Persona persona) {
		System.out.println("TheBrideResourceService: " + persona);
		// service
		persona = theBrideService.update(persona);
		// wrap
		TheBrideResourceSupport resourceSupport = theBrideResourceAssembler.toResource(persona);
		return resourceSupport;
	}

	@Override
	public TheBrideResourceSupport delete(String id) {
		Persona persona = theBrideService.getById(id);
		persona = theBrideService.delete(persona);
		// wrap
		TheBrideResourceSupport resourceSupport = theBrideResourceAssembler.toResource(persona);
		return resourceSupport;
	}

	@Override
	public boolean isPersonaExist(String id, String name) {
		Persona exist = null;
		
		if (name != null) {
			exist = theBrideService.getByName(name);	
		}
		
		if (exist != null) {
			return true;
		} else if (id != null) {
			exist = theBrideService.getById(id.toString());
		}

		return exist == null ? false : true;
	}

}
