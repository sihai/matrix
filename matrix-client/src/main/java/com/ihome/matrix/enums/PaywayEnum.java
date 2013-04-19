/**
 * ihome.igo
 */
package com.ihome.matrix.enums;

/**
 * 
 * @author sihai
 *
 */
public enum PaywayEnum {
	
	PAYMENT_AFTER_ARRIVAL_OF_GOODS(0, "货到付款"),
	ALIPAY(1, "支付宝"),
	TENPAY(2, "财付通"),
	NET_BANK(3, "网银");
	
	private int 	value;
	private String 	name;
	
	private PaywayEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static PaywayEnum toEnum(int value) {
		for(PaywayEnum e : PaywayEnum.values()) {
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
