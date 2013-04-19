/**
 * ihome.igo
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.WebSiteDO;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.model.WebSiteQueryModel;

/**
 * 
 * @author sihai
 *
 */
public interface WebSiteManager {
	
	/**
	 * 
	 * @param webSite
	 * @throws ValidateException
	 */
	void add(WebSiteDO webSite) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	WebSiteDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	ResultModel<WebSiteDO> query(WebSiteQueryModel queryModel);
	
	/**
	 * 
	 * @param webSite
	 */
	void update(WebSiteDO webSite) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
