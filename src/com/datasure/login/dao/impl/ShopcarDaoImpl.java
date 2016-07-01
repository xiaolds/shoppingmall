package com.datasure.login.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.datasure.common.dao.impl.BaseDaoHibernate3;
import com.datasure.login.dao.ShopcarDao;
import com.datasure.login.domain.Shopcar;


@Repository("shopcarDao")
public class ShopcarDaoImpl extends BaseDaoHibernate3<Shopcar> implements
		ShopcarDao {

	@Override
	public void saveProductToShopcar(Shopcar shop) throws DataAccessException {
		//直接保存用户的商品
		save(shop);
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
		update(shopcar);
	}

	@Override
	public void delProductFromShopcar(Shopcar shopcar)
			throws DataAccessException {
		delete(shopcar);
	}

	@Override
	public Shopcar getProcuctFromShopcar(int userId, int productId)
			throws DataAccessException {
		String hql = "select s from Shopcar s where userid= "+
					userId + " and where productid= "+productId;
		List<Shopcar> shopcarList = find(hql);
		
		if(0 != shopcarList.size()){
			return shopcarList.get(0);
		}
		
		return null;
	}

}
