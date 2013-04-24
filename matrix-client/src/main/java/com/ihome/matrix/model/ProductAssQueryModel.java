package com.ihome.matrix.model;

public class ProductAssQueryModel extends BaseQueryModel {
	
	private Long outProductId;
	
	private String outProductName;
	
	private Integer platform;
	
	private Long innerProductId;
	
	
	public static ProductAssQueryModel newInstance() {
		return new ProductAssQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	public ProductAssQueryModel withOutProductId(Long outProductId) {
		this.outProductId = outProductId;
		return this;
	}
	
	
	public ProductAssQueryModel withOutProductName(String outProductName) {
		this.outProductName = outProductName;
		return this;
	}
	
	public ProductAssQueryModel withPlatform(Integer platform) {
		this.platform = platform;
		return this;
	}
	
	public ProductAssQueryModel withInnerProductId(Long innerProductId) {
		this.innerProductId = innerProductId;
		return this;
	}
	
	@Override
	public ProductAssQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public ProductAssQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}

	//======================================================
	//					setter/getter
	//======================================================
	public Long getOutProductId() {
		return outProductId;
	}

	public void setOutProductId(Long outProductId) {
		this.outProductId = outProductId;
	}

	public String getOutProductName() {
		return outProductName;
	}

	public void setOutProductName(String outProductName) {
		this.outProductName = outProductName;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public Long getInnerProductId() {
		return innerProductId;
	}

	public void setInnerProductId(Long innerProductId) {
		this.innerProductId = innerProductId;
	}
}
