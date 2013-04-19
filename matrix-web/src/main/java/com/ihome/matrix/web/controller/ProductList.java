/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.manager.BrandManager;
import com.ihome.matrix.manager.ProductManager;
import com.ihome.matrix.model.BaseQueryModel;
import com.ihome.matrix.model.BrandQueryModel;
import com.ihome.matrix.model.ProductQueryModel;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class ProductList extends AbstractLoginedController {
	
	private ProductManager productManager;
	private BrandManager   brandManager;
	

	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("productList");
		ProductQueryModel queryModel = FormUtil.toBean(ProductQueryModel.class, request);
		ResultModel<ProductDO> resultModel = productManager.query(queryModel);
		mv.getModel().put("resultModel", resultModel);
		return mv;
	}
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
	
	public void setBrandManager(BrandManager brandManager) {
		this.brandManager = brandManager;
	}
}
