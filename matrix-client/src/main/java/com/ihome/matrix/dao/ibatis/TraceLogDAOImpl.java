/**
 * 
 */
package com.ihome.matrix.dao.ibatis;

import com.ihome.matrix.dao.TraceLogDAO;
import com.ihome.matrix.domain.TraceLogDO;

/**
 * 
 * @author sihai
 *
 */
public class TraceLogDAOImpl extends BaseDAO implements TraceLogDAO {

	/* (non-Javadoc)
	 * @see com.ihome.matrix.dao.TraceLogDAO#insert(com.ihome.matrix.domain.TraceLogDO)
	 */
	@Override
	public void insert(TraceLogDO trace) {
		this.insert("traceLog.dao.insert", trace);
	}
}
