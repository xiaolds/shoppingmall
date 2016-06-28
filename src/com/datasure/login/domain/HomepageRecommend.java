package com.datasure.login.domain;

/**
 * DHomepageRecommend entity. @author MyEclipse Persistence Tools
 */

public class HomepageRecommend implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer recommendid;
	private Integer productid;

	// Constructors

	/** default constructor */
	public HomepageRecommend() {
	}

	/** full constructor */
	public HomepageRecommend(Integer productid) {
		this.productid = productid;
	}

	// Property accessors

	public Integer getRecommendid() {
		return this.recommendid;
	}

	public void setRecommendid(Integer recommendid) {
		this.recommendid = recommendid;
	}

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

}