package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.BrandDO;
import com.ihome.matrix.model.BrandQueryModel;

public interface BrandDAO {
	
	/**
	 * 
	 * @param brand
	 */
	void insert(BrandDO brand);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	BrandDO get(Long id);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	BrandDO getByName(String name);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<BrandDO> query(BrandQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(BrandQueryModel queryModel);
	
	/**
	 * 
	 * @param brand
	 */
	void update(BrandDO brand);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
