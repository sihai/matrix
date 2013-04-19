/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class TraceLogDO extends BaseTraceLogDO {
	
	private String  	refererURL;
	private String  	clickURL;
	private ItemDO		item;
	private ShopDO		shop;
	private WebSiteDO 	webSite;
	
	public String getRefererURL() {
		return refererURL;
	}
	
	public void setRefererURL(String refererURL) {
		this.refererURL = refererURL;
	}
	
	public String getClickURL() {
		return clickURL;
	}
	
	public void setClickURL(String clickURL) {
		this.clickURL = clickURL;
	}
	
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
	
	public WebSiteDO getWebSite() {
		return webSite;
	}

	public void setWebSite(WebSiteDO webSite) {
		this.webSite = webSite;
	}
}
