/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class ShopCategoryDO extends BaseDO {
	
	private ShopDO 		shop;
	private CategoryDO 	category;
	private Long		rank;
	private Integer		status;
	
	public ShopDO getShop() {
		return shop;
	}
	public void setShop(ShopDO shop) {
		this.shop = shop;
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