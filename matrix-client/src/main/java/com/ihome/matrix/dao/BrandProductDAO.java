/**
 * 
 */
package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.BrandProductDO;
import com.ihome.matrix.model.BrandProductQueryModel;

/**
 * 
 * @author sihai
 *
 */
public interface BrandProductDAO {

	/**
	 * 
	 * @param brandProduct
	 */
	void insert(BrandProductDO brandProduct);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	BrandProductDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<BrandProductDO> query(BrandProductQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(BrandProductQueryModel queryModel);
	
	/**
	 * 
	 * @param brandProduct
	 */
	void update(BrandProductDO brandProduct);
	
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
	 * @param product
	 */
	void delete(Long brand, Long product);
}