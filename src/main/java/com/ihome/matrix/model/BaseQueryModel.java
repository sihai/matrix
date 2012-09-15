package com.ihome.matrix.model;

public class BaseQueryModel extends BaseModel {
	
	public static final Long DEFALUT_CURRENT_PAGE = 1L;
	public static final Long MIN_PAGE_SIZE = 40L;
	public static final Long DEFAULT_PAGE_SIZE = MIN_PAGE_SIZE;
	public static final Long MAX_PAGE_SIZE = 2 * MIN_PAGE_SIZE;
	
	protected Long currentPage = DEFALUT_CURRENT_PAGE;
	protected Long pageSize = DEFAULT_PAGE_SIZE;
	
	/**
	 * Get current page no
	 * @return
	 */
	public Long getCurrentPage() {
		return currentPage;
	}
	
	/**
	 * Get size of one page
	 * @return
	 */
	public Long getPageSize() {
		return pageSize;
	}
	
	/**
	 * Set current page no
	 * @param currentPage
	 */
	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage == null || currentPage < 0 ? DEFALUT_CURRENT_PAGE : currentPage;
	}
	
	/**
	 * Set size of one page
	 * @param pageSize
	 */
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize == null || pageSize < MIN_PAGE_SIZE
				|| pageSize > MAX_PAGE_SIZE ? DEFAULT_PAGE_SIZE : pageSize;
	}
	
	/**
	 * Get page start
	 * @return
	 */
	public Long getStart() {
		return (currentPage - 1) * pageSize;
	}
	
	/**
	 * Get page end
	 * @return
	 */
	public Long getEnd() {
		return getStart() + pageSize;
	}
	
	//======================================================
	//				DSL
	//======================================================
	public BaseQueryModel withCurrentPage(Long currentPage) {
		setCurrentPage(currentPage);
		return this;
	}
	
	public BaseQueryModel withPageSize(Long pageSize) {
		setPageSize(pageSize);
		return this;
	}
}
