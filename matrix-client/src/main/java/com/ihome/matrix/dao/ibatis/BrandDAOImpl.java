package com.ihome.matrix.dao.ibatis;

import java.util.List;

import com.ihome.matrix.dao.BrandDAO;
import com.ihome.matrix.domain.BrandDO;
import com.ihome.matrix.model.BrandQueryModel;

public class BrandDAOImpl extends BaseDAO implements BrandDAO {

	private static final String STATEMENT_INSERT = "brand.dao.insert";
	private static final String STATEMENT_GET = "brand.dao.get";
	private static final String STATEMENT_GET_BY_NAME = "brand.dao.getByName";
	private static final String STATEMENT_QUERY = "brand.dao.query";
	private static final String STATEMENT_COUNT = "brand.dao.count";
	private static final String STATEMENT_UPDATE = "brand.dao.update";
	private static final String STATEMENT_DELETE = "brand.dao.delete";
	
	@Override
	public void insert(BrandDO brand) {
		super.insert(STATEMENT_INSERT, brand);
	}

	@Override
	public BrandDO get(Long id) {
		return super.get(STATEMENT_GET, id);
	}
	
	@Override
	public BrandDO getByName(String name) {
		return super.get(STATEMENT_GET_BY_NAME, name);
	}

	@Override
	public List<BrandDO> query(BrandQueryModel queryModel) {
		return super.query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(BrandQueryModel queryModel) {
		return super.count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(BrandDO brand) {
		super.update(STATEMENT_UPDATE, brand);
	}

	@Override
	public void delete(Long id) {
		super.update(STATEMENT_DELETE, id);
	}
}
