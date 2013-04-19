/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.manager.ItemManager;
import com.ihome.matrix.model.ItemQueryModel;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class ItemList extends AbstractLoginedController {
	
	private ItemManager itemManager;
	

	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("itemList");
		ItemQueryModel queryModel = FormUtil.toBean(ItemQueryModel.class, request);
		ResultModel<ItemDO> resultModel = itemManager.query(queryModel);
		mv.getModel().put("resultModel", resultModel);
		return mv;
	}
	
	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
}
