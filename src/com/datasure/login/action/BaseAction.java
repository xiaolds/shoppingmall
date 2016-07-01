package com.datasure.login.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.datasure.login.util.CookieUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("singleton")
@Controller("baseAction")
public abstract class BaseAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware, Serializable{

	private static final long serialVersionUID = 1L;
	
	//����Action֮��������ݴ���
	public String actionMsg;

	public HttpServletRequest request;
	public HttpServletResponse response;
	//���ڷ���jSon����
	public Map<String, Object> dataMap = new HashMap<String, Object>(0);
	//���ڲ���Cookie
	public CookieUtils cookieUtil = new CookieUtils();
	
	// �õ�Action���ȫ��
	protected abstract String getActionClassFullName();
	
	/**
	 * 
	 * getSession:��ȡSession����. <br/>
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
	
}
