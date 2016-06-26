package com.datasure.login.domain;

/**
 * DAddress entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User User;
	private String postcode;
	private String address;
	private String phone;

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** full constructor */
	public Address(User User, String postcode, String address, String phone) {
		this.User = User;
		this.postcode = postcode;
		this.address = address;
		this.phone = phone;
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.User;
	}

	public void setUser(User User) {
		this.User = User;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}