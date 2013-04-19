package com.ihome.matrix.dao.ibatis;

import java.util.List;

import com.ihome.matrix.dao.PictureDAO;
import com.ihome.matrix.domain.PictureDO;
import com.ihome.matrix.model.PictureQueryModel;

public class PictureDAOImpl extends BaseDAO implements PictureDAO {

	private static final String STATEMENT_INSERT = "picture.dao.insert";
	private static final String STATEMENT_GET = "picture.dao.get";
	private static final String STATEMENT_QUERY = "picture.dao.query";
	private static final String STATEMENT_COUNT = "picture.dao.count";
	private static final String STATEMENT_UPDATE = "picture.dao.update";
	private static final String STATEMENT_DELETE = "picture.dao.delete";
	
	@Override
	public void insert(PictureDO picture) {
		insert(STATEMENT_INSERT, picture);
	}

	@Override
	public PictureDO get(Long id) {
		return get(STATEMENT_GET, id);
	}

	@Override
	public List<PictureDO> query(PictureQueryModel queryModel) {
		return query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(PictureQueryModel queryModel) {
		return count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(PictureDO picture) {
		update(STATEMENT_UPDATE, picture);
	}

	@Override
	public void delete(Long id) {
		delete(STATEMENT_DELETE, id);
	}
}