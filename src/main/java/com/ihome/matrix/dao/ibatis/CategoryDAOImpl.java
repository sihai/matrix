package com.ihome.matrix.dao.ibatis;

import java.util.List;

import com.ihome.matrix.dao.BaseDAO;
import com.ihome.matrix.dao.CategoryDAO;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.model.CategoryQueryModel;

public class CategoryDAOImpl extends BaseDAO implements CategoryDAO {

	private static final String STATEMENT_INSERT = "category.dao.insert";
	private static final String STATEMENT_GET = "category.dao.get";
	private static final String STATEMENT_QUERY = "category.dao.query";
	private static final String STATEMENT_COUNT = "category.dao.count";
	private static final String STATEMENT_UPDATE = "category.dao.update";
	private static final String STATEMENT_DELETE = "category.dao.delete";
	
	@Override
	public void insert(CategoryDO category) {
		insert(STATEMENT_INSERT, category);
	}

	@Override
	public CategoryDO get(Long id) {
		return get(STATEMENT_GET, id);
	}

	@Override
	public List<CategoryDO> query(CategoryQueryModel queryModel) {
		return query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(CategoryQueryModel queryModel) {
		return count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(CategoryDO category) {
		update(STATEMENT_UPDATE, category);
	}

	@Override
	public void delete(Long id) {
		delete(STATEMENT_DELETE, id);
	}
}
