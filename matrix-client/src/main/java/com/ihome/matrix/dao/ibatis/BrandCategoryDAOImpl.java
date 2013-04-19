/**
 * 
 */
package com.ihome.matrix.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihome.matrix.dao.BrandCategoryDAO;
import com.ihome.matrix.domain.BrandCategoryDO;
import com.ihome.matrix.model.BrandCategoryQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class BrandCategoryDAOImpl extends BaseDAO implements BrandCategoryDAO {
	
	private static final String STATEMENT_INSERT = "brandCategory.dao.insert";
	private static final String STATEMENT_GET = "brandCategory.dao.get";
	private static final String STATEMENT_QUERY = "brandCategory.dao.query";
	private static final String STATEMENT_COUNT = "brandCategory.dao.count";
	private static final String STATEMENT_UPDATE = "brandCategory.dao.update";
	private static final String STATEMENT_DELETE = "brandCategory.dao.delete";
	private static final String STATEMENT_DELETE_BY_BRAND_ID = "brandCategory.dao.deleteByBrandId";
	private static final String STATEMENT_DELETE_BY_BRAND_AND_CATEGORY = "brandCategory.dao.deleteByBrandAndCategory";

	@Override
	public void insert(BrandCategoryDO brandCategory) {
		super.insert(STATEMENT_INSERT, brandCategory);
	}

	@Override
	public BrandCategoryDO get(Long id) {
		return super.get(STATEMENT_GET, id);
	}

	@Override
	public List<BrandCategoryDO> query(BrandCategoryQueryModel queryModel) {
		return super.query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(BrandCategoryQueryModel queryModel) {
		return super.count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(BrandCategoryDO brandCategory) {
		super.update(STATEMENT_UPDATE, brandCategory);
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
		super.update(STATEMENT_DELETE_BY_BRAND_AND_CATEGORY, parameterMap);
	}
}