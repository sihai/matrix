/**
 * 
 */
package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.ActivityDO;
import com.ihome.matrix.model.ActivityQueryModel;

/**
 * 
 * @author sihai
 *
 */
public interface ActivityDAO {

	/**
	 * 
	 * @param activity
	 */
	void insert(ActivityDO activity);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ActivityDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<ActivityDO> query(ActivityQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(ActivityQueryModel queryModel);
	
	/**
	 * 
	 * @param activity
	 */
	void update(ActivityDO activity);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
