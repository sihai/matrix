/**
 * ihome.igo
 */
package com.ihome.matrix.enums;

/**
 * 
 * @author sihai
 *
 */
public enum StuffStatusEnum {
	
	STUFF_NEW(0, "全新"),
	STUFF_UNUSED(1, "闲置"),
	STUFF_SECOND(2, "二手");
	
	public static final String TAOBAO_STUFF_NEW = "new";
	public static final String TAOBAO_STUFF_UNUSED = "unused";
	public static final String TAOBAO_STUFF_SECOND = "second";
	
	private int 	value;
	private String 	name;
	
	private StuffStatusEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static StuffStatusEnum toEnum(int value) {
		for(StuffStatusEnum e : StuffStatusEnum.values()) {
			if(e.getValue() == value) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static StuffStatusEnum valueOf4Taobao(String value) {
		if(TAOBAO_STUFF_NEW.equals(value)) {
			return STUFF_NEW;
		} else if(TAOBAO_STUFF_UNUSED.equals(value)) {
			return STUFF_UNUSED;
		} else if(TAOBAO_STUFF_SECOND.equals(value)) {
			return STUFF_SECOND;
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
