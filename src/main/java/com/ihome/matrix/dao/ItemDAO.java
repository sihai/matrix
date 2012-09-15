package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.model.ItemQueryModel;

public interface ItemDAO {
	
	/**
	 * 
	 * @param item
	 */
	void insert(ItemDO item);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ItemDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<ItemDO> query(ItemQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(ItemQueryModel queryModel);
	
	/**
	 * 
	 * @param item
	 */
	void update(ItemDO item);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
