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
public enum SearchModeEnum {
	
	PRODUCT(0, "Only Search Product"),
	ITEM(1, "Only Search Item"),
	SHOP(2, "Only Search Shop"),
	HYBRID(3, "Hybrid, Search Both");
	
	private int value;
	private String desc;
	
	/**
	 * 
	 * @param value
	 * @param desc
	 */
	private SearchModeEnum(int value, String desc) {
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
	public static SearchModeEnum toEnum(int value) {
		for(SearchModeEnum s : SearchModeEnum.values()) {
			if(s.value == value) {
				return s;
			}
		}
		
		return null;
	}
}