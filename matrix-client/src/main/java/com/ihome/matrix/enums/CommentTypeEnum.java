/**
 * ihome.igo
 */
package com.ihome.matrix.enums;

/**
 * 
 * @author sihai
 *
 */
public enum CommentTypeEnum {
	
	ITEM(0, "Comment of Item");
	
	private int 	value;
	private String 	name;
	
	private CommentTypeEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static CommentTypeEnum toEnum(int value) {
		for(CommentTypeEnum e : CommentTypeEnum.values()) {
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
