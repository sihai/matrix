package com.ihome.matrix.model;

public class CategoryQueryModel extends BaseQueryModel {
	
	private Long parent;
	private Integer status;
	
	
	public static CategoryQueryModel newInstance() {
		return new CategoryQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	public CategoryQueryModel withParent(Long parent) {
		this.parent = parent;
		return this;
	}
	
	
	public CategoryQueryModel withStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@Override
	public CategoryQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public CategoryQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}

	//======================================================
	//					setter/getter
	//======================================================
	
	public Long getParent() {
		return parent;
	}

	public Integer getStatus() {
		return status;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
