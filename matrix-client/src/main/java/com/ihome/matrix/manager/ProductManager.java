/**
 * ihome.igo
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.ProductAssDO;
import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.model.ProductAssQueryModel;
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
	
	//=================================================================
	//						Product Ass
	//=================================================================
	/**
	 * 
	 * @param productAss
	 * @throws ValidateException
	 */
	void add(ProductAssDO productAss) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ProductAssDO getProductAss(Long id);
	
	/**
	 * 
	 * @param queryModel
	 * @return
	 */
	ResultModel<ProductAssDO> query(ProductAssQueryModel queryModel);
	
	/**
	 * 
	 * @param productAss
	 * @throws ValidateException
	 */
	void update(ProductAssDO productAss) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void deleteProductAss(Long id);
}
