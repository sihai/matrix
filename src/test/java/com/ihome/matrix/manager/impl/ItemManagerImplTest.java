package com.ihome.matrix.manager.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihome.matrix.MatrixBaseTestCase;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.domain.ShopDO;
import com.ihome.matrix.enums.FreightFeePayerEnum;
import com.ihome.matrix.enums.ItemStatusEnum;
import com.ihome.matrix.enums.PlatformEnum;
import com.ihome.matrix.manager.ItemManager;

public class ItemManagerImplTest extends MatrixBaseTestCase {

	@Autowired
	private ItemManager itemManager;
	
	@Test
	public void testAdd() throws Exception {
		ItemDO item = new ItemDO();
		ShopDO shop = new ShopDO();
		shop.setId(1L);
		CategoryDO cat = new CategoryDO();
		cat.setId(1L);
		item.setCategory(cat);
		item.setDetailURL("http://www.google.com");
		item.setLogoURL("http://www.google.com");
		item.setName("test_test_test_test");
		item.setPlatform(PlatformEnum.PLATFORM_IGO.getValue());
		item.setPrice(0.99D);
		item.setShop(shop);
		item.setStatus(ItemStatusEnum.ITEM_STATUS_ON_SALE.getValue());
		item.setPostFee(0.0D);
		item.setEmsFee(0.0D);
		item.setExpressFee(0.0D);
		item.setEmsFee(0.0D);
		item.setFreightFeePayer(FreightFeePayerEnum.FREIGHT_FEE_PALYER_SELLER.getValue());
		item.setHasDiscount(true);
		item.setHasInvoice(true);
		item.setHasWarranty(true);
		item.setIsSecondKill(true);
		item.setIsSellPromise(true);
		item.setIsXinpin(true);
		item.setItemId("itemId-----fdsfsdfsfsfs");
		item.setLocation("location");
		item.setNumber(100L);
		item.setStuffStatus(0);
		item.setIsDeleted(false);
		itemManager.add(item);
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
}
