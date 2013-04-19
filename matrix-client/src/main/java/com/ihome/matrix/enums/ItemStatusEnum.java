/**
 * ihome.igo
 */
package com.ihome.matrix.enums;

/**
 * 
 * @author sihai
 *
 */
public enum ItemStatusEnum {
	
	ITEM_STATUS_ON_SALE(0, "在售");
	
	private int 	value;
	private String 	name;
	
	private ItemStatusEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static ItemStatusEnum toEnum(int value) {
		for(ItemStatusEnum e : ItemStatusEnum.values()) {
			if(e.getValue() == value) {
				return e;
			}
		}
		return null;
	}
	
	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setName(String name) {
		this.name = name;
	}
}
