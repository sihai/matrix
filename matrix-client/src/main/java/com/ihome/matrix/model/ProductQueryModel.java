package com.ihome.matrix.model;

public class ProductQueryModel extends BaseQueryModel {
	
	private String name;
	private Long brand;
	private Long category;
	private Integer status;
	
	public static ProductQueryModel newInstance() {
		return new ProductQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	
	public ProductQueryModel withName(String name) {
		this.name = name;
		return this;
	}
	
	public ProductQueryModel withBrand(Long brand) {
		this.brand = brand;
		return this;
	}
	
	public ProductQueryModel withCategory(Long category) {
		this.category = category;
		return this;
	}
	
	public ProductQueryModel withStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@Override
	public ProductQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public ProductQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}
	
	//======================================================
	//				setter/getter
	//======================================================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getBrand() {
		return brand;
	}
	
	public Long getCategory() {
		return category;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setBrand(Long brand) {
		this.brand = brand;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
