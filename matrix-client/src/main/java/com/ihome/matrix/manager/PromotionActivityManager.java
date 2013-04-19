/**
 * 
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.PromotionActivityDO;
import com.ihome.matrix.model.PromotionActivityQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public interface PromotionActivityManager {

	/**
	 * 
	 * @param promotionActivity
	 * @throws ValidateException
	 */
	void add(PromotionActivityDO promotionActivity) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	PromotionActivityDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	ResultModel<PromotionActivityDO> query(PromotionActivityQueryModel queryModel);
	
	/**
	 * 
	 * @param promotionActivity
	 */
	void update(PromotionActivityDO promotionActivity) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
