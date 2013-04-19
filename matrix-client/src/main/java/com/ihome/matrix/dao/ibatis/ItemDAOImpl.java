package com.ihome.matrix.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihome.matrix.dao.ItemDAO;
import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.model.ItemQueryModel;

public class ItemDAOImpl extends BaseDAO implements ItemDAO {

	private static final String STATEMENT_INSERT = "item.dao.insert";
	private static final String STATEMENT_GET = "item.dao.get";
	private static final String STATEMENT_GET_BY_ITEMID_AND_PLATFORM = "item.dao.getByItemIdAndPlatform";
	private static final String STATEMENT_QUERY = "item.dao.query";
	private static final String STATEMENT_COUNT = "item.dao.count";
	private static final String STATEMENT_UPDATE = "item.dao.update";
	private static final String STATEMENT_DELETE = "item.dao.delete";
	
	@Override
	public void insert(ItemDO item) {
		insert(STATEMENT_INSERT, item);
	}

	@Override
	public ItemDO get(Long id) {
		return get(STATEMENT_GET, id);
	}
	
	@Override
	public ItemDO getByItemIdAndPlatform(String itemId, int platform) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("itemId", itemId);
		parameterMap.put("platform", platform);
		return get(STATEMENT_GET_BY_ITEMID_AND_PLATFORM, parameterMap);
	}

	@Override
	public List<ItemDO> query(ItemQueryModel queryModel) {
		return query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(ItemQueryModel queryModel) {
		return count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(ItemDO item) {
		update(STATEMENT_UPDATE, item);
	}

	@Override
	public void delete(Long id) {
		delete(STATEMENT_DELETE, id);
	}
}
