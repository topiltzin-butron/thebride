package xyz.cafeconleche.web.thebride.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.thebride.dao.UserDao;
import xyz.cafeconleche.web.thebride.dto.User;
import xyz.cafeconleche.web.thebride.service.UserService;

@Service
public class UserServicePojoImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Override
	public User getByUserName(String username) {
		return userDao.getByUserName(username);
	}

	@Override
	public User add(User user) {
		return userDao.add(user);
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public User delete(User user) {
		return userDao.delete(user);
	}

}
