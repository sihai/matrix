/**
 * ihome inc.
 * igo.igo-client
 */
package com.ihome.matrix.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.SolrParams;

import com.iacrqq.util.StringUtil;
import com.ihome.matrix.index.AbstractSolrIndexer;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.model.SearchModel;
import com.ihome.matrix.model.SearchModel.Order;
import com.ihome.matrix.model.SearchModel.SortCondition;
import com.ihome.matrix.solr.SolrServerAdapter;

/**
 * 
 * @author sihai
 *
 */
public abstract class AbstractSolrSearcher<T> implements Searcher<T> {

	protected static final Log logger = LogFactory.getLog(AbstractSolrIndexer.class);
	
	private SolrServerAdapter solrServerAdapter;

	/**
	 * 
	 * @param searchModel
	 */
	protected void before(SearchModel searchModel) {
		// sort
		String sortField = searchModel.getSortField();
		String order = searchModel.getOrder();
		if(StringUtil.isNotBlank(sortField) && StringUtil.isNotBlank(order)) {
			List<SortCondition> sortConditionList = searchModel.getSortConditionList();
			if(null == sortConditionList) {
				sortConditionList = new ArrayList<SortCondition>(1);
				searchModel.setSortConditionList(sortConditionList);
			}
			sortConditionList.add(new SortCondition(sortField, Order.valueOf(StringUtil.upperCase(order))));
		}
	}
	
	@Override
	public ResultModel<T> search(Class<T> type, SearchModel searchModel) {
		try {
			before(searchModel);
			long start = System.currentTimeMillis();
			QueryResponse response = solrServerAdapter.query(searchModel2SolrParams(searchModel));
			after(response, searchModel);
			ResultModel<T> resultModel =  ResultModel.buildResultModel(searchModel, response.getBeans(type), response.getResults().getNumFound(), Double.valueOf((System.currentTimeMillis() - start)));
			buildResultModel(response, resultModel);
			return resultModel;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SolrServerException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @param response
	 */
	protected void after(QueryResponse response, SearchModel searchModel) {
		
	}
	
	/**
	 * 
	 * @param response
	 * @param resultModel
	 */
	protected void buildResultModel(QueryResponse response, ResultModel<T> resultModel) {
		
	}
	
	/**
	 * 
	 * @param solrQuery
	 * @param searchModel
	 */
	protected abstract void buildQuery(SolrQuery solrQuery, SearchModel searchModel);
	
	/**
	 * //XXX 是否要对q分个词呢？？？
	 * @param searchModel
	 * @return
	 */
	private SolrParams searchModel2SolrParams(SearchModel searchModel) {
		SolrQuery query = new SolrQuery();
		// 分页
		query.setStart(searchModel.getStart().intValue());
		query.setRows(searchModel.getPageSize().intValue());
		//
		buildQuery(query, searchModel);
		
		if(null != searchModel.getSortConditionList() && !searchModel.getSortConditionList().isEmpty()) {
			for(SortCondition sc : searchModel.getSortConditionList()) {
				query.addSortField(sc.getField(), sc.getOrder() == Order.ASC ? ORDER.asc : ORDER.desc);
			}
		}
		return query;
	}
	
	public void setSolrServerAdapter(SolrServerAdapter solrServerAdapter) {
		this.solrServerAdapter = solrServerAdapter;
	}
}
