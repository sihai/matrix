/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.ihome.matrix.manager.CategoryManager;

/**
 * 
 * @author sihai
 *
 */
public class Category extends AbstractLoginedController {
	
	private CategoryManager categoryManager;
	
	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("category");
		/*CategoryQueryModel queryModel = FormUtil.toBean(CategoryQueryModel.class, request);
		ResultModel<CategoryDO> resultModel = categoryManager.query(queryModel);
		mv.getModel().put("resultModel", resultModel); */
		return mv;
	}

	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}	
}
