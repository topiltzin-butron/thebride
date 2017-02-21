package xyz.cafeconleche.web.thebride.service;

import java.util.List;

import xyz.cafeconleche.web.thebride.dto.Persona;

public interface TheBrideService {

	List<Persona> list();
	
	Persona getById(String id);
	
	Persona getByName(String name);
	
	Persona add(Persona persona);
	
	Persona update(Persona persona);
	
	Persona delete(Persona persona);
	
}
