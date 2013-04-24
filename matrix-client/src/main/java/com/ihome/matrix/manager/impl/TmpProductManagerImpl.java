/**
 * ihome.igo
 */
package com.ihome.matrix.manager.impl;

import com.ihome.matrix.dao.TmpProductDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.TmpProductDO;
import com.ihome.matrix.manager.TmpProductManager;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.model.TmpProductQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class TmpProductManagerImpl implements TmpProductManager {

	private TmpProductDAO tmpProductDAO;
	
	@Override
	public void add(TmpProductDO tmpProduct) throws ValidateException {
		validate(tmpProduct, true);
		tmpProductDAO.insert(tmpProduct);
	}

	@Override
	public TmpProductDO get(Long id) {
		return tmpProductDAO.get(id);
	}
	
	@Override
	public TmpProductDO getByOutProductIdIdAndPlatform(Long outProductId, int platform) {
		return tmpProductDAO.getByOutProductIdIdAndPlatform(outProductId, platform);
	}

	@Override
	public ResultModel<TmpProductDO> query(TmpProductQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, tmpProductDAO.query(queryModel), tmpProductDAO.count(queryModel));
	}

	@Override
	public void update(TmpProductDO tmpProduct) throws ValidateException {
		throw new UnsupportedOperationException("Unsupported operation");
	}

	@Override
	public void delete(Long id) {
		tmpProductDAO.delete(id);
	}

	/**
	 * 
	 * @param tmpProduct
	 * @param isNew
	 * @throws ValidateException
	 */
	private void validate(TmpProductDO tmpProduct, boolean isNew) throws ValidateException {
		// TODO
	}
	
	public void setTmpProductDAO(TmpProductDAO tmpProductDAO) {
		this.tmpProductDAO = tmpProductDAO;
	}
}
