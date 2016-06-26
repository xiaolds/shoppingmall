package com.datasure.login.dao;

/**
 * 查询是否存在该用户
 */

import org.springframework.dao.DataAccessException;

import com.datasure.common.dao.BaseDao;
import com.datasure.login.domain.User;

public interface UserDao extends BaseDao<User> {
	
	/**用户是否存在
	 */
	public boolean isValid(String username, String password) 
								throws DataAccessException;
	
	/**
	 * 
	 * updateUser:更新用户信息. <br/>
	 *
	 * @author LiDongSheng
	 */
	public void updateUser(User user) throws DataAccessException;
	
	/**
	 * 
	 * deleteUser:删除用户. <br/>

	 * @author LiDongSheng
	 * @param user
	 */
	public void deleteUser(User user) throws DataAccessException;
	
	/**
	 * 
	 * getUser:根据User表中的任意一个unique字段查找用户. <br/>
	 *
	 * @author LiDongSheng
	 * @param key: 键名，如 nickName
	 * @param value: 键值，如"Lids"
	 * @return 返回查询到的用户信息
	 */
	public User getUser(String key, String value) throws DataAccessException;
	
	/**
	 * 
	 * addUser:添加用户. <br/>
	 * @author LiDongSheng
	 * @param user
	 */
	public void addUser(User user) throws DataAccessException;
	
	
}
