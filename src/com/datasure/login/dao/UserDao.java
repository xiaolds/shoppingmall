package com.datasure.login.dao;

/**
 * ��ѯ�Ƿ���ڸ��û�
 */

import org.springframework.dao.DataAccessException;

import com.datasure.common.dao.BaseDao;
import com.datasure.login.domain.User;

public interface UserDao extends BaseDao<User> {
	
	/**�û��Ƿ����
	 */
	public boolean isValid(String username, String password) 
								throws DataAccessException;
	
	/**
	 * 
	 * updateUser:�����û���Ϣ. <br/>
	 *
	 * @author LiDongSheng
	 */
	public void updateUser(User user) throws DataAccessException;
	
	/**
	 * 
	 * deleteUser:ɾ���û�. <br/>

	 * @author LiDongSheng
	 * @param user
	 */
	public void deleteUser(User user) throws DataAccessException;
	
	/**
	 * 
	 * getUser:����User���е�����һ��unique�ֶβ����û�. <br/>
	 *
	 * @author LiDongSheng
	 * @param key: �������� nickName
	 * @param value: ��ֵ����"Lids"
	 * @return ���ز�ѯ�����û���Ϣ
	 */
	public User getUser(String key, String value) throws DataAccessException;
	
	/**
	 * 
	 * addUser:����û�. <br/>
	 * @author LiDongSheng
	 * @param user
	 */
	public void addUser(User user) throws DataAccessException;
	
	
}
