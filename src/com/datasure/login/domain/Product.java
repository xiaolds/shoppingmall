package com.datasure.login.domain;

import java.sql.Timestamp;

/**
 * DProduct entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer productid;
	private Category Category;
	private String name;
	private Double originprice;
	private Double presentprice;
	private Timestamp update;
	private Timestamp downdate;
	private Integer stock;
	private String description;
	private Integer sellnumber;
	private String picture;
	private String keyword;

	// Constructors
	/** default constructor */
	public Product() {
	}
	public Product(String name) {
		this.name = name;
	}
	
	/** minimal constructor */
	public Product(Category Category, String name) {
		this.Category = Category;
		this.name = name;
	}

	/** full constructor */
	public Product(Category Category, String name, Double originprice,
			Double presentprice, Timestamp update, Timestamp downdate,
			Integer stock, String description, Integer sellnumber,
			String picture, String keyword) {
		this.Category = Category;
		this.name = name;
		this.originprice = originprice;
		this.presentprice = presentprice;
		this.update = update;
		this.downdate = downdate;
		this.stock = stock;
		this.description = description;
		this.sellnumber = sellnumber;
		this.picture = picture;
		this.keyword = keyword;
	}

	// Property accessors

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Category getCategory() {
		return this.Category;
	}

	public void setCategory(Category Category) {
		this.Category = Category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getOriginprice() {
		return this.originprice;
	}

	public void setOriginprice(Double originprice) {
		this.originprice = originprice;
	}

	public Double getPresentprice() {
		return this.presentprice;
	}

	public void setPresentprice(Double presentprice) {
		this.presentprice = presentprice;
	}

	public Timestamp getUpdate() {
		return this.update;
	}

	public void setUpdate(Timestamp update) {
		this.update = update;
	}

	public Timestamp getDowndate() {
		return this.downdate;
	}

	public void setDowndate(Timestamp downdate) {
		this.downdate = downdate;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSellnumber() {
		return this.sellnumber;
	}

	public void setSellnumber(Integer sellnumber) {
		this.sellnumber = sellnumber;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", Category=" + Category
				+ ", name=" + name + ", originprice=" + originprice
				+ ", update=" + update + ", downdate=" + downdate + ", stock="
				+ stock + ", description=" + description + ", sellnumber="
				+ sellnumber + ", picture=" + picture + ", keyword=" + keyword
				+ "]";
	}
	
	

}