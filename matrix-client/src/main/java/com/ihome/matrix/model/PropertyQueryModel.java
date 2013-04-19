package com.ihome.matrix.model;

public class PropertyQueryModel extends BaseQueryModel {
	
	private Integer type;
	private Long 	owner;
	private Long	group;
	
	public static PropertyQueryModel newInstance() {
		return new PropertyQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	public PropertyQueryModel withType(Integer type) {
		this.type = type;
		return this;
	}
	
	public PropertyQueryModel withOwner(Long owner) {
		this.owner = owner;
		return this;
	}
	
	public PropertyQueryModel withGroup(Long group) {
		this.group = group;
		return this;
	}
	
	@Override
	public PropertyQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public PropertyQueryModel withPageSize(Long pageSize) {
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
	public Long getGroup() {
		return group;
	}
}
