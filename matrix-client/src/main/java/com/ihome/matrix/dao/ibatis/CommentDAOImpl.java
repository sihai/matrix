/**
 * 
 */
package com.ihome.matrix.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihome.matrix.dao.CommentDAO;
import com.ihome.matrix.domain.CommentDO;
import com.ihome.matrix.model.CommentQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class CommentDAOImpl extends BaseDAO implements CommentDAO {
	
	private static final String STATEMENT_INSERT = "comment.dao.insert";
	private static final String STATEMENT_GET = "comment.dao.get";
	private static final String STATEMENT_QUERY = "comment.dao.query";
	private static final String STATEMENT_COUNT = "comment.dao.count";
	private static final String STATEMENT_UPDATE = "comment.dao.update";
	private static final String STATEMENT_DELETE = "comment.dao.delete";
	private static final String STATEMENT_DELETE_BY_TYPE_AND_OWNER = "comment.dao.deleteByTypeAndOwner";

	@Override
	public void insert(CommentDO comment) {
		super.insert(STATEMENT_INSERT, comment);
	}

	@Override
	public CommentDO get(Long id) {
		return super.get(STATEMENT_GET, id);
	}

	@Override
	public List<CommentDO> query(CommentQueryModel queryModel) {
		return super.query(STATEMENT_QUERY, queryModel);
	}

	@Override
	public Long count(CommentQueryModel queryModel) {
		return super.count(STATEMENT_COUNT, queryModel);
	}

	@Override
	public void update(CommentDO comment) {
		super.update(STATEMENT_UPDATE, comment);
	}

	@Override
	public void delete(Long id) {
		super.update(STATEMENT_DELETE, id);
	}
	
	@Override
	public void deleteByTypeAndOwner(Integer type, Long owner) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("type", type);
		parameterMap.put("owner", owner);
		super.update(STATEMENT_DELETE_BY_TYPE_AND_OWNER, parameterMap);
	}
}
