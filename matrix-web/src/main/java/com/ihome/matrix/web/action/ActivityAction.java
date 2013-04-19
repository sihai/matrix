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
import com.ihome.matrix.domain.ActivityDO;
import com.ihome.matrix.manager.ActivityManager;
import com.ihome.matrix.web.controller.AbstractLoginedController;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class ActivityAction extends AbstractLoginedController {

	private static final Log logger = LogFactory.getLog(ActivityAction.class);
	
	public static final String OPERATION_CREATE = "_create_";
	public static final String OPERATION_UPDATE = "_update_";
	public static final String OPERATION_DELETE = "_delete_";
	
	private ActivityManager activityManager;
	
	//=================================================================================
	//							Route Method
	//=================================================================================
	
	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String operation = request.getParameter(OPERATION_KEY);
		if(StringUtil.equals(operation, OPERATION_CREATE)) {
			return doCreate(FormUtil.toBean(ActivityDO.class, request), request);
		} else if(StringUtil.equals(operation, OPERATION_UPDATE)) {
			return doUpdate(FormUtil.toBean(ActivityDO.class, request), request);
		} else if(StringUtil.equals(operation, OPERATION_DELETE)) {
			return doDelete(FormUtil.toBean(ActivityDO.class, request));
		} else {
			throw new RuntimeException(String.format("Unknown operation:%s", operation));
		}
	}
		
	//=================================================================================
	//							Action Method
	//=================================================================================
	/**
	 * 
	 * @param activity
	 * @param request
	 * @return
	 */
	private ModelAndView doCreate(ActivityDO activity, HttpServletRequest request) throws IOException {
		
		ModelAndView mv = null;
		try {
			MultipartFile logo = ((MultipartHttpServletRequest)request).getFile("logo");
			activity.setLogoURL(upload(request, logo));
			activity.setIsDeleted(false);
			activityManager.add(activity);
			mv = new ModelAndView("redirect:/activity_list.jhtml");
		} catch (ValidateException e) {
			// TODO
		}
		
		return mv;
	}
	
	/**
	 * 
	 * @param activity
	 * @param request
	 * @return
	 */
	private ModelAndView doUpdate(ActivityDO activity, HttpServletRequest request) throws IOException {
		
		ModelAndView mv = null;
		try {
			MultipartFile logo = ((MultipartHttpServletRequest)request).getFile("logo");
			if(null != logo) {
				activity.setLogoURL(upload(request, logo));
			}
			activity.setIsDeleted(false);
			activityManager.update(activity);
			mv = new ModelAndView("redirect:/activity_list.jhtml");
		} catch (ValidateException e) {
			// TODO
		}
		
		return mv;
	}
	
	/**
	 * 
	 * @param activity
	 * @return
	 */
	private ModelAndView doDelete(ActivityDO activity) {
		
		ModelAndView mv = null;
		activityManager.delete(activity.getId());
		mv = new ModelAndView("redirect:/activity_list.jhtml");
		
		return mv;
	}
	
	public void setActivityManager(ActivityManager activityManager) {
		this.activityManager = activityManager;
	}
}