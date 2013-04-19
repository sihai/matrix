/*
 * ihome inc.
 * igo
 */
package com.ihome.matrix.enums;

/**
 * 搜索模式
 * @author sihai
 *
 */
public enum ShowModeEnum {
	
	PICTURE(0, "Show as picture"),
	LIST(1, "Show as list");
	
	private int value;
	private String desc;
	
	/**
	 * 
	 * @param value
	 * @param desc
	 */
	private ShowModeEnum(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getDesc() {
		return desc;
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static ShowModeEnum toEnum(int value) {
		for(ShowModeEnum s : ShowModeEnum.values()) {
			if(s.value == value) {
				return s;
			}
		}
		
		return null;
	}
}