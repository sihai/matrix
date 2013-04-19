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
public class ActivityQueryModel extends BaseQueryModel {
	
	private String  name;
	private Date 	startTime;
	private Date 	endTime;
	
	public static ActivityQueryModel newInstance() {
		return new ActivityQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	
	public ActivityQueryModel withName(String name) {
		this.name = name;
		return this;
	}
	
	public ActivityQueryModel withStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}
	
	public ActivityQueryModel withEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}
	
	@Override
	public ActivityQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public ActivityQueryModel withPageSize(Long pageSize) {
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
}
