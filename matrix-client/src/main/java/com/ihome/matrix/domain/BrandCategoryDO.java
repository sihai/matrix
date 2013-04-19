/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class BrandCategoryDO extends BaseDO {
	
	private BrandDO 	brand;
	private CategoryDO 	category;
	private Long		rank;
	private Integer		status;
	
	public BrandDO getBrand() {
		return brand;
	}
	public void setBrand(BrandDO brand) {
		this.brand = brand;
	}
	public CategoryDO getCategory() {
		return category;
	}
	public void setCategory(CategoryDO category) {
		this.category = category;
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