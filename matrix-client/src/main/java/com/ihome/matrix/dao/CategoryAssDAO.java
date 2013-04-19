package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.CategoryAssDO;
import com.ihome.matrix.model.CategoryAssQueryModel;

public interface CategoryAssDAO {
	
	/**
	 * 
	 * @param categoryAss
	 */
	void insert(CategoryAssDO categoryAss);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	CategoryAssDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<CategoryAssDO> query(CategoryAssQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(CategoryAssQueryModel queryModel);
	
	/**
	 * 
	 * @param categoryAss
	 */
	void update(CategoryAssDO categoryAss);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
