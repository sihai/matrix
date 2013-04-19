package com.ihome.matrix.manager.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihome.matrix.MatrixBaseTestCase;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.ShopDO;
import com.ihome.matrix.enums.PlatformEnum;
import com.ihome.matrix.manager.ShopManager;

public class ShopManagerImplTest extends MatrixBaseTestCase {

	@Autowired
	private ShopManager shopManager;
	
	@Test
	public void test() throws Exception {
		CategoryDO cat = new CategoryDO();
		cat.setId(0L);
		
		ShopDO shop = new ShopDO();
		shop.setDescription("店铺简介");
		shop.setDetailURL("http：//www.google.com");
		shop.setIsDeleted(false);
		shop.setName("店铺名称");
		shop.setLogoURL("http：//www.google.com");
		shop.setRank(1L);
		shop.setIsRecommend(false);
		shop.setPlatform(PlatformEnum.PLATFORM_IGO.getValue());
		shop.setSellerName("卖家名称");
		shop.setShopId("888888888999999998888899998889889898989898989898989");
		shop.setStatus(0);
		
		shopManager.add(shop);
	}
	
	public void setShopManager(ShopManager shopManager) {
		this.shopManager = shopManager;
	}
	
	public static void main(String[] args) {
		Thread t = new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 100000000; i++) {
					System.out.println(i);
				}
			}
		};
		t.setDaemon(true);
		t.start();
		String name = t.getName();
 		System.out.println(t.getName());
	}
}