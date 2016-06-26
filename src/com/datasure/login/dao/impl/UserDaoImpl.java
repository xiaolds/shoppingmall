package com.datasure.login.dao.impl;



import java.util.List;

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
	public boolean isValid(String username, String password) {
		//��ȡ���ϵ��û�����
		List<User> users = find("select u from User u where u.nickname=?0" +
				" and u.password=?1", username, password);
		
		if(users.size()<=0){
			return false;
		}
		return true;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public User getUser(String key, String value) {
		//�����ǳƲ�ѯ�û�
		List<User> users = find("select u form User u where u."+ key +"=?0",
				value);
		return users.get(0);
	}

	@Override
	public void addUser(User user) {
		//����baseDao�ķ���������
		save(user);
	}

	
	
}
