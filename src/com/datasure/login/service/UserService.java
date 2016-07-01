package com.datasure.login.service;

import org.springframework.dao.DataAccessException;

import com.datasure.login.domain.User;

/*
 * ��֤��½���߼�
 */

public interface UserService {
	
	
	/**
	 * 
	 * validLogin:��֤�û��Ƿ����. <br/>
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
	 * signUp:�û�ע��. <br/>
	 * 
	 * @author LiDongSheng
	 * @param user
	 * @return
	 */
	public int signUp(User user) throws DataAccessException;
	
	/**
	 * 
	 * getUser:(����d_user���е�Լ��Ϊunique���ֶβ����û�). <br/>
	 *
	 * @author LiDongSheng
	 * @param key
	 * @param value
	 * @return
	 */
	public User getUser(String key, String value) throws DataAccessException;
	
	/**
	 * 
	 * isOnline:(ͨ��Session�ж��û��Ƿ�����). <br/>
	 * @author LiDongSheng
	 * @return
	 */
	public boolean isOnline();
	
	/**
	 * 
	 * getUserFromSession:(ͨ��Session��ȡ��ǰ��user). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 *
	 * @author LiDongSheng
	 * @return
	 */
	public User getUserFromSession();
}
