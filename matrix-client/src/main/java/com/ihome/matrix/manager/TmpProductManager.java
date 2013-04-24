/**
 * ihome.igo
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.TmpProductDO;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.model.TmpProductQueryModel;

/**
 * 
 * @author sihai
 *
 */
public interface TmpProductManager {
	
	/**
	 * 
	 * @param tmpProduct
	 * @throws ValidateException
	 */
	void add(TmpProductDO tmpProduct) throws ValidateException;
	
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
	 * @throws ValidateException
	 */
	ResultModel<TmpProductDO> query(TmpProductQueryModel queryModel);
	
	/**
	 * 
	 * @param tmpProduct
	 */
	void update(TmpProductDO tmpProduct) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
