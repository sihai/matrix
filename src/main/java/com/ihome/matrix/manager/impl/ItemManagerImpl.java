/**
 * ihome.igo
 */
package com.ihome.matrix.manager.impl;

import com.ihome.matrix.dao.ItemDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.manager.ItemManager;
import com.ihome.matrix.model.ItemQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public class ItemManagerImpl implements ItemManager {

	private ItemDAO itemDAO;
	
	
	@Override
	public void add(ItemDO item) throws ValidateException {
		validate(item);
		itemDAO.insert(item);
	}

	@Override
	public ItemDO get(Long id) {
		return itemDAO.get(id);
	}

	@Override
	public ResultModel<ItemDO> query(ItemQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, itemDAO.query(queryModel), itemDAO.count(queryModel));
	}

	@Override
	public void update(ItemDO item) throws ValidateException {
		validate(item);
		itemDAO.update(item);
	}

	@Override
	public void delete(Long id) {
		itemDAO.delete(id);
	}
	
	private void validate(ItemDO item) throws ValidateException {
		// TODO
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
}
