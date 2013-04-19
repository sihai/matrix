package com.ihome.matrix.model;

public class PictureQueryModel extends BaseQueryModel {
	
	private Integer type;
	private Long 	owner;
	
	public static PictureQueryModel newInstance() {
		return new PictureQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	public PictureQueryModel withType(Integer type) {
		this.type = type;
		return this;
	}
	
	public PictureQueryModel withOwner(Long owner) {
		this.owner = owner;
		return this;
	}
	
	@Override
	public PictureQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public PictureQueryModel withPageSize(Long pageSize) {
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
