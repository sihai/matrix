/**
 * ihome
 * igo
 */
package com.ihome.matrix.model;

/**
 * 
 * @author sihai
 *
 */
public class WebSiteQueryModel extends BaseQueryModel {
	
	private Integer type;
	
	public static WebSiteQueryModel newInstance() {
		return new WebSiteQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	public WebSiteQueryModel withType(Integer type) {
		this.type = type;
		return this;
	}
	
	@Override
	public WebSiteQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public WebSiteQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}
	
	//======================================================
	//				DSL
	//======================================================
	public Integer getType() {
		return type;
	}
}
