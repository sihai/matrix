package com.ihome.matrix.dao;

import java.util.List;

import com.ihome.matrix.domain.PictureDO;
import com.ihome.matrix.model.PictureQueryModel;

public interface PictureDAO {
	
	/**
	 * 
	 * @param picture
	 */
	void insert(PictureDO picture);
	
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
	 */
	List<PictureDO> query(PictureQueryModel queryModel);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	Long count(PictureQueryModel queryModel);
	
	/**
	 * 
	 * @param picture
	 */
	void update(PictureDO picture);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
