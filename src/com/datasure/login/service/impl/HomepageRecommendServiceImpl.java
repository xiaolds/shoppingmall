package com.datasure.login.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.datasure.login.dao.HomepageRecommendDao;
import com.datasure.login.domain.HomepageRecommend;
import com.datasure.login.service.HomepageRecommendService;


@Service("homepageRecommendService")
public class HomepageRecommendServiceImpl implements HomepageRecommendService {

	public HomepageRecommendDao homepageRecommendDao;
	
	@Override
	public long getHomepageRecommendCount() throws DataAccessException {
		Class<HomepageRecommend> cls = HomepageRecommend.class;
		return homepageRecommendDao.findCount(cls);
	}

	/******getter & setter***/
	@Resource
	public void setHomepageRecommendDao(HomepageRecommendDao homepageRecommendDao) {
		this.homepageRecommendDao = homepageRecommendDao;
	}

	@Override
	public List<HomepageRecommend> getHomepageRecommend(int page, int pageSize)
			throws DataAccessException {
		return homepageRecommendDao.getHomePageRecommend(page, pageSize);
	}
	
	
	
	
	

}
