/**
 * 
 */
package com.ihome.matrix.dao.ibatis;

import java.util.List;

import com.ihome.matrix.dao.ActivityDAO;
import com.ihome.matrix.domain.ActivityDO;
import com.ihome.matrix.model.ActivityQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class ActivityDAOImpl extends BaseDAO implements ActivityDAO {
	
	private static final String STATEMENT_INSERT = "activity.dao.insert";
	private static final String STATEMENT_GET = "activity.dao.get";
	private static final String STATEMENT_QUERY = "activity.dao.query";
	private static final String STATEMENT_COUNT = "activity.dao.count";
	private static final String STATEMENT_UPDATE = "activity.dao.update";
	private static final String STATEMENT_DELETE = "activity.dao.delete";

	@Override
	public void insert(ActivityDO activity) {
		super.insert(STATEMENT_INSERT, activity);
	}

	@Override
	public ActivityDO get(Long id) {
		return super.get(STATEMENT_GET, id);
	}

	@Override
	public List<ActivityDO> query(ActivityQueryModel queryModel) {
		return super.query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(ActivityQueryModel queryModel) {
		return super.count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(ActivityDO activity) {
		super.update(STATEMENT_UPDATE, activity);
	}

	@Override
	public void delete(Long id) {
		super.update(STATEMENT_DELETE, id);
	}
}
