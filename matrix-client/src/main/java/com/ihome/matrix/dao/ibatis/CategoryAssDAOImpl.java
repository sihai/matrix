package com.ihome.matrix.dao.ibatis;

import java.util.List;

import com.ihome.matrix.dao.CategoryAssDAO;
import com.ihome.matrix.domain.CategoryAssDO;
import com.ihome.matrix.model.CategoryAssQueryModel;

public class CategoryAssDAOImpl extends BaseDAO implements CategoryAssDAO {

	private static final String STATEMENT_INSERT = "categoryAss.dao.insert";
	private static final String STATEMENT_GET = "categoryAss.dao.get";
	private static final String STATEMENT_QUERY = "categoryAss.dao.query";
	private static final String STATEMENT_COUNT = "categoryAss.dao.count";
	private static final String STATEMENT_UPDATE = "categoryAss.dao.update";
	private static final String STATEMENT_DELETE = "categoryAss.dao.delete";
	
	@Override
	public void insert(CategoryAssDO categoryAss) {
		insert(STATEMENT_INSERT, categoryAss);
	}

	@Override
	public CategoryAssDO get(Long id) {
		return get(STATEMENT_GET, id);
	}
	
	@Override
	public List<CategoryAssDO> query(CategoryAssQueryModel queryModel) {
		return query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(CategoryAssQueryModel queryModel) {
		return count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(CategoryAssDO categoryAss) {
		update(STATEMENT_UPDATE, categoryAss);
	}

	@Override
	public void delete(Long id) {
		delete(STATEMENT_DELETE, id);
	}
}
