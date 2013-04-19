/**
 * 
 */
package com.ihome.matrix.manager.impl;

import com.ihome.matrix.dao.PropertyDAO;
import com.ihome.matrix.dao.PropertyGroupDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.PropertyDO;
import com.ihome.matrix.domain.PropertyGroupDO;
import com.ihome.matrix.manager.PropertyManager;
import com.ihome.matrix.model.PropertyGroupQueryModel;
import com.ihome.matrix.model.PropertyQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public class PropertyManagerImpl implements PropertyManager {

	private PropertyGroupDAO 	propertyGroupDAO;
	private PropertyDAO			propertyDAO;

	@Override
	public void addPropertyGroup(PropertyGroupDO propertyGroup)
			throws ValidateException {
		validatePropertyGroup(propertyGroup);
		propertyGroupDAO.insert(propertyGroup);
	}

	@Override
	public PropertyGroupDO getPropertyGroup(Long id) {
		return propertyGroupDAO.get(id);
	}

	@Override
	public ResultModel<PropertyGroupDO> queryPropertyGroup(
			PropertyGroupQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, propertyGroupDAO.query(queryModel), propertyGroupDAO.count(queryModel));
	}

	@Override
	public void update(PropertyGroupDO propertyGroup) throws ValidateException {
		propertyGroupDAO.update(propertyGroup);
	}

	@Override
	public void deletePropertyGroup(Long id) {
		propertyGroupDAO.delete(id);
	}

	@Override
	public void addProperty(PropertyDO property) throws ValidateException {
		validateProperty(property);
		propertyDAO.insert(property);
	}

	@Override
	public PropertyDO getProperty(Long id) {
		return propertyDAO.get(id);
	}

	@Override
	public ResultModel<PropertyDO> queryProperty(PropertyQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, propertyDAO.query(queryModel), propertyDAO.count(queryModel));
	}

	@Override
	public void update(PropertyDO property) throws ValidateException {
		propertyDAO.update(property);
	}

	@Override
	public void deleteProperty(Long id) {
		propertyDAO.delete(id);
	}
	
	/**
	 * 
	 * @param propertyGroup
	 * @throws ValidateException
	 */
	private void validatePropertyGroup(PropertyGroupDO propertyGroup) throws ValidateException {
		// TODO
	}
	
	/**
	 * 
	 * @param property
	 * @throws ValidateException
	 */
	private void validateProperty(PropertyDO property) throws ValidateException {
		// TODO
	}
	
	public void setPropertyGroupDAO(PropertyGroupDAO propertyGroupDAO) {
		this.propertyGroupDAO = propertyGroupDAO;
	}

	public void setPropertyDAO(PropertyDAO propertyDAO) {
		this.propertyDAO = propertyDAO;
	}
}
