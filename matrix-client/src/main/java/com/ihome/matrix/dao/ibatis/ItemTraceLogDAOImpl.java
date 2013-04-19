/**
 * 
 */
package com.ihome.matrix.dao.ibatis;

import java.util.List;

import com.ihome.matrix.dao.ItemTraceLogDAO;
import com.ihome.matrix.domain.ItemTraceLogDO;
import com.ihome.matrix.model.ItemTraceLogQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class ItemTraceLogDAOImpl extends BaseDAO implements ItemTraceLogDAO {

	private static final String STATEMENT_INSERT = "itemTraceLog.dao.insert";
	private static final String STATEMENT_QUERY = "itemTraceLog.dao.query";
	private static final String STATEMENT_COUNT = "itemTraceLog.dao.count";
	
	@Override
	public void insert(ItemTraceLogDO itemTrace) {
		this.insert(STATEMENT_INSERT, itemTrace);
	}

	@Override
	public List<ItemTraceLogDO> query(ItemTraceLogQueryModel queryModel) {
		return this.query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(ItemTraceLogQueryModel queryModel) {
		return this.count(STATEMENT_COUNT, queryModel);
	}
}
