/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class ShopTraceLogDO extends BaseTraceLogDO {
	
	private ShopDO  shop;
	private Integer	platform;
	
	public ShopDO getShop() {
		return shop;
	}
	
	public void setShop(ShopDO shop) {
		this.shop = shop;
	}
	
	public Integer getPlatform() {
		return platform;
	}
	
	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
}
