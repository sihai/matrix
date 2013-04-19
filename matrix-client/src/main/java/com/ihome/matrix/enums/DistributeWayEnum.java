/**
 * ihome.igo
 */
package com.ihome.matrix.enums;

/**
 * 
 * @author sihai
 *
 */
public enum DistributeWayEnum {
	
	EXPRESS_DELIVERY(0, "快递");
	
	private int 	value;
	private String 	name;
	
	private DistributeWayEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static DistributeWayEnum toEnum(int value) {
		for(DistributeWayEnum e : DistributeWayEnum.values()) {
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
