package com.datasure.login.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * DOrder entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer orderid;
	private User User;
	private Integer status;
	private Timestamp ordertime;
	private String orderdesc;
	private String receivename;
	private String receiveaddress;
	private String postcode;
	private Boolean ispaid;
	private String payway;
	private Integer totalnumber;
	private Double totalprice;
	private Set<Item> Items = new HashSet<Item>(0);

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(User User) {
		this.User = User;
	}

	/** full constructor */
	public Order(User User, Integer status, Timestamp ordertime,
			String orderdesc, String receivename, String receiveaddress,
			String postcode, Boolean ispaid, String payway,
			Integer totalnumber, Double totalprice, Set<Item> Items) {
		this.User = User;
		this.status = status;
		this.ordertime = ordertime;
		this.orderdesc = orderdesc;
		this.receivename = receivename;
		this.receiveaddress = receiveaddress;
		this.postcode = postcode;
		this.ispaid = ispaid;
		this.payway = payway;
		this.totalnumber = totalnumber;
		this.totalprice = totalprice;
		this.Items = Items;
	}

	// Property accessors

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public User getUser() {
		return this.User;
	}

	public void setUser(User User) {
		this.User = User;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getOrdertime() {
		return this.ordertime;
	}

	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}

	public String getOrderdesc() {
		return this.orderdesc;
	}

	public void setOrderdesc(String orderdesc) {
		this.orderdesc = orderdesc;
	}

	public String getReceivename() {
		return this.receivename;
	}

	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}

	public String getReceiveaddress() {
		return this.receiveaddress;
	}

	public void setReceiveaddress(String receiveaddress) {
		this.receiveaddress = receiveaddress;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Boolean getIspaid() {
		return this.ispaid;
	}

	public void setIspaid(Boolean ispaid) {
		this.ispaid = ispaid;
	}

	public String getPayway() {
		return this.payway;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}

	public Integer getTotalnumber() {
		return this.totalnumber;
	}

	public void setTotalnumber(Integer totalnumber) {
		this.totalnumber = totalnumber;
	}

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public Set<Item> getItems() {
		return this.Items;
	}

	public void setItems(Set<Item> Items) {
		this.Items = Items;
	}

}