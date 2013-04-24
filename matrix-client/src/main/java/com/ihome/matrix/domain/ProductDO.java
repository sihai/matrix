/**
 * 
 */
package com.ihome.matrix.domain;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 产品定义
 * @author sihai
 *
 */
public class ProductDO extends BaseDO {
	
	@Field
	private String name;						// 产品名称
	@Field
	private String logoURL;						// 产品logo URL
	
	private BrandDO brand;						// 品牌
	private CategoryDO category;				// 类目
	
	private String description;					// 
	
	@Field
	private Integer status;						// 状态
	
	// 产品属性
	private List<PropertyDO> propertyList;		// 属性
	
	// 如下属性是动态计算出来
	private Long   pictureCount;				// 图片数量
	private Double score;						// 综合评分
	private Double badCommentRate;				// 推荐
	private Long   commentCount;				// 推荐次数
	private List<Double> averagePriceList;		// 历史均价
	private Double minPrice;					// 最低价格
	private Double maxPrice;					// 最高价格
	
	private List<ShopDO> shopList;				// 有售的店铺
	
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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public List<PropertyDO> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<PropertyDO> propertyList) {
		this.propertyList = propertyList;
	}

	public Long getPictureCount() {
		return pictureCount;
	}

	public void setPictureCount(Long pictureCount) {
		this.pictureCount = pictureCount;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Double getBadCommentRate() {
		return badCommentRate;
	}

	public void setBadCommentRate(Double badCommentRate) {
		this.badCommentRate = badCommentRate;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public List<Double> getAveragePriceList() {
		return averagePriceList;
	}

	public void setAveragePriceList(List<Double> averagePriceList) {
		this.averagePriceList = averagePriceList;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public List<ShopDO> getShopList() {
		return shopList;
	}

	public void setShopList(List<ShopDO> shopList) {
		this.shopList = shopList;
	}
}