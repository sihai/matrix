package com.ihome.matrix.model;

public class ShopProductQueryModel extends BaseQueryModel {
	
	private Long 	shop;
	private Long 	product;
	private Integer status;
	
	public static ShopProductQueryModel newInstance() {
		return new ShopProductQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	public ShopProductQueryModel withShop(Long shop) {
		this.shop = shop;
		return this;
	}
	
	public ShopProductQueryModel withProduct(Long product) {
		this.product = product;
		return this;
	}
	
	public ShopProductQueryModel withStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@Override
	public ShopProductQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public ShopProductQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}
	
	//======================================================
	//				setter/getter
	//======================================================
	public Long getShop() {
		return shop;
	}

	public void setShop(Long shop) {
		this.shop = shop;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
