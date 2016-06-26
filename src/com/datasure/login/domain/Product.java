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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Category == null) ? 0 : Category.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((downdate == null) ? 0 : downdate.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((originprice == null) ? 0 : originprice.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result
				+ ((presentprice == null) ? 0 : presentprice.hashCode());
		result = prime * result
				+ ((productid == null) ? 0 : productid.hashCode());
		result = prime * result
				+ ((sellnumber == null) ? 0 : sellnumber.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + ((update == null) ? 0 : update.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (Category == null) {
			if (other.Category != null)
				return false;
		} else if (!Category.equals(other.Category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (downdate == null) {
			if (other.downdate != null)
				return false;
		} else if (!downdate.equals(other.downdate))
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (originprice == null) {
			if (other.originprice != null)
				return false;
		} else if (!originprice.equals(other.originprice))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (presentprice == null) {
			if (other.presentprice != null)
				return false;
		} else if (!presentprice.equals(other.presentprice))
			return false;
		if (productid == null) {
			if (other.productid != null)
				return false;
		} else if (!productid.equals(other.productid))
			return false;
		if (sellnumber == null) {
			if (other.sellnumber != null)
				return false;
		} else if (!sellnumber.equals(other.sellnumber))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (update == null) {
			if (other.update != null)
				return false;
		} else if (!update.equals(other.update))
			return false;
		return true;
	}

	
	

}