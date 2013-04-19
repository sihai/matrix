/**
 * 
 */
package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.BrandCategoryDO;
import com.ihome.matrix.model.BrandCategoryQueryModel;

/**
 * 
 * @author sihai
 *
 */
public interface BrandCategoryDAO {

	/**
	 * 
	 * @param brandCategory
	 */
	void insert(BrandCategoryDO brandCategory);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	BrandCategoryDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<BrandCategoryDO> query(BrandCategoryQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(BrandCategoryQueryModel queryModel);
	
	/**
	 * 
	 * @param brandCategory
	 */
	void update(BrandCategoryDO brandCategory);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 
	 * @param brandId
	 */
	void deleteByBrandId(Long brandId);
	
	/**
	 * 
	 * @param brand
	 * @param category
	 */
	void delete(Long brand, Long category);
}