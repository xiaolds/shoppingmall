package com.datasure.login.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.datasure.login.domain.Shopcar;
import com.datasure.login.domain.User;


/**
 * 
 * @ClassName: ShopcarDao 
 * @Description: ���ﳵ����
 * @date: 2016-6-29 ����10:04:32 
 * @author LiDongSheng
 * @version
 */
public interface ShopcarDao {
	
	/**
	 * 
	 * saveProductToShopcar:(����Ʒ���浽��Ӧ�û��Ĺ��ﳵ��). <br/>
	 * @author LiDongSheng
	 * @param shop
	 * @throws DataAccessException
	 */
	public void saveProductToShopcar(Shopcar shop) throws DataAccessException;

	/**
	 * 
	 * getProductFromShopcar:(ͨ��UserID���ҹ��ﳵ�е���Ʒ). <br/>
	 * @author LiDongSheng
	 * @param userId
	 * @return
	 * @throws DataAccessException
	 */
	public List<Shopcar> getProductFromShopcar(int userId)
						throws DataAccessException;

	/**
	 * 
	 * getProcuctFromShopcar:(ͨ��UserId��ProductId���Ψһ����Ʒ). <br/>
	 * @author LiDongSheng
	 * @param userId
	 * @param productId
	 * @return�� ����Null ���û�ж�Ӧ����Ʒ�Ļ�
	 * @throws DataAccessException
	 */
	public Shopcar getProcuctFromShopcar(User user, int productId)
						throws DataAccessException;
	
	/**
	 * 
	 * getProcuctFromShopcar:(ͨ��Shopcar�����ѯ��Ʒ). <br/>
	 * @author LiDongSheng
	 * @param userId
	 * @param productId
	 * @return�� ����Null ���û�ж�Ӧ����Ʒ�Ļ�
	 * @throws DataAccessException
	 */
	public Shopcar getProcuctFromShopcar(Shopcar shopcar)
						throws DataAccessException;
	
	/**
	 * 
	 * updateProductInShopcar:(���¹��ﳵ�е���Ʒ��Ϣ��һ��Ϊ��Ʒ����). <br/>
	 * @author LiDongSheng
	 * @param shopcar
	 * @throws DataAccessException
	 */
	public void updateProductInShopcar(Shopcar shopcar)
				throws DataAccessException;
	
	/**
	 * 
	 * delProductFromShopcar:(�ӹ��ﳵ��ɾ����Ʒ). <br/>
	 *
	 * @author LiDongSheng
	 * @param shopcar
	 * @throws DataAccessException
	 */
	public void delProductFromShopcar(Shopcar shopcar)
				throws DataAccessException;
	
	
}
