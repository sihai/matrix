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
public class CommentDO extends BaseDO {
	
	private Double 	score;				// 
	private String 	content;			// 
	private String  publisher;			// 
	private Integer type;				// 
	private BaseDO 	owner;				// 
	private Date	publishTime;		// 
	private Boolean isBuy;				// 是否购买过
	
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public BaseDO getOwner() {
		return owner;
	}
	public void setOwner(BaseDO owner) {
		this.owner = owner;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Boolean getIsBuy() {
		return isBuy;
	}
	public void setIsBuy(Boolean isBuy) {
		this.isBuy = isBuy;
	}
	
	
}
