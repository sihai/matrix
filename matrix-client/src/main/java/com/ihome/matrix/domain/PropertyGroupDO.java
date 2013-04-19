/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 属性分组
 * @author sihai
 *
 */
public class PropertyGroupDO extends BaseDO {
	
	private String 	name;		// 属性组名称
	private Integer type;		// type + owner 决定属性组的owner 
	private Long    owner;		// 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
}
