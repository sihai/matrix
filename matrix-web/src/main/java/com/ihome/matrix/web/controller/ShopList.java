/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.ihome.matrix.domain.ShopDO;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.manager.ShopManager;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.model.ShopQueryModel;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class ShopList extends AbstractLoginedController {
	
	private ShopManager shopManager;
	private CategoryManager categoryManager;
	
	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("shopList");
		ShopQueryModel queryModel = FormUtil.toBean(ShopQueryModel.class, request);
		ResultModel<ShopDO> resultModel = shopManager.query(queryModel);
		mv.getModel().put("resultModel", resultModel);
		mv.getModel().put("mainCategoryList", categoryManager.getMainCategoryList());
		return mv;
	}
	
	public void setShopManager(ShopManager shopManager) {
		this.shopManager = shopManager;
	}
	
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
}
