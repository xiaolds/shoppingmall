package com.datasure.login.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {
	
	public static final String USER_COOKIE = "user.cookie";
	
	//添加Cookie,Cookie只做保存用户名的作用
	public Cookie addCookie(String userName){
		
		Cookie cookie = new Cookie(USER_COOKIE,
				userName);
		System.out.println("添加Cookie");
		cookie.setMaxAge(60*60*24*14);
		return cookie;
		
	}
	
	//删除Cookies
	public void delCookie(HttpServletRequest request){
		
		Cookie[] cookies = request.getCookies();
		
		if(null != cookies){
			
			for(Cookie c: cookies){
				 if(c.getName().equals(USER_COOKIE)){
					 //删除
					 c.setValue("");
					 c.setMaxAge(0);
				 }
			}
		}
	}

	
}
