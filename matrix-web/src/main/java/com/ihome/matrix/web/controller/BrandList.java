/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.ihome.matrix.domain.BrandDO;
import com.ihome.matrix.manager.BrandManager;
import com.ihome.matrix.model.BrandQueryModel;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class BrandList extends AbstractLoginedController {
	
	private BrandManager brandManager;
	

	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("brandList");
		BrandQueryModel queryModel = FormUtil.toBean(BrandQueryModel.class, request);
		ResultModel<BrandDO> resultModel = brandManager.query(queryModel);
		mv.getModel().put("resultModel", resultModel);
		return mv;
	}
	
	public void setBrandManager(BrandManager brandManager) {
		this.brandManager = brandManager;
	}
}
