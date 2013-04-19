/**
 * ihome.igo
 */
package com.ihome.matrix.enums;

/**
 * 
 * @author sihai
 *
 */
public enum WebSiteTypeEnum {
	
	COMPOSITE_COMPARE_PIRCE(0, "综合比价"),
	THREE_C_COMPARE_PIRCE(1, "3C比价");
	
	private int 	value;
	private String 	name;
	
	private WebSiteTypeEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static WebSiteTypeEnum toEnum(int value) {
		for(WebSiteTypeEnum e : WebSiteTypeEnum.values()) {
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
