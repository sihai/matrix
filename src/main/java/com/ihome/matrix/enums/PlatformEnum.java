/**
 * ihome.igo
 */
package com.ihome.matrix.enums;

/**
 * 
 * @author sihai
 *
 */
public enum PlatformEnum {
	
	PLATFORM_IGO(0, "igo"),
	PLATFORM_TAOBAO(1, "Taobao(淘宝集市)"),
	PLATFORM_TMALL(2, "Tall(天猫商城)"),
	PLATFORM_360_BUY(3, "360buy(京东商城)"),
	PLATFORM_DANGDANG(4, "Dangdang(当当网)"),
	PLATFORM_AMAZON(5, "Amazon(亚马逊)"),
	PLATFORM_NO_1_SHOP(6, "No.1 Shop(一号店)"),
	PLATFORM_NEW_EGG(7, "New Egg(新蛋)"),
	PLATFORM_51_BUY(8, "51Buy(易迅)"),
	PLATFORM_LUSEN(9, "Lusen(绿森)"),
	PLATFORM_EFEIHU(9, "efeihu(飞虎乐购)"),
	PLATFORM_TAO3C(10, "Tao3c(高鸿)"),
	PLATFORM_COO8(11, "coo8(库巴)"),
	PLATFORM_SUNING(12, "suning(苏宁)"),
	PLATFORM_GOME(13, "gome(国美)"),
	PLATFORM_OUKU(14, "ouku(欧酷)"),
	PLATFORM_NEW7(15, "new7(新七天)"),
	PLATFORM_RED_BABY(16, "redbaby(红孩儿)");
	
	private int 	value;
	private String 	name;
	
	private PlatformEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static PlatformEnum toEnum(int value) {
		for(PlatformEnum e : PlatformEnum.values()) {
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
