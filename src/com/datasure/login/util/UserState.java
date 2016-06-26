package com.datasure.login.util;

public class UserState {
	
	//登陆成功 ---> 登陆操作
	public static final int LOGIN = 3000;
	//注册成功 ---> 注册操作
	public static final int SIGNUP = 3001;
	//注销成功 ---> 注销操作
	public static final int LOGOUT = 3002;
	//在线 --->判断是否在线
	public static final int ONLINE = 3003;
	
	
	//登陆失败
	public static final int NO_SUCH_USER = 30001;			//该用户不存在
	public static final int PWD_NOT_CRT = 30002;			//密码不正确
	public static final int ACCOUNT_FORBIDDEN = 30003;		//账户被禁用
	
	//注册失败
	public static final int NICKNAME_EXIST = 30011;			//昵称已经存在
	public static final int EMAIL_EXIST = 30012;			//email已经存在
	public static final int PHONE_EXIT = 30013;				//手机号码已经存在
	
	public static final int NICKNAME_NOT_EXIT = 30014;		//昵称未被占用
	public static final int EMAIL_NOT_EXIST = 30015;		//email未被占用
	public static final int PHONE_NOT_EXIT = 30016;			//手机未被占用
	
	//不在线
	public static final int OUTLINE = 30031;				//用户不在线
}
