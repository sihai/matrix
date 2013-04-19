/**
 * ihome.igo
 */
package com.ihome.matrix.enums;

/**
 * 
 * @author sihai
 *
 */
public enum OwnerTypeEnum {
	
	PRODUCT(0, "Owner是Product");
	
	private int 	value;
	private String 	name;
	
	private OwnerTypeEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static OwnerTypeEnum toEnum(int value) {
		for(OwnerTypeEnum e : OwnerTypeEnum.values()) {
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