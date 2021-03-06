package com.datasure.login.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.datasure.common.dao.impl.BaseDaoHibernate3;
import com.datasure.login.dao.HomepageRecommendDao;
import com.datasure.login.domain.HomepageRecommend;

@Repository("HomepageRecommendDao")
public class HomepageRecommendDaoImpl extends
					BaseDaoHibernate3<HomepageRecommend>
					implements HomepageRecommendDao {


	@Override
	public List<HomepageRecommend> getHomePageRecommend(int page, int pageSize)
			throws DataAccessException {
		
		String hql = "select h from HomepageRecommend h";
		List<HomepageRecommend> prdtList = findByPage(hql, page, pageSize);
		return prdtList;
	}

}
