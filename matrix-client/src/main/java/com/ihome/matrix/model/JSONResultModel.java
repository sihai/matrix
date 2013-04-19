/**
 * ihome inc.
 * matrix-client
 */
package com.ihome.matrix.model;

import java.util.Date;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.JSONUtils;

import com.iacrqq.util.DateUtil;

/**
 * 
 * @author sihai
 * 
 */
public class JSONResultModel extends BaseModel {

	public static JsonConfig DEFUALT_JSON_CONFIG = new JsonConfig();
	static {
		DEFUALT_JSON_CONFIG.setExcludes(new String[]{"isDeleted", "gmtCreate", "gmtModified", "categoryPath", "parent", "children", "totalBrand", "totalProduct", "totalShop", "totalItem"});
		DEFUALT_JSON_CONFIG.registerJsonValueProcessor(Date.class , new JSONDateValueProcessor());
	}
	
	private Boolean isSucceed;
	private Object result;
	private String errorMsg;
	
	static {
		String[] dateFormats = new String[] {DateUtil.DEFAULT_DATE_FORMAT}; 
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
	}
	
	public JSONResultModel() {}

	public JSONResultModel(Boolean isSucceed, Object result, String errorMsg) {
		this.isSucceed = isSucceed;
		this.result = result;
		this.errorMsg = errorMsg;
	}

	public Boolean getIsSucceed() {
		return isSucceed;
	}

	public Object getResult() {
		return result;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public JSONResultModel withIsSucceed(Boolean isSucceed) {
		this.isSucceed = isSucceed;
		return this;
	}

	public JSONResultModel withResult(Object result) {
		this.result = result;
		return this;
	}

	public JSONResultModel withErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toJSON() {
		return toJSON(DEFUALT_JSON_CONFIG);
	}
	
	/**
	 * 
	 * @return
	 */
	public String toJSON(JsonConfig config) {
		return JSONObject.fromObject(this, config).toString();
	}
	
	public static class JSONDateValueProcessor implements JsonValueProcessor {  
		  
	    public Object processArrayValue(Object value, JsonConfig config) {  
	        return process(value);  
	    }  
	  
	    public Object processObjectValue(String key, Object value, JsonConfig config) {  
	        return process(value);  
	    }  
	      
	    private Object process(Object value){  
	          
	        if(value instanceof Date){
	        	return DateUtil.format((Date)value);
	        }  
	        return value == null ? "" : value.toString();  
	    }  
	}
}
