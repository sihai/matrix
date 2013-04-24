package com.ihome.matrix.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihome.matrix.dao.TmpProductDAO;
import com.ihome.matrix.domain.TmpProductDO;
import com.ihome.matrix.model.TmpProductQueryModel;

public class TmpProductDAOImpl extends BaseDAO implements TmpProductDAO {

	private static final String STATEMENT_INSERT = "tmpProduct.dao.insert";
	private static final String STATEMENT_GET = "tmpProduct.dao.get";
	private static final String STATEMENT_GET_BY_OUTPRODUCTID_AND_PLATFORM = "tmpProduct.dao.getByOutProductIdAndPlatform";
	private static final String STATEMENT_QUERY = "tmpProduct.dao.query";
	private static final String STATEMENT_COUNT = "tmpProduct.dao.count";
	private static final String STATEMENT_UPDATE = "tmpProduct.dao.update";
	private static final String STATEMENT_DELETE = "tmpProduct.dao.delete";
	
	@Override
	public void insert(TmpProductDO tmpProduct) {
		insert(STATEMENT_INSERT, tmpProduct);
	}

	@Override
	public TmpProductDO get(Long id) {
		return get(STATEMENT_GET, id);
	}
	
	@Override
	public TmpProductDO getByOutProductIdIdAndPlatform(Long outProductId, int platform) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("outProductId", outProductId);
		parameterMap.put("platform", platform);
		return get(STATEMENT_GET_BY_OUTPRODUCTID_AND_PLATFORM, parameterMap);
	}

	@Override
	public List<TmpProductDO> query(TmpProductQueryModel queryModel) {
		return query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(TmpProductQueryModel queryModel) {
		return count(STATEMENT_COUNT, queryModel);
	}

	/*@Override
	public void update(TmpProductDO tmpProduct) {
		update(STATEMENT_UPDATE, tmpProduct);
	}*/

	@Override
	public void delete(Long id) {
		delete(STATEMENT_DELETE, id);
	}
}
