/**
 * ihome.igo
 */
package com.ihome.matrix.manager.impl;

import com.ihome.matrix.dao.CategoryDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.model.CategoryQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public class CategoryManagerImpl implements CategoryManager {

	private CategoryDAO categoryDAO;
	
	
	@Override
	public void add(CategoryDO category) throws ValidateException {
		validate(category);
		categoryDAO.insert(category);
	}

	@Override
	public CategoryDO get(Long id) {
		return categoryDAO.get(id);
	}

	@Override
	public ResultModel<CategoryDO> query(CategoryQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, categoryDAO.query(queryModel), categoryDAO.count(queryModel));
	}

	@Override
	public void update(CategoryDO category) throws ValidateException {
		validate(category);
		categoryDAO.update(category);
	}

	@Override
	public void delete(Long id) {
		categoryDAO.delete(id);
	}
	
	private void validate(CategoryDO category) throws ValidateException {
		// TODO
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
}
