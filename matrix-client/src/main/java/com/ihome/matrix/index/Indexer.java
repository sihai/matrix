/**
 * ihome inc.
 * igo.igo-client
 */
package com.ihome.matrix.index;

import org.apache.solr.common.SolrInputDocument;

/**
 * Index 操作者
 * @author sihai
 *
 */
public interface Indexer<T> {
	
	String DOC_ID = "doc_id";
	
	/**
	 * 直接添加bean,JavaBean需要加注解 <code>@Field</code>
	 * @param t
	 */
	void add(T t);
	
	/**
	 * 
	 * @param doc
	 */
	void addDoc(SolrInputDocument doc);
	
	/**
	 * 批量添加
	 * @param t
	 */
	void addBatch(T t);
	
	/**
	 * 批量添加doc
	 * @param doc
	 */
	void addDocBatch(SolrInputDocument doc);
	
	/**
	 * 
	 * @param t
	 */
	void upate(T t);
	
	/**
	 * 批量更新
	 * @param t
	 */
	void updateBatch(T t);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 批量删除
	 * @param id
	 */
	void deleteBatch(Long id);
	
	/**
	 * 提交变更 
	 */
	void commit();
}
