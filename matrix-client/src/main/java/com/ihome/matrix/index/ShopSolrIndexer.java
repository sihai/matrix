/**
 * ihome inc.
 * igo.igo-client
 */
package com.ihome.matrix.index;

import com.ihome.matrix.domain.ShopDO;

/**
 * 
 * <p>
 * <b>注意:</b>
 * <p>
 * ShopDO要加注解 <code>@Field</code>哦
 * @author sihai
 *
 */
public class ShopSolrIndexer extends AbstractSolrIndexer<ShopDO> {

	@Override
	protected Long getBeanId(ShopDO t) {
		return t.getId();
	}
}
