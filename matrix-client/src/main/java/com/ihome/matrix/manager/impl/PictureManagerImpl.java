/**
 * 
 */
package com.ihome.matrix.manager.impl;

import com.ihome.matrix.dao.PictureDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.PictureDO;
import com.ihome.matrix.manager.PictureManager;
import com.ihome.matrix.model.PictureQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public class PictureManagerImpl implements PictureManager {
	
	private PictureDAO pictureDAO;
	
	@Override
	public void add(PictureDO picture) throws ValidateException {
		validate(picture);
		pictureDAO.insert(picture);
	}

	@Override
	public PictureDO get(Long id) {
		return pictureDAO.get(id);
	}

	@Override
	public ResultModel<PictureDO> query(PictureQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, pictureDAO.query(queryModel), pictureDAO.count(queryModel));
	}

	@Override
	public void update(PictureDO picture) throws ValidateException {
		pictureDAO.update(picture);
	}

	@Override
	public void delete(Long id) {
		pictureDAO.delete(id);
	}
	
	/**
	 * 
	 * @param picture
	 * @throws ValidateException
	 */
	private void validate(PictureDO picture) throws ValidateException {
		
	}
	
	public void setPictureDAO(PictureDAO pictureDAO) {
		this.pictureDAO = pictureDAO;
	}
}
