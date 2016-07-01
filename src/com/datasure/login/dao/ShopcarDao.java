package com.datasure.login.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.datasure.login.domain.Shopcar;
import com.datasure.login.domain.User;


/**
 * 
 * @ClassName: ShopcarDao 
 * @Description: 购物车部分
 * @date: 2016-6-29 上午10:04:32 
 * @author LiDongSheng
 * @version
 */
public interface ShopcarDao {
	
	/**
	 * 
	 * saveProductToShopcar:(将商品保存到对应用户的购物车中). <br/>
	 * @author LiDongSheng
	 * @param shop
	 * @throws DataAccessException
	 */
	public void saveProductToShopcar(Shopcar shop) throws DataAccessException;

	/**
	 * 
	 * getProductFromShopcar:(通过UserID查找购物车中的商品). <br/>
	 * @author LiDongSheng
	 * @param userId
	 * @return
	 * @throws DataAccessException
	 */
	public List<Shopcar> getProductFromShopcar(int userId)
						throws DataAccessException;

	/**
	 * 
	 * getProcuctFromShopcar:(通过UserId与ProductId查出唯一的商品). <br/>
	 * @author LiDongSheng
	 * @param userId
	 * @param productId
	 * @return： 返回Null 如果没有对应的商品的话
	 * @throws DataAccessException
	 */
	public Shopcar getProcuctFromShopcar(User user, int productId)
						throws DataAccessException;
	
	/**
	 * 
	 * getProcuctFromShopcar:(通过Shopcar对象查询商品). <br/>
	 * @author LiDongSheng
	 * @param userId
	 * @param productId
	 * @return： 返回Null 如果没有对应的商品的话
	 * @throws DataAccessException
	 */
	public Shopcar getProcuctFromShopcar(Shopcar shopcar)
						throws DataAccessException;
	
	/**
	 * 
	 * updateProductInShopcar:(更新购物车中的商品信息，一般为商品数量). <br/>
	 * @author LiDongSheng
	 * @param shopcar
	 * @throws DataAccessException
	 */
	public void updateProductInShopcar(Shopcar shopcar)
				throws DataAccessException;
	
	/**
	 * 
	 * delProductFromShopcar:(从购物车中删除商品). <br/>
	 *
	 * @author LiDongSheng
	 * @param shopcar
	 * @throws DataAccessException
	 */
	public void delProductFromShopcar(Shopcar shopcar)
				throws DataAccessException;
	
	
}
