/**
 * ihome.igo
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.model.CategoryQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public interface CategoryManager {
	
	/**
	 * 
	 * @param category
	 * @throws ValidateException
	 */
	void add(CategoryDO category) throws ValidateException;
	
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
	 * @throws ValidateException
	 */
	ResultModel<CategoryDO> query(CategoryQueryModel queryModel);
	
	/**
	 * 
	 * @param category
	 */
	void update(CategoryDO category) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
