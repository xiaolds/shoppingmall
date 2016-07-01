package com.datasure.login.domain;

import java.sql.Timestamp;
import java.util.Set;

/**
 * DUser entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public User() {
	}
	
	public User(Integer userid) {
		super(userid);
	}

	public User(String nickname, String realname, Integer age, String sex,
			String password, String email, String phone) {
		super(nickname, realname, age, sex, password, email, phone);
	}

	/** minimal constructor */
	public User(String nickname, String realname, String password,
			String email, Integer userdegree) {
		super(nickname, realname, password, email, userdegree);
	}

	/** full constructor */
	public User(String nickname, String realname, Integer age, String sex,
			String password, String email, String phone, Timestamp createtime,
			Timestamp lastlogintime, Integer userdegree,Set<Order> Orders, 
			Set<Address> Addresses, Set<Shopcar> Shopcares) {
		super(nickname, realname, age, sex, password, email, phone, createtime,
				lastlogintime, userdegree,Orders,Addresses,Shopcares);
	}

}
