/**
 * 
 */
package com.ihome.matrix.dao.ibatis;

import java.util.List;

import com.ihome.matrix.dao.ShopProductDAO;
import com.ihome.matrix.domain.ShopProductDO;
import com.ihome.matrix.model.ShopProductQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class ShopProductDAOImpl extends BaseDAO implements ShopProductDAO {

	private static final String STATEMENT_INSERT = "shopProduct.dao.insert";
	private static final String STATEMENT_GET = "shopProduct.dao.get";
	private static final String STATEMENT_QUERY = "shopProduct.dao.query";
	private static final String STATEMENT_COUNT = "shopProduct.dao.count";
	private static final String STATEMENT_UPDATE = "shopProduct.dao.update";
	private static final String STATEMENT_DELETE = "shopProduct.dao.delete";
	private static final String STATEMENT_DELETE_BY_SHOP_ID = "shopProduct.dao.deleteByShopId";
	
	@Override
	public void insert(ShopProductDO shopProduct) {
		super.insert(STATEMENT_INSERT, shopProduct);
	}

	@Override
	public ShopProductDO get(Long id) {
		return super.get(STATEMENT_GET, id);
	}

	@Override
	public List<ShopProductDO> query(ShopProductQueryModel queryModel) {
		return super.query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(ShopProductQueryModel queryModel) {
		return super.count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(ShopProductDO shopProduct) {
		super.update(STATEMENT_UPDATE, shopProduct);
	}
	
	@Override
	public void deleteByShopId(Long shopId) {
		super.delete(STATEMENT_DELETE_BY_SHOP_ID, shopId);
	}

	@Override
	public void delete(Long id) {
		super.delete(STATEMENT_DELETE, id);
	}
}
