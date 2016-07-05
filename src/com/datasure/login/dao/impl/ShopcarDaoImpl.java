package com.datasure.login.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.datasure.common.dao.impl.BaseDaoHibernate3;
import com.datasure.login.dao.ShopcarDao;
import com.datasure.login.domain.Shopcar;
import com.datasure.login.domain.User;


@Repository("shopcarDao")
public class ShopcarDaoImpl extends BaseDaoHibernate3<Shopcar> implements
		ShopcarDao {

	@Override
	public void saveProductToShopcar(Shopcar shop) throws DataAccessException {
		//直接保存用户的商品
		try{
			save(shop);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Shopcar> getProductFromShopcar(int userId) throws DataAccessException {
		//HQL语句
		String hql = "select s from Shopcar s where userid=" + userId;
		return find(hql);
	}

	@Override
	public void updateProductInShopcar(Shopcar shopcar)
			throws DataAccessException {
		try{
			update(shopcar);
		}
		catch(Exception e){
			e.printStackTrace();
		}
/*		String hql = "update Shopcar set productnum="+shopcar.getProductnum()
					+" where shopcarid=" + shopcar.getShopcarid();
		find(hql);*/
	}

	@Override
	public void delProductFromShopcar(Shopcar shopcar)
			throws DataAccessException {
		delete(shopcar);
	}

	@Override
	public Shopcar getProcuctFromShopcar(User user, int productId)
			throws DataAccessException {
		String hql = "select s from Shopcar s where s.User="+
					user + " and s.productid="+productId;
		List<Shopcar> shopcarList = find(hql);
		
		if(0 != shopcarList.size()){
			return shopcarList.get(0);
		}
		
		return null;
	}

	@Override
	public Shopcar getProcuctFromShopcar(Shopcar shopcar)
			throws DataAccessException {

		
		String hql = null;
		hql = "select s from Shopcar s where s.productid=?0 " +
				"and s.User=?1";
		
		List<Shopcar> shopList = find(hql,shopcar.getProductid(),
				shopcar.getUser());
		if(0 != shopList.size()){
			return shopList.get(0);
		}
		return null;
	}

}
