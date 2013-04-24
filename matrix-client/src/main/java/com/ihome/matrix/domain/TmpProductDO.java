/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class TmpProductDO extends BaseDO {

	private Long outProductId;
	
	private String outProductName;
	
	private String logoURL;
	
	private Long outCategoryId;
	
	private String outCategoryName;
	
	private String description;
	
	private String property;
	
	private Integer platform;

	public Long getOutProductId() {
		return outProductId;
	}

	public void setOutProductId(Long outProductId) {
		this.outProductId = outProductId;
	}

	public String getOutProductName() {
		return outProductName;
	}

	public void setOutProductName(String outProductName) {
		this.outProductName = outProductName;
	}
	
	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}

	public Long getOutCategoryId() {
		return outCategoryId;
	}

	public void setOutCategoryId(Long outCategoryId) {
		this.outCategoryId = outCategoryId;
	}

	public String getOutCategoryName() {
		return outCategoryName;
	}

	public void setOutCategoryName(String outCategoryName) {
		this.outCategoryName = outCategoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
}
