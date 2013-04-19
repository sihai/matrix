/**
 * ihome.matrix
 */
package com.ihome.matrix.domain;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 
 * @author sihai
 *
 */
public class ItemDO extends BaseDO {
	
	@Field
	private String name;
	@Field
	private Double price;				// 商品价格，格式：5.00；单位：元；精确到：分
	@Field
	private String detailURL;			// 商品连接
	@Field
	private String logoURL;				// 图片地址
	@Field
	private Long   number;				// 数量
	@Field
	private Long   saleCountPreMonth;	// 销量
	
	@Field
	private Double igoScore = 4.75D;	// 综合评分 

	private String  itemId;				// 商品id，平台相关
	
	@Field
	private Integer platform;			// 商品所属平台，如 taobao,jingdong,dangdang...
	
	@Field
	private Integer freightFeePayer; 	// 运费承担方式,seller（卖家承担），buyer(买家承担）
	@Field
	private Double  postFee;			// 平邮费用,格式：5.00；单位：元；精确到：分
	@Field
	private Double  expressFee;			// 快递费用,格式：5.00；单位：元；精确到：
	@Field
	private Double  emsFee;				// ems费用,格式：5.00；单位：元；精确到：分
	
	@Field
	private Boolean hasDiscount;		// 支持会员打折,true/false
	@Field
	private Boolean hasInvoice;			// 是否有发票,true/false
	@Field
	private Boolean hasWarranty;		// 是否有保修,true/false
	@Field
	private Boolean isSecondKill;		// 是否为秒杀商品
	@Field
	private Boolean isSellPromise;		// 是否承诺退换货服务
	
	@Field
	private String promotion;			// 促销信息
	@Field
	private String gifts;				// 赠品
	
	@Field
	private Integer status;				// igo 状态
	
	@Field
	private CategoryDO category;		// 类目
	
	@Field
	private String location;			//
	
	@Field
	private ShopDO shop;				// 所属店铺
	
	@Field
	private List<CategoryDO> categoryPath;	// 
	
	@Field
	private BrandDO brand;					// 品牌
	
	@Field
	private ProductDO product;				// 所属产品
	
	// 商品评价 来自商品所属Shop, 5分标准
	@Field
	private Long score;						// 评分
	
	private Boolean isRecommended;			// 是否推荐
	private String recommendReason;			// 推荐理由

	// 评论
	private Long commentCount;				// 评价数
	
	private Long favorableCommentCount;		// 好评数
	private Long mediumCommentCount;		// 中评数
	private Long poorCommentCount;			// 差评数

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

	public void setDetailURL(String detailURL) {
		this.detailURL = detailURL;
	}

	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Long getSaleCountPreMonth() {
		return saleCountPreMonth;
	}

	public void setSaleCountPreMonth(Long saleCount) {
		this.saleCountPreMonth = saleCount;
	}

	public Double getIgoScore() {
		return igoScore;
	}

	public void setIgoScore(Double igoScore) {
		this.igoScore = igoScore;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public Integer getFreightFeePayer() {
		return freightFeePayer;
	}

	public void setFreightFeePayer(Integer freightFeePayer) {
		this.freightFeePayer = freightFeePayer;
	}

	public Double getPostFee() {
		return postFee;
	}

	public void setPostFee(Double postFee) {
		this.postFee = postFee;
	}

	public Double getExpressFee() {
		return expressFee;
	}

	public void setExpressFee(Double expressFee) {
		this.expressFee = expressFee;
	}

	public Double getEmsFee() {
		return emsFee;
	}

	public void setEmsFee(Double emsFee) {
		this.emsFee = emsFee;
	}

	public Boolean getHasDiscount() {
		return hasDiscount;
	}

	public void setHasDiscount(Boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}

	public Boolean getHasInvoice() {
		return hasInvoice;
	}

	public void setHasInvoice(Boolean hasInvoice) {
		this.hasInvoice = hasInvoice;
	}

	public Boolean getHasWarranty() {
		return hasWarranty;
	}

	public void setHasWarranty(Boolean hasWarranty) {
		this.hasWarranty = hasWarranty;
	}

	public Boolean getIsSecondKill() {
		return isSecondKill;
	}

	public void setIsSecondKill(Boolean isSecondKill) {
		this.isSecondKill = isSecondKill;
	}

	public Boolean getIsSellPromise() {
		return isSellPromise;
	}

	public void setIsSellPromise(Boolean isSellPromise) {
		this.isSellPromise = isSellPromise;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public String getGifts() {
		return gifts;
	}

	public void setGifts(String gifts) {
		this.gifts = gifts;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public CategoryDO getCategory() {
		return category;
	}

	public void setCategory(CategoryDO category) {
		this.category = category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public ShopDO getShop() {
		return shop;
	}

	public void setShop(ShopDO shop) {
		this.shop = shop;
	}

	public List<CategoryDO> getCategoryPath() {
		return categoryPath;
	}

	public void setCategoryPath(List<CategoryDO> categoryPath) {
		this.categoryPath = categoryPath;
	}

	public BrandDO getBrand() {
		return brand;
	}

	public void setBrand(BrandDO brand) {
		this.brand = brand;
	}

	public ProductDO getProduct() {
		return product;
	}

	public void setProduct(ProductDO product) {
		this.product = product;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Boolean getIsRecommended() {
		return isRecommended;
	}

	public void setIsRecommended(Boolean isRecommended) {
		this.isRecommended = isRecommended;
	}
	
	public String getRecommendReason() {
		return recommendReason;
	}

	public void setRecommendReason(String recommendReason) {
		this.recommendReason = recommendReason;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public Long getFavorableCommentCount() {
		return favorableCommentCount;
	}

	public void setFavorableCommentCount(Long favorableCommentCount) {
		this.favorableCommentCount = favorableCommentCount;
	}

	public Long getMediumCommentCount() {
		return mediumCommentCount;
	}

	public void setMediumCommentCount(Long mediumCommentCount) {
		this.mediumCommentCount = mediumCommentCount;
	}

	public Long getPoorCommentCount() {
		return poorCommentCount;
	}

	public void setPoorCommentCount(Long poorCommentCount) {
		this.poorCommentCount = poorCommentCount;
	}
}