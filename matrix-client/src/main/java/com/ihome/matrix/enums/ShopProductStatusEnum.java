/**
 * ihome.igo
 */
package com.ihome.matrix.enums;

/**
 * 
 * @author sihai
 *
 */
public enum ShopProductStatusEnum {
	
	NORMAL(0, "正常");
	
	private int 	value;
	private String 	name;
	
	private ShopProductStatusEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static ShopProductStatusEnum toEnum(int value) {
		for(ShopProductStatusEnum e : ShopProductStatusEnum.values()) {
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
