/**
 * 
 */
package com.ihome.matrix.cluster;

import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.ItemDO;

/**
 * 
 * @author sihai
 *
 */
public interface CategoryCluster {
	
	/**
	 * 
	 * @param item
	 * @return
	 */
	CategoryDO clusterCategory(ItemDO item);
}
