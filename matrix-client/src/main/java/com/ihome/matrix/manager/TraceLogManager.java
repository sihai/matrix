/**
 * 
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.domain.ItemTraceLogDO;
import com.ihome.matrix.domain.ShopTraceLogDO;
import com.ihome.matrix.domain.TraceLogDO;
import com.ihome.matrix.domain.WebSiteTraceLogDO;
import com.ihome.matrix.model.ItemTraceLogQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public interface TraceLogManager {

	/**
	 * 
	 * @param trace
	 */
	void addTrace(TraceLogDO trace);
	
	/**
	 * 
	 * @param itemTrace
	 */
	void addItemTrace(ItemTraceLogDO itemTrace);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	ResultModel<ItemTraceLogDO> query(ItemTraceLogQueryModel queryModel);
	
	/**
	 * 
	 * @param itemTrace
	 */
	void addShopTrace(ShopTraceLogDO shopTrace);
	
	/**
	 * 
	 * @param webSiteTrace
	 */
	void addWebSiteTrace(WebSiteTraceLogDO webSiteTrace);
}
