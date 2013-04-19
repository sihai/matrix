/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class CategoryAssDO extends BaseDO {

	private Long outCategoryId;
	
	private String outCategoryName;
	
	private Integer platform;
	
	private String shopName;
	
	private CategoryDO category;

	public Long getOutCategoryId() {
		return outCategoryId;
	}

	public void setOutCategoryId(Long outCategoryId) {
		this.outCategoryId = outCategoryId;
	}

	public String getOutCategoryName() {
		return outCategoryName;
	}

	public void setOutCategoryName(String outCategoryName) {
		this.outCategoryName = outCategoryName;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public CategoryDO getCategory() {
		return category;
	}

	public void setCategory(CategoryDO category) {
		this.category = category;
	}
}
