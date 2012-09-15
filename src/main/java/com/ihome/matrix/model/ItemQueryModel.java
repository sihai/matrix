package com.ihome.matrix.model;

public class ItemQueryModel extends BaseQueryModel {
	
	private Long category;
	private Long shop;
	private Integer status;
	private Integer platform;
	
	public Long getCategory() {
		return category;
	}
	public Long getShop() {
		return shop;
	}
	public Integer getStatus() {
		return status;
	}
	public Integer getPlatform() {
		return platform;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	public void setShop(Long shop) {
		this.shop = shop;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
	
	public ItemQueryModel newInstance() {
		return new ItemQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	public ItemQueryModel withCategory(Long category) {
		this.category = category;
		return this;
	}
	
	public ItemQueryModel withShop(Long shop) {
		this.shop = shop;
		return this;
	}
	
	public ItemQueryModel withStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public ItemQueryModel withPlatform(Integer platform) {
		this.platform = platform;
		return this;
	}
	
	@Override
	public ItemQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public ItemQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}
}
