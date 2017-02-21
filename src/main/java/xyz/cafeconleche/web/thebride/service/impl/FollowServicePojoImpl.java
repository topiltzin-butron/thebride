package xyz.cafeconleche.web.thebride.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.thebride.dao.FollowDao;
import xyz.cafeconleche.web.thebride.service.FollowService;

@Service
public class FollowServicePojoImpl implements FollowService{
	
	@Autowired
	private FollowDao followingDao; 

	@Override
	public List<String> getFollowing(String username) {
		return followingDao.getFollowing(username);
	}

	@Override
	public List<String> getFollowers(String username) {
		return followingDao.getFollowers(username);
	}
	
}
