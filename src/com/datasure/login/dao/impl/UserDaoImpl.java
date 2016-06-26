package com.datasure.login.dao.impl;



import java.util.List;

import org.springframework.dao.DataAccessException;

import com.datasure.common.dao.impl.BaseDaoHibernate3;
import com.datasure.login.dao.UserDao;
import com.datasure.login.domain.User;

public class UserDaoImpl extends BaseDaoHibernate3<User> 
									implements UserDao{
	//ʹ��SessionFactory�������ݿ��ѯ������
	
	/**
	 * ʹ��������������е�½�������username�ݶ�Ϊnickname
	 */
	@Override
	public boolean isValid(String username, String password) 
								throws DataAccessException {
		//��ȡ���ϵ��û�����
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
		
		//�����ǳƲ�ѯ�û�
		List<User> users = find("select u from User u where u."+ key +"=?0",
				value);
		if(users.size()==0){
			return null;
		}
		return users.get(0);
	}

	@Override
	public void addUser(User user) throws DataAccessException{
		//����baseDao�ķ���������
		save(user);
	}

	
	
}
