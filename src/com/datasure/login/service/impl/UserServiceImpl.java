package com.datasure.login.service.impl;

import org.springframework.dao.DataAccessException;

import com.datasure.login.dao.UserDao;
import com.datasure.login.domain.User;
import com.datasure.login.service.UserService;


/**
 * 
 * @ClassName: UserServiceImpl 
 * @Description: ʹ��UserDao�����û�������߼�����
 * @date: 2016-6-20 ����09:30:33 
 * @author LiDongSheng
 * @version
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Override
	public boolean validLogin(String username, String password)
								throws DataAccessException{
		return userDao.isValid(username, password);
	}
	
	/**
	 * 
	 * �û�ע��.
	 * @see com.datasure.login.service.UserService#signUp(com.datasure.login.domain.User)
	 */
	@Override
	public int signUp(User user) throws DataAccessException {
		// ����UserDao�ķ��������û�ע��
		userDao.addUser(user);
		return 0;
	}
	
	@Override
	public User getUser(String key, String value) throws DataAccessException {
		
		return userDao.getUser(key, value);
	}


	
	
	
	
	
	
	/****** getter && setter****/

	public void setUserDao(UserDao userDao) throws DataAccessException {
		this.userDao = userDao;
	}



	
	
	
	

}
