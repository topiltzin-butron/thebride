package xyz.cafeconleche.web.thebride.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.thebride.dao.TheBrideDao;
import xyz.cafeconleche.web.thebride.dto.Persona;
import xyz.cafeconleche.web.thebride.service.TheBrideService;

@Service
public class TheBrideServicePojoImpl implements TheBrideService {

	@Autowired
	private TheBrideDao theBrideDao;

	@Override
	public List<Persona> list() {
		return theBrideDao.list();
	}

	@Override
	public Persona getById(String id) {
		return theBrideDao.getById(id);
	}
	
	@Override
	public Persona getByName(String name) {
		return theBrideDao.getByName(name);
	}
	
	@Override
	public Persona add(Persona persona) {
		System.out.println("TheBrideService: " + persona);
		return theBrideDao.add(persona);
	}

	@Override
	public Persona update(Persona persona) {
		System.out.println("TheBrideService: " + persona);
		return theBrideDao.update(persona);
	}

	@Override
	public Persona delete(Persona persona) {
		return theBrideDao.delete(persona);
	}

}
