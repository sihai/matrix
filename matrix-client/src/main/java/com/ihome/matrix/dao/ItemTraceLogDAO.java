package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.ItemTraceLogDO;
import com.ihome.matrix.model.ItemTraceLogQueryModel;

public interface ItemTraceLogDAO {
	
	/**
	 * 
	 * @param itemTrace
	 */
	void insert(ItemTraceLogDO itemTrace);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<ItemTraceLogDO> query(ItemTraceLogQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(ItemTraceLogQueryModel queryModel);
}
