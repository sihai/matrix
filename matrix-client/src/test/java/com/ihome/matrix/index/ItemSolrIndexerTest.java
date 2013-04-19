package com.ihome.matrix.index;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihome.matrix.MatrixBaseTestCase;
import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.manager.ItemManager;
import com.ihome.matrix.model.BaseQueryModel;
import com.ihome.matrix.model.ItemQueryModel;
import com.ihome.matrix.model.ResultModel;

public class ItemSolrIndexerTest extends MatrixBaseTestCase {

	@Autowired
	private ItemSolrIndexer itemSolrIndexer;
	@Autowired
	private ItemManager itemManager;
	
	@Test
	public void test() {
		/*for( int i = 0; i < 10000; i++) {
			ItemDO item = new ItemDO();
			item.setId(Long.valueOf(i));
			item.setName(String.format("Samsung/三星 I9300 GALAXY SIII S3 盖世3 正品行货 送剪卡器 -item-%d", i));
			item.setDetailURL("http://detail.tmall.com/venus/spu_detail.htm?spm=a220m.1000858.1000725.6.eao3i4&spu_id=201616287&cat_id=2&entryNum=0&loc=&mallstItemId=14520330551&q=%C8%FD%D0%C7&rn=1c59f5151e5cd7ce1262901116590b1b&rewcatid=2&from=&disp=g&active=0");
			item.setLogoURL("http://img01.taobaocdn.com/bao/uploaded/i1/T1a4LOXjNnXXXkMgI._112346.jpg_310x310.jpg");
			item.setPlatform(PlatformEnum.PLATFORM_TMALL.getValue());
			item.setLocation("中国浙江杭州");
			item.setNumber(100L);
			item.setPrice(3699.00D);
			item.setGmtCreate(new Date());
			item.setGmtModified(item.getGmtCreate());
			itemSolrIndexer.add(item);
		}*/
		
		Long currentPage = 1L;
		ItemQueryModel queryModel = ItemQueryModel.newInstance()
				.withCurrentPage(currentPage)
				.withPageSize(BaseQueryModel.MAX_PAGE_SIZE);
		ResultModel<ItemDO> resultModel = itemManager.query(queryModel);
		Long totalPage = resultModel.getTotalPage();
		do {
			queryModel.withCurrentPage(currentPage);
			resultModel = itemManager.query(queryModel);
			for(ItemDO item : resultModel.getItemList()) {
				indexOne(item);
			}
		} while(++currentPage <= totalPage);
	}
	
	@Test
	public void indexAll() {
		Long currentPage = 1L;
		ItemQueryModel queryModel = ItemQueryModel.newInstance()
				.withCurrentPage(currentPage)
				.withPageSize(BaseQueryModel.MAX_PAGE_SIZE);
		ResultModel<ItemDO> resultModel = itemManager.query(queryModel);
		Long totalPage = resultModel.getTotalItem();
		do {
			resultModel = itemManager.query(queryModel);
			for(ItemDO item : resultModel.getItemList()) {
				indexOne(item);
			}
		} while(++currentPage < totalPage);
	}
	
	private void indexOne(ItemDO item) {
		itemSolrIndexer.upate(item);
	}
	
	public void setItemSolrIndexer(ItemSolrIndexer itemSolrIndexer) {
		this.itemSolrIndexer = itemSolrIndexer;
	}
	
	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
}
