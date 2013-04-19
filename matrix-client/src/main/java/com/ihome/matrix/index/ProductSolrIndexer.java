/**
 * ihome inc.
 * igo.igo-client
 */
package com.ihome.matrix.index;

import com.ihome.matrix.domain.ProductDO;

/**
 * 
 * @author sihai
 *
 */
public class ProductSolrIndexer extends AbstractSolrIndexer<ProductDO> {

	@Override
	protected  Long getBeanId(ProductDO t) {
		return t.getId();
	}
}
