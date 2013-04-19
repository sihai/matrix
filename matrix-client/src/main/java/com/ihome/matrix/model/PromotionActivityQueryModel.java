/**
 * 
 */
package com.ihome.matrix.model;

import java.util.Date;

/**
 * 
 * @author sihai
 *
 */
public class PromotionActivityQueryModel extends BaseQueryModel {
	
	private String  name;
	private Date 	startTime;
	private Date 	endTime;
	private Long	shop;
	private Long	category;
	
	public static PromotionActivityQueryModel newInstance() {
		return new PromotionActivityQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	
	public PromotionActivityQueryModel withName(String name) {
		this.name = name;
		return this;
	}
	
	public PromotionActivityQueryModel withStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}
	
	public PromotionActivityQueryModel withEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}
	
	public PromotionActivityQueryModel withShop(Long shop) {
		this.shop = shop;
		return this;
	}
	
	public PromotionActivityQueryModel withCategory(Long category) {
		this.category = category;
		return this;
	}
	
	@Override
	public PromotionActivityQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public PromotionActivityQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}
	
	//======================================================
	//				stter/getter
	//======================================================
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;;
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

	public Long getShop() {
		return shop;
	}

	public void setShop(Long shop) {
		this.shop = shop;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}
}
