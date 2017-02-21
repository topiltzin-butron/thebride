package xyz.cafeconleche.web.thebride.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import xyz.cafeconleche.web.thebride.dao.TheBrideDao;
import xyz.cafeconleche.web.thebride.dto.Persona;

//@Repository
public class TheBrideDaoPojoImpl implements TheBrideDao {

	public static List<Persona> personas;
	
	static {
		personas = new ArrayList<>();
		
		Persona theBride = new Persona();
		theBride.setId(UUID.randomUUID());
		theBride.setName("Beatrix Kiddo");
		theBride.setCodeName("Black Mamba");
		theBride.setActorName("Uma Thurman");
		theBride.setWeaponOfChoice("Hattori Hanzo sword");
		theBride.setGroup("Deadly Viper Assassination Squad");
		
		Persona bill = new Persona();
		bill.setId(UUID.randomUUID());
		bill.setName("Bill");
		bill.setCodeName("Snake Charmer");
		bill.setActorName("David Carradine");
		bill.setWeaponOfChoice("EMF Hartford Pinkerton chambered in .45");
		bill.setGroup("Deadly Viper Assassination Squad");

		Persona sophie = new Persona();
		sophie.setId(UUID.randomUUID());
		sophie.setName("Sofie Fatale");
		sophie.setCodeName("");
		sophie.setActorName("Julie Dreyfus");
		sophie.setWeaponOfChoice("Lawyer");
		sophie.setGroup("Associates of O-Ren Ishii");
		
		personas.add(theBride);
		personas.add(bill);
		personas.add(sophie);
	}

	@Override
	public List<Persona> list() {
		return personas;
	}

	@Override
	
	public Persona getById(String id) {

		UUID uuid = UUID.fromString(id);
		Persona persona = personas.stream()
				.filter(p -> p.getId().equals(uuid))
				.findFirst()
				.get();
		
		return persona;
	}
	
	@Override
	public Persona getByName(String name) {
		Persona persona = personas.stream()
				.filter(p -> p.getName().equals(name))
				.findFirst()
				.get();
		
		return persona;
	}

	@Override
	public Persona add(Persona persona) {
		personas.add(persona);
		return persona;
	}

	@Override
	public Persona update(Persona persona) {
		// TODO check
		Persona temp = getById(persona.getId().toString());
		temp = persona;
		return temp;
	}

	@Override
	public Persona delete(Persona persona) {
		personas = personas.stream()
				.filter(p -> !p.getId().equals(persona.getId()))
				.collect(Collectors.toList());
		return persona;
	}

}
