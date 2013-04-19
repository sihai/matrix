/**
 * ihome inc.
 * igo.igo-client
 */
package com.ihome.matrix.model;

import java.util.ArrayList;
import java.util.List;

import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.enums.SearchModeEnum;
import com.ihome.matrix.enums.ShowModeEnum;

/**
 * 
 * @author sihai
 *
 */
public class SearchModel extends BaseQueryModel {
	
	private String q;
	private Long categoryId;
	
	// price interval
	private Double startPrice;
	private Double endPrice;
	
	// sort
	private String sortField;
	private String order;
	
	private List<PropertyValue> pvList = new ArrayList<PropertyValue>(2);
	private List<SortCondition> sortConditionList = new ArrayList<SortCondition>(1);
	
	private int searchMode = SearchModeEnum.ITEM.getValue();
	private int showMode = ShowModeEnum.PICTURE.getValue();
	
	private List<CategoryDO> categoryPath;
	
	public static SearchModel newInstance() {
		return new SearchModel();
	}
	
	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public Double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(Double startPrice) {
		this.startPrice = startPrice;
	}

	public Double getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(Double endPrice) {
		this.endPrice = endPrice;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public List<PropertyValue> getPvList() {
		return pvList;
	}

	public void setPvList(List<PropertyValue> pvList) {
		this.pvList = pvList;
	}

	public List<SortCondition> getSortConditionList() {
		return sortConditionList;
	}

	public void setSortConditionList(List<SortCondition> sortConditionList) {
		this.sortConditionList = sortConditionList;
	}
	
	public int getSearchMode() {
		return searchMode;
	}

	public void setSearchMode(int searchMode) {
		this.searchMode = searchMode;
	}
	
	public int getShowMode() {
		return showMode;
	}

	public void setShowMode(int showMode) {
		this.showMode = showMode;
	}
	
	public List<CategoryDO> getCategoryPath() {
		return categoryPath;
	}

	public void setCategoryPath(List<CategoryDO> categoryPath) {
		this.categoryPath = categoryPath;
	}

	/**
	 * 		
	 * @author sihai
	 *
	 */
	public static class PropertyValue {
		
		private String property;
		private Long   value;
		
		/**
		 * 
		 * @param property
		 * @param value
		 */
		public PropertyValue(String property, Long value) {
			this.property = property;
			this.value = value;
		}

		public String getProperty() {
			return property;
		}

		public void setProperty(String property) {
			this.property = property;
		}

		public Long getValue() {
			return value;
		}

		public void setValue(Long value) {
			this.value = value;
		}
	}
	
	/**
	 * 		
	 * @author sihai
	 *
	 */
	public static class SortCondition {
		private String field;
		private Order  order;
		
		/**
		 * 
		 * @param field
		 * @param value
		 */
		public SortCondition(String field, Order order) {
			this.field = field;
			this.order = order;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}
	}
	
	/**
	 * 
	 * @author sihai
	 *
	 */
	public static enum Order {
		ASC(),
		DESC();
	}
}
