/**
 * 
 */
package com.ihome.matrix.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihome.matrix.dao.CommentDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.CommentDO;
import com.ihome.matrix.manager.CommentManager;
import com.ihome.matrix.model.CommentQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public class CommentManagerImpl implements CommentManager {
	
	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public void add(CommentDO comment) throws ValidateException {
		validate(comment);
		commentDAO.insert(comment);
	}

	@Override
	public CommentDO get(Long id) {
		return commentDAO.get(id);
	}

	@Override
	public ResultModel<CommentDO> query(CommentQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, commentDAO.query(queryModel), commentDAO.count(queryModel));
	}

	@Override
	public void update(CommentDO comment) throws ValidateException {
		validate(comment);
		commentDAO.update(comment);

	}

	@Override
	public void delete(Long id) {
		commentDAO.delete(id);
	}
	
	@Override
	public void deleteByTypeAndOwner(Integer type, Long owner) {
		commentDAO.deleteByTypeAndOwner(type, owner);
	}

	/**
	 * 
	 * @param comment
	 * @throws ValidateException
	 */
	private void validate(CommentDO comment) throws ValidateException {
		// TODO
	}
	
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
}