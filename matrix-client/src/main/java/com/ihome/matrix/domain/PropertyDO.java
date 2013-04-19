/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class PropertyDO extends BaseDO {

	private String 			key;
	private String 			value;
	private Integer 		valueType;
	private PropertyGroupDO group;
	private Integer type;		// type + owner 决定属性组的owner 
	private Long    owner;		// 
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getValueType() {
		return valueType;
	}
	public void setValueType(Integer valueType) {
		this.valueType = valueType;
	}
	public PropertyGroupDO getGroup() {
		return group;
	}
	public void setGroup(PropertyGroupDO group) {
		this.group = group;
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