package xyz.cafeconleche.web.thebride.controller.rest;

import java.util.List;
import java.util.UUID;

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

import xyz.cafeconleche.web.thebride.dto.Persona;
import xyz.cafeconleche.web.thebride.hateoas.resources.TheBrideResourceSupport;
import xyz.cafeconleche.web.thebride.service.TheBrideResourceService;

@RestController
@RequestMapping("/thebride/persona")
@EnableHypermediaSupport(type = { HypermediaType.HAL })
public class TheBrideController {

	@Autowired
	private TheBrideResourceService theBrideResourceService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<List<TheBrideResourceSupport>> list() {

		List<TheBrideResourceSupport> resourcesSupport = theBrideResourceService.list();

		if (resourcesSupport == null) {
			return new ResponseEntity<List<TheBrideResourceSupport>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<TheBrideResourceSupport>>(resourcesSupport, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TheBrideResourceSupport> getById(@PathVariable("id") String id) {

		TheBrideResourceSupport resourceSupport = theBrideResourceService.getById(id);
		if (resourceSupport == null || resourceSupport.getPersona() == null) {
			return new ResponseEntity<TheBrideResourceSupport>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TheBrideResourceSupport>(resourceSupport, HttpStatus.OK);
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.POST)
	public ResponseEntity<TheBrideResourceSupport> add(@RequestBody Persona persona) {

		System.out.println(persona);

		String id = persona.getId() == null ? null : persona.getId().toString();
		boolean personaExist = theBrideResourceService.isPersonaExist(id, persona.getName());
		if (personaExist) {
			return new ResponseEntity<TheBrideResourceSupport>(HttpStatus.CONFLICT);
		}

		TheBrideResourceSupport resourceSupport = theBrideResourceService.add(persona);
		return new ResponseEntity<TheBrideResourceSupport>(resourceSupport, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TheBrideResourceSupport> update(@PathVariable("id") String id, @RequestBody Persona persona) {

		System.out.println("____ update ____ id: " + id + " persona: " + persona);
		
		// sets the right id, not needed on the body
		persona.setId(UUID.fromString(id));

		System.out.println(persona);
		boolean personaExist = theBrideResourceService.isPersonaExist(id, persona.getName());
		
		System.out.println("personaExist? " + personaExist);
		if (!personaExist) {
			return new ResponseEntity<TheBrideResourceSupport>(HttpStatus.NOT_FOUND);
		}

		TheBrideResourceSupport resourceSupport = theBrideResourceService.update(persona);
		return new ResponseEntity<TheBrideResourceSupport>(resourceSupport, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TheBrideResourceSupport> delete(@PathVariable("id") String id) {

		boolean personaExist = theBrideResourceService.isPersonaExist(id, null);
		if (!personaExist) {
			return new ResponseEntity<TheBrideResourceSupport>(HttpStatus.NOT_FOUND);
		}

		TheBrideResourceSupport resourceSupport = theBrideResourceService.delete(id);

		return new ResponseEntity<TheBrideResourceSupport>(resourceSupport, HttpStatus.NO_CONTENT);
	}

}
