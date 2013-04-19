/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class BrandProductDO extends BaseDO {
	
	private BrandDO 	brand;
	private ProductDO 	product;
	private Long		rank;
	private Integer		status;
	
	public BrandDO getBrand() {
		return brand;
	}
	public void setBrand(BrandDO brand) {
		this.brand = brand;
	}
	public ProductDO getProduct() {
		return product;
	}
	public void setProduct(ProductDO product) {
		this.product = product;
	}
	public Long getRank() {
		return rank;
	}
	public void setRank(Long rank) {
		this.rank = rank;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}