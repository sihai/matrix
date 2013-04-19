/**
 * ihome inc.
 * igo.igo-client
 */
package com.ihome.matrix.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;

import com.iacrqq.util.StringUtil;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.manager.ShopManager;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.model.ResultModel.FacetValue;
import com.ihome.matrix.model.SearchModel;
import com.ihome.matrix.model.SearchModel.Order;
import com.ihome.matrix.model.SearchModel.PropertyValue;
import com.ihome.matrix.model.SearchModel.SortCondition;


/**
 * 
 * @author sihai
 *
 */
public class ItemSolrSearcher extends AbstractSolrSearcher<ItemDO> {

	private static final String FACET_FIELD_CATEGORY_ID = "_categoryId";
	private static final String FACET_FIELD_SHOP_ID = "_shopId";
	
	@Autowired
	private CategoryManager categoryManager;
	@Autowired
	private ShopManager		shopManager;

	@Override
	protected void buildQuery(SolrQuery solrQuery, SearchModel searchModel) {

		solrQuery.set("df", new String[]{"name"});
		
		// 排序
		List<SortCondition> sortConditionList = searchModel.getSortConditionList();
		if(null == sortConditionList) {
			sortConditionList = new ArrayList<SortCondition>(1);
			searchModel.setSortConditionList(sortConditionList);
		}
		sortConditionList.add(new SortCondition("price", Order.ASC));
		
	    solrQuery.setQuery(buildQueryString(searchModel));
		//solrQuery.setQuery(String.format("name:%s", StringUtils.isNotBlank(searchModel.getQ()) ? searchModel.getQ() : "*"));
	    solrQuery.setFacet(true);
	    solrQuery.addFacetField(FACET_FIELD_CATEGORY_ID).addFacetField(FACET_FIELD_SHOP_ID);
	   // System.out.println(solrQuery.toString());
	}
	
	@Override
	protected void before(SearchModel searchModel) {
		super.before(searchModel);
		Long categoryId = searchModel.getCategoryId();
		if(null != categoryId) {
			List<CategoryDO> categoryPath = categoryManager.getCategoryPath(categoryId);
			Iterator<CategoryDO> iterator = categoryPath.iterator();
			if(iterator.hasNext()) {
				if(iterator.next().getId().equals(CategoryManager.ROOT_ID)) {
					iterator.remove();
				}
			}
			searchModel.setCategoryPath(categoryPath);
		}
	}

	@Override
	protected void after(QueryResponse response, SearchModel searchModel) {
		super.after(response, searchModel);
	}
	
	@Override
	protected void buildResultModel(QueryResponse response, ResultModel<ItemDO> resultModel) {
		super.buildResultModel(response, resultModel);
		List<FacetField> facetFieldList = response.getFacetFields();
		if(null != facetFieldList && !facetFieldList.isEmpty()) {
			String facetName = null;
			Map<String, List<FacetValue>> facetMap = new HashMap<String, List<FacetValue>>(facetFieldList.size());
			for(FacetField facetField : facetFieldList) {
				facetName = facetField.getName();
				List<Count> countList = facetField.getValues();
				facetMap.put(facetName, marge(facetName, countList));
			}
			
			resultModel.setFacetMap(facetMap);
		}
	}
	
	/**
	 * 
	 * @param facetName
	 * @param countList
	 */
	private List<FacetValue> marge(String facetName, List<Count> countList) {
		if(StringUtil.equals(facetName, FACET_FIELD_CATEGORY_ID) && null != countList && !countList.isEmpty()) {
			int i = 0;
			Long categoryId = null;
			FacetValue fv = null;
			FacetValue parent = null;
			Map<Long, FacetValue> c2fMap = new HashMap<Long, FacetValue>();			// 做为一个索引
			
			List<CategoryDO> mainCategoryList = categoryManager.getMainCategoryList();
			List<FacetValue> resultList = new ArrayList<FacetValue>(mainCategoryList.size());	// 最多这么多
			
			// 其它分类
			CategoryDO otherCategory = new CategoryDO();
			otherCategory.setId(CategoryManager.ROOT_ID);
			otherCategory.setName("其它");
			FacetValue others = new FacetValue(otherCategory, 0L, null);
			
			for(Count count : countList) {
				if(StringUtil.isNotBlank(count.getName())) {
					categoryId = Long.valueOf(count.getName());
					if(categoryId.equals(CategoryManager.ROOT_ID)) {
						others.addCount(count.getCount());
					} else {
						i = 0;
						List<CategoryDO> categoryPath = categoryManager.getCategoryPath(categoryId);
						for(CategoryDO category : categoryPath) {
							if(0 == i) {
								fv = new FacetValue(category, 0L, null);
								if(null == c2fMap.get(category.getId())) {
									resultList.add(fv);
								}
							} else {
								parent = c2fMap.get(categoryPath.get(i - 1).getId());
								fv = new FacetValue(category, 0L, parent);
								parent.addChild(fv);
							}
							c2fMap.put(category.getId(), fv);
							i++;
							if(categoryPath.size() == i) {
								fv.setCountThrougth(count.getCount());
							}
						}
					}
				} else {
					System.out.println("Category  is empty");
				}
			}
			resultList.add(others);
			c2fMap.clear();
			mainCategoryList.clear();
			return resultList;
		}
		// TODO
		return null;
	}

	private String buildQueryString(SearchModel searchModel) {
		StringBuilder sb = new StringBuilder();
		String q = StringUtil.isBlank(searchModel.getQ()) ? "*" : searchModel.getQ();
		sb.append("(");
		sb.append("name:").append(q);
		sb.append(" OR ");
		sb.append("_categoryName:").append(q);
		sb.append(" OR ");
		sb.append("_shopName:").append(q);
		sb.append(" OR ");
		sb.append("location:").append(q);
		sb.append(")");
		if(null != searchModel.getCategoryId()) {
			sb.append(" AND ");
			sb.append("_categoryId:").append(searchModel.getCategoryId());
		}
		List<PropertyValue> pvList = searchModel.getPvList();
		if(null != pvList && !pvList.isEmpty()) {
			sb.append(" AND ");
			for(PropertyValue pv : pvList) {
				sb.append(pv.getProperty()).append(":").append(pv.getValue());
			}
		}
		
		// 价格区间
		Double startPrice = searchModel.getStartPrice();
		Double endPrice = searchModel.getEndPrice();
		if(null != startPrice && !startPrice.equals(0.0D)) {
			sb.append(" AND ");
			sb.append(" price:");
			sb.append("[").append(startPrice);
			sb.append(" TO ").append(null == endPrice ? Double.MAX_VALUE : endPrice).append("]");
		}
		return sb.toString();
	}
	
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}

	public void setShopManager(ShopManager shopManager) {
		this.shopManager = shopManager;
	}
}