/**
 * 
 */
package com.ihome.matrix.manager.impl;

import java.util.List;

import com.ihome.matrix.dao.BrandCategoryDAO;
import com.ihome.matrix.dao.BrandDAO;
import com.ihome.matrix.dao.BrandProductDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.BrandCategoryDO;
import com.ihome.matrix.domain.BrandDO;
import com.ihome.matrix.domain.BrandProductDO;
import com.ihome.matrix.manager.BrandManager;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.model.BaseQueryModel;
import com.ihome.matrix.model.BrandCategoryQueryModel;
import com.ihome.matrix.model.BrandProductQueryModel;
import com.ihome.matrix.model.BrandQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public class BrandManagerImpl implements BrandManager {
	
	private BrandDAO brandDAO;
	private BrandCategoryDAO brandCategoryDAO;
	private BrandProductDAO brandProductDAO;
	private CategoryManager categoryManager;

	@Override
	public void add(BrandDO brand) throws ValidateException {
		validate(brand);
		brandDAO.insert(brand);
	}

	@Override
	public BrandDO get(Long id) {
		BrandDO brand = brandDAO.get(id);
		if(null != brand) {
			setCategory(brand);
		}
		return brand;
	}

	@Override
	public BrandDO getByName(String name) {
		return brandDAO.getByName(name);
	}

	@Override
	public ResultModel<BrandDO> query(BrandQueryModel queryModel) {
		List<BrandDO> brandList = brandDAO.query(queryModel);
		for(BrandDO brand : brandList) {
			setCategory(brand);
		}
		return ResultModel.buildResultModel(queryModel, brandList, brandDAO.count(queryModel));
	}

	@Override
	public void update(BrandDO brand) throws ValidateException {
		// TODO Update validate
		validate(brand);
		brandDAO.update(brand);
	}

	@Override
	public void delete(Long id) {
		brandDAO.delete(id);
	}
	
	@Override
	public void addBrandCategory(BrandCategoryDO brandCategory) throws ValidateException {
		validateBrandCategory(brandCategory);
		brandCategoryDAO.insert(brandCategory);
	}

	@Override
	public BrandCategoryDO getBrandCategory(Long id) {
		return brandCategoryDAO.get(id);
	}

	@Override
	public ResultModel<BrandCategoryDO> queryBrandCategory(BrandCategoryQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, brandCategoryDAO.query(queryModel), brandCategoryDAO.count(queryModel));
	}

	@Override
	public void updateBrandCategory(BrandCategoryDO brandCategory) throws ValidateException {
		validateBrandCategory(brandCategory);
		brandCategoryDAO.update(brandCategory);
	}

	@Override
	public void deleteBrandCategory(Long id) {
		brandCategoryDAO.delete(id);
	}

	@Override
	public void deleteBrandCategoryByBrandId(Long brandId) {
		brandCategoryDAO.deleteByBrandId(brandId);
	}

	@Override
	public void deleteBrandCategory(Long brand, Long category) {
		brandCategoryDAO.delete(brand, category);
	}
	
	@Override
	public void addBrandProduct(BrandProductDO brandProduct) throws ValidateException {
		validateBrandProduct(brandProduct);
		brandProductDAO.insert(brandProduct);
	}

	@Override
	public BrandProductDO getBrandProduct(Long id) {
		return brandProductDAO.get(id);
	}

	@Override
	public ResultModel<BrandProductDO> queryBrandProduct(BrandProductQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, brandProductDAO.query(queryModel), brandProductDAO.count(queryModel));
	}

	@Override
	public void updateBrandProduct(BrandProductDO brandProduct) throws ValidateException {
		validateBrandProduct(brandProduct);
		brandProductDAO.update(brandProduct);
	}

	@Override
	public void deleteBrandProduct(Long id) {
		brandProductDAO.delete(id);
	}

	@Override
	public void deleteBrandProductByBrandId(Long brandId) {
		brandProductDAO.deleteByBrandId(brandId);
	}

	@Override
	public void deleteBrandProduct(Long brand, Long product) {
		brandProductDAO.delete(brand, product);
	}

	/**
	 * 
	 * @param brand
	 * @throws ValidateException
	 */
	private void validate(BrandDO brand) throws ValidateException {
		// TODO
	}
	
	/**
	 * 
	 * @param brandCategory
	 * @throws ValidateException
	 */
	private void validateBrandCategory(BrandCategoryDO brandCategory) throws ValidateException {
		// TODO
	}
	
	/**
	 * 
	 * @param brandProduct
	 * @throws ValidateException
	 */
	private void validateBrandProduct(BrandProductDO brandProduct) throws ValidateException {
		// TODO
	}
	
	/**
	 * 
	 * @param brand
	 */
	private void setCategory(BrandDO brand) {
		ResultModel<BrandCategoryDO> resultModel = this.queryBrandCategory(BrandCategoryQueryModel.newInstance().withBrand(brand.getId()).withPageSize(BaseQueryModel.MAX_PAGE_SIZE));
		for(BrandCategoryDO bc : resultModel.getItemList()) {
			bc.setCategory(categoryManager.get(bc.getCategory().getId()));
		}
		brand.setBrandCategoryList(resultModel.getItemList());
	}
	
	public void setBrandDAO(BrandDAO brandDAO) {
		this.brandDAO = brandDAO;
	}
	
	public void setBrandCategoryDAO(BrandCategoryDAO brandCategoryDAO) {
		this.brandCategoryDAO = brandCategoryDAO;
	}
	
	public void setBrandProductDAO(BrandProductDAO brandProductDAO) {
		this.brandProductDAO = brandProductDAO;
	}
	
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
}
