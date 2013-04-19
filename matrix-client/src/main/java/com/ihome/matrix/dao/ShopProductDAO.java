package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.ShopProductDO;
import com.ihome.matrix.model.ShopProductQueryModel;

public interface ShopProductDAO {
	
	/**
	 * 
	 * @param shopProduct
	 */
	void insert(ShopProductDO shopProduct);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ShopProductDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<ShopProductDO> query(ShopProductQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(ShopProductQueryModel queryModel);
	
	/**
	 * 
	 * @param shopProduct
	 */
	void update(ShopProductDO shopProduct);
	
	/**
	 * 
	 * @param shopId
	 */
	void deleteByShopId(Long shopId);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}