/**
 * ihome.igo
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.model.ProductQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public interface ProductManager {
	
	/**
	 * 
	 * @param product
	 * @throws ValidateException
	 */
	void add(ProductDO product) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ProductDO get(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 * @throws ValidateException
	 */
	ResultModel<ProductDO> query(ProductQueryModel queryModel);
	
	/**
	 * 
	 * @param product
	 */
	void update(ProductDO product) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
