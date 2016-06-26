package com.datasure.login.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {
	
	public static final String USER_COOKIE = "user.cookie";
	
	//���Cookie,Cookieֻ�������û���������
	public Cookie addCookie(String userName){
		
		Cookie cookie = new Cookie(USER_COOKIE,
				userName);
		System.out.println("���Cookie");
		cookie.setMaxAge(60*60*24*14);
		return cookie;
		
	}
	
	//ɾ��Cookies
	public void delCookie(HttpServletRequest request){
		
		Cookie[] cookies = request.getCookies();
		
		if(null != cookies){
			
			for(Cookie c: cookies){
				 if(c.getName().equals(USER_COOKIE)){
					 //ɾ��
					 c.setValue("");
					 c.setMaxAge(0);
				 }
			}
		}
	}

	
}
