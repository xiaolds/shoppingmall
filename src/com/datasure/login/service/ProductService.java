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
	
	/**
	 * 
	 * saveProductToShopcar:(向购物车中添加商品). <br/>
	 * @author LiDongSheng
	 * @param shopcar
	 */
	public void saveProductToShopcar(Shopcar shopcar);
	
	/**
	 * 
	 * saveProductToCookies:(将商品信息保存在Cookie中并发送回客户端). <br/>
	 * @author LiDongSheng
	 * @param shopcar
	 */
	public void saveProductToCookies(HttpServletRequest request, 
			HttpServletResponse response, CookieUtils util);
	
	/**
	 * 
	 * getAndSaveProductFromCookie:(从Cookie中获取商品信息并且持久化). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author LiDongSheng
	 * @param request
	 * @param response
	 * @param util
	 */
	public void getAndSaveProductFromCookie(HttpServletRequest request, 
			HttpServletResponse response, CookieUtils util);
}
