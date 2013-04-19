/**
 * 
 */
package com.ihome.matrix.model;


/**
 * 
 * @author sihai
 *
 */
public class BrandCategoryQueryModel extends BaseQueryModel {
	
	private Long  	brand;
	private Long 	category;
	private Integer status;
	
	public static BrandCategoryQueryModel newInstance() {
		return new BrandCategoryQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	
	public BrandCategoryQueryModel withBrand(Long brand) {
		this.brand = brand;
		return this;
	}
	
	public BrandCategoryQueryModel withCategory(Long category) {
		this.category = category;
		return this;
	}
	
	public BrandCategoryQueryModel withStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@Override
	public BrandCategoryQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public BrandCategoryQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}

	
	//======================================================
	//				stter/getter
	//======================================================
	public Long getBrand() {
		return brand;
	}

	public void setBrand(Long brand) {
		this.brand = brand;
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