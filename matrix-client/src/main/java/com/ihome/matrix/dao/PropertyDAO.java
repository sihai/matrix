package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.PropertyDO;
import com.ihome.matrix.model.PropertyQueryModel;

public interface PropertyDAO {
	
	/**
	 * 
	 * @param property
	 */
	void insert(PropertyDO property);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	PropertyDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<PropertyDO> query(PropertyQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(PropertyQueryModel queryModel);
	
	/**
	 * 
	 * @param property
	 */
	void update(PropertyDO property);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
