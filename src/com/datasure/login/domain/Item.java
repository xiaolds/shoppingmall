package com.datasure.login.domain;

/**
 * DItem entity. @author MyEclipse Persistence Tools
 */

public class Item implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer itemid;
	private Order Order;
	private Double unitprice;
	private Integer productid;
	private String productname;
	private Integer productnumber;

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** minimal constructor */
	public Item(Integer productnumber) {
		this.productnumber = productnumber;
	}

	/** full constructor */
	public Item(Order Order, Double unitprice, Integer productid,
			String productname, Integer productnumber) {
		this.Order = Order;
		this.unitprice = unitprice;
		this.productid = productid;
		this.productname = productname;
		this.productnumber = productnumber;
	}

	// Property accessors

	public Integer getItemid() {
		return this.itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public Order getOrder() {
		return this.Order;
	}

	public void setOrder(Order Order) {
		this.Order = Order;
	}

	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getProductnumber() {
		return this.productnumber;
	}

	public void setProductnumber(Integer productnumber) {
		this.productnumber = productnumber;
	}

}