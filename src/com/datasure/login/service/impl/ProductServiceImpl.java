package com.datasure.login.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.datasure.login.dao.ProductDao;
import com.datasure.login.dao.ShopcarDao;
import com.datasure.login.dao.UserDao;
import com.datasure.login.domain.Product;
import com.datasure.login.domain.Shopcar;
import com.datasure.login.domain.User;
import com.datasure.login.service.ProductService;
import com.datasure.login.service.UserService;
import com.datasure.login.util.CookieUtils;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	public ProductDao productDao;
	public ShopcarDao shopcarDao;
	public UserDao userDao;
	public UserService userService;
	
	


	@Override
	public List<Product> getProduct(String key, String value) {
		
		return productDao.getProduct(key, value);
	}
	
	@Override
	public List<Product> getProduct(int... productId) {
		return productDao.getProduct(productId);
	}
	
	@Override
	public void saveProductToShopcar(Shopcar shopcar) {
		//��һ������ѯ��Ʒ�Ƿ��Ѿ�����
		Shopcar shop = 
			shopcarDao.getProcuctFromShopcar(shopcar);
		
		if(shop != null){
			//���ݿ��д��ڸ���Ʒ,����������Ϣ
			int prdtNum = shop.getProductnum()+shopcar.getProductnum();
			shop.setProductnum(prdtNum);
			shopcarDao.updateProductInShopcar(shop);
		}
		else{
			//�����ڸ���Ʒ��Ϣ
			shopcarDao.saveProductToShopcar(shopcar);
		}
		
	}
	
	@Override
	public void saveProductToCookies(HttpServletRequest request,
			HttpServletResponse response, CookieUtils util) {
		
		String productid = request.getParameter("productid");
		String productnum = request.getParameter("productnum");
		
		
		Cookie c = util.getCookie(request, productid);
		
		if(null != c){
			c.setValue(String.valueOf(Integer.parseInt(c.getValue()) +
					Integer.parseInt(productnum)));
		}
		else{
			//create a new Cookie
			c = util.createCookie(productid, productnum);
			c.setPath("/shoppingmall");
		}
		
		response.addCookie(c);
		
	}
	
	@Override
	public void getAndSaveProductFromCookie(HttpServletRequest request,
			HttpServletResponse response, CookieUtils util) {
		
		int prdtId = 0;
		int prdtNum = 0;
		
		User user = null;
		try{
			user = userService.getUserFromSession();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		Cookie[] cookies = request.getCookies();
		
		//��ȡ��Ʒ
		for(Cookie c: cookies){
			
			String cName = c.getName();
			String cValue = c.getValue();
			
			try{
				prdtId = Integer.valueOf(cName);
				prdtNum = Integer.valueOf(cValue);
				//���� Shopcar
				Shopcar s = new Shopcar(user, prdtId, prdtNum);
				//�����ݿ��л�ȡ��shopcar
				Shopcar ss = null;
				 try{
					 //TODO
					 ss = shopcarDao.getProcuctFromShopcar(s);
					 System.out.println(ss);
				 }
				 catch(Exception e){
					 e.printStackTrace();
				 }
				
				if(null != ss){
					//���ݿ��д��ڸü�¼��ˢ��
					ss.setProductnum(ss.getProductnum()+s.getProductnum());
					shopcarDao.updateProductInShopcar(ss);
				}
				else{
					//������ֱ�Ӵ���
					shopcarDao.saveProductToShopcar(s);
				}
				
				//ɾ����Cookie
				util.delCookie(request, cName);
			}
			catch(NumberFormatException ne){
				//ignore
			}
			
		}
		
		
	}
	
	@Override
	public List<Product> getProductFromShopcart() {
		//1.��ȡ��Ӧ��User
		User user = userService.getUserFromSession();
		
		if(user == null) return null;
		//2.����user��ȡ��Ӧ��productid��productnum
		List<Product> shopcartList = productDao.getProductFromShopcart(user);
		//3.����productid��ȡ��ϸ��product��Ϣ
		
		//4.ͳ��product�������ܽ��
		
		//TODO
		
		return shopcartList;
	}

	




	/******getter && setter*****/
	@Resource
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Resource
	public void setShopcarDao(ShopcarDao shopcarDao) {
		this.shopcarDao = shopcarDao;
	}
	
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	






	
	
	
	

}
