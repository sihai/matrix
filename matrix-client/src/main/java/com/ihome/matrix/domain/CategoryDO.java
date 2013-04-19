/**
 * 
 */
package com.ihome.matrix.domain;

import java.util.ArrayList;
import java.util.List;

import com.it.iddl.util.StringUtil;

/**
 * 
 * @author sihai
 *
 */
public class CategoryDO extends BaseDO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4163198422639559686L;
	
	private String 	name;				// 类目名称
	private String 	description;		// 类目描述
	private String 	keywords;			// 类目关键字,分割
	private Integer status;				// 类目状态
	private Integer rank;				// 类目排序
	
	private CategoryDO parent;			// parent
	private List<CategoryDO> children;	// children
	
	// extra
	private List<CategoryDO> categoryPath;	// 
	private Long totalBrand;			// 属于这个类目的品牌数量，包含所有的子类目
	private Long totalProduct;			// 属于这个类目的产品数量，包含所有的子类目
	private Long totalShop;				// 属于这个类目的店铺数量，包含所有的子类目
	private Long totalItem;				// 属于这个类目的宝贝数量，包含所有的子类目
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public String getKeywords() {
		return keywords;
	}

	public Integer getStatus() {
		return status;
	}

	public Integer getRank() {
		return rank;
	}

	public CategoryDO getParent() {
		return parent;
	}
	
	public List<CategoryDO> getChildren() {
		return children;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	public void setParent(CategoryDO parent) {
		this.parent = parent;
	}
	
	public void setChildren(List<CategoryDO> children) {
		this.children = children;
	}
	
	public List<CategoryDO> getCategoryPath() {
		return categoryPath;
	}

	public void setCategoryPath(List<CategoryDO> categoryPath) {
		this.categoryPath = categoryPath;
	}
	
	public String getStrCategoryPath() {
		if(null == categoryPath || categoryPath.isEmpty()) {
			return null;
		}
		List<String> path = new ArrayList<String>();
		for(CategoryDO cat : categoryPath) {
			path.add(cat.getName());
		}
		return StringUtil.join(path.iterator(), ">");
	}

	public Long getTotalBrand() {
		return totalBrand;
	}

	public void setTotalBrand(Long totalBrand) {
		this.totalBrand = totalBrand;
	}
	
	public Long getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(Long totalProduct) {
		this.totalProduct = totalProduct;
	}

	public Long getTotalShop() {
		return totalShop;
	}

	public void setTotalShop(Long totalShop) {
		this.totalShop = totalShop;
	}

	public Long getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Long totalItem) {
		this.totalItem = totalItem;
	}
}