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
 * 处理登陆逻辑
 * @ClassName: LoginAction 
 * @date: 2016-6-19 下午12:09:18 
 * @author LiDongSheng
 * @version
 */
@Controller("userAction")
public class UserAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	private String nickName;	//登录名
	private String password;	//密码
	private String realName;	//真实姓名
	private int age;
	private String sex;
	private String email;
	private String mobilePhone;	//手机号码
	
	public static final String UserStateCode = "UserStateCode";
	public static final String UserStateSession = "UserStateSession";
	public static final String UserStateCookie = "UserStateCookie";
	
	
	//系统所用业务处理逻辑
	private UserService userService;
	private ProductService productService;
	
	
	//登陆
	public String login() throws Exception{
		//TODO 进行登陆次数的验证，如果在一段时间内登陆次数过多，锁定账号不允许登陆
		//TODO 另外也可以从IP地址进行判断
		
		if(userService.validLogin(getNickName().trim(), getPassword())) {
			System.out.println(getNickName());
			
			//成功
			dataMap.put(UserStateCode, UserState.LOGIN);
			//登陆成功后添加一条session
			Map<String, Object> sessionMap = getSession();
			sessionMap.put(UserStateSession, getNickName().trim());
			
			
			//将缓存的Cookie持久化
			productService.getAndSaveProductFromCookie(request,
					response, cookieUtil);
			
			
			//同时向客户端添加一条Cookie
			Cookie c = cookieUtil.getCookie(request, UserStateCookie);
			
			if(null == c){
				//全新创建一个
				c = cookieUtil.createCookie(UserStateCookie, getNickName().trim());
			}
			else{
				c = cookieUtil.updateCookie(c, getNickName().trim());
			}
			//返回Cookie
			response.addCookie(c);
			//刷新
			response.flushBuffer();
			
		}else{
			//登陆失败
			dataMap.put(UserStateCode, UserState.PWD_NOT_CRT);
		}

		return "returnJson";
		
	}
	
	//注销
	public String logout() throws Exception {
		
		//使对应的Session无效
		Map<String, Object> sessions = getSession();

		//删除对应名称的Session
		sessions.remove(UserStateSession);
		dataMap.put(UserStateCode, UserState.LOGOUT);
		return "returnJson";
	}
	
	//注册
	public String signUp() throws Exception {
		
		//TODO
		//此处获取前端发送来的数据并且构造一个User
		User user = null;
		try{
			user = new User(nickName,realName,age,sex, password, email,
					mobilePhone);
			userService.signUp(user);
		}
		catch(DataAccessException e){
			//TODO 这里会因为昵称、email与电话号码造成冲突
			e.printStackTrace();
		}
		
		//正常退出
		dataMap.put(UserStateCode,UserState.LOGOUT);
		return "returnJson";
	}
	
	
	/***用户查询方法，以后可以整合为一个函数*****/
	//TODO
	//使用姓名查询用户
	public String findUserByNickName() throws Exception{
		
		User user = userService.getUser("nickname", getNickName());
		
		if(null == user){
			//昵称未被占用
			dataMap.put(UserStateCode, UserState.NICKNAME_NOT_EXIT);
		}else{
			//昵称已经存在
			dataMap.put(UserStateCode, UserState.NICKNAME_EXIST);
		}
		return "returnJson";
	}
	
	//使用电话号码查询用户
	public String findUserByPhoneNumber() throws Exception {
		
		User user = userService.getUser("phone", getMobilePhone());
		
		if(null == user){
			
			//手机未被占用
			dataMap.put(UserStateCode, UserState.PHONE_NOT_EXIT);
		}else{
			//手机号码已经存在
			dataMap.put(UserStateCode, UserState.PHONE_EXIT);
		}
		
		return "returnJson";
	}
	
	//使用Email查询用户
	public String findUserByEmail() throws Exception {
		
		User user = userService.getUser("email", getEmail());
		
		if(null == user){
			//email未被占用
			dataMap.put(UserStateCode, UserState.EMAIL_NOT_EXIST);
		}else{
			//email已经存在
			dataMap.put(UserStateCode, UserState.EMAIL_EXIST);
		}
		return "returnJson";
	}
	/*****/
	
	//判断用户是否在线
	public String isOnline() throws Exception {
		
		//获取Session判断用户状态
		Map<String, Object> sessions = getSession();
		String userName = (String) sessions.get(UserStateSession);
		
		if(getNickName()==null || userName==null){
			//用户不在线
			dataMap.put(UserStateCode, UserState.OUTLINE);
			return "returnJson";
		}
		
		if(userName.equals(getNickName())){
			//用户存在
			dataMap.put(UserStateCode, UserState.ONLINE);
		}
		else{
			//用户不在线
			dataMap.put(UserStateCode, UserState.OUTLINE);
		}
		
		return "returnJson";
	}
	
	//返回特定用户购物车中的所有商品
	public String getShopcart() throws Exception {
		
		List<Map<String,Object>> prdtList = productService.getProductFromShopcart();
		dataMap.put("prdtList", prdtList);
		return "returnJson";
	}
	
	//通过Session获取用户姓名
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
