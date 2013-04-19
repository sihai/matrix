/**
 * ihome
 * igo
 */
package com.ihome.matrix.model;

/**
 * 
 * @author sihai
 *
 */
public class ShopQueryModel extends BaseQueryModel {
	
	private String name;
	private Integer status;
	private Boolean isRecommend;
	private Integer platform;
	
	public static ShopQueryModel newInstance() {
		return new ShopQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	
	public ShopQueryModel withName(String name) {
		this.name = name;
		return this;
	}
	
	public ShopQueryModel withStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public ShopQueryModel withIsRecommend(Boolean isRecommend) {
		this.isRecommend = isRecommend;
		return this;
	}
	
	public ShopQueryModel withPlatform(Integer platform) {
		this.platform = platform;
		return this;
	}
	
	@Override
	public ShopQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public ShopQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}
	
	//======================================================
	//				DSL
	//======================================================
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Boolean getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Boolean isRecommend) {
		this.isRecommend = isRecommend;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public Integer getStatus() {
		return status;
	}
	public Integer getPlatform() {
		return platform;
	}
}