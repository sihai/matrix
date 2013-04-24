package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.TmpProductDO;
import com.ihome.matrix.model.TmpProductQueryModel;

public interface TmpProductDAO {
	
	/**
	 * 
	 * @param tmpProduct
	 */
	void insert(TmpProductDO tmpProduct);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	TmpProductDO get(Long id);
	
	/**
	 * 
	 * @param outProductId
	 * @param platform
	 * @return
	 */
	TmpProductDO getByOutProductIdIdAndPlatform(Long outProductId, int platform);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	List<TmpProductDO> query(TmpProductQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(TmpProductQueryModel queryModel);
	
	/**
	 * 
	 * @param tmpProduct
	 */
	//void update(TmpProductDO tmpProduct);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
