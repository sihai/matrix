/**
 * ihome.igo
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.PictureDO;
import com.ihome.matrix.model.PictureQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public interface PictureManager {
	
	/**
	 * 
	 * @param picture
	 * @throws ValidateException
	 */
	void add(PictureDO picture) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	PictureDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 * @throws ValidateException
	 */
	ResultModel<PictureDO> query(PictureQueryModel queryModel);
	
	/**
	 * 
	 * @param picture
	 */
	void update(PictureDO picture) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
