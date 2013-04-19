/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;

import com.iacrqq.util.StringUtil;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.model.BaseQueryModel;
import com.ihome.matrix.model.CategoryQueryModel;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.web.util.FormUtil;

/**
 * 
 * @author sihai
 *
 */
public class CategoryQuery extends AbstractLoginedController {
	
	private CategoryManager categoryManager;
	
	@Override
	protected ModelAndView handleLogined(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CategoryQueryModel queryModel = FormUtil.toBean(CategoryQueryModel.class, request);
		queryModel.withPageSize(BaseQueryModel.MAX_PAGE_SIZE);
		
		if(StringUtil.equals("_JS_TREE_", request.getParameter("_who_"))) {
			doJSTree(queryModel, response);
		} else {
			ResultModel<CategoryDO> resultModel = categoryManager.query(queryModel);
			writeJSONResponse(true, resultModel.getItemList(), null, response);
		}
		return null;
	}
	
	/**
	 * 
	 * @param queryModel
	 * @param response
	 * @throws IOException
	 */
	private void doJSTree(CategoryQueryModel queryModel, HttpServletResponse response) throws IOException {
		
		ResultModel<CategoryDO> resultModel = categoryManager.query(queryModel);
		
		// [{"attr":{"id":"0","rel":"drive"},"data":"Psg","state":"closed"}]
		JSONArray jsonArray = new JSONArray();
		JSONObject json = null;
		JSONObject attr = null;
		for(CategoryDO category : resultModel.getItemList()) {
			json = new JSONObject();
			attr = new JSONObject();
			attr.put("id", category.getId());
			attr.put("rel", "folder");
			attr.put("name", category.getName());
			attr.put("description", category.getDescription());
			attr.put("keywords", category.getKeywords());
			attr.put("status", category.getStatus());
			attr.put("rank", category.getStatus());
			json.put("attr", attr);
			json.put("data", String.format("%s(product:%d,shop:%d.item:%d)", category.getName(), category.getTotalProduct(), category.getTotalShop(), category.getTotalItem()));
			json.put("state", "closed");
			jsonArray.add(json);
		}
		
		Writer writer = null;
		try {
			response.setContentType("text/x-json;charset=UTF-8");
			writer = response.getWriter();
			writer.write(jsonArray.toString());
			writer.flush();
		} finally {
			if(writer != null) {
				writer.close();
			}
		}
	}
	
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
}
