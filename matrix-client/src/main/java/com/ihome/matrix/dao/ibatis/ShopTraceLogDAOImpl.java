/**
 * 
 */
package com.ihome.matrix.dao.ibatis;

import com.ihome.matrix.dao.ShopTraceLogDAO;
import com.ihome.matrix.domain.ShopTraceLogDO;

/**
 * 
 * @author sihai
 *
 */
public class ShopTraceLogDAOImpl extends BaseDAO implements ShopTraceLogDAO {

	@Override
	public void insert(ShopTraceLogDO shopTrace) {
		this.insert("shopTraceLog.dao.insert", shopTrace);
	}
}
