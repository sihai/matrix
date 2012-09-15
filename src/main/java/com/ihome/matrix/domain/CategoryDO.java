package com.ihome.matrix.domain;

public class CategoryDO extends BaseDO {
	
	private String name;
	private String description;
	private Integer status;
	private Integer rank;
	
	private CategoryDO parent;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getStatus() {
		return status;
	}

	public Integer getRank() {
		return rank;
	}

	public CategoryDO getParent() {
		return parent;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public void setParent(CategoryDO parent) {
		this.parent = parent;
	}
}
