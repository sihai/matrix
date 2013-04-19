/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class ItemTraceLogDO extends BaseTraceLogDO {
	
	private ItemDO  item;
	private ShopDO 	shop;
	
	private Integer	platform;

	public ItemDO getItem() {
		return item;
	}

	public void setItem(ItemDO item) {
		this.item = item;
	}

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
