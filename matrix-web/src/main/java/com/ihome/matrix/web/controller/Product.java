/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iacrqq.util.StringUtil;
import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.manager.BrandManager;
import com.ihome.matrix.manager.ProductManager;
import com.ihome.matrix.model.BaseQueryModel;
import com.ihome.matrix.model.BrandQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class Product extends AbstractLoginedController {
	
	private ProductManager productManager;
	private BrandManager   brandManager;
	

	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("product");
		Map<String, Object> context = mv.getModelMap();
		String strId = request.getParameter("id");
		if(StringUtil.isNotBlank(strId)) {
			ProductDO product = productManager.get(Long.valueOf(strId));
			context.put("product", product);
		}
		context.put("brandList", brandManager.query(BrandQueryModel.newInstance().withPageSize(BaseQueryModel.MAX_PAGE_SIZE).withCurrentPage(1L)).getItemList());
		return mv;
	}
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
	
	public void setBrandManager(BrandManager brandManager) {
		this.brandManager = brandManager;
	}
}
