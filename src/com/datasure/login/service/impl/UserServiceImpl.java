package com.datasure.login.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.datasure.login.action.UserAction;
import com.datasure.login.dao.UserDao;
import com.datasure.login.domain.User;
import com.datasure.login.service.UserService;
import com.opensymphony.xwork2.ActionContext;


/**
 * 
 * @ClassName: UserServiceImpl 
 * @Description: 使用UserDao进行用户的相关逻辑处理
 * @date: 2016-6-20 上午09:30:33 
 * @author LiDongSheng
 * @version
 */

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Override
	public boolean validLogin(String username, String password)
								throws DataAccessException{
		return userDao.isValid(username, password);
	}
	
	/**
	 * 
	 * 用户注册.
	 * @see com.datasure.login.service.UserService#signUp(com.datasure.login.domain.User)
	 */
	@Override
	public int signUp(User user) throws DataAccessException {
		// 调用UserDao的方法进行用户注册
		userDao.addUser(user);
		return 0;
	}
	
	@Override
	public User getUser(String key, String value) throws DataAccessException {
		
		return userDao.getUser(key, value);
	}
	
	@Override
	public User getUserNameFromSession()
			throws DataAccessException {

		Map<String, Object> sessionMap = 
			ActionContext.getContext().getSession();
		
		String name = (String) sessionMap.get(UserAction.UserStateSession);
		if(null != name){
			//返回用户
			return userDao.getUser("nickname", name);
		}
		else{
			return null;
		}
		
	}


	
	
	
	
	
	/****** getter && setter****/
	@Resource
	public void setUserDao(UserDao userDao) throws DataAccessException {
		this.userDao = userDao;
	}







	
	
	
	

}
