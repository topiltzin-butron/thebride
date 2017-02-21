package xyz.cafeconleche.web.thebride.hateoas.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.TemplateVariable;
import org.springframework.hateoas.TemplateVariables;
import org.springframework.hateoas.UriTemplate;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.thebride.controller.rest.TheBrideController;
import xyz.cafeconleche.web.thebride.dto.Persona;
import xyz.cafeconleche.web.thebride.hateoas.resources.TheBrideResourceSupport;

@Service
public class TheBrideResourceAssembler extends ResourceAssemblerSupport<Persona, TheBrideResourceSupport> {

	public TheBrideResourceAssembler() {
		super(TheBrideController.class, TheBrideResourceSupport.class);
	}

	@Override
	public TheBrideResourceSupport toResource(Persona persona) {
		
		System.out.println("=== persona");
		
		if (persona != null) {
			
			TheBrideResourceSupport resourceSupport = createResourceWithId(persona.getId(), persona);
			
			Link addLink = ControllerLinkBuilder.linkTo(methodOn(TheBrideController.class).add(persona)).withRel("add");
			Link updateLink = ControllerLinkBuilder.linkTo(methodOn(TheBrideController.class).update(persona.getId().toString(), persona)).withRel("update");
			Link deleteLink = ControllerLinkBuilder.linkTo(methodOn(TheBrideController.class).delete(persona.getId().toString())).withRel("delete");
			
			resourceSupport.add(addLink);
			resourceSupport.add(updateLink);
			resourceSupport.add(deleteLink);
			
			resourceSupport.setPersona(persona);

			// templated
			String baseUri = ControllerLinkBuilder.linkTo(methodOn(TheBrideController.class).list()).toUriComponentsBuilder().build().toString();
			TemplateVariable idTemplateVariable = new TemplateVariable("id", TemplateVariable.VariableType.SEGMENT);
			TemplateVariables variables = new TemplateVariables(idTemplateVariable);
			UriTemplate uriTemplate =  new UriTemplate(baseUri, variables);
			
			Link link = new Link(uriTemplate, "templated");
			resourceSupport.add(link);

			return resourceSupport;
		}
		return null;
	}
	
}
