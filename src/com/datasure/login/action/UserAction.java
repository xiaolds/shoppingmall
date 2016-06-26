package com.datasure.login.action;


import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.Cookie;

import org.springframework.dao.DataAccessException;

import com.datasure.login.domain.User;
import com.datasure.login.service.UserService;
import com.datasure.login.util.UserState;

/**
 * �����½�߼�
 * @ClassName: LoginAction 
 * @date: 2016-6-19 ����12:09:18 
 * @author LiDongSheng
 * @version
 */

public class UserAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	private String nickName;	//��¼��
	private String password;	//����
	private String realName;	//��ʵ����
	private int age;
	private String sex;
	private String email;
	private String mobilePhone;	//�ֻ�����
	
	public static final String UserStateCode = "UserStateCode";
	public static final String UserStateSession = "UserStateSession";
	
	
	//ϵͳ����ҵ�����߼�
	private UserService userService;
	
	
	//��½
	public String login() throws Exception{
		//TODO ���е�½��������֤�������һ��ʱ���ڵ�½�������࣬�����˺Ų������½
		//TODO ����Ҳ���Դ�IP��ַ�����ж�
		
		if(userService.validLogin(getNickName().trim(), getPassword())) {
			
			//�ɹ�
			dataMap.put(UserStateCode, UserState.LOGIN);
			//��½�ɹ������һ��session
			Map<String, Object> sessionMap = getSession();
			sessionMap.put(UserStateSession, getNickName().trim());
			//ͬʱ��ͻ������һ��Cookie
			Cookie usrInfoCookie = cookieUtil.addCookie(getNickName().trim());
			response.addCookie(usrInfoCookie);
		}else{
			//��½ʧ��
			dataMap.put(UserStateCode, UserState.PWD_NOT_CRT);
		}

		return "returnJson";
		
	}
	
	//ע��
	public String logout() throws Exception {
		
		//ʹ��Ӧ��Session��Ч
		String name = getNickName();
		Map<String, Object> sessions = getSession();
		
		@SuppressWarnings("unchecked")
		Map<String ,String> usrMap = 
			(Map<String, String>) sessions.get(UserStateSession);
		//ɾ����Ӧ���Ƶ�Session
		Set<Entry<String, String>> set = usrMap.entrySet();
		boolean isLogout = false;
		for(Entry<String, String> entry: set){
			
			if(entry.getValue().equals(name)){
				usrMap.remove(entry.getKey());	//ɾ����Ӧ�û�
				isLogout = true;
				dataMap.put(UserStateCode, UserState.LOGOUT);	//�����˳�
			}
			
		}
		
		if(!isLogout){
			dataMap.put(UserStateCode, UserState.NO_SUCH_USER);
		}
		
		return "returnJson";
	}
	
	//ע��
	public String signUp() throws Exception {
		
		//TODO
		//�˴���ȡǰ�˷����������ݲ��ҹ���һ��User
		User user = null;
		try{
			user = new User(nickName,realName,age,sex, password, email,
					mobilePhone);
			userService.signUp(user);
		}
		catch(DataAccessException e){
			//TODO �������Ϊ�ǳơ�email��绰������ɳ�ͻ
			e.printStackTrace();
		}
		
		//�����˳�
		dataMap.put(UserStateCode,UserState.LOGOUT);
		return "returnJson";
	}
	
	
	/***�û���ѯ����*****/
	public String findUserByNickName() throws Exception{
		
		User user = userService.getUser("nickname", getNickName());
		
		if(null == user){
			//�ǳ��Ѿ�����
			dataMap.put(UserStateCode, UserState.NICKNAME_EXIST);
		}else{
			//�ǳ�δ��ռ��
			dataMap.put(UserStateCode, UserState.NICKNAME_NOT_EXIT);
		}
		return "returnJson";
	}
	
	public String findUserByPhoneNumber() throws Exception {
		
		User user = userService.getUser("phone", getMobilePhone());
		
		if(null == user){
			//�ֻ������Ѿ�����
			dataMap.put(UserStateCode, UserState.PHONE_EXIT);
		}else{
			//�ֻ�δ��ռ��
			dataMap.put(UserStateCode, UserState.PHONE_NOT_EXIT);
		}
		
		return "returnJson";
	}
	
	public String findUserByEmail() throws Exception {
		
		User user = userService.getUser("email", getNickName());
		
		if(null == user){
			//email�Ѿ�����
			dataMap.put(UserStateCode, UserState.EMAIL_EXIST);
		}else{
			//emailδ��ռ��
			dataMap.put(UserStateCode, UserState.EMAIL_NOT_EXIST);
		}
		return "returnJson";
	}
	/*****/
	
	//�ж��û��Ƿ�����
	public String isOnline() throws Exception {
		
		//��ȡSession�ж��û�״̬
		Map<String, Object> sessions = getSession();
		String userName = (String) sessions.get(getNickName().trim());
		
		if(null == userName){
			//�û�������
			dataMap.put(UserStateCode, UserState.OUTLINE);
		}
		else{
			//�û�����
			dataMap.put(UserStateCode, UserState.ONLINE);
		}
		
		return "returnJson";
	}
	

	
	
	/**
	 * getter && setter
	 */
	public void setUserService(UserService userService){
		this.userService = userService;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Override
	protected String getActionClassFullName() {
		return "com.datasure.login.action.UserAction";
	}
	
	
}
