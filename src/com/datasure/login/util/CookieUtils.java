package com.datasure.login.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.datasure.login.action.UserAction;

public class CookieUtils {
	
//	public static final String USER_COOKIE = "user.cookie";
	
	//����Cookie
	public Cookie createCookie(String cookieName, String value){
		
		Cookie cookie = new Cookie(cookieName,
				value);
		cookie.setMaxAge(60*60*24*14);
		return cookie;
		
	}
	
	//ɾ��Cookies
	public void delCookie(HttpServletRequest request, String name){
		
		Cookie[] cookies = request.getCookies();
		
		if(null != cookies){
			
			for(Cookie c: cookies){
				 if(c.getName().equals(name)){
					 //ɾ��
					 c.setValue("");
					 c.setMaxAge(0);
				 }
			}
		}
	}
	
	//����Cookie
	public Cookie getCookie(HttpServletRequest request, String name){
		
		Cookie[] cookies = request.getCookies();
		
		if(null != cookies){
			
			for(Cookie c: cookies){
				
				if(c.getName().equals(name)){
					return c;
				}
				
			}
			
		}
		
		return null;
		
	}
	
	//�޸�Cookie��ֵ
	public Cookie updateCookie(Cookie cookie, String value){
		cookie.setValue(value);
		return cookie;
	}

	
}
