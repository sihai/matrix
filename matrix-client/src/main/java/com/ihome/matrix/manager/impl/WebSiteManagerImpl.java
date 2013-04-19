package com.ihome.matrix.manager.impl;

import com.ihome.matrix.dao.WebSiteDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.WebSiteDO;
import com.ihome.matrix.manager.WebSiteManager;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.model.WebSiteQueryModel;

public class WebSiteManagerImpl implements WebSiteManager {

	private WebSiteDAO webSiteDAO;
	
	@Override
	public void add(WebSiteDO webSite) throws ValidateException {
		validate(webSite);
		webSiteDAO.insert(webSite);
	}

	@Override
	public WebSiteDO get(Long id) {
		return webSiteDAO.get(id);
	}

	@Override
	public ResultModel<WebSiteDO> query(WebSiteQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, webSiteDAO.query(queryModel), webSiteDAO.count(queryModel));
	}

	@Override
	public void update(WebSiteDO webSite) throws ValidateException {
		validate(webSite);
		webSiteDAO.update(webSite);
	}

	@Override
	public void delete(Long id) {
		webSiteDAO.delete(id);
	}
	
	/**
	 * 
	 * @param webSite
	 * @throws ValidateException
	 */
	private void validate(WebSiteDO webSite) throws ValidateException {
		// TODO
		WebSiteDO tmp = webSiteDAO.getByName(webSite.getName());
		if(null != tmp) {
			throw new ValidateException(String.format("网站：%s已经存在！！！", webSite.getName()));
		}
	}
	
	public void setWebSiteDAO(WebSiteDAO webSiteDAO) {
		this.webSiteDAO = webSiteDAO;
	}
}
