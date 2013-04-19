/**
 * 
 */
package com.ihome.matrix.model;


/**
 * 
 * @author sihai
 *
 */
public class BrandProductQueryModel extends BaseQueryModel {
	
	private Long  	brand;
	private Long 	product;
	private Integer status;
	
	public static BrandProductQueryModel newInstance() {
		return new BrandProductQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	
	public BrandProductQueryModel withBrand(Long brand) {
		this.brand = brand;
		return this;
	}
	
	public BrandProductQueryModel withProduct(Long product) {
		this.product = product;
		return this;
	}
	
	public BrandProductQueryModel withStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@Override
	public BrandProductQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public BrandProductQueryModel withPageSize(Long pageSize) {
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