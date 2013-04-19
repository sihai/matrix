/**
 * ihome.igo
 */
package com.ihome.matrix.manager;

import java.util.List;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.CategoryAssDO;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.model.CategoryAssQueryModel;
import com.ihome.matrix.model.CategoryQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public interface CategoryManager {
	
	Long ROOT_ID = 1L;
	String ROOT_NAME = "root";
	
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
	
	//=================================================================
	//						
	//=================================================================
	/**
	 * 
	 * @param categoryId
	 * @return
	 */
	List<CategoryDO> getCategoryPath(Long categoryId);
	
	/**
	 * 
	 * @param category
	 * @return
	 */
	List<CategoryDO> getCategoryPath(CategoryDO category);
	
	/**
	 * 
	 * @return
	 */
	List<CategoryDO> getMainCategoryList();
	
	//=================================================================
	//						Category Ass
	//=================================================================
	/**
	 * 
	 * @param categoryAss
	 * @throws ValidateException
	 */
	void add(CategoryAssDO categoryAss) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	CategoryAssDO getCategoryAss(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 * @throws ValidateException
	 */
	ResultModel<CategoryAssDO> query(CategoryAssQueryModel queryModel);
	
	/**
	 * 
	 * @param categoryAss
	 */
	void update(CategoryAssDO categoryAss) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void deleteCategoryAss(Long id);
}
