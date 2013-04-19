/**
 * 
 */
package com.ihome.matrix.domain;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 
 * @author sihai
 *
 */
public class ShopDO extends BaseDO {
	
	@Field
	private String name;			// 店铺名称
	@Field
	private String sellerName;		// 卖家名称
	@Field
	private String description;		// 店铺简介
	@Field
	private String logoURL;			// 店铺logo
	@Field
	private String detailURL;		// 店铺URL
	@Field
	private String location;
	
	private String shopId;			// 店铺id，和具体平台相关
	
	@Field
	private Long   rank;			// RANK
	@Field
	private Boolean isRecommend;	// 是否推荐，展示在首页
	
	
	private String payways;			// 支付方式
	
	private String distributeWays;	// 配送方式
	
	// 
	
	@Field
	private Integer platform;		// 店铺平台
	@Field
	private Integer status;			// igo sta
	
	private String license;			// 
	
	private ShopScoreDO shopScore;	// 店铺评分
	
	@Field
	private List<ShopCategoryDO> shopCategoryList;	// 主营类目
	@Field
	private List<ShopProductDO> shopProductList;	// 主营产品
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLogoURL() {
		return logoURL;
	}
	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}
	public String getDetailURL() {
		return detailURL;
	}
	public void setDetailURL(String detailURL) {
		this.detailURL = detailURL;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public Long getRank() {
		return rank;
	}
	public void setRank(Long rank) {
		this.rank = rank;
	}
	public Boolean getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(Boolean isRecommend) {
		this.isRecommend = isRecommend;
	}
	public String getPayways() {
		return payways;
	}
	public void setPayways(String payways) {
		this.payways = payways;
	}
	public String getDistributeWays() {
		return distributeWays;
	}
	public void setDistributeWays(String distributeWays) {
		this.distributeWays = distributeWays;
	}
	public Integer getPlatform() {
		return platform;
	}
	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public ShopScoreDO getShopScore() {
		return shopScore;
	}
	public void setShopScore(ShopScoreDO shopScore) {
		this.shopScore = shopScore;
	}
	public List<ShopCategoryDO> getShopCategoryList() {
		return shopCategoryList;
	}
	public void setShopCategoryList(List<ShopCategoryDO> shopCategoryList) {
		this.shopCategoryList = shopCategoryList;
	}
	public List<ShopProductDO> getShopProductList() {
		return shopProductList;
	}
	public void setShopProductList(List<ShopProductDO> shopProductList) {
		this.shopProductList = shopProductList;
	}
}