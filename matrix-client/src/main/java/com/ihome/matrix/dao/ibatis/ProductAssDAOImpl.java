package com.ihome.matrix.dao.ibatis;

import java.util.List;

import com.ihome.matrix.dao.ProductAssDAO;
import com.ihome.matrix.domain.ProductAssDO;
import com.ihome.matrix.model.ProductAssQueryModel;

public class ProductAssDAOImpl extends BaseDAO implements ProductAssDAO {

	private static final String STATEMENT_INSERT = "productAss.dao.insert";
	private static final String STATEMENT_GET = "productAss.dao.get";
	private static final String STATEMENT_QUERY = "productAss.dao.query";
	private static final String STATEMENT_COUNT = "productAss.dao.count";
	private static final String STATEMENT_UPDATE = "productAss.dao.update";
	private static final String STATEMENT_DELETE = "productAss.dao.delete";
	
	@Override
	public void insert(ProductAssDO productAss) {
		insert(STATEMENT_INSERT, productAss);
	}

	@Override
	public ProductAssDO get(Long id) {
		return get(STATEMENT_GET, id);
	}
	
	@Override
	public List<ProductAssDO> query(ProductAssQueryModel queryModel) {
		return query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(ProductAssQueryModel queryModel) {
		return count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(ProductAssDO productAss) {
		update(STATEMENT_UPDATE, productAss);
	}

	@Override
	public void delete(Long id) {
		delete(STATEMENT_DELETE, id);
	}
}
