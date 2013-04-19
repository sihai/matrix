/**
 * ihome
 * igo
 */
package com.ihome.matrix.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihome.matrix.dao.ShopDAO;
import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.domain.ShopDO;
import com.ihome.matrix.model.ShopQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class ShopDAOImpl extends BaseDAO implements ShopDAO {

	private static final String STATEMENT_INSERT = "shop.dao.insert";
	private static final String STATEMENT_GET = "shop.dao.get";
	private static final String STATEMENT_GET_BY_ITEMID_AND_PLATFORM = "shop.dao.getByShopIdAndPlatform";
	private static final String STATEMENT_QUERY = "shop.dao.query";
	private static final String STATEMENT_COUNT = "shop.dao.count";
	private static final String STATEMENT_UPDATE = "shop.dao.update";
	private static final String STATEMENT_DELETE = "shop.dao.delete";
	
	@Override
	public void insert(ShopDO shop) {
		insert(STATEMENT_INSERT, shop);
	}

	@Override
	public ShopDO get(Long id) {
		return get(STATEMENT_GET, id);
	}
	
	@Override
	public ShopDO getByShopIdAndPlatform(String shopId, int platform) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("shopId", shopId);
		parameterMap.put("platform", platform);
		return get(STATEMENT_GET_BY_ITEMID_AND_PLATFORM, parameterMap);
	}

	@Override
	public List<ShopDO> query(ShopQueryModel queryModel) {
		return query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(ShopQueryModel queryModel) {
		return count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(ShopDO shop) {
		update(STATEMENT_UPDATE, shop);
	}

	@Override
	public void delete(Long id) {
		delete(STATEMENT_DELETE, id);
	}
}
