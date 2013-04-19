/**
 * ihome
 * igo
 */
package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.ShopDO;
import com.ihome.matrix.model.ShopQueryModel;

/**
 * 
 * @author sihai
 *
 */
public interface ShopDAO {
	
	/**
	 * 
	 * @param shop
	 */
	void insert(ShopDO shop);
	
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
	 */
	List<ShopDO> query(ShopQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(ShopQueryModel queryModel);
	
	/**
	 * 
	 * @param shop
	 */
	void update(ShopDO shop);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
