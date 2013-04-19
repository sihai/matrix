/**
 * 
 */
package com.ihome.matrix.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihome.matrix.dao.BrandProductDAO;
import com.ihome.matrix.domain.BrandProductDO;
import com.ihome.matrix.model.BrandProductQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class BrandProductDAOImpl extends BaseDAO implements BrandProductDAO {
	
	private static final String STATEMENT_INSERT = "brandProduct.dao.insert";
	private static final String STATEMENT_GET = "brandProduct.dao.get";
	private static final String STATEMENT_QUERY = "brandProduct.dao.query";
	private static final String STATEMENT_COUNT = "brandProduct.dao.count";
	private static final String STATEMENT_UPDATE = "brandProduct.dao.update";
	private static final String STATEMENT_DELETE = "brandProduct.dao.delete";
	private static final String STATEMENT_DELETE_BY_BRAND_ID = "brandProduct.dao.deleteByBrandId";
	private static final String STATEMENT_DELETE_BY_BRAND_AND_PRODUCT = "brandProduct.dao.deleteByBrandAndCategory";

	@Override
	public void insert(BrandProductDO brandProduct) {
		super.insert(STATEMENT_INSERT, brandProduct);
	}

	@Override
	public BrandProductDO get(Long id) {
		return super.get(STATEMENT_GET, id);
	}

	@Override
	public List<BrandProductDO> query(BrandProductQueryModel queryModel) {
		return super.query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(BrandProductQueryModel queryModel) {
		return super.count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(BrandProductDO brandProduct) {
		super.update(STATEMENT_UPDATE, brandProduct);
	}

	@Override
	public void delete(Long id) {
		super.update(STATEMENT_DELETE, id);
	}
	
	@Override
	public void deleteByBrandId(Long brandId) {
		super.update(STATEMENT_DELETE_BY_BRAND_ID, brandId);
	}

	@Override
	public void delete(Long brand, Long category) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("brand", brand);
		parameterMap.put("category", category);
		super.update(STATEMENT_DELETE_BY_BRAND_AND_PRODUCT, parameterMap);
	}
}