/**
 * ihome.igo
 */
package com.ihome.matrix.enums;

/**
 * 
 * @author sihai
 *
 */
public enum BrandStatusEnum {
	
	NORMAL(0, "正常");
	
	private int 	value;
	private String 	name;
	
	private BrandStatusEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static BrandStatusEnum toEnum(int value) {
		for(BrandStatusEnum e : BrandStatusEnum.values()) {
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
