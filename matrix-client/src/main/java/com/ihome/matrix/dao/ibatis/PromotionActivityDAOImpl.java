/**
 * 
 */
package com.ihome.matrix.dao.ibatis;

import java.util.List;

import com.ihome.matrix.dao.PromotionActivityDAO;
import com.ihome.matrix.domain.PromotionActivityDO;
import com.ihome.matrix.model.PromotionActivityQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class PromotionActivityDAOImpl extends BaseDAO implements PromotionActivityDAO {
	
	private static final String STATEMENT_INSERT = "promotionActivity.dao.insert";
	private static final String STATEMENT_GET = "promotionActivity.dao.get";
	private static final String STATEMENT_QUERY = "promotionActivity.dao.query";
	private static final String STATEMENT_COUNT = "promotionActivity.dao.count";
	private static final String STATEMENT_UPDATE = "promotionActivity.dao.update";
	private static final String STATEMENT_DELETE = "promotionActivity.dao.delete";

	@Override
	public void insert(PromotionActivityDO promotionActivity) {
		super.insert(STATEMENT_INSERT, promotionActivity);
	}

	@Override
	public PromotionActivityDO get(Long id) {
		return super.get(STATEMENT_GET, id);
	}

	@Override
	public List<PromotionActivityDO> query(PromotionActivityQueryModel queryModel) {
		return super.query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(PromotionActivityQueryModel queryModel) {
		return super.count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(PromotionActivityDO promotionActivity) {
		super.update(STATEMENT_UPDATE, promotionActivity);
	}

	@Override
	public void delete(Long id) {
		super.update(STATEMENT_DELETE, id);
	}
}
