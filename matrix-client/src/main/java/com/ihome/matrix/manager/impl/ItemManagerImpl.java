/**
 * ihome.igo
 */
package com.ihome.matrix.manager.impl;

import java.util.List;

import com.ihome.matrix.dao.ItemDAO;
import com.ihome.matrix.dao.ProductDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.manager.ItemManager;
import com.ihome.matrix.model.ItemQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public class ItemManagerImpl implements ItemManager {

	private ItemDAO itemDAO;
	private ProductDAO productDAO;
	private CategoryManager categoryManager;
	
	
	@Override
	public void add(ItemDO item) throws ValidateException {
		validate(item);
		itemDAO.insert(item);
	}

	@Override
	public ItemDO get(Long id) {
		ItemDO item = itemDAO.get(id);
		if(null != item) {
			setCategoryPath(item);
			setProduct(item);
		}
		return item;
	}
	
	@Override
	public ItemDO getByItemIdAndPlatform(String itemId, int platform) {
		return itemDAO.getByItemIdAndPlatform(itemId, platform);
	}

	@Override
	public ResultModel<ItemDO> query(ItemQueryModel queryModel) {
		List<ItemDO> itemList = itemDAO.query(queryModel);
		for(ItemDO item : itemList) {
			setCategoryPath(item);
			setProduct(item);
		}
		return ResultModel.buildResultModel(queryModel, itemList, itemDAO.count(queryModel));
	}

	@Override
	public void update(ItemDO item) throws ValidateException {
		validate(item);
		itemDAO.update(item);
	}

	@Override
	public void delete(Long id) {
		itemDAO.delete(id);
	}
	
	private void validate(ItemDO item) throws ValidateException {
		// TODO
	}
	
	/**
	 * 
	 * @param item
	 */
	private void setCategoryPath(ItemDO item) {
		CategoryDO category = item.getCategory();
		Long categoryId = null;
		
		if(null != category) {
			categoryId = category.getId();
		}
		if(null != categoryId) {
			item.setCategoryPath(categoryManager.getCategoryPath(categoryId));
		}
	}
	
	private void setProduct(ItemDO item) {
		ProductDO product = item.getProduct();
		Long productId = null;
		
		if(null != product) {
			productId = product.getId();
		}
		if(null != productId) {
			item.setProduct(productDAO.get(productId));
		}
	}
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
}
