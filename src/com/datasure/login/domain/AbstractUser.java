package com.datasure.login.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractDUser entity provides the base persistence definition of the DUser
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUser implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nickname;
	private String realname;
	private Integer age;
	private String sex;
	private String password;
	private String email;
	private String phone;
	private Timestamp createtime;
	private Timestamp lastlogintime;
	private Integer userdegree;
	private Set<Order> Orders = new HashSet<Order>(0);
	private Set<Address> Addresses = new HashSet<Address>(0);

	// Constructors

	/** default constructor */
	public AbstractUser() {
	}
	
	

	public AbstractUser(String nickname, String realname, Integer age,
			String sex, String password, String email, String phone) {
		super();
		this.nickname = nickname;
		this.realname = realname;
		this.age = age;
		this.sex = sex;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}



	/** minimal constructor */
	public AbstractUser(String nickname, String realname, String password,
			String email, Integer userdegree) {
		this.nickname = nickname;
		this.realname = realname;
		this.password = password;
		this.email = email;
		this.userdegree = userdegree;
	}

	/** full constructor */
	public AbstractUser(String nickname, String realname, Integer age,
			String sex, String password, String email, String phone,
			Timestamp createtime, Timestamp lastlogintime, Integer userdegree,
			Set<Order> Orders, Set<Address> Addresses
			) {
		this.nickname = nickname;
		this.realname = realname;
		this.age = age;
		this.sex = sex;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.createtime = createtime;
		this.lastlogintime = lastlogintime;
		this.userdegree = userdegree;
		this.Orders = Orders;
		this.Addresses = Addresses;
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getLastlogintime() {
		return this.lastlogintime;
	}

	public void setLastlogintime(Timestamp lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public Integer getUserdegree() {
		return this.userdegree;
	}

	public void setUserdegree(Integer userdegree) {
		this.userdegree = userdegree;
	}

	public Set<Order> getOrders() {
		return this.Orders;
	}

	public void setOrders(Set<Order> Orders) {
		this.Orders = Orders;
	}

	public Set<Address> getAddresses() {
		return this.Addresses;
	}

	public void setAddresses(Set<Address> Addresses) {
		this.Addresses = Addresses;
	}

}