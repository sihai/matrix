/**
 * 
 */
package com.ihome.matrix.model;


/**
 * 
 * @author sihai
 *
 */
public class ItemTraceLogQueryModel extends BaseQueryModel {
	
	private Long  	uuid;
	private Long 	userId;
	private Long 	itemId;
	private Long	shopId;
	private Integer	platform;
	
	public static ItemTraceLogQueryModel newInstance() {
		return new ItemTraceLogQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	
	public ItemTraceLogQueryModel withUuid(Long uuid) {
		this.uuid = uuid;
		return this;
	}
	
	public ItemTraceLogQueryModel withUserId(Long userId) {
		this.userId = userId;
		return this;
	}
	
	public ItemTraceLogQueryModel withItemId(Long itemId) {
		this.itemId = itemId;
		return this;
	}
	
	public ItemTraceLogQueryModel withShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}
	
	public ItemTraceLogQueryModel withPlatform(Integer platform) {
		this.platform = platform;
		return this;
	}
	
	@Override
	public ItemTraceLogQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public ItemTraceLogQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}
	
	//======================================================
	//				stter/getter
	//======================================================
	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
}