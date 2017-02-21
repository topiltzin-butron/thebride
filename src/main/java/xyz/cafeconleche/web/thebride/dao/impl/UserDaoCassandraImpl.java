package xyz.cafeconleche.web.thebride.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import xyz.cafeconleche.web.thebride.dao.UserDao;
import xyz.cafeconleche.web.thebride.dto.User;

@Repository
public class UserDaoCassandraImpl implements UserDao {

	@Autowired
	private CassandraAdminOperations cassandraTemplate;
	
	@Override
	public List<User> list() {
		
		Statement select = QueryBuilder.select()
				.from("users");
		
		List<User> users = cassandraTemplate.select(select, User.class);
		return users;
	}

	@Override
	public User getByUserName(String username) {
		
		Statement select = QueryBuilder.select()
				.from("users")
				.where(QueryBuilder.eq("username", username));
		
		return cassandraTemplate.selectOne(select, User.class);
	}

	@Override
	public User add(User user) {
		user = cassandraTemplate.insert(user);
		return user;
	}

	@Override
	public User update(User user) {
		user = cassandraTemplate.update(user);
		return user;
	}

	@Override
	public User delete(User user) {
		user = cassandraTemplate.delete(user);
		return user;
	}

}
