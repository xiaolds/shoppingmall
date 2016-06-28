package com.datasure.login.dao.impl;

import java.util.List;

import com.datasure.common.dao.impl.BaseDaoHibernate3;
import com.datasure.login.dao.ProductDao;
import com.datasure.login.domain.Product;

public class ProductDaoImpl extends BaseDaoHibernate3<Product>
								implements ProductDao {

	@Override
	public List<Product> getProduct(String key, String value) {
		String hql = "select p form Product p where p." + key +
				"=" + value;
		return find(hql);
	}

	

}
