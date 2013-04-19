/**
 * 
 */
package com.ihome.matrix.domain;

import java.util.List;

/**
 * 品牌
 * @author sihai
 *
 */
public class BrandDO extends BaseDO {
	
	private String name;
	private String logoURL;
	private String companyName;
	private String companyURL;
	private Integer status;
	
	private List<BrandCategoryDO> brandCategoryList;	// 品牌拥有的类目
	private List<BrandProductDO>  brandProductLIst;		// 品牌拥有的产品
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogoURL() {
		return logoURL;
	}
	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyURL() {
		return companyURL;
	}
	public void setCompanyURL(String companyURL) {
		this.companyURL = companyURL;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<BrandCategoryDO> getBrandCategoryList() {
		return brandCategoryList;
	}
	public void setBrandCategoryList(List<BrandCategoryDO> brandCategoryList) {
		this.brandCategoryList = brandCategoryList;
	}
}
