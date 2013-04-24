/**
 * 
 */
package com.ihome.matrix.cluster.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ihome.matrix.cluster.ProductCluster;
import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.domain.ProductAssDO;
import com.ihome.matrix.domain.ProductDO;

/**
 * 
 * @author sihai
 *
 */
public class MetadataProductCluster implements ProductCluster {

private static final Log logger = LogFactory.getLog(MetadataProductCluster.class);
	
	private static final Map<OutProduct, ProductDO> catMap = new HashMap<OutProduct, ProductDO>();
	
	public void initialize(List<ProductAssDO> assList) {
		for(ProductAssDO ass : assList) {
			catMap.put(new OutProduct(ass.getOutProductId(), ass.getOutProductName(), ass.getPlatform()), ass.getProduct());
			if(null != ass.getOutProductId()) {
				catMap.put(new OutProduct(ass.getOutProductId(), null, ass.getPlatform()), ass.getProduct());
			}
			if(null != ass.getOutProductName()) {
				catMap.put(new OutProduct(null, ass.getOutProductName(), ass.getPlatform()), ass.getProduct());
			}
		}
		logger.info(String.format("Load %d product ass", catMap.size()));
	}
	
	@Override
	public ProductDO clusterProduct(ItemDO item) {
		if(null == item.getProduct()) {
			return null;
		}
		return _cluster_(new OutProduct(item.getProduct().getId(), item.getProduct().getName(), item.getPlatform()));
	}

	private ProductDO _cluster_(OutProduct outCategory) {
		// 
		logger.info(String.format("Try to cluster category: outProductId=%d,outProductName=%s,platform=%d", 
				outCategory.outProductId, outCategory.outProductName, outCategory.platform));
		return catMap.get(outCategory);
	}
	
	public static class OutProduct {
		
		Long outProductId;
		
		String outProductName;
		
		Integer platform;
		
		OutProduct() {}
		
		OutProduct(Long outProductId, String outProductName, Integer platform) {
			this.outProductId = outProductId;
			this.outProductName = outProductName;
			this.platform = platform;
		}

		@Override
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(!(obj instanceof OutProduct)) {
				return false;
			}
			OutProduct oc = (OutProduct)obj;
			if(oc.platform.equals(platform)
					&& ((null != oc.outProductId && oc.outProductId.equals(outProductId)) 
					|| (null != oc.outProductName && oc.outProductName.equals(outProductName)))) {
				return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			int code = 0;
			if(null != outProductId) {
				code += outProductId.hashCode();
			}
			if(null != outProductName) {
				code += outProductName.hashCode();
			}
			if(null != platform) {
				code += platform.hashCode();
			}
			return code;
		}
	}

}
