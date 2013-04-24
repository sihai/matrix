package com.ihome.matrix.model;

public class TmpProductQueryModel extends BaseQueryModel {
	
	private Long outProductId;
	
	private String outProductName;
	
	private Long outCategoryId;
	
	private String outCategoryName;
	
	private Integer platform;
	
	public static TmpProductQueryModel newInstance() {
		return new TmpProductQueryModel();
	}
	
	//======================================================
	//				DSL
	//======================================================
	public TmpProductQueryModel withOutProductId(Long outProductId) {
		this.outProductId = outProductId;
		return this;
	}
	
	public TmpProductQueryModel withOutProductName(String outProductName) {
		this.outProductName = outProductName;
		return this;
	}
	
	public TmpProductQueryModel withOutCategoryId(Long outCategoryId) {
		this.outCategoryId = outCategoryId;
		return this;
	}
	
	public TmpProductQueryModel withOutCategoryName(String outCategoryName) {
		this.outCategoryName = outCategoryName;
		return this;
	}
	
	public TmpProductQueryModel withPlatform(Integer platform) {
		this.platform = platform;
		return this;
	}
	
	@Override
	public TmpProductQueryModel withCurrentPage(Long currentPage) {
		super.withCurrentPage(currentPage);
		return this;
	}
	
	@Override
	public TmpProductQueryModel withPageSize(Long pageSize) {
		super.withPageSize(pageSize);
		return this;
	}

	//======================================================
	//				setter/getter
	//======================================================
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

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
}