/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class ShopProductDO extends BaseDO {

	private ShopDO    	shop;
	private ProductDO	product;
	private Long		rank;
	private Integer		status;
	
	public ShopDO getShop() {
		return shop;
	}
	public void setShop(ShopDO shop) {
		this.shop = shop;
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
