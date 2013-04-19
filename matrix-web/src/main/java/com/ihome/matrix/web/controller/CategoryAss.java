/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.ihome.matrix.domain.CategoryAssDO;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.model.CategoryAssQueryModel;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class CategoryAss extends AbstractLoginedController {
	
	private CategoryManager categoryManager;
	

	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("categoryAss");
		CategoryAssQueryModel queryModel = FormUtil.toBean(CategoryAssQueryModel.class, request);
		ResultModel<CategoryAssDO> resultModel = categoryManager.query(queryModel);
		mv.getModel().put("resultModel", resultModel);
		return mv;
	}
	
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
}
