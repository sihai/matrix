package com.ihome.matrix.enums;

public enum FreightFeePayerEnum {

	FREIGHT_FEE_PALYER_SELLER(0, "卖家承担运费"),
	FREIGHT_FEE_PALYER_BUYER(1, "买家承担运费");
	
	private int 	value;
	private String 	name;
	
	private FreightFeePayerEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static FreightFeePayerEnum toEnum(int value) {
		for(FreightFeePayerEnum e : FreightFeePayerEnum.values()) {
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
