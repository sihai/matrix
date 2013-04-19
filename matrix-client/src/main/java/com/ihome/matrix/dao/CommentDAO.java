/**
 * 
 */
package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.CommentDO;
import com.ihome.matrix.model.CommentQueryModel;

/**
 * 
 * @author sihai
 *
 */
public interface CommentDAO {

	/**
	 * 
	 * @param comment
	 */
	void insert(CommentDO comment);
	
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
	List<CommentDO> query(CommentQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(CommentQueryModel queryModel);
	
	/**
	 * 
	 * @param comment
	 */
	void update(CommentDO comment);
	
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
