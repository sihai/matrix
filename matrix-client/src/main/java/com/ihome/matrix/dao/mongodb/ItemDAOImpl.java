package com.ihome.matrix.dao.mongodb;

import java.util.List;

import com.ihome.matrix.dao.ItemDAO;
import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.model.ItemQueryModel;

public class ItemDAOImpl implements ItemDAO {

	@Override
	public void insert(ItemDO item) {
		// TODO Auto-generated method stub

	}

	@Override
	public ItemDO get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDO getByItemIdAndPlatform(String itemId, int platform) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDO> query(ItemQueryModel queryModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count(ItemQueryModel queryModel) {
		// TODO Auto-generated method stub
		return 0L;
	}

	@Override
	public void update(ItemDO item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
