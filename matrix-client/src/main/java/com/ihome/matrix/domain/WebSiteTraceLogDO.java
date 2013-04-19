/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class WebSiteTraceLogDO extends BaseTraceLogDO {
	
	private WebSiteDO  webSite;

	public WebSiteDO getWebSite() {
		return webSite;
	}

	public void setWebSite(WebSiteDO webSite) {
		this.webSite = webSite;
	}
}
