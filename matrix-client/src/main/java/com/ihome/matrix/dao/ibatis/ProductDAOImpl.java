package com.ihome.matrix.dao.ibatis;

import java.util.List;

import com.ihome.matrix.dao.ProductDAO;
import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.model.ProductQueryModel;

public class ProductDAOImpl extends BaseDAO implements ProductDAO {

	private static final String STATEMENT_INSERT = "product.dao.insert";
	private static final String STATEMENT_GET = "product.dao.get";
	private static final String STATEMENT_QUERY = "product.dao.query";
	private static final String STATEMENT_COUNT = "product.dao.count";
	private static final String STATEMENT_UPDATE = "product.dao.update";
	private static final String STATEMENT_DELETE = "product.dao.delete";
	
	@Override
	public void insert(ProductDO product) {
		insert(STATEMENT_INSERT, product);
	}

	@Override
	public ProductDO get(Long id) {
		return get(STATEMENT_GET, id);
	}

	@Override
	public List<ProductDO> query(ProductQueryModel queryModel) {
		return query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(ProductQueryModel queryModel) {
		return count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(ProductDO product) {
		update(STATEMENT_UPDATE, product);
	}

	@Override
	public void delete(Long id) {
		delete(STATEMENT_DELETE, id);
	}
}