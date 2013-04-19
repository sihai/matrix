/**
 * ihome inc.
 * igo.igo-client
 */
package com.ihome.matrix.index;

import com.ihome.matrix.domain.ItemDO;

/**
 * 
 * @author sihai
 *
 */
public class ItemSolrIndexer extends AbstractSolrIndexer<ItemDO> {

	@Override
	protected  Long getBeanId(ItemDO t) {
		return t.getId();
	}
}
