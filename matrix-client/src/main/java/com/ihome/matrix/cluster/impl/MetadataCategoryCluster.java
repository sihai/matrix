/**
 * 
 */
package com.ihome.matrix.cluster.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ihome.matrix.cluster.CategoryCluster;
import com.ihome.matrix.domain.CategoryAssDO;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.ItemDO;

/**
 * 
 * @author sihai
 *
 */
public class MetadataCategoryCluster implements CategoryCluster {

	private static final Log logger = LogFactory.getLog(MetadataCategoryCluster.class);
	
	private static final Map<OutCategory, CategoryDO> catMap = new HashMap<OutCategory, CategoryDO>();
	
	public void initialize(List<CategoryAssDO> assList) {
		for(CategoryAssDO ass : assList) {
			catMap.put(new OutCategory(ass.getOutCategoryId(), ass.getOutCategoryName(), ass.getPlatform(), ass.getShopName()), ass.getCategory());
			if(null != ass.getOutCategoryId()) {
				catMap.put(new OutCategory(ass.getOutCategoryId(), null, ass.getPlatform(), ass.getShopName()), ass.getCategory());
			}
			if(null != ass.getOutCategoryName()) {
				catMap.put(new OutCategory(null, ass.getOutCategoryName(), ass.getPlatform(), ass.getShopName()), ass.getCategory());
			}
		}
		logger.info(String.format("Load %d category ass", catMap.size()));
	}
	
	@Override
	public CategoryDO clusterCategory(ItemDO item) {
		CategoryDO cat = null;
		OutCategory oc = new OutCategory();
		oc.platform = item.getPlatform();
		oc.shopName = item.getShop().getName();
		// 店铺自定义类目优先
		String cids = item.getCategory().getDescription();
		if(StringUtils.isNotBlank(cids)) {
			String[] tmp = cids.split(",");
			for(String v : tmp) {
				oc.outCategoryId = Long.valueOf(v);
				cat = _cluster_(oc);
				if(null != cat) {
					break;
				}
			}
		}
		
		if(null == cat) {
			oc.outCategoryId = item.getCategory().getId();
			oc.outCategoryName = item.getCategory().getName();
			cat = _cluster_(oc);
		}
		logger.info(String.format("Result of cluster category:%s", null == cat ? null : cat.getStrCategoryPath()));
		return cat;
	}

	private CategoryDO _cluster_(OutCategory outCategory) {
		// 
		logger.info(String.format("Try to cluster category: outCategoryId=%d,outCategoryName=%s,platform=%d,shopName=%s", 
				outCategory.outCategoryId, outCategory.outCategoryName, outCategory.platform, outCategory.shopName));
		return catMap.get(outCategory);
	}
	
	public static class OutCategory {
		
		Long outCategoryId;
		
		String outCategoryName;
		
		Integer platform;
		
		String shopName;
		
		OutCategory() {}
		
		OutCategory(Long outCategoryId, String outCategoryName, Integer platform, String shopName) {
			this.outCategoryId = outCategoryId;
			this.outCategoryName = outCategoryName;
			this.platform = platform;
			this.shopName = shopName;
		}

		@Override
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(!(obj instanceof OutCategory)) {
				return false;
			}
			OutCategory oc = (OutCategory)obj;
			if(oc.platform.equals(platform) && oc.shopName.equals(shopName) 
					&& ((null != oc.outCategoryId && oc.outCategoryId.equals(outCategoryId)) 
					|| (null != oc.outCategoryName && oc.outCategoryName.equals(outCategoryName)))) {
				return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			int code = 0;
			if(null != outCategoryId) {
				code += outCategoryId.hashCode();
			}
			if(null != outCategoryName) {
				code += outCategoryName.hashCode();
			}
			if(null != platform) {
				code += platform.hashCode();
			}
			if(null != shopName) {
				code += shopName.hashCode();
			}
			return code;
		}
	}
}
