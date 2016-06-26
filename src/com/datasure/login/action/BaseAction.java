package com.datasure.login.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.datasure.login.util.CookieUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware, CookiesAware, Serializable{

	private static final long serialVersionUID = 1L;
	
	//用于Action之间进行数据传递
	public String actionMsg;

	public HttpServletRequest request;
	public HttpServletResponse response;
	//用于返回jSon数据
	public Map<String, Object> dataMap = new HashMap<String, Object>(0);
	//用于操作Cookie
	public CookieUtils cookieUtil = new CookieUtils();
	public Map<String, String> cookieMap;
	
	// 得到Action类的全名
	protected abstract String getActionClassFullName();
	
	/**
	 * 
	 * getSession:获取Session数据. <br/>
	 * @author LiDongSheng
	 * @return
	 */
	public Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getActionMsg() {
		return actionMsg;
	}

	public void setActionMsg(String actionMsg) {
		this.actionMsg = actionMsg;
	}
	
	@Override
	public void setCookiesMap(Map<String, String> cookies) {
		this.cookieMap = cookies;
	}
	
	public Map<String, String> getCookiesMap(){
		return cookieMap;
	}
}
