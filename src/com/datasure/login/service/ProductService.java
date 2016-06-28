package com.datasure.login.service;

import java.util.List;

import com.datasure.login.domain.Product;

public interface ProductService {
	
	/**
	 * 
	 * getProduct:(根据键值获取商品). <br/>
	 * @author LiDongSheng
	 * @param key
	 * @param valule
	 * @return
	 */
	public List<Product> getProduct(String key, String valule);

	/**
	 * 
	 * getProduct:(根据productid批量获取商品). <br/>
	 * @author LiDongSheng
	 * @param productId
	 * @return
	 */
	public List<Product> getProduct(int...productId);
}
