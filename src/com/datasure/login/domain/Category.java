package com.datasure.login.domain;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * DCategory entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer categoryid;
	private Integer fatherid;
	private String categoryname;
	private Integer categorygrade;
	private String categorydesc;
	private String url;
	private Set<Product> Products = new HashSet<Product>(0);

	// Constructors

	/** default constructor */
	public Category() {
	}
	
	public Category(Set<Product> Products) {
		this.Products = Products;
	}

	/** full constructor */
	public Category(Integer fatherid, String categoryname,
			Integer categorygrade, String categorydesc, Set<Product> Products) {
		this.fatherid = fatherid;
		this.categoryname = categoryname;
		this.categorygrade = categorygrade;
		this.categorydesc = categorydesc;
		this.Products = Products;
	}

	// Property accessors
	public Integer getCategoryid() {
		return this.categoryid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public Integer getFatherid() {
		return this.fatherid;
	}

	public void setFatherid(Integer fatherid) {
		this.fatherid = fatherid;
	}

	public String getCategoryname() {
		return this.categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Integer getCategorygrade() {
		return this.categorygrade;
	}

	public void setCategorygrade(Integer categorygrade) {
		this.categorygrade = categorygrade;
	}

	public String getCategorydesc() {
		return this.categorydesc;
	}

	public void setCategorydesc(String categorydesc) {
		this.categorydesc = categorydesc;
	}
	
	@JSON(serialize=false)
	public Set<Product> getProducts() {
		return Products;
	}

	public void setProducts(Set<Product> products) {
		Products = products;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Products == null) ? 0 : Products.hashCode());
		result = prime * result
				+ ((categorydesc == null) ? 0 : categorydesc.hashCode());
		result = prime * result
				+ ((categorygrade == null) ? 0 : categorygrade.hashCode());
		result = prime * result
				+ ((categoryid == null) ? 0 : categoryid.hashCode());
		result = prime * result
				+ ((categoryname == null) ? 0 : categoryname.hashCode());
		result = prime * result
				+ ((fatherid == null) ? 0 : fatherid.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Category other = (Category) obj;
		if (Products == null) {
			if (other.Products != null)
				return false;
		} else if (!Products.equals(other.Products))
			return false;
		if (categorydesc == null) {
			if (other.categorydesc != null)
				return false;
		} else if (!categorydesc.equals(other.categorydesc))
			return false;
		if (categorygrade == null) {
			if (other.categorygrade != null)
				return false;
		} else if (!categorygrade.equals(other.categorygrade))
			return false;
		if (categoryid == null) {
			if (other.categoryid != null)
				return false;
		} else if (!categoryid.equals(other.categoryid))
			return false;
		if (categoryname == null) {
			if (other.categoryname != null)
				return false;
		} else if (!categoryname.equals(other.categoryname))
			return false;
		if (fatherid == null) {
			if (other.fatherid != null)
				return false;
		} else if (!fatherid.equals(other.fatherid))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	

	



}