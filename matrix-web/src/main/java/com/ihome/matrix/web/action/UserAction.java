/**
 * 
 */
package com.ihome.matrix.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.iacrqq.util.StringUtil;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.UserDO;
import com.ihome.matrix.enums.UserStatusEnum;
import com.ihome.matrix.web.controller.AbstractController;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class UserAction extends AbstractController {

	private static final Log logger = LogFactory.getLog(UserAction.class);
	
	public static final String OPERATION_REGISTER = "_register_";
	public static final String OPERATION_LOGIN = "_login_";
	
	private static final String ADMINISTRATOR = "matrix";
	private static final String PASSWORD = "matrix";
	
	//=================================================================================
	//							Route Method
	//=================================================================================
	
	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String operation = request.getParameter(OPERATION_KEY);
		if(StringUtil.equals(operation, OPERATION_REGISTER)) {
			return doRegister(FormUtil.toBean(UserDO.class, request), request.getSession());
		} else if(StringUtil.equals(operation, OPERATION_LOGIN)) {
			return doLogin(FormUtil.toBean(UserDO.class, request), request.getParameter(PARAMETER_REDIRECT_TO), request.getSession());
		} else {
			throw new RuntimeException(String.format("Unknown operation:%s", operation));
		}
	}
	
	//=================================================================================
	//							Action Method
	//=================================================================================
	/**
	 * 注册
	 * @param request
	 * @param session
	 * @return
	 */
	private ModelAndView doRegister(UserDO user, HttpSession session) {
		
		ModelAndView mv = null;
		try {
			user.setStatus(UserStatusEnum.NORMAL.getValue());
			user.setIsDeleted(false);
			//userManager.register(user);
			mv = new ModelAndView("redirect:/index.jhtml");
			// 构建登录上下文
			setLoginContext(session, user);
			throw new ValidateException("At now we not supported register.");
		} catch (ValidateException e) {
			 mv = new ModelAndView("member/login");
			 mv.getModel().put("user", user);
			 mv.getModel().put("registerErrorMsg", e.getMessage());
		}
		
		return mv;
	}
	
	/**
	 * 登录
	 * @param request
	 * @param rt
	 * @return
	 */
	private ModelAndView doLogin(UserDO user, String rt, HttpSession session) {
		
		ModelAndView mv = null;
		//UserDO u = userManager.login(user.getName(), user.getPassword());
		if(!StringUtil.equals(ADMINISTRATOR, user.getName()) || !StringUtil.equals(PASSWORD, user.getPassword())) {
			mv = new ModelAndView("login");
			mv.getModel().put("loginErrorMsg", "用户名或密码错误！！！");
		} else {
			mv = new ModelAndView("redirect:" + (StringUtil.isBlank(rt) ? "/index.jhtml" : rt));
			// 构建登录上下文
			user.setId(0L);
			setLoginContext(session, user);
		}
		
		return mv;
	}
	
	/**
	 * 构建登录上下文
	 * @param session
	 * @param user
	 */
	private void setLoginContext(HttpSession session, UserDO user) {
		
		// 目前的cookie支持 Byte, Short, Integer, Long, Float, Double, Boolean, String 
		session.setAttribute("userId", user.getId());
		session.setAttribute("userName", user.getName());
		session.setAttribute("userLogo", user.getLogoURL());
	}
}
