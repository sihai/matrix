/**
 * ihome.igo
 */
package com.ihome.matrix.enums;

/**
 * 
 * @author sihai
 *
 */
public enum ShopStatusEnum {
	
	SHOP_STATUS_NORMAL(0, "正常");
	
	private int 	value;
	private String 	name;
	
	private ShopStatusEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static ShopStatusEnum toEnum(int value) {
		for(ShopStatusEnum e : ShopStatusEnum.values()) {
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
}