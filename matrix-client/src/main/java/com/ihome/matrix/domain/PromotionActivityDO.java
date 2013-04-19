/**
 * 
 */
package com.ihome.matrix.domain;

import java.util.Date;

/**
 * 
 * @author sihai
 *
 */
public class PromotionActivityDO extends BaseDO {
	
	private String name;
	private String logoURL;
	private String url;
	private Long   rank;
	private Date   startTime;
	private Date   endTime;
	private ShopDO shop;
	private CategoryDO category;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogoURL() {
		return logoURL;
	}
	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getRank() {
		return rank;
	}
	public void setRank(Long rank) {
		this.rank = rank;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
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
}