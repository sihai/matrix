/**
 * ihome.igo
 */
package com.ihome.matrix.manager.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ihome.matrix.dao.CategoryAssDAO;
import com.ihome.matrix.dao.CategoryDAO;
import com.ihome.matrix.dao.ItemDAO;
import com.ihome.matrix.dao.ProductDAO;
import com.ihome.matrix.dao.ShopCategoryDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.CategoryAssDO;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.model.BaseQueryModel;
import com.ihome.matrix.model.CategoryAssQueryModel;
import com.ihome.matrix.model.CategoryQueryModel;
import com.ihome.matrix.model.ItemQueryModel;
import com.ihome.matrix.model.ProductQueryModel;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.model.ShopCategoryQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class CategoryManagerImpl implements CategoryManager {

	private CategoryDAO 	categoryDAO;
	private CategoryAssDAO 	categoryAssDAO;
	private ProductDAO  	productDAO;
	private ItemDAO			itemDAO;
	private ShopCategoryDAO	shopCategoryDAO;
	
	@Override
	public void add(CategoryDO category) throws ValidateException {
		validate(category);
		categoryDAO.insert(category);
	}

	@Override
	public CategoryDO get(Long id) {
		CategoryDO category = categoryDAO.get(id);
		if(null != category) {
			setExtraInfo(category);
		}
		return category;
	}

	@Override
	public ResultModel<CategoryDO> query(CategoryQueryModel queryModel) {
		List<CategoryDO> categoryList = categoryDAO.query(queryModel);
		for(CategoryDO category : categoryList) {
			setExtraInfo(category);
		}
		return ResultModel.buildResultModel(queryModel, categoryList, categoryDAO.count(queryModel));
	}

	@Override
	public void update(CategoryDO category) throws ValidateException {
		validate(category);
		categoryDAO.update(category);
	}

	@Override
	public void delete(Long id) {
		categoryDAO.delete(id);
	}
	
	@Override
	public void add(CategoryAssDO categoryAss) throws ValidateException {
		validateCategoryAss(categoryAss);
		categoryAssDAO.insert(categoryAss);
	}

	@Override
	public CategoryAssDO getCategoryAss(Long id) {
		return categoryAssDAO.get(id);
	}

	@Override
	public ResultModel<CategoryAssDO> query(CategoryAssQueryModel queryModel) {
		List<CategoryAssDO> categoryAssList = categoryAssDAO.query(queryModel);
		for(CategoryAssDO categoryAss : categoryAssList) {
			setExtraInfo(categoryAss);
		}
		return ResultModel.buildResultModel(queryModel, categoryAssList, categoryAssDAO.count(queryModel));
	}

	@Override
	public void update(CategoryAssDO categoryAss) throws ValidateException {
		validateCategoryAss(categoryAss);
		categoryAssDAO.update(categoryAss);
	}

	@Override
	public void deleteCategoryAss(Long id) {
		categoryAssDAO.delete(id);
	}

	@Override
	public List<CategoryDO> getCategoryPath(Long categoryId) {
		CategoryDO category = categoryDAO.get(categoryId);
		if(null != category) {
			return getCategoryPath(category);
		} else {
			return Collections.EMPTY_LIST;
		}
	}
	
	@Override
	public List<CategoryDO> getCategoryPath(CategoryDO category) {
		List<CategoryDO> categoryPath = new ArrayList<CategoryDO>(3);
		CategoryDO tmp = null;
		CategoryDO parent = category.getParent();
		categoryPath.add(category);
		while(null != parent && null != parent.getId() && !parent.getId().equals(ROOT_ID)) {
			tmp = categoryDAO.get(parent.getId());
			categoryPath.add(tmp);
			parent = tmp.getParent();
		}
		Collections.reverse(categoryPath);
		return categoryPath;
	}

	@Override
	public List<CategoryDO> getMainCategoryList() {
		ResultModel<CategoryDO> resultModel = query(CategoryQueryModel.newInstance().withParent(CategoryManager.ROOT_ID).withPageSize(10L));
		// 一级
		List<CategoryDO> mainCategoryList = resultModel.getItemList();
		for(CategoryDO mainCategory : mainCategoryList) {
			// 二级
			resultModel = query(CategoryQueryModel.newInstance().withParent(mainCategory.getId()).withPageSize(BaseQueryModel.MAX_PAGE_SIZE));
			mainCategory.setChildren(resultModel.getItemList());
			// 三级
			for(CategoryDO child : mainCategory.getChildren()) {
				resultModel = query(CategoryQueryModel.newInstance().withParent(child.getId()).withPageSize(BaseQueryModel.MAX_PAGE_SIZE));
				child.setChildren(resultModel.getItemList());
				// 叶子
				for(CategoryDO leaf : child.getChildren()) {
					resultModel = query(CategoryQueryModel.newInstance().withParent(leaf.getId()).withPageSize(BaseQueryModel.MAX_PAGE_SIZE));
					leaf.setChildren(resultModel.getItemList());
				}
			}
		}
		return mainCategoryList;
	}
	
	private List<CategoryDO> MockChildren(int size) {
		List<CategoryDO> children = new ArrayList<CategoryDO>(size);
		CategoryDO tmp = null;
		for(int i = 0; i < size; i++) {
			tmp = new CategoryDO();
			tmp.setId(Long.valueOf(i));
			tmp.setName(String.format("类目名称_%d", i));
			children.add(tmp);
		}
		return children;
	}

	private void validate(CategoryDO category) throws ValidateException {
		// TODO
	}
	
	private void validateCategoryAss(CategoryAssDO categoryAss) throws ValidateException {
		// TODO
	}
	
	private void setExtraInfo(CategoryDO category) {
		category.setCategoryPath(this.getCategoryPath(category));
		category.setTotalProduct(productDAO.count(ProductQueryModel.newInstance().withCategory(category.getId())));
		category.setTotalShop(shopCategoryDAO.count(ShopCategoryQueryModel.newInstance().withCategory(category.getId())));
		category.setTotalItem(itemDAO.count(ItemQueryModel.newInstance().withCategory(category.getId())));
		List<CategoryDO> children = categoryDAO.query(CategoryQueryModel.newInstance().withParent(category.getId()).withCurrentPage(1L).withPageSize(BaseQueryModel.MAX_PAGE_SIZE));
		for(CategoryDO child : children) {
			_setExtraInfo_(category, child);
		}
	}
	
	private void setExtraInfo(CategoryAssDO categoryAss) {
		CategoryDO tmp = categoryAss.getCategory();
		if(null != tmp && null != tmp.getId()) {
			categoryAss.setCategory(this.get(tmp.getId()));
		}
	}
	
	private void _setExtraInfo_(CategoryDO parent, CategoryDO category) {
		parent.setTotalProduct(parent.getTotalProduct() + productDAO.count(ProductQueryModel.newInstance().withCategory(category.getId())));
		parent.setTotalShop(parent.getTotalShop() + shopCategoryDAO.count(ShopCategoryQueryModel.newInstance().withCategory(category.getId())));
		parent.setTotalItem(parent.getTotalItem() + itemDAO.count(ItemQueryModel.newInstance().withCategory(category.getId())));
		
		List<CategoryDO> children = categoryDAO.query(CategoryQueryModel.newInstance().withParent(category.getId()).withCurrentPage(1L).withPageSize(BaseQueryModel.MAX_PAGE_SIZE));
		for(CategoryDO child : children) {
			_setExtraInfo_(parent, child);
		}
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	public void setCategoryAssDAO(CategoryAssDAO categoryAssDAO) {
		this.categoryAssDAO = categoryAssDAO;
	}
	
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public void setShopCategoryDAO(ShopCategoryDAO shopCategoryDAO) {
		this.shopCategoryDAO = shopCategoryDAO;
	}
}