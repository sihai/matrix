package com.ihome.matrix.dao.ibatis;

import java.util.List;

import com.ihome.matrix.dao.PropertyDAO;
import com.ihome.matrix.domain.PropertyDO;
import com.ihome.matrix.model.PropertyQueryModel;

public class PropertyDAOImpl extends BaseDAO implements PropertyDAO {

	private static final String STATEMENT_INSERT = "property.dao.insert";
	private static final String STATEMENT_GET = "property.dao.get";
	private static final String STATEMENT_QUERY = "property.dao.query";
	private static final String STATEMENT_COUNT = "property.dao.count";
	private static final String STATEMENT_UPDATE = "property.dao.update";
	private static final String STATEMENT_DELETE = "property.dao.delete";
	
	@Override
	public void insert(PropertyDO property) {
		insert(STATEMENT_INSERT, property);
	}

	@Override
	public PropertyDO get(Long id) {
		return get(STATEMENT_GET, id);
	}

	@Override
	public List<PropertyDO> query(PropertyQueryModel queryModel) {
		return query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(PropertyQueryModel queryModel) {
		return count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(PropertyDO property) {
		update(STATEMENT_UPDATE, property);
	}

	@Override
	public void delete(Long id) {
		delete(STATEMENT_DELETE, id);
	}
}