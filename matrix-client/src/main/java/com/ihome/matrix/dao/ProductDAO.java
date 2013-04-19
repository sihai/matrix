package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.model.ProductQueryModel;

public interface ProductDAO {
	
	/**
	 * 
	 * @param product
	 */
	void insert(ProductDO product);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ProductDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<ProductDO> query(ProductQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(ProductQueryModel queryModel);
	
	/**
	 * 
	 * @param product
	 */
	void update(ProductDO product);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
