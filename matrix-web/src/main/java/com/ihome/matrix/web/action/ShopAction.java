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
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.domain.ShopCategoryDO;
import com.ihome.matrix.domain.ShopDO;
import com.ihome.matrix.domain.ShopProductDO;
import com.ihome.matrix.enums.ShopCategoryStatusEnum;
import com.ihome.matrix.enums.ShopProductStatusEnum;
import com.ihome.matrix.manager.ShopManager;
import com.ihome.matrix.web.controller.AbstractLoginedController;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class ShopAction extends AbstractLoginedController {

	private static final Log logger = LogFactory.getLog(ShopAction.class);
	
	public static final String OPERATION_CREATE = "_create_";
	public static final String OPERATION_UPDATE = "_update_";
	public static final String OPERATION_DELETE = "_delete_";
	
	private ShopManager shopManager;

	//=================================================================================
	//							Route Method
	//=================================================================================
	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String operation = request.getParameter(OPERATION_KEY);
		if(StringUtil.equals(operation, OPERATION_CREATE)) {
			return doCreate(FormUtil.toBean(ShopDO.class, request), request);
		} else if(StringUtil.equals(operation, OPERATION_UPDATE)) {
			return doUpdate(FormUtil.toBean(ShopDO.class, request), request);
		} else if(StringUtil.equals(operation, OPERATION_DELETE)) {
			return doDelete(FormUtil.toBean(ShopDO.class, request));
		} else {
			throw new RuntimeException(String.format("Unknown operation:%s", operation));
		}
	}
	
	//=================================================================================
	//							Action Method
	//=================================================================================
	/**
	 * 
	 * @param shop
	 * @param request
	 * @return
	 */
	private ModelAndView doCreate(ShopDO shop, HttpServletRequest request) throws IOException {
		
		ModelAndView mv = null;
		try {
			fillOtherParameters(shop, request);
			shop.setRank(Long.MAX_VALUE);
			shop.setIsRecommend(false);
			shop.setIsDeleted(false);
			shopManager.add(shop);
			updateOthers(shop, request);
			mv = new ModelAndView("redirect:/shop_list.jhtml");
		} catch (ValidateException e) {
			// TODO
		}
		
		return mv;
	}
	
	/**
	 * 
	 * @param shop
	 * @param request
	 * @return
	 */
	private ModelAndView doUpdate(ShopDO shop, HttpServletRequest request) throws IOException {
		
		ModelAndView mv = null;
		try {
			fillOtherParameters(shop, request);
			shop.setRank(Long.MAX_VALUE);
			shop.setIsRecommend(false);
			shop.setIsDeleted(false);
			shopManager.update(shop);
			updateOthers(shop, request);
			mv = new ModelAndView("redirect:/shop_list.jhtml");
		} catch (ValidateException e) {
			// TODO
		}
		
		return mv;
	}
	
	/**
	 * 
	 * @param shop
	 * @return
	 */
	private ModelAndView doDelete(ShopDO shop) {
		
		ModelAndView mv = null;
		shopManager.delete(shop.getId());
		shopManager.deleteShopCategoryByShopId(shop.getId());
		shopManager.deleteShopProductByShopId(shop.getId());
		mv = new ModelAndView("redirect:/shop_list.jhtml");
		return mv;
	}
	
	/**
	 * 
	 * @param shop
	 * @param request
	 * @throws IOException
	 */
	private void fillOtherParameters(ShopDO shop, HttpServletRequest request) throws IOException {
		MultipartFile logo = ((MultipartHttpServletRequest)request).getFile("logo");
		if(null != logo && StringUtil.isNotBlank(logo.getName())) {
			shop.setLogoURL(upload(request, logo));
		}
		String[] array = request.getParameterValues("pay_way");
		if(null == array || 0 == array.length) {
			shop.setPayways("");
		} else {
			shop.setPayways(StringUtil.join(array, ","));
		}
		array = request.getParameterValues("distribute_way");
		if(null == array || 0 == array.length) {
			shop.setDistributeWays("");
		} else {
			shop.setDistributeWays(StringUtil.join(array, ","));
		}
	}
	
	/**
	 * 
	 * @param shop
	 * @param request
	 * @throws ValidateException
	 */
	private void updateOthers(ShopDO shop, HttpServletRequest request) throws ValidateException {
		
		shopManager.deleteShopCategoryByShopId(shop.getId());
		shopManager.deleteShopProductByShopId(shop.getId());

		// shop category
		String[] values = request.getParameterValues("shop_category");
		if(null != values) {
			ShopCategoryDO sc = null;
			CategoryDO category = new CategoryDO();
			for(String v : values) {
				sc = new ShopCategoryDO();
				sc.setShop(shop);
				category.setId(Long.valueOf(v));
				sc.setCategory(category);
				sc.setRank(Long.MAX_VALUE);
				sc.setStatus(ShopCategoryStatusEnum.NORMAL.getValue());
				sc.setIsDeleted(false);
				shopManager.addShopCategory(sc);
			}
		}
		
		// shop product
		values = request.getParameterValues("shop_product");
		if(null != values) {
			ShopProductDO sp = null;
			ProductDO product = new ProductDO();
			for(String v : values) {
				sp = new ShopProductDO();
				sp.setShop(shop);
				product.setId(Long.valueOf(v));
				sp.setProduct(product);
				sp.setRank(Long.MAX_VALUE);
				sp.setStatus(ShopProductStatusEnum.NORMAL.getValue());
				sp.setIsDeleted(false);
				shopManager.addShopProduct(sp);
			}
		}
	}
	
	public void setShopManager(ShopManager shopManager) {
		this.shopManager = shopManager;
	}
}
