/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iacrqq.util.StringUtil;
import com.ihome.matrix.domain.BrandCategoryDO;
import com.ihome.matrix.domain.BrandDO;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.manager.BrandManager;
import com.ihome.matrix.manager.CategoryManager;

/**
 * 
 * @author sihai
 *
 */
public class Brand extends AbstractLoginedController {
	
	private BrandManager brandManager;
	private CategoryManager categoryManager;

	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("brand");
		Map<String, Object> context = mv.getModelMap();
		String strId = request.getParameter("id");
		if(StringUtil.isNotBlank(strId)) {
			BrandDO brand = brandManager.get(Long.valueOf(strId));
			context.put("brand", brand);
			context.put("categoryIdList", getCategoryIdList(brand));
		}
		List<CategoryDO> mainCategoryList = categoryManager.getMainCategoryList();
		mv.getModel().put("mainCategoryList", mainCategoryList);
		return mv;
	}
	
	/**
	 * 
	 * @param brand
	 * @return
	 */
	private List<Long> getCategoryIdList(BrandDO brand) {
		if(null == brand) {
			return Collections.EMPTY_LIST;
		}
		List<BrandCategoryDO> brandCategoryList = brand.getBrandCategoryList();
		List<Long> categoryIdList = new ArrayList<Long>();
		for(BrandCategoryDO bc : brandCategoryList) {
			if(null != bc.getCategory() && null != bc.getCategory().getId()) {
				categoryIdList.add(bc.getCategory().getId());
			}
		}
		return categoryIdList;
	}
	
	public void setBrandManager(BrandManager brandManager) {
		this.brandManager = brandManager;
	}
	
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
}
