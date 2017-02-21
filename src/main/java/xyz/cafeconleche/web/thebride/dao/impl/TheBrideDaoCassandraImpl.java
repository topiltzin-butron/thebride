package xyz.cafeconleche.web.thebride.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import xyz.cafeconleche.web.thebride.dao.TheBrideDao;
import xyz.cafeconleche.web.thebride.dto.Persona;

@Repository
public class TheBrideDaoCassandraImpl implements TheBrideDao {
	
	@Autowired
	private CassandraAdminOperations cassandraTemplate;
	
	@Override
	public List<Persona> list() {

		Statement select = QueryBuilder.select()
				.from("characters");
		
		List<Persona> personas = cassandraTemplate.select(select, Persona.class);
		return personas;
	}
	
	@Override
	public Persona getById(String id) {
		
		UUID uuid = UUID.fromString(id);
		Statement select = QueryBuilder.select()
				.from("characters")
				.where(QueryBuilder.eq("id", uuid));
		
		Persona persona = cassandraTemplate.selectOne(select, Persona.class);
		return persona;
	}
	
	@Override
	public Persona getByName(String name) {
		
		Statement select = QueryBuilder.select()
				.from("characters")
				.where(QueryBuilder.eq("name", name));
		
		Persona persona = cassandraTemplate.selectOne(select, Persona.class);
		return persona;
	}

	@Override
	public Persona add(Persona persona) {
		
		persona.setId(UUID.randomUUID());
		persona.setCreationTime(new Date());
		
		System.out.println("TheBrideDao: " + persona);
		
		Persona added = cassandraTemplate.insert(persona);
		System.out.println("added: " + added);
		return added;
	}

	@Override
	public Persona update(Persona persona) {
		Persona updated = cassandraTemplate.update(persona);
		System.out.println("updated: " + updated);
		return updated;
	}

	@Override
	public Persona delete(Persona persona) {
		Persona deleted = cassandraTemplate.delete(persona);
		System.out.println("deleted: " + deleted);
		return deleted;
	}

}
