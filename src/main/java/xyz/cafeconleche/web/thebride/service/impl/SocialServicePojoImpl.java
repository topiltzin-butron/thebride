package xyz.cafeconleche.web.thebride.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.cafeconleche.web.thebride.dao.SocialDao;
import xyz.cafeconleche.web.thebride.dto.Post;
import xyz.cafeconleche.web.thebride.service.SocialService;

@Service
public class SocialServicePojoImpl implements SocialService{

	@Autowired
	private SocialDao socialDao;
	
	@Override
	public List<Post> getUserTimeline(String username) {
		return socialDao.getUserTimeline(username);
	}

	@Override
	public List<Post> getTimeline(String username) {
		return socialDao.getTimeline(username);
	}

	@Override
	public Post add(Post post) {
		return socialDao.add(post);
	}

	@Override
	public Post get(Post post) {
		return socialDao.get(post);
	}

	@Override
	public Post update(Post post) {
		return socialDao.update(post);
	}
	
	@Override
	public Post delete(Post post) {
		return socialDao.delete(post);
	}

}
