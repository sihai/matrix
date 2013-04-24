/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.ihome.matrix.domain.TmpProductDO;
import com.ihome.matrix.manager.TmpProductManager;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.model.TmpProductQueryModel;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class TmpProductList extends AbstractLoginedController {
	
	private TmpProductManager tmpProductManager;

	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("tmpProductList");
		TmpProductQueryModel queryModel = FormUtil.toBean(TmpProductQueryModel.class, request);
		ResultModel<TmpProductDO> resultModel = tmpProductManager.query(queryModel);
		mv.getModel().put("resultModel", resultModel);
		return mv;
	}
	
	public void setTmpProductManager(TmpProductManager tmpProductManager) {
		this.tmpProductManager = tmpProductManager;
	}
}
