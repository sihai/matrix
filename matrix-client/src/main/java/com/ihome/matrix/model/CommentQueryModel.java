/**
 * 
 */
package com.ihome.matrix.model;


/**
 * 
 * @author sihai
 *
 */
public class CommentQueryModel extends BaseQueryModel {
	
	private Integer type;
	private Long 	owner;
	private Boolean	isBuy;
	
	public static CommentQueryModel newInstance() {
		return new CommentQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	
	public CommentQueryModel withType(Integer type) {
		this.type = type;
		return this;
	}
	
	public CommentQueryModel withOwner(Long owner) {
		this.owner = owner;
		return this;
	}
	
	public CommentQueryModel withIsBuy(Boolean isBuy) {
		this.isBuy = isBuy;
		return this;
	}
	
	@Override
	public CommentQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public CommentQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}
	
	//======================================================
	//				stter/getter
	//======================================================
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getOwner() {
		return owner;
	}

	public void setOwner(Long owner) {
		this.owner = owner;
	}

	public Boolean getIsBuy() {
		return isBuy;
	}

	public void setIsBuy(Boolean isBuy) {
		this.isBuy = isBuy;
	}
}