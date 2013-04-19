/**
 * 
 */
package com.ihome.matrix.dao.ibatis;

import java.util.List;

import com.ihome.matrix.dao.WebSiteDAO;
import com.ihome.matrix.domain.WebSiteDO;
import com.ihome.matrix.model.WebSiteQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class WebSiteDAOImpl extends BaseDAO implements WebSiteDAO {

	@Override
	public void insert(WebSiteDO webSite) {
		super.insert("webSite.dao.insert", webSite);
	}

	@Override
	public WebSiteDO get(Long id) {
		return super.get("webSite.dao.get", id);
	}

	@Override
	public WebSiteDO getByName(String name) {
		return super.get("webSite.dao.getByName", name);
	}

	@Override
	public List<WebSiteDO> query(WebSiteQueryModel queryModel) {
		return super.query("webSite.dao.query", queryModel);
	}
	
	@Override
	public Long count(WebSiteQueryModel queryModel) {
		return super.count("webSite.dao.count", queryModel);
	}

	@Override
	public void update(WebSiteDO webSite) {
		super.update("webSite.dao.update", webSite);
	}

	@Override
	public void delete(Long id) {
		super.delete("webSite.dao.delete", id);
	}
}