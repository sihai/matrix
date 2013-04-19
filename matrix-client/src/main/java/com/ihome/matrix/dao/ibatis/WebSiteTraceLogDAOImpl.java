/**
 * 
 */
package com.ihome.matrix.dao.ibatis;

import com.ihome.matrix.dao.WebSiteTraceLogDAO;
import com.ihome.matrix.domain.WebSiteTraceLogDO;

/**
 * 
 * @author sihai
 *
 */
public class WebSiteTraceLogDAOImpl extends BaseDAO implements WebSiteTraceLogDAO {

	@Override
	public void insert(WebSiteTraceLogDO webSiteTrace) {
		this.insert("webSiteTraceLog.dao.insert", webSiteTrace);
	}
}
