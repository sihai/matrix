/**
 * 
 */
package com.ihome.matrix.manager.impl;

import java.util.List;

import com.ihome.matrix.dao.BrandDAO;
import com.ihome.matrix.dao.ProductDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.BrandDO;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.manager.ProductManager;
import com.ihome.matrix.model.ProductQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public class ProductManagerImpl implements ProductManager {
	
	private ProductDAO productDAO;
	private BrandDAO brandDAO;
	
	private CategoryManager categoryManager;
	
	@Override
	public void add(ProductDO product) throws ValidateException {
		validate(product);
		productDAO.insert(product);
	}

	@Override
	public ProductDO get(Long id) {
		ProductDO p = productDAO.get(id);
		if(null != p) {
			setBrand(p);
			setCategory(p);
		}
		return p;
	}

	@Override
	public ResultModel<ProductDO> query(ProductQueryModel queryModel) {
		List<ProductDO> pList = productDAO.query(queryModel);
		for(ProductDO p : pList) {
			setBrand(p);
			setCategory(p);
		}
		return ResultModel.buildResultModel(queryModel, pList, productDAO.count(queryModel));
	}

	@Override
	public void update(ProductDO product) throws ValidateException {
		// TODO Update validate
		productDAO.update(product);
	}

	@Override
	public void delete(Long id) {
		productDAO.delete(id);
	}
	
	/**
	 * 
	 * @param product
	 * @throws ValidateException
	 */
	private void validate(ProductDO product) throws ValidateException {
		// TODO
	}
	
	/**
	 * 
	 * @param product
	 */
	private void setBrand(ProductDO product) {
		BrandDO brand = product.getBrand();
		Long    brandId = null;
		if(null != brand) {
			brandId = brand.getId();
		}
		if(null != brandId) {
			product.setBrand(brandDAO.get(brandId));
		}
	}
	
	private void setCategory(ProductDO product) {
		CategoryDO category = product.getCategory();
		Long categoryId = null;
		
		if(null != category) {
			categoryId = category.getId();
		}
		if(null != categoryId) {
			product.setCategory(categoryManager.get(categoryId));
		}
	}
	
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public void setBrandDAO(BrandDAO brandDAO) {
		this.brandDAO = brandDAO;
	}
	
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
}