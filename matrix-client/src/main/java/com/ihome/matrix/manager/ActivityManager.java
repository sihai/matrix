/**
 * 
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.ActivityDO;
import com.ihome.matrix.model.ActivityQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public interface ActivityManager {

	/**
	 * 
	 * @param activity
	 * @throws ValidateException
	 */
	void add(ActivityDO activity) throws ValidateException;
	
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
	ResultModel<ActivityDO> query(ActivityQueryModel queryModel);
	
	/**
	 * 
	 * @param activity
	 */
	void update(ActivityDO activity) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
