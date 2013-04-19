/**
 * 
 */
package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.PromotionActivityDO;
import com.ihome.matrix.model.PromotionActivityQueryModel;

/**
 * 
 * @author sihai
 *
 */
public interface PromotionActivityDAO {

	/**
	 * 
	 * @param promotionActivity
	 */
	void insert(PromotionActivityDO promotionActivity);
	
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
	List<PromotionActivityDO> query(PromotionActivityQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(PromotionActivityQueryModel queryModel);
	
	/**
	 * 
	 * @param promotionActivity
	 */
	void update(PromotionActivityDO promotionActivity);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}