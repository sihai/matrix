/**
 * 
 */
package com.ihome.matrix.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihome.matrix.dao.ActivityDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.ActivityDO;
import com.ihome.matrix.manager.ActivityManager;
import com.ihome.matrix.model.ActivityQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public class ActivityManagerImpl implements ActivityManager {
	
	@Autowired
	private ActivityDAO activityDAO;
	
	@Override
	public void add(ActivityDO activity) throws ValidateException {
		validate(activity);
		activityDAO.insert(activity);
	}

	@Override
	public ActivityDO get(Long id) {
		return activityDAO.get(id);
	}

	@Override
	public ResultModel<ActivityDO> query(ActivityQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, activityDAO.query(queryModel), activityDAO.count(queryModel));
	}

	@Override
	public void update(ActivityDO activity) throws ValidateException {
		validate(activity);
		activityDAO.update(activity);

	}

	@Override
	public void delete(Long id) {
		activityDAO.delete(id);
	}
	
	/**
	 * 
	 * @param activity
	 * @throws ValidateException
	 */
	private void validate(ActivityDO activity) throws ValidateException {
		// TODO
	}
	
	public void setActivityDAO(ActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}
}