/**
 * 
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.CommentDO;
import com.ihome.matrix.model.CommentQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public interface CommentManager {

	/**
	 * 
	 * @param comment
	 * @throws ValidateException
	 */
	void add(CommentDO comment) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	CommentDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	ResultModel<CommentDO> query(CommentQueryModel queryModel);
	
	/**
	 * 
	 * @param comment
	 */
	void update(CommentDO comment) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 
	 * @param type
	 * @param owner
	 */
	void deleteByTypeAndOwner(Integer type, Long owner);
}