/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author sihai
 *
 */
public class Index extends AbstractLoginedController {
	
	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("index");
		// 
		return mv;
	}
}
