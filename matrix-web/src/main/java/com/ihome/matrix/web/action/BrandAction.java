/**
 * 
 */
package com.ihome.matrix.web.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.iacrqq.util.StringUtil;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.BrandCategoryDO;
import com.ihome.matrix.domain.BrandDO;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.enums.BrandCategoryStatusEnum;
import com.ihome.matrix.manager.BrandManager;
import com.ihome.matrix.web.controller.AbstractLoginedController;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class BrandAction extends AbstractLoginedController {

	private static final Log logger = LogFactory.getLog(BrandAction.class);
	
	public static final String OPERATION_CREATE = "_create_";
	public static final String OPERATION_UPDATE = "_update_";
	public static final String OPERATION_DELETE = "_delete_";
	
	private BrandManager brandManager;
	
	//=================================================================================
	//							Route Method
	//=================================================================================
	
	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String operation = request.getParameter(OPERATION_KEY);
		if(StringUtil.equals(operation, OPERATION_CREATE)) {
			return doCreate(FormUtil.toBean(BrandDO.class, request), request);
		} else if(StringUtil.equals(operation, OPERATION_UPDATE)) {
			return doUpdate(FormUtil.toBean(BrandDO.class, request), request);
		} else if(StringUtil.equals(operation, OPERATION_DELETE)) {
			return doDelete(FormUtil.toBean(BrandDO.class, request));
		} else {
			throw new RuntimeException(String.format("Unknown operation:%s", operation));
		}
	}
		
	//=================================================================================
	//							Action Method
	//=================================================================================
	/**
	 * 
	 * @param brand
	 * @param request
	 * @return
	 */
	private ModelAndView doCreate(BrandDO brand, HttpServletRequest request) throws IOException {
		
		ModelAndView mv = null;
		try {
			MultipartFile logo = ((MultipartHttpServletRequest)request).getFile("logo");
			brand.setLogoURL(upload(request, logo));
			brand.setIsDeleted(false);
			brandManager.add(brand);
			
			// brand category
			String[] values = request.getParameterValues("brand_category");
			BrandCategoryDO bc = null;
			CategoryDO category = new CategoryDO();
			for(String v : values) {
				bc = new BrandCategoryDO();
				bc.setBrand(brand);
				category.setId(Long.valueOf(v));
				bc.setCategory(category);
				bc.setRank(Long.MAX_VALUE);
				bc.setStatus(BrandCategoryStatusEnum.NORMAL.getValue());
				bc.setIsDeleted(false);
				brandManager.addBrandCategory(bc);
			}
			mv = new ModelAndView("redirect:/brand_list.jhtml");
		} catch (ValidateException e) {
			// TODO
		}
		
		return mv;
	}
	
	/**
	 * 
	 * @param brand
	 * @param request
	 * @return
	 */
	private ModelAndView doUpdate(BrandDO brand, HttpServletRequest request) throws IOException {
		
		ModelAndView mv = null;
		try {
			MultipartFile logo = ((MultipartHttpServletRequest)request).getFile("logo");
			if(null != logo && StringUtil.isNotBlank(logo.getOriginalFilename())) {
				brand.setLogoURL(upload(request, logo));
			}
			brand.setIsDeleted(false);
			brandManager.update(brand);
			
			// brand category
			brandManager.deleteBrandCategoryByBrandId(brand.getId());
			String[] values = request.getParameterValues("brand_category");
			BrandCategoryDO bc = null;
			CategoryDO category = new CategoryDO();
			for(String v : values) {
				bc = new BrandCategoryDO();
				bc.setBrand(brand);
				category.setId(Long.valueOf(v));
				bc.setCategory(category);
				bc.setRank(Long.MAX_VALUE);
				bc.setStatus(BrandCategoryStatusEnum.NORMAL.getValue());
				bc.setIsDeleted(false);
				brandManager.addBrandCategory(bc);
			}
						
			mv = new ModelAndView("redirect:/brand_list.jhtml");
		} catch (ValidateException e) {
			// TODO
		}
		
		return mv;
	}
	
	/**
	 * 
	 * @param brand
	 * @return
	 */
	private ModelAndView doDelete(BrandDO brand) {
		
		ModelAndView mv = null;
		brandManager.delete(brand.getId());
		// 删除
		brandManager.deleteBrandCategoryByBrandId(brand.getId());
		mv = new ModelAndView("redirect:/brand_list.jhtml");
		
		return mv;
	}
	
	public void setBrandManager(BrandManager brandManager) {
		this.brandManager = brandManager;
	}
}
