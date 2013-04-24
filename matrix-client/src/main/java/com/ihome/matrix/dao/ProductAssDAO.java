package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.ProductAssDO;
import com.ihome.matrix.model.ProductAssQueryModel;

public interface ProductAssDAO {
	
	/**
	 * 
	 * @param productAss
	 */
	void insert(ProductAssDO productAss);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ProductAssDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<ProductAssDO> query(ProductAssQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(ProductAssQueryModel queryModel);
	
	/**
	 * 
	 * @param productAss
	 */
	void update(ProductAssDO productAss);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
