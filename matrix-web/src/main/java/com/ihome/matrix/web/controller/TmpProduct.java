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
import com.ihome.matrix.domain.TmpProductDO;
import com.ihome.matrix.manager.ProductManager;
import com.ihome.matrix.manager.TmpProductManager;
import com.ihome.matrix.model.BaseQueryModel;
import com.ihome.matrix.model.ProductQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class TmpProduct extends AbstractLoginedController {
	
	private TmpProductManager tmpProductManager;
	private ProductManager productManager;

	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("tmpProduct");
		Map<String, Object> context = mv.getModelMap();
		String strId = request.getParameter("id");
		if(StringUtil.isNotBlank(strId)) {
			TmpProductDO tmpProduct = tmpProductManager.get(Long.valueOf(strId));
			context.put("tmpProduct", tmpProduct);
		}
		context.put("productList", productManager.query(ProductQueryModel.newInstance().withPageSize(BaseQueryModel.MAX_PAGE_SIZE)).getItemList());
		return mv;
	}

	public void setTmpProductManager(TmpProductManager tmpProductManager) {
		this.tmpProductManager = tmpProductManager;
	}
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
}
