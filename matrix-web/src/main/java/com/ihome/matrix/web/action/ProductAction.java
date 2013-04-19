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
import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.manager.ProductManager;
import com.ihome.matrix.web.controller.AbstractLoginedController;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class ProductAction extends AbstractLoginedController {

	private static final Log logger = LogFactory.getLog(ProductAction.class);
	
	public static final String OPERATION_CREATE = "_create_";
	public static final String OPERATION_UPDATE = "_update_";
	public static final String OPERATION_DELETE = "_delete_";
	
	private ProductManager productManager;
	
	//=================================================================================
	//							Route Method
	//=================================================================================
	
	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String operation = request.getParameter(OPERATION_KEY);
		if(StringUtil.equals(operation, OPERATION_CREATE)) {
			return doCreate(FormUtil.toBean(ProductDO.class, request), request);
		} else if(StringUtil.equals(operation, OPERATION_UPDATE)) {
			return doUpdate(FormUtil.toBean(ProductDO.class, request), request);
		} else if(StringUtil.equals(operation, OPERATION_DELETE)) {
			return doDelete(FormUtil.toBean(ProductDO.class, request));
		} else {
			throw new RuntimeException(String.format("Unknown operation:%s", operation));
		}
	}
		
	//=================================================================================
	//							Action Method
	//=================================================================================
	/**
	 * 
	 * @param product
	 * @param request
	 * @return
	 */
	private ModelAndView doCreate(ProductDO product, HttpServletRequest request) throws IOException {
		
		ModelAndView mv = null;
		try {
			MultipartFile logo = ((MultipartHttpServletRequest)request).getFile("logo");
			product.setLogoURL(upload(request, logo));
			product.setIsDeleted(false);
			productManager.add(product);
			mv = new ModelAndView("redirect:/product_list.jhtml");
		} catch (ValidateException e) {
			// TODO
		}
		
		return mv;
	}
	
	/**
	 * 
	 * @param product
	 * @param request
	 * @return
	 */
	private ModelAndView doUpdate(ProductDO product, HttpServletRequest request) throws IOException {
		
		ModelAndView mv = null;
		try {
			MultipartFile logo = ((MultipartHttpServletRequest)request).getFile("logo");
			if(null != logo) {
				product.setLogoURL(upload(request, logo));
			}
			product.setIsDeleted(false);
			productManager.update(product);
			mv = new ModelAndView("redirect:/product_list.jhtml");
		} catch (ValidateException e) {
			// TODO
		}
		
		return mv;
	}
	
	/**
	 * 
	 * @param product
	 * @return
	 */
	private ModelAndView doDelete(ProductDO product) {
		
		ModelAndView mv = null;
		productManager.delete(product.getId());
		mv = new ModelAndView("redirect:/product_list.jhtml");
		
		return mv;
	}
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
}