/**
 * ihome.igo
 */
package com.ihome.matrix.enums;

/**
 * 
 * @author sihai
 *
 */
public enum ShopCategoryStatusEnum {
	
	NORMAL(0, "正常");
	
	private int 	value;
	private String 	name;
	
	private ShopCategoryStatusEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static ShopCategoryStatusEnum toEnum(int value) {
		for(ShopCategoryStatusEnum e : ShopCategoryStatusEnum.values()) {
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
