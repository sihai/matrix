/**
 * ihome.igo
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.model.ItemQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public interface ItemManager {
	
	/**
	 * 
	 * @param item
	 * @throws ValidateException
	 */
	void add(ItemDO item) throws ValidateException;
	
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
	 * @throws ValidateException
	 */
	ResultModel<ItemDO> query(ItemQueryModel queryModel);
	
	/**
	 * 
	 * @param item
	 */
	void update(ItemDO item) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
