package xyz.cafeconleche.web.thebride.dao;

import java.util.List;

import xyz.cafeconleche.web.thebride.dto.User;

public interface UserDao {

	List<User> list();

	User getByUserName(String username);

	User add(User user);
	
	User update(User user);
	
	User delete(User user);

}
