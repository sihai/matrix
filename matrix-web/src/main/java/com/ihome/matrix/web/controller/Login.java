/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iacrqq.util.StringUtil;

/**
 * 
 * @author sihai
 *
 */
public class Login extends AbstractController {
	
	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(isLogined(request.getSession())) {
			String rt = request.getParameter(PARAMETER_REDIRECT_TO);
			return new ModelAndView("redirect:" + (StringUtil.isNotBlank(rt) ? rt : "/"));
		} else {
			return new ModelAndView("login");
		}
	}
}
