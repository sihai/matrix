/**
 * 
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class ProductAssDO extends BaseDO {

	private Long outProductId;
	
	private String outProductName;
	
	private Integer platform;
	
	private ProductDO product;

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

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public ProductDO getProduct() {
		return product;
	}

	public void setProduct(ProductDO product) {
		this.product = product;
	}
}
