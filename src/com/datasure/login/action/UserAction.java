package com.datasure.login.action;


import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.datasure.login.domain.Product;
import com.datasure.login.domain.User;
import com.datasure.login.service.ProductService;
import com.datasure.login.service.UserService;
import com.datasure.login.util.UserState;

/**
 * �����½�߼�
 * @ClassName: LoginAction 
 * @date: 2016-6-19 ����12:09:18 
 * @author LiDongSheng
 * @version
 */
@Controller("userAction")
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
	public static final String UserStateCookie = "UserStateCookie";
	
	
	//ϵͳ����ҵ�����߼�
	private UserService userService;
	private ProductService productService;
	
	
	//��½
	public String login() throws Exception{
		//TODO ���е�½��������֤�������һ��ʱ���ڵ�½�������࣬�����˺Ų������½
		//TODO ����Ҳ���Դ�IP��ַ�����ж�
		
		if(userService.validLogin(getNickName().trim(), getPassword())) {
			System.out.println(getNickName());
			
			//�ɹ�
			dataMap.put(UserStateCode, UserState.LOGIN);
			//��½�ɹ������һ��session
			Map<String, Object> sessionMap = getSession();
			sessionMap.put(UserStateSession, getNickName().trim());
			
			
			//�������Cookie�־û�
			productService.getAndSaveProductFromCookie(request,
					response, cookieUtil);
			
			
			//ͬʱ��ͻ������һ��Cookie
			Cookie c = cookieUtil.getCookie(request, UserStateCookie);
			
			if(null == c){
				//ȫ�´���һ��
				c = cookieUtil.createCookie(UserStateCookie, getNickName().trim());
			}
			else{
				c = cookieUtil.updateCookie(c, getNickName().trim());
			}
			//����Cookie
			response.addCookie(c);
			//ˢ��
			response.flushBuffer();
			
		}else{
			//��½ʧ��
			dataMap.put(UserStateCode, UserState.PWD_NOT_CRT);
		}

		return "returnJson";
		
	}
	
	//ע��
	public String logout() throws Exception {
		
		//ʹ��Ӧ��Session��Ч
		Map<String, Object> sessions = getSession();

		//ɾ����Ӧ���Ƶ�Session
		sessions.remove(UserStateSession);
		dataMap.put(UserStateCode, UserState.LOGOUT);
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
	
	
	/***�û���ѯ�������Ժ��������Ϊһ������*****/
	//TODO
	//ʹ��������ѯ�û�
	public String findUserByNickName() throws Exception{
		
		User user = userService.getUser("nickname", getNickName());
		
		if(null == user){
			//�ǳ�δ��ռ��
			dataMap.put(UserStateCode, UserState.NICKNAME_NOT_EXIT);
		}else{
			//�ǳ��Ѿ�����
			dataMap.put(UserStateCode, UserState.NICKNAME_EXIST);
		}
		return "returnJson";
	}
	
	//ʹ�õ绰�����ѯ�û�
	public String findUserByPhoneNumber() throws Exception {
		
		User user = userService.getUser("phone", getMobilePhone());
		
		if(null == user){
			
			//�ֻ�δ��ռ��
			dataMap.put(UserStateCode, UserState.PHONE_NOT_EXIT);
		}else{
			//�ֻ������Ѿ�����
			dataMap.put(UserStateCode, UserState.PHONE_EXIT);
		}
		
		return "returnJson";
	}
	
	//ʹ��Email��ѯ�û�
	public String findUserByEmail() throws Exception {
		
		User user = userService.getUser("email", getEmail());
		
		if(null == user){
			//emailδ��ռ��
			dataMap.put(UserStateCode, UserState.EMAIL_NOT_EXIST);
		}else{
			//email�Ѿ�����
			dataMap.put(UserStateCode, UserState.EMAIL_EXIST);
		}
		return "returnJson";
	}
	/*****/
	
	//�ж��û��Ƿ�����
	public String isOnline() throws Exception {
		
		//��ȡSession�ж��û�״̬
		Map<String, Object> sessions = getSession();
		String userName = (String) sessions.get(UserStateSession);
		
		if(getNickName()==null || userName==null){
			//�û�������
			dataMap.put(UserStateCode, UserState.OUTLINE);
			return "returnJson";
		}
		
		if(userName.equals(getNickName())){
			//�û�����
			dataMap.put(UserStateCode, UserState.ONLINE);
		}
		else{
			//�û�������
			dataMap.put(UserStateCode, UserState.OUTLINE);
		}
		
		return "returnJson";
	}
	
	//�����ض��û����ﳵ�е�������Ʒ
	public String getShopcart() throws Exception {
		
		List<Map<String,Object>> prdtList = productService.getProductFromShopcart();
		dataMap.put("prdtList", prdtList);
		return "returnJson";
	}
	
	//ͨ��Session��ȡ�û�����
	public String getOnlineUserName() throws Exception{
		
		User user = userService.getUserFromSession();
		if(null != user){
			dataMap.put("UserName", user.getNickname());
		}else{
			//do nothing
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
	

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	protected String getActionClassFullName() {
		return "com.datasure.login.action.UserAction";
	}

	
	
	
}
