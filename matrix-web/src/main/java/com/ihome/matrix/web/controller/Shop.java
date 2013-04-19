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
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.ShopCategoryDO;
import com.ihome.matrix.domain.ShopDO;
import com.ihome.matrix.domain.ShopProductDO;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.manager.ProductManager;
import com.ihome.matrix.manager.ShopManager;
import com.ihome.matrix.model.BaseQueryModel;
import com.ihome.matrix.model.ProductQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class Shop extends AbstractLoginedController {
	
	private ShopManager shopManager;
	private CategoryManager categoryManager;
	private ProductManager productManager;
	
	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("shop");
		Map<String, Object> context = mv.getModelMap();
		String strId = request.getParameter("id");
		if(StringUtil.isNotBlank(strId)) {
			ShopDO shop = shopManager.get(Long.valueOf(strId));
			context.put("shop", shop);
			context.put("categoryIdList", getCategoryIdList(shop));
			context.put("productIdList", getProductIdList(shop));
		}
		List<CategoryDO> mainCategoryList = categoryManager.getMainCategoryList();
		context.put("mainCategoryList", mainCategoryList);
		context.put("productList", productManager.query(ProductQueryModel.newInstance().withPageSize(BaseQueryModel.MAX_PAGE_SIZE)).getItemList());
		return mv;
	}
	
	/**
	 * 
	 * @param brand
	 * @return
	 */
	private List<Long> getCategoryIdList(ShopDO shop) {
		if(null == shop) {
			return Collections.EMPTY_LIST;
		}
		List<ShopCategoryDO> shopCategoryList = shop.getShopCategoryList();
		List<Long> categoryIdList = new ArrayList<Long>();
		for(ShopCategoryDO sc : shopCategoryList) {
			// 有可能类目被删掉了
			if(null != sc.getCategory() && null != sc.getCategory().getId()) {
				categoryIdList.add(sc.getCategory().getId());
			}
		}
		return categoryIdList;
	}
	
	/**
	 * 
	 * @param brand
	 * @return
	 */
	private List<Long> getProductIdList(ShopDO shop) {
		if(null == shop) {
			return Collections.EMPTY_LIST;
		}
		List<ShopProductDO> shopProductList = shop.getShopProductList();
		List<Long> productIdList = new ArrayList<Long>();
		for(ShopProductDO sp : shopProductList) {
			// 有可能产品被删掉了
			if(null != sp.getProduct() && null != sp.getProduct().getId()) {
				productIdList.add(sp.getProduct().getId());
			}
		}
		return productIdList;
	}
	
	public void setShopManager(ShopManager shopManager) {
		this.shopManager = shopManager;
	}
	
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
}
