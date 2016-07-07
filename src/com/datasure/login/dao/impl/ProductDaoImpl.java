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
		}	//end of if
		System.out.println("Product Hql:"+sb);
		
		return find(sb.toString());
	}
	
	@Override
	public List<Product> getProductFromShopcart(User user) {
		
		String sql = "select p.*,s.productnum from shoppingmall.d_product p inner join " +
				"shoppingmall.d_shopcar s on s.productid = p.productid " +
				"and s.userid="+user.getId();
		
		Map<String, Type> map = new HashMap<String, Type>(0);
		List<Product> list = findWithSql(sql, Product.class,map);
		return list;
	}

	

}
