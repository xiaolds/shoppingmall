package com.datasure.login.domain;

/**
 * DShopcar entity. @author MyEclipse Persistence Tools
 */

public class Shopcar implements java.io.Serializable {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer shopcarid;
	private User User;
	private Integer productid;
	private Integer productnum;

	// Constructors

	/** default constructor */
	public Shopcar() {
	}

	/** full constructor */
	public Shopcar(User User, Integer productid, Integer productnum) {
		this.User = User;
		this.productid = productid;
		this.productnum = productnum;
	}

	// Property accessors

	public Integer getShopcarid() {
		return this.shopcarid;
	}

	public void setShopcarid(Integer shopcarid) {
		this.shopcarid = shopcarid;
	}

	public User getUser() {
		return this.User;
	}

	public void setUser(User User) {
		this.User = User;
	}

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getProductnum() {
		return this.productnum;
	}

	public void setProductnum(Integer productnum) {
		this.productnum = productnum;
	}

}