package com.datasure.login.service.impl;

import java.util.List;

import com.datasure.login.dao.ProductDao;
import com.datasure.login.domain.Product;
import com.datasure.login.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	public ProductDao productDao;
	


	@Override
	public List<Product> getProduct(String key, String value) {
		
		return productDao.getProduct(key, value);
	}
	
	@Override
	public List<Product> getProduct(int... productId) {
		
		return productDao.getProduct(productId);
	}
	
	
	/******getter && setter*****/

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


	


	
	
	
	

}
