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
	
	PLATFORM_IGO(0, "igo", "http://www.igo.com", "/assets/img/platform/igo.png"),
	PLATFORM_TAOBAO(1, "Taobao(淘宝集市)", "http://www.taobao.com", "/assets/img/platform/taobao.png"),
	PLATFORM_TMALL(2, "Tall(天猫商城)", "http://www.tmall.com", "/assets/img/platform/tmall.png"),
	PLATFORM_360_BUY(3, "360buy(京东商城)", "http://www.360buy.com", "/assets/img/platform/360buy.png"),
	PLATFORM_DANGDANG(4, "Dangdang(当当网)", "http://www.dangdang.com", "/assets/img/platform/dangdang.png"),
	PLATFORM_AMAZON(5, "Amazon(亚马逊)", "http://www.amazon.cn", "/assets/img/platform/amazon.png"),
	PLATFORM_NO_1_SHOP(6, "No.1 Shop(一号店)", "http://www.yihaodian.com", "/assets/img/platform/no1shop.png"),
	PLATFORM_NEW_EGG(7, "New Egg(新蛋)", "http://www.newegg.cn", "/assets/img/platform/newegg.png"),
	PLATFORM_51_BUY(8, "51Buy(易迅)", "http://www.51buy.com", "/assets/img/platform/51buy.png"),
	PLATFORM_LUSEN(9, "Lusen(绿森)", "http://www.lusen.com", "/assets/img/platform/lusen.png"),
	PLATFORM_EFEIHU(10, "efeihu(飞虎乐购)", "http://www.efeihu.com", "/assets/img/platform/efeihu.png"),
	PLATFORM_TAO3C(11, "Tao3c(高鸿)", "http://www.tao3c.com", "/assets/img/platform/tao3c.png"),
	PLATFORM_COO8(12, "coo8(库巴)", "http://www.coo8.com", "/assets/img/platform/coo8.png"),
	PLATFORM_SUNING(13, "suning(苏宁)", "http://www.suning.com", "/assets/img/platform/suning.png"),
	PLATFORM_GOME(14, "gome(国美)", "http://www.gome.com", "/assets/img/platform/gome.png"),
	PLATFORM_OUKU(15, "ouku(欧酷)", "http://www.ouku.com", "/assets/img/platform/ouku.png"),
	PLATFORM_NEW7(16, "new7(新七天)", "http://www.new7.com", "/assets/img/platform/new7.png"),
	PLATFORM_RED_BABY(17, "redbaby(红孩儿)", "http://www.redbaby.cn", "/assets/img/platform/redbaby.png"),
	PLATFORM_EHAOYAO(18, "京东好药师网", "http://www.ehaoyao.com/", "/assets/img/platform/ehaoyao.png"),
	PLATFORM_NO1_YAO_WANG(19, "一号药网", "http://www.111.com.cn/", "/assets/img/platform/no1yaowang.png"),
	PLATFORM_BEIJING_YAO_PIN_WANG(20, "北京药品网", "http://www.bjypw.com/", "/assets/img/platform/beijingyaopinwang.png"),
	PLATFORM_DAO_YAO(21, "导药网", "http://www.daoyao.com/", "/assets/img/platform/daoyao.png"),
	PLATFORM_HE_PING(22, "和平药房", "http://www.hp1997.com/", "/assets/img/platform/heping.png"),
	PLATFORM_GUANG_YAO_JIAN_MIN(23, "广药健民", "http://www.gyjm.com.cn/", "/assets/img/platform/gyjm.png"),
	PLATFORM_HUA_TUO_YAO_FANG(24, "华佗药房", "http://www.huatuoyf.com/", "/assets/img/platform/huatuoyaofang.png"),
	PLATFORM_JIAN_YI_WANG(25, "健一网", "http://www.j1.com/", "/assets/img/platform/jianyiwang.png"),
	PLATFORM_JIN_XIANG_DA_YAO_FANG(26, "金象大药房", "http://www.jxdyf.com/", "/assets/img/platform/jinxiangdayaofang.png");
	
	private int 	value;
	private String 	name;
	private String  url;
	private String  logoURL;
	
	private PlatformEnum(int value, String name, String url, String logoURL) {
		this.value = value;
		this.name = name;
		this.url = url;
		this.logoURL = logoURL;
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
	
	public String getUrl() {
		return url;
	}
	
	public String getlogoURL() {
		return logoURL;
	}
}
