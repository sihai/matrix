/**
 * ihome.igo
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.ShopCategoryDO;
import com.ihome.matrix.domain.ShopDO;
import com.ihome.matrix.domain.ShopProductDO;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.model.ShopCategoryQueryModel;
import com.ihome.matrix.model.ShopProductQueryModel;
import com.ihome.matrix.model.ShopQueryModel;

/**
 * 
 * @author sihai
 *
 */
public interface ShopManager {
	
	//=================================================================
	//						Shop
	//=================================================================
	
	/**
	 * 
	 * @param shop
	 * @throws ValidateException
	 */
	void add(ShopDO shop) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ShopDO get(Long id);
	
	/**
	 * 
	 * @param shopId
	 * @param platform
	 * @return
	 */
	ShopDO getByShopIdAndPlatform(String shopId, int platform);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 * @throws ValidateException
	 */
	ResultModel<ShopDO> query(ShopQueryModel queryModel);
	
	/**
	 * 
	 * @param shop
	 */
	void update(ShopDO shop) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
	
	//=================================================================
	//						Shop Product
	//=================================================================
	/**
	 * 
	 * @param shopProduct
	 * @throws ValidateException
	 */
	void addShopProduct(ShopProductDO shopProduct) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ShopProductDO getShopProduct(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 * @throws ValidateException
	 */
	ResultModel<ShopProductDO> query(ShopProductQueryModel queryModel);
	
	/**
	 * 
	 * @param shopProduct
	 */
	void updateShopProduct(ShopProductDO shopProduct) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void deleteShopProduct(Long id);
	
	/**
	 * 
	 * @param shopId
	 */
	void deleteShopProductByShopId(Long shopId);
	
	//=================================================================
	//						Shop Category
	//=================================================================
	/**
	 * 
	 * @param shopCategory
	 * @throws ValidateException
	 */
	void addShopCategory(ShopCategoryDO shopCategory) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ShopCategoryDO getShopCategory(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 * @throws ValidateException
	 */
	ResultModel<ShopCategoryDO> query(ShopCategoryQueryModel queryModel);
	
	/**
	 * 
	 * @param shopCategory
	 */
	void updateShopCategory(ShopCategoryDO shopCategory) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void deleteShopCategory(Long id);
	
	/**
	 * 
	 * @param shopId
	 */
	void deleteShopCategoryByShopId(Long shopId);
	
	/**
	 * 
	 * @param shop
	 * @param category
	 */
	void deleteShopCategory(Long shop, Long category);
}
