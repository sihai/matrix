/**
 * 
 */
package com.ihome.matrix.manager.impl;

import com.ihome.matrix.dao.ItemTraceLogDAO;
import com.ihome.matrix.dao.ShopTraceLogDAO;
import com.ihome.matrix.dao.TraceLogDAO;
import com.ihome.matrix.dao.WebSiteTraceLogDAO;
import com.ihome.matrix.domain.ItemTraceLogDO;
import com.ihome.matrix.domain.ShopTraceLogDO;
import com.ihome.matrix.domain.TraceLogDO;
import com.ihome.matrix.domain.WebSiteTraceLogDO;
import com.ihome.matrix.manager.TraceLogManager;
import com.ihome.matrix.model.ItemTraceLogQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public class TraceLogManagerImpl implements TraceLogManager {

	private TraceLogDAO 		traceLogDAO;
	private ItemTraceLogDAO 	itemTraceLogDAO;
	private ShopTraceLogDAO 	shopTraceLogDAO;
	private WebSiteTraceLogDAO 	webSiteTraceLogDAO;

	@Override
	public void addTrace(TraceLogDO trace) {
		traceLogDAO.insert(trace);
	}	
	
	@Override
	public void addItemTrace(ItemTraceLogDO itemTrace) {
		itemTraceLogDAO.insert(itemTrace);
	}
	
	@Override
	public ResultModel<ItemTraceLogDO> query(ItemTraceLogQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, itemTraceLogDAO.query(queryModel), itemTraceLogDAO.count(queryModel));
	}

	@Override
	public void addShopTrace(ShopTraceLogDO shopTrace) {
		shopTraceLogDAO.insert(shopTrace);
	}

	@Override
	public void addWebSiteTrace(WebSiteTraceLogDO webSiteTrace) {
		webSiteTraceLogDAO.insert(webSiteTrace);
	}

	public void setTraceLogDAO(TraceLogDAO traceLogDAO) {
		this.traceLogDAO = traceLogDAO;
	}
	
	public void setItemTraceLogDAO(ItemTraceLogDAO itemTraceLogDAO) {
		this.itemTraceLogDAO = itemTraceLogDAO;
	}

	public void setShopTraceLogDAO(ShopTraceLogDAO shopTraceLogDAO) {
		this.shopTraceLogDAO = shopTraceLogDAO;
	}
	
	public void setWebSiteTraceLogDAO(WebSiteTraceLogDAO webSiteTraceLogDAO) {
		this.webSiteTraceLogDAO = webSiteTraceLogDAO;
	}
}
