/**
 * 
 */
package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.ShopCategoryDO;
import com.ihome.matrix.model.ShopCategoryQueryModel;

/**
 * 
 * @author sihai
 *
 */
public interface ShopCategoryDAO {

	/**
	 * 
	 * @param shopCategory
	 */
	void insert(ShopCategoryDO shopCategory);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ShopCategoryDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<ShopCategoryDO> query(ShopCategoryQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(ShopCategoryQueryModel queryModel);
	
	/**
	 * 
	 * @param shopCategory
	 */
	void update(ShopCategoryDO shopCategory);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 
	 * @param shopId
	 */
	void deleteByShopId(Long shopId);
	
	/**
	 * 
	 * @param shop
	 * @param category
	 */
	void delete(Long shop, Long category);
}