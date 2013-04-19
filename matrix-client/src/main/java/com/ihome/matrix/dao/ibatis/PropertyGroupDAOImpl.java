package com.ihome.matrix.dao.ibatis;

import java.util.List;

import com.ihome.matrix.dao.PropertyGroupDAO;
import com.ihome.matrix.domain.PropertyGroupDO;
import com.ihome.matrix.model.PropertyGroupQueryModel;

public class PropertyGroupDAOImpl extends BaseDAO implements PropertyGroupDAO {

	private static final String STATEMENT_INSERT = "propertyGroup.dao.insert";
	private static final String STATEMENT_GET = "propertyGroup.dao.get";
	private static final String STATEMENT_QUERY = "propertyGroup.dao.query";
	private static final String STATEMENT_COUNT = "propertyGroup.dao.count";
	private static final String STATEMENT_UPDATE = "propertyGroup.dao.update";
	private static final String STATEMENT_DELETE = "propertyGroup.dao.delete";
	
	@Override
	public void insert(PropertyGroupDO propertyGroup) {
		insert(STATEMENT_INSERT, propertyGroup);
	}

	@Override
	public PropertyGroupDO get(Long id) {
		return get(STATEMENT_GET, id);
	}

	@Override
	public List<PropertyGroupDO> query(PropertyGroupQueryModel queryModel) {
		return query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(PropertyGroupQueryModel queryModel) {
		return count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(PropertyGroupDO propertyGroup) {
		update(STATEMENT_UPDATE, propertyGroup);
	}

	@Override
	public void delete(Long id) {
		delete(STATEMENT_DELETE, id);
	}
}