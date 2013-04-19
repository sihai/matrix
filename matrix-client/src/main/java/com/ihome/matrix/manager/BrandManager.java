/**
 * ihome.igo
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.BrandCategoryDO;
import com.ihome.matrix.domain.BrandDO;
import com.ihome.matrix.domain.BrandProductDO;
import com.ihome.matrix.model.BrandCategoryQueryModel;
import com.ihome.matrix.model.BrandProductQueryModel;
import com.ihome.matrix.model.BrandQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public interface BrandManager {
	
	//=================================================================
	//						Brand
	//=================================================================
	
	/**
	 * 
	 * @param brand
	 * @throws ValidateException
	 */
	void add(BrandDO brand) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	BrandDO get(Long id);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	BrandDO getByName(String name);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	ResultModel<BrandDO> query(BrandQueryModel queryModel);
	
	/**
	 * 
	 * @param brand
	 */
	void update(BrandDO brand) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
	
	//=================================================================
	//						Brand Category
	//=================================================================
	/**
	 * 
	 * @param brandCategory
	 * @throws ValidateException
	 */
	void addBrandCategory(BrandCategoryDO brandCategory) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	BrandCategoryDO getBrandCategory(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	ResultModel<BrandCategoryDO> queryBrandCategory(BrandCategoryQueryModel queryModel);
	
	/**
	 * 
	 * @param brandCategory
	 * @throws ValidateException
	 */
	void updateBrandCategory(BrandCategoryDO brandCategory) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void deleteBrandCategory(Long id);
	
	/**
	 * 
	 * @param brandId
	 */
	void deleteBrandCategoryByBrandId(Long brandId);
	
	/**
	 * 
	 * @param brand
	 * @param category
	 */
	void deleteBrandCategory(Long brand, Long category);
	
	//=================================================================
	//						Brand Product
	//=================================================================
	/**
	 * 
	 * @param brandProduct
	 * @throws ValidateException
	 */
	void addBrandProduct(BrandProductDO brandProduct) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	BrandProductDO getBrandProduct(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	ResultModel<BrandProductDO> queryBrandProduct(BrandProductQueryModel queryModel);
	
	/**
	 * 
	 * @param brandProduct
	 * @throws ValidateException
	 */
	void updateBrandProduct(BrandProductDO brandProduct) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void deleteBrandProduct(Long id);
	
	/**
	 * 
	 * @param brandId
	 */
	void deleteBrandProductByBrandId(Long brandId);
	
	/**
	 * 
	 * @param brand
	 * @param category
	 */
	void deleteBrandProduct(Long brand, Long category);
}
