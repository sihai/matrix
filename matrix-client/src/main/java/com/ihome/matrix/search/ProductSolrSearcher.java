/**
 * ihome inc.
 * igo.igo-client
 */
package com.ihome.matrix.search;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;

import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.model.SearchModel;


/**
 * 
 * @author sihai
 *
 */
public class ProductSolrSearcher extends AbstractSolrSearcher<ProductDO> {

	@Override
	protected void buildQuery(SolrQuery solrQuery, SearchModel searchModel) {
		 solrQuery.setQuery(String.format("name:%s", StringUtils.isNotBlank(searchModel.getQ()) ? searchModel.getQ() : "*"));
	     solrQuery.setFacet(true);
	     solrQuery.addFacetField("categoryId");
	}
}
