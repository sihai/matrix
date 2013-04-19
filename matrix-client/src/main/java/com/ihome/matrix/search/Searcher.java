/**
 * ihome inc.
 * igo.igo-client
 */
package com.ihome.matrix.search;

import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.model.SearchModel;

/**
 * 
 * @author sihai
 *
 * @param <T>
 */
public interface Searcher<T> {

	/**
	 * 
	 * @param type
	 * @param searchModel
	 * @return
	 */
	ResultModel<T> search(Class<T> type, SearchModel searchModel);
}
