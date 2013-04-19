/**
 * 
 */
package com.ihome.matrix.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihome.matrix.dao.ShopCategoryDAO;
import com.ihome.matrix.domain.ShopCategoryDO;
import com.ihome.matrix.model.ShopCategoryQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class ShopCategoryDAOImpl extends BaseDAO implements ShopCategoryDAO {
	
	private static final String STATEMENT_INSERT = "shopCategory.dao.insert";
	private static final String STATEMENT_GET = "shopCategory.dao.get";
	private static final String STATEMENT_QUERY = "shopCategory.dao.query";
	private static final String STATEMENT_COUNT = "shopCategory.dao.count";
	private static final String STATEMENT_UPDATE = "shopCategory.dao.update";
	private static final String STATEMENT_DELETE = "shopCategory.dao.delete";
	private static final String STATEMENT_DELETE_BY_SHOP_ID = "shopCategory.dao.deleteByShopId";
	private static final String STATEMENT_DELETE_BY_SHOP_AND_CATEGORY = "shopCategory.dao.deleteByShopAndCategory";

	@Override
	public void insert(ShopCategoryDO shopCategory) {
		super.insert(STATEMENT_INSERT, shopCategory);
	}

	@Override
	public ShopCategoryDO get(Long id) {
		return super.get(STATEMENT_GET, id);
	}

	@Override
	public List<ShopCategoryDO> query(ShopCategoryQueryModel queryModel) {
		return super.query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(ShopCategoryQueryModel queryModel) {
		return super.count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(ShopCategoryDO shopCategory) {
		super.update(STATEMENT_UPDATE, shopCategory);
	}

	@Override
	public void delete(Long id) {
		super.update(STATEMENT_DELETE, id);
	}
	
	@Override
	public void deleteByShopId(Long shopId) {
		super.update(STATEMENT_DELETE_BY_SHOP_ID, shopId);
	}

	@Override
	public void delete(Long shop, Long category) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("shop", shop);
		parameterMap.put("category", category);
		super.update(STATEMENT_DELETE_BY_SHOP_AND_CATEGORY, parameterMap);
	}
}