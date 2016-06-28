package com.datasure.login.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.datasure.login.domain.HomepageRecommend;

public interface HomepageRecommendService {
	
	/**
	 * 
	 * getHomepageRecommendCount:(��ȡ�Ƽ���Ʒ������). <br/>
	 * @author LiDongSheng
	 * @return
	 * @throws DataAccessException
	 */
	public long getHomepageRecommendCount() throws DataAccessException;
	
	/**
	 * 
	 * getHomepageRecommend:(ʹ�÷�ҳ��ȡ�Ƽ���Ʒ). <br/>
	 * @author LiDongSheng
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public List<HomepageRecommend> getHomepageRecommend(int page, int pageSize) 
								throws DataAccessException;
	

}