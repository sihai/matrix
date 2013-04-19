/**
 * 
 */
package com.ihome.matrix.model;


/**
 * 
 * @author sihai
 *
 */
public class ShopCategoryQueryModel extends BaseQueryModel {
	
	private Long  	shop;
	private Long 	category;
	private Integer status;
	
	public static ShopCategoryQueryModel newInstance() {
		return new ShopCategoryQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	
	public ShopCategoryQueryModel withShop(Long shop) {
		this.shop = shop;
		return this;
	}
	
	public ShopCategoryQueryModel withCategory(Long category) {
		this.category = category;
		return this;
	}
	
	public ShopCategoryQueryModel withStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@Override
	public ShopCategoryQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public ShopCategoryQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}

	
	//======================================================
	//				stter/getter
	//======================================================
	public Long getShop() {
		return shop;
	}

	public void setShop(Long shop) {
		this.shop = shop;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}