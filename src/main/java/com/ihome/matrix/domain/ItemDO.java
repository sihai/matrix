/**
 * ihome.matrix
 */
package com.ihome.matrix.domain;

/**
 * 
 * @author sihai
 *
 */
public class ItemDO extends BaseDO {
	
	private String name;
	private Double price;				// 商品价格，格式：5.00；单位：元；精确到：分
	private String detailURL;		
	private String logoURL;
	private String location;			// 商品所在地
	private Long   number;				// 
	private Integer stuffStatus;		// 商品新旧程度(全新:0，闲置:1，二手：2)
	private Integer status;
	private String  itemId;
	private Integer platform;
	
	private Integer freightFeePayer; 	// 运费承担方式,seller（卖家承担），buyer(买家承担）
	private Double  postFee;			// 平邮费用,格式：5.00；单位：元；精确到：分
	private Double  expressFee;			// 快递费用,格式：5.00；单位：元；精确到：分
	private Double  emsFee;				// ems费用,格式：5.00；单位：元；精确到：分
	
	private Boolean hasDiscount;		// 支持会员打折,true/false
	private Boolean hasInvoice;			// 是否有发票,true/false
	private Boolean hasWarranty;		// 是否有保修,true/false
	private Boolean isSecondKill;		// 是否为秒杀商品
	private Boolean isSellPromise;		// 是否承诺退换货服务
	private Boolean isXinpin;			// 标示商品是否为新品。 值含义：true-是，false-否。
	
	private CategoryDO category;
	private ShopDO shop;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDetailURL() {
		return detailURL;
	}
	public String getLocation() {
		return location;
	}
	public Long getNumber() {
		return number;
	}
	public Integer getStuffStatus() {
		return stuffStatus;
	}
	public String getItemId() {
		return itemId;
	}
	public Integer getFreightFeePayer() {
		return freightFeePayer;
	}
	public Double getPostFee() {
		return postFee;
	}
	public Double getExpressFee() {
		return expressFee;
	}
	public Double getEmsFee() {
		return emsFee;
	}
	public Boolean getHasDiscount() {
		return hasDiscount;
	}
	public Boolean getHasInvoice() {
		return hasInvoice;
	}
	public Boolean getHasWarranty() {
		return hasWarranty;
	}
	public Boolean getIsSecondKill() {
		return isSecondKill;
	}
	public Boolean getIsSellPromise() {
		return isSellPromise;
	}
	public Boolean getIsXinpin() {
		return isXinpin;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public void setStuffStatus(Integer stuffStatus) {
		this.stuffStatus = stuffStatus;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public void setFreightFeePayer(Integer freightFeePayer) {
		this.freightFeePayer = freightFeePayer;
	}
	public void setPostFee(Double postFee) {
		this.postFee = postFee;
	}
	public void setExpressFee(Double expressFee) {
		this.expressFee = expressFee;
	}
	public void setEmsFee(Double emsFee) {
		this.emsFee = emsFee;
	}
	public void setHasDiscount(Boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}
	public void setHasInvoice(Boolean hasInvoice) {
		this.hasInvoice = hasInvoice;
	}
	public void setHasWarranty(Boolean hasWarranty) {
		this.hasWarranty = hasWarranty;
	}
	public void setIsSecondKill(Boolean isSecondKill) {
		this.isSecondKill = isSecondKill;
	}
	public void setIsSellPromise(Boolean isSellPromise) {
		this.isSellPromise = isSellPromise;
	}
	public void setIsXinpin(Boolean isXinpin) {
		this.isXinpin = isXinpin;
	}
	public void setDetailURL(String detailURL) {
		this.detailURL = detailURL;
	}
	public String getLogoURL() {
		return logoURL;
	}
	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}
	public Integer getStatus() {
		return status;
	}
	public Integer getPlatform() {
		return platform;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
	public CategoryDO getCategory() {
		return category;
	}
	public void setCategory(CategoryDO category) {
		this.category = category;
	}
	public ShopDO getShop() {
		return shop;
	}
	public void setShop(ShopDO shop) {
		this.shop = shop;
	}
}
