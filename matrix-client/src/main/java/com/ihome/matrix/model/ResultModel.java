/**
 * pug
 */
package com.ihome.matrix.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ihome.matrix.domain.BaseDO;

/**
 * 
 * @author sihai
 * 
 */
public class ResultModel<T> extends BaseModel {
	private BaseQueryModel queryModel;

	private Long totalItem;	// 	
	private Long totalPage;	//
	private Double time; 		// 耗时, 单位秒
	
	// 
	private Map<String, List<FacetValue>> facetMap;
	
	private List<T> itemList;

	public static <T> ResultModel buildResultModel(BaseQueryModel queryModel, List<T> itemList, Long totalItem, Map<String, List<FacetValue>> facetMap, Double time) {
		ResultModel<T> resultModel = new ResultModel<T>();
		resultModel.setQueryModel(queryModel);
		resultModel.setItemList(itemList);
		resultModel.setTotalItem(totalItem);
		resultModel.time = time;
		resultModel.setTotalPage((totalItem - 1) / queryModel.getPageSize() + 1);
		resultModel.facetMap = facetMap;
		return resultModel;
	}
	
	public static <T> ResultModel buildResultModel(BaseQueryModel queryModel, List<T> itemList, Long totalItem, Double time) {
		return buildResultModel(queryModel, itemList, totalItem, null, time);
	}

	public static <T> ResultModel buildResultModel(BaseQueryModel queryModel, List<T> itemList, Long totalItem) {
		return buildResultModel(queryModel, itemList, totalItem, null);
	}

	public BaseQueryModel getQueryModel() {
		return queryModel;
	}

	public Long getTotalItem() {
		return totalItem;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public List<T> getItemList() {
		return itemList;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public void setQueryModel(BaseQueryModel queryModel) {
		this.queryModel = queryModel;
	}

	public void setTotalItem(Long totalItem) {
		this.totalItem = totalItem;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public void setItemList(List<T> itemList) {
		this.itemList = itemList;
	}
	
	public Map<String, List<FacetValue>> getFacetMap() {
		return facetMap;
	}

	public void setFacetMap(Map<String, List<FacetValue>> facetMap) {
		this.facetMap = facetMap;
	}
	
	/***
	 * 
	 * @author sihai
	 *
	 */
	public static class FacetValue {
		
		private BaseDO facet;
		private Long   count;
		
		FacetValue parent;
		List<FacetValue> children;
		
		public FacetValue(BaseDO facet, Long count, FacetValue parent) {
			this.facet = facet;
			this.count = count;
			this.parent = parent;
		}

		public BaseDO getFacet() {
			return facet;
		}

		public void setFacet(BaseDO facet) {
			this.facet = facet;
		}

		public Long getCount() {
			return count;
		}

		public void setCount(Long count) {
			this.count = count;
		}
		
		public FacetValue getParent() {
			return parent;
		}

		public void setParent(FacetValue parent) {
			this.parent = parent;
		}
		
		public List<FacetValue> getChildren() {
			return children;
		}
		
		public void addChild(FacetValue child) {
			if(null == children) {
				children = new ArrayList<FacetValue>(8);
			}
			children.add(child);
		}
		
		public void addCount(Long count) {
			this.count += count;
		}
		
		public void setCountThrougth(Long count) {
			this.count += count;
			FacetValue p = this.parent;
			while(null != p) {
				p.count += count;
				p = p.parent;
			}
		}
	}
}
