package com.datasure.login.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.datasure.common.dao.BaseDao;
import com.datasure.login.domain.HomepageRecommend;

public interface HomepageRecommendDao extends BaseDao<HomepageRecommend> {
	
	/**
	 * 
	 * getHomePageRecommend:��ȡ��ҳ�Ƽ�. <br/>
	 * @author LiDongSheng
	 * @return
	 * @throws DataAccessException
	 */
	public List<HomepageRecommend> getHomePageRecommend(int page, int pageSize)
								throws DataAccessException;
	
	

}
