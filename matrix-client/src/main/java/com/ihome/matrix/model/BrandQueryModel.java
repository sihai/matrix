package com.ihome.matrix.model;

public class BrandQueryModel extends BaseQueryModel {
	
	private String  name;
	private Integer status;
	
	public static BrandQueryModel newInstance() {
		return new BrandQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	
	public BrandQueryModel withName(String name) {
		this.name = name;
		return this;
	}
	
	public BrandQueryModel withStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@Override
	public BrandQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public BrandQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}
	
	//======================================================
	//				stter/getter
	//======================================================
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
}
