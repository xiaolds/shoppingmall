package com.datasure.login.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import com.datasure.common.dao.impl.BaseDaoHibernate3;
import com.datasure.login.dao.ProductDao;
import com.datasure.login.domain.Product;
import com.datasure.login.domain.User;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoHibernate3<Product>
								implements ProductDao {

	@Override
	public List<Product> getProduct(String key, String value) {
		String hql = "select p form Product p where p." + key +
				"=" + value;
		return find(hql);
	}

	@Override
	public List<Product> getProduct(int... productId) {
		
		//根据数组长度来拼接HQL语句
		int len = productId.length;
		StringBuilder sb = new StringBuilder();
		
		
		if(0 != len){
			sb.append("select p from Product p where p.productid=");
			sb.append(productId[0]+" ");
			for(int i = 1; i < len; i++){
				
				sb.append("or p.productid =");
				sb.append(productId[i]+" ");
				
				
			}	//end of for
//			sb.append(";");
		}	//end of if
		System.out.println("Product Hql:"+sb);
		
		return find(sb.toString());
	}
	
	@Override
	public List<Product> getProductFromShopcart(User user) {
		
		/*
		 * SELECT 
  			p.`productid`,
  			p.`name`,
  			p.`description`,
  			s.productnum 
		   FROM
  			d_product p 
  			INNER JOIN d_shopcar s 
    		ON s.`productid` = p.`productid` 
    		AND s.`userid` = 2 ;
		 */
		/*String hql = "select p from Product p inner join Shopcar.product as s with " +
				"s.productid=p.productid and s.userid=" +
				user.getId();*/
		
		String sql = "select p.* from shoppingmall.d_product p inner join " +
				"shoppingmall.d_shopcar s on s.productid = p.productid " +
				"and s.userid="+user.getId();
		Map<String, Type> map = new HashMap<String, Type>(0);
//		map.put("")
		List<Product> list = findWithSql(sql, Product.class,map);
		return list;
	}

	

}
