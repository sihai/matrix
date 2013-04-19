/**
 * 
 */
package com.ihome.matrix.cluster;

import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.domain.ProductDO;

/**
 * 
 * @author sihai
 *
 */
public interface ProductCluster {
	
	/**
	 * 
	 * @param item
	 * @return
	 */
	ProductDO clusterProduct(ItemDO item);
}
