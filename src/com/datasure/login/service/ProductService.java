package com.datasure.login.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datasure.login.domain.Product;
import com.datasure.login.domain.Shopcar;
import com.datasure.login.util.CookieUtils;

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
	
	/**
	 * 
	 * saveProductToShopcar:(���ﳵ�������Ʒ). <br/>
	 * @author LiDongSheng
	 * @param shopcar
	 */
	public void saveProductToShopcar(Shopcar shopcar);
	
	/**
	 * 
	 * saveProductToCookies:(����Ʒ��Ϣ������Cookie�в����ͻؿͻ���). <br/>
	 * @author LiDongSheng
	 * @param shopcar
	 */
	public void saveProductToCookies(HttpServletRequest request, 
			HttpServletResponse response, CookieUtils util);
	
	/**
	 * 
	 * getAndSaveProductFromCookie:(��Cookie�л�ȡ��Ʒ��Ϣ���ҳ־û�). <br/>
	 *
	 * @author LiDongSheng
	 * @param request
	 * @param response
	 * @param util
	 */
	public void getAndSaveProductFromCookie(HttpServletRequest request, 
			HttpServletResponse response, CookieUtils util);
}
