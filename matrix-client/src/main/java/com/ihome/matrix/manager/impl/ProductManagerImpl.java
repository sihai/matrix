/**
 * 
 */
package com.ihome.matrix.manager.impl;

import java.util.List;

import com.ihome.matrix.dao.BrandDAO;
import com.ihome.matrix.dao.ProductAssDAO;
import com.ihome.matrix.dao.ProductDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.BrandDO;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.ProductAssDO;
import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.manager.ProductManager;
import com.ihome.matrix.model.ProductAssQueryModel;
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
	private ProductAssDAO productAssDAO;
	
	private CategoryManager categoryManager;
	
	@Override
	public void add(ProductDO product) throws ValidateException {
		validate(product, true);
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
		validate(product, false);
		productDAO.update(product);
	}

	@Override
	public void delete(Long id) {
		productDAO.delete(id);
	}
	
	@Override
	public void add(ProductAssDO productAss) throws ValidateException {
		validateProductAss(productAss, true);
		productAssDAO.insert(productAss);
	}

	@Override
	public ProductAssDO getProductAss(Long id) {
		return productAssDAO.get(id);
	}

	@Override
	public ResultModel<ProductAssDO> query(ProductAssQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, productAssDAO.query(queryModel), productAssDAO.count(queryModel));
	}

	@Override
	public void update(ProductAssDO productAss) throws ValidateException {
		validateProductAss(productAss, false);
		productAssDAO.update(productAss);
	}

	@Override
	public void deleteProductAss(Long id) {
		productAssDAO.delete(id);
	}

	/**
	 * 
	 * @param product
	 * @param isNew
	 * @throws ValidateException
	 */
	private void validate(ProductDO product, boolean isNew) throws ValidateException {
		// TODO
	}
	
	/**
	 * 
	 * @param productAss
	 * @param isNew
	 * @throws ValidateException
	 */
	private void validateProductAss(ProductAssDO productAss, boolean isNew) throws ValidateException {
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
	
	public void setProductAssDAO(ProductAssDAO productAssDAO) {
		this.productAssDAO = productAssDAO;
	}
	
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
}