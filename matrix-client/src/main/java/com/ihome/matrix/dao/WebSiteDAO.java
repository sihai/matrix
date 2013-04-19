/*
 * ihome inc.
 * igo
 */
package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.WebSiteDO;
import com.ihome.matrix.model.WebSiteQueryModel;

/**
 * webSite DAO
 * @author sihai
 *
 */
public interface WebSiteDAO {
	
	/**
	 * 
	 * @param webSite
	 */
	void insert(WebSiteDO webSite);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	WebSiteDO get(Long id);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	WebSiteDO getByName(String name);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<WebSiteDO> query(WebSiteQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(WebSiteQueryModel queryModel);
	
	/**
	 * 
	 * @param webSite
	 */
	void update(WebSiteDO webSite);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
