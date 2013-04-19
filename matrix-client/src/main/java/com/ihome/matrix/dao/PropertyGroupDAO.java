package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.PropertyGroupDO;
import com.ihome.matrix.model.PropertyGroupQueryModel;

public interface PropertyGroupDAO {
	
	/**
	 * 
	 * @param propertyGroup
	 */
	void insert(PropertyGroupDO propertyGroup);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	PropertyGroupDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<PropertyGroupDO> query(PropertyGroupQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(PropertyGroupQueryModel queryModel);
	
	/**
	 * 
	 * @param propertyGroup
	 */
	void update(PropertyGroupDO propertyGroup);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
