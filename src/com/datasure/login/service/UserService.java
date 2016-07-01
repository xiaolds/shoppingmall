package com.datasure.login.service;

import org.springframework.dao.DataAccessException;

import com.datasure.login.domain.User;

/*
 * 验证登陆的逻辑
 */

public interface UserService {
	
	
	/**
	 * 
	 * validLogin:验证用户是否存在. <br/>
	 *
	 * @author LiDongSheng
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean validLogin(String username, String password)
									throws DataAccessException;
	
	/**
	 * 
	 * signUp:用户注册. <br/>
	 * 
	 * @author LiDongSheng
	 * @param user
	 * @return
	 */
	public int signUp(User user) throws DataAccessException;
	
	/**
	 * 
	 * getUser:(根据d_user表中的约束为unique的字段查找用户). <br/>
	 *
	 * @author LiDongSheng
	 * @param key
	 * @param value
	 * @return
	 */
	public User getUser(String key, String value) throws DataAccessException;
	
	/**
	 * 
	 * getUserNameFromSession:(从Session中获取用户姓名). <br/>
	 *
	 * @author LiDongSheng
	 * @param nickName
	 * @return
	 * @throws DataAccessException
	 */
	public User getUserNameFromSession() 
				throws DataAccessException;
	
}
