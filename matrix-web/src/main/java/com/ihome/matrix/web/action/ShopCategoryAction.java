/**
 * 
 */
package com.ihome.matrix.web.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.iacrqq.util.StringUtil;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.ShopCategoryDO;
import com.ihome.matrix.enums.ShopCategoryStatusEnum;
import com.ihome.matrix.manager.ShopManager;
import com.ihome.matrix.model.JSONResultModel;
import com.ihome.matrix.web.controller.AbstractLoginedController;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class ShopCategoryAction extends AbstractLoginedController {

	private static final Log logger = LogFactory.getLog(ShopCategoryAction.class);
	
	public static final String OPERATION_CREATE = "_create_";
	public static final String OPERATION_DELETE = "_delete_";
	
	private ShopManager shopManager;

	//=================================================================================
	//							Route Method
	//=================================================================================
	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String operation = request.getParameter(OPERATION_KEY);
		if(StringUtil.equals(operation, OPERATION_CREATE)) {
			return doCreate(FormUtil.toBean(ShopCategoryDO.class, request), response);
		} else if(StringUtil.equals(operation, OPERATION_DELETE)) {
			return doDelete(FormUtil.toBean(ShopCategoryDO.class, request), response);
		} else {
			throw new RuntimeException(String.format("Unknown operation:%s", operation));
		}
	}
	
	//=================================================================================
	//							Action Method
	//=================================================================================
	/**
	 * 
	 * @param shopCategory
	 * @param response
	 * @return
	 */
	private ModelAndView doCreate(ShopCategoryDO shopCategory, HttpServletResponse response) throws IOException {
		
		JSONResultModel result = new JSONResultModel(true, null, null);
		try {
			shopCategory.setRank(Long.MAX_VALUE);
			shopCategory.setStatus(ShopCategoryStatusEnum.NORMAL.getValue());
			shopCategory.setIsDeleted(false);
			shopManager.addShopCategory(shopCategory);
		} catch (ValidateException e) {
			result.withIsSucceed(false);
			result.withErrorMsg(e.getMessage());
		}
		
		this.writeJSONResponse(result, response);
		
		return null;
	}

	/**
	 * 
	 * @param shopCategory
	 * @param response
	 * @return
	 */
	private ModelAndView doDelete(ShopCategoryDO shopCategory, HttpServletResponse response) {
		shopManager.deleteShopCategory(shopCategory.getShop().getId(), shopCategory.getCategory().getId());
		JSONResultModel result = new JSONResultModel(true, null, null);
		this.writeJSONResponse(result, response);
		return null;
	}
		
	public void setShopManager(ShopManager shopManager) {
		this.shopManager = shopManager;
	}
}
