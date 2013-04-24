/**
 * 
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.ProductAssDO;
import com.ihome.matrix.domain.PropertyDO;
import com.ihome.matrix.domain.PropertyGroupDO;
import com.ihome.matrix.model.ProductAssQueryModel;
import com.ihome.matrix.model.PropertyGroupQueryModel;
import com.ihome.matrix.model.PropertyQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public interface PropertyManager {
	
	//============================================================================
	//							Property Group
	//============================================================================
	/**
	 * 
	 * @param propertyGroup
	 * @throws ValidateException
	 */
	void addPropertyGroup(PropertyGroupDO propertyGroup) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	PropertyGroupDO getPropertyGroup(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 * @throws ValidateException
	 */
	ResultModel<PropertyGroupDO> queryPropertyGroup(PropertyGroupQueryModel queryModel);
	
	/**
	 * 
	 * @param propertyGroup
	 */
	void update(PropertyGroupDO propertyGroup) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void deletePropertyGroup(Long id);
	
	
	
	//============================================================================
	//							Property
	//============================================================================
	/**
	 * 
	 * @param property
	 * @throws ValidateException
	 */
	void addProperty(PropertyDO property) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	PropertyDO getProperty(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 * @throws ValidateException
	 */
	ResultModel<PropertyDO> queryProperty(PropertyQueryModel queryModel);
	
	/**
	 * 
	 * @param property
	 */
	void update(PropertyDO property) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void deleteProperty(Long id);
}
