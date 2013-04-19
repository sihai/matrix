/**
 * 
 */
package com.ihome.matrix.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.ihome.matrix.manager.ItemManager;
import com.ihome.matrix.web.controller.AbstractLoginedController;

/**
 * 
 * @author sihai
 *
 */
public class ItemAction extends AbstractLoginedController {

	private ItemManager itemManager;

	@Override
	protected ModelAndView handleLogined(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
}
