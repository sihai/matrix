package com.ihome.matrix.model;

public class PropertyGroupQueryModel extends BaseQueryModel {
	
	private Integer type;
	private Long 	owner;
	
	public static PropertyGroupQueryModel newInstance() {
		return new PropertyGroupQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	public PropertyGroupQueryModel withType(Integer type) {
		this.type = type;
		return this;
	}
	
	public PropertyGroupQueryModel withOwner(Long owner) {
		this.owner = owner;
		return this;
	}
	
	@Override
	public PropertyGroupQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public PropertyGroupQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}
	
	//======================================================
	//				getter
	//======================================================
	
	public Integer getType() {
		return type;
	}
	public Long getOwner() {
		return owner;
	}
}
