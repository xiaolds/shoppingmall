package com.datasure.login.service;

import java.util.List;

import com.datasure.login.domain.Product;

public interface ProductService {
	
	/**
	 * 
	 * getProduct:(���ݼ�ֵ��ȡ��Ʒ). <br/>
	 * @author LiDongSheng
	 * @param key
	 * @param valule
	 * @return
	 */
	public List<Product> getProduct(String key, String valule);

	/**
	 * 
	 * getProduct:(����productid������ȡ��Ʒ). <br/>
	 * @author LiDongSheng
	 * @param productId
	 * @return
	 */
	public List<Product> getProduct(int...productId);
}
