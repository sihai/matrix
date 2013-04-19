package com.ihome.matrix.model;

public class CategoryAssQueryModel extends BaseQueryModel {
	
	private Long outCategoryId;
	
	private String outCategoryName;
	
	private Integer platform;
	
	private String shopName;
	
	private Long innerCategoryId;
	
	
	public static CategoryAssQueryModel newInstance() {
		return new CategoryAssQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	public CategoryAssQueryModel withOutCategoryId(Long outCategoryId) {
		this.outCategoryId = outCategoryId;
		return this;
	}
	
	
	public CategoryAssQueryModel withOutCategoryName(String outCategoryName) {
		this.outCategoryName = outCategoryName;
		return this;
	}
	
	public CategoryAssQueryModel withPlatform(Integer platform) {
		this.platform = platform;
		return this;
	}
	
	public CategoryAssQueryModel withShopName(String shopName) {
		this.shopName = shopName;
		return this;
	}
	
	public CategoryAssQueryModel withInnerCategoryId(Long innerCategoryId) {
		this.innerCategoryId = innerCategoryId;
		return this;
	}
	
	@Override
	public CategoryAssQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public CategoryAssQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}

	//======================================================
	//					setter/getter
	//======================================================
	public Long getOutCategoryId() {
		return outCategoryId;
	}

	public void setOutCategoryId(Long outCategoryId) {
		this.outCategoryId = outCategoryId;
	}

	public String getOutCategoryName() {
		return outCategoryName;
	}

	public void setOutCategoryName(String outCategoryName) {
		this.outCategoryName = outCategoryName;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Long getInnerCategoryId() {
		return innerCategoryId;
	}

	public void setInnerCategoryId(Long innerCategoryId) {
		this.innerCategoryId = innerCategoryId;
	}
}
