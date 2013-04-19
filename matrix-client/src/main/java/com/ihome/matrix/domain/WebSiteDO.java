/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class WebSiteDO extends BaseDO {

	private String name;
	private String siteURL;
	private String logo;
	
	private Integer type;
	private Long viewCount;
	private Long rank;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSiteURL() {
		return siteURL;
	}
	public void setSiteURL(String siteURL) {
		this.siteURL = siteURL;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getViewCount() {
		return viewCount;
	}
	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}
	public Long getRank() {
		return rank;
	}
	public void setRank(Long rank) {
		this.rank = rank;
	}
}
