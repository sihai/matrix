package com.ihome.matrix.model;

public class ItemQueryModel extends BaseQueryModel {
	
	private String name;
	private Long product;
	private Long category;
	private Long shop;
	private Integer status;
	private Integer platform;
	
	public static ItemQueryModel newInstance() {
		return new ItemQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	public ItemQueryModel withName(String name) {
		this.name = name;
		return this;
	}
	
	public ItemQueryModel withProduct(Long product) {
		this.product = product;
		return this;
	}
	
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
	
	//======================================================
	//				setter/getter
	//======================================================
	
	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}
	
	public Long getCategory() {
		return category;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getShop() {
		return shop;
	}
	public Integer getStatus() {
		return status;
	}
	public Integer getPlatform() {
		return platform;
	}
}