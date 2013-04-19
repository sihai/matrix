/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.ihome.matrix.domain.ActivityDO;
import com.ihome.matrix.manager.ActivityManager;
import com.ihome.matrix.model.ActivityQueryModel;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class ActivityList extends AbstractLoginedController {
	
	private ActivityManager activityManager;
	

	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("activityList");
		ActivityQueryModel queryModel = FormUtil.toBean(ActivityQueryModel.class, request);
		ResultModel<ActivityDO> resultModel = activityManager.query(queryModel);
		mv.getModel().put("resultModel", resultModel);
		return mv;
	}
	
	public void setActivityManager(ActivityManager activityManager) {
		this.activityManager = activityManager;
	}
}
