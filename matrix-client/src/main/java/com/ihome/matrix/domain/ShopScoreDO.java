package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class ShopScoreDO extends BaseDO {
	
	private Integer itemScore;		// 商品描述评分，满分100
	private Integer serviceScore;	// 服务态度评分，满分100
	private Integer deliveryScore;	// 发货速度评分，满分100
	
	public Integer getItemScore() {
		return itemScore;
	}
	public void setItemScore(Integer itemScore) {
		this.itemScore = itemScore;
	}
	public Integer getServiceScore() {
		return serviceScore;
	}
	public void setServiceScore(Integer serviceScore) {
		this.serviceScore = serviceScore;
	}
	public Integer getDeliveryScore() {
		return deliveryScore;
	}
	public void setDeliveryScore(Integer deliveryScore) {
		this.deliveryScore = deliveryScore;
	}
}
