package com.datasure.login.dao.impl;



import java.util.List;

import org.springframework.dao.DataAccessException;

import com.datasure.common.dao.impl.BaseDaoHibernate3;
import com.datasure.login.dao.UserDao;
import com.datasure.login.domain.User;

public class UserDaoImpl extends BaseDaoHibernate3<User> 
									implements UserDao{
	//使用SessionFactory进行数据库查询个工作
	
	/**
	 * 使用姓名，密码进行登陆，这里的username暂定为nickname
	 */
	@Override
	public boolean isValid(String username, String password) 
								throws DataAccessException {
		//获取符合的用户数据
		List<User> users = find("select u from User u where u.nickname=?0" +
				" and u.password=?1", username, password);
		
		if(users.size()<=0){
			return false;
		}
		return true;
	}

	@Override
	public void updateUser(User user) throws DataAccessException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) throws DataAccessException{
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public User getUser(String key, String value) throws DataAccessException{
		
		//根据昵称查询用户
		List<User> users = find("select u from User u where u."+ key +"=?0",
				value);
		if(users.size()==0){
			return null;
		}
		return users.get(0);
	}

	@Override
	public void addUser(User user) throws DataAccessException{
		//调用baseDao的方法来处理
		save(user);
	}

	
	
}
