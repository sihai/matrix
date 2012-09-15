package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.model.CategoryQueryModel;

public interface CategoryDAO {
	
	/**
	 * 
	 * @param category
	 */
	void insert(CategoryDO category);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	CategoryDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<CategoryDO> query(CategoryQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(CategoryQueryModel queryModel);
	
	/**
	 * 
	 * @param category
	 */
	void update(CategoryDO category);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
