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
import com.ihome.matrix.domain.CategoryAssDO;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.enums.CategoryStatusEnum;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.web.controller.AbstractLoginedController;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class CategoryAction extends AbstractLoginedController {

	private static final Log logger = LogFactory.getLog(CategoryAction.class);
	
	public static final String OPERATION_CREATE_AJAX = "_create_ajax_";
	public static final String OPERATION_UPDATE_AJAX = "_update_ajax_";
	public static final String OPERATION_DELETE_AJAX = "_delete_ajax_";
	
	public static final String OPERATION_CREATE_CATEGORY_ASS = "_create_category_ass_";
	public static final String OPERATION_UPDATE_CATEGORY_ASS = "_update_category_ass_";
	public static final String OPERATION_DELETE_CATEGORY_ASS = "_delete_category_ass_";
	
	private CategoryManager categoryManager;
	
	//=================================================================================
	//							Route Method
	//=================================================================================
	
	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String operation = request.getParameter(OPERATION_KEY);
		if(StringUtil.equals(operation, OPERATION_CREATE_AJAX)) {
			return doCreateAjax(FormUtil.toBean(CategoryDO.class, request), response);
		} else if(StringUtil.equals(operation, OPERATION_UPDATE_AJAX)) {
			return doUpdateAjax(FormUtil.toBean(CategoryDO.class, request), response);
		} else if(StringUtil.equals(operation, OPERATION_DELETE_AJAX)) {
			return doDeleteAjax(FormUtil.toBean(CategoryDO.class, request), response);
		} else if(StringUtil.equals(operation, OPERATION_CREATE_CATEGORY_ASS)) {
			return doCreateCategoryAss(FormUtil.toBean(CategoryAssDO.class, request), response);
		} else if(StringUtil.equals(operation, OPERATION_UPDATE_CATEGORY_ASS)) {
			return doUpdateCategoryAss(FormUtil.toBean(CategoryAssDO.class, request), response);
		} else if(StringUtil.equals(operation, OPERATION_DELETE_CATEGORY_ASS)) {
			return doDeleteCategoryAss(FormUtil.toBean(CategoryAssDO.class, request), response);
		} else {
			throw new RuntimeException(String.format("Unknown operation:%s", operation));
		}
	}
		
	//=================================================================================
	//							Action Method
	//=================================================================================
	/**
	 * 
	 * @param category
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private ModelAndView doCreateAjax(CategoryDO category, HttpServletResponse response) throws IOException {
		
		try {
			category.setStatus(CategoryStatusEnum.NORMAL.getValue());
			category.setIsDeleted(false);
			categoryManager.add(category);
			writeJSONResponse(true, category.getId(), null, response);
		} catch (ValidateException e) {
			// TODO
			writeJSONResponse(false, null, e.getMessage(), response);
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param category
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private ModelAndView doUpdateAjax(CategoryDO category, HttpServletResponse response) throws IOException {
		
		try {
			categoryManager.update(category);
			writeJSONResponse(true, null, null, response);
		} catch (ValidateException e) {
			// TODO
			writeJSONResponse(false, null, e.getMessage(), response);
		}
		return null;
	}
	
	/**
	 * 
	 * @param category
	 * @param response
	 * @return
	 */
	private ModelAndView doDeleteAjax(CategoryDO category, HttpServletResponse response) {
		
		categoryManager.delete(category.getId());
		writeJSONResponse(true, null, null, response);
		return null;
	}
	
	/**
	 * 
	 * @param categoryAss
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private ModelAndView doCreateCategoryAss(CategoryAssDO categoryAss, HttpServletResponse response) throws IOException {
		
		try {
			categoryAss.setIsDeleted(false);
			categoryManager.add(categoryAss);
		} catch (ValidateException e) {
			// TODO
		}
		
		return new ModelAndView("redirect:/category_ass.jhtml");
	}
	
	/**
	 * 
	 * @param categoryAss
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private ModelAndView doUpdateCategoryAss(CategoryAssDO categoryAss, HttpServletResponse response) throws IOException {
		
		try {
			categoryManager.update(categoryAss);
			writeJSONResponse(true, null, null, response);
		} catch (ValidateException e) {
			// TODO
		}
		return new ModelAndView("redirect:/category_ass.jhtml");
	}
	
	/**
	 * 
	 * @param categoryAss
	 * @param response
	 * @return
	 */
	private ModelAndView doDeleteCategoryAss(CategoryAssDO categoryAss, HttpServletResponse response) {
		
		categoryManager.deleteCategoryAss(categoryAss.getId());
		return new ModelAndView("redirect:/category_ass.jhtml");
	}
	
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
}