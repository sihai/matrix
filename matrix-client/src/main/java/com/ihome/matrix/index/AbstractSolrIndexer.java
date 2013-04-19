/**
 * ihome inc.
 * igo.igo-client
 */
package com.ihome.matrix.index;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

import com.ihome.matrix.solr.SolrServerAdapter;

/**
 * 
 * @author sihai
 *
 */
public abstract class AbstractSolrIndexer<T> implements Indexer<T> {

	protected static final Log logger = LogFactory.getLog(AbstractSolrIndexer.class);
	
	private SolrServerAdapter solrServerAdapter;

	@Override
	public void add(T t) {
		try {
			UpdateResponse response = solrServerAdapter.addBean((Object)t);
			logger.debug(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SolrServerException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void addBatch(T t) {
		try {
			UpdateResponse response = solrServerAdapter.addBatch((Object)t);
			logger.debug(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SolrServerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void upate(T t) {
		delete(getBeanId(t));
		add(t);
	}
	
	@Override
	public void updateBatch(T t) {
		deleteBatch(getBeanId(t));
		addBatch(t);
	}

	/**
	 * 
	 * @param doc
	 */
	public void addDoc(SolrInputDocument doc) {
		try {
			UpdateResponse response = solrServerAdapter.add(doc);
			logger.debug(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SolrServerException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void addDocBatch(SolrInputDocument doc) {
		try {
			UpdateResponse response = solrServerAdapter.addDocBatch(doc);
			logger.debug(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SolrServerException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void commit() {
		try {
			UpdateResponse response = solrServerAdapter.commit();
			logger.debug(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SolrServerException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @param id 非Solr的document哦，是bean的id哦
	 */
	public void delete(Long id) {
		try {
			UpdateResponse response = solrServerAdapter.deleteById(id.toString());
			logger.debug(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SolrServerException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @param id 非Solr的document哦，是bean的id哦
	 */
	public void deleteBatch(Long id) {
		try {
			UpdateResponse response = solrServerAdapter.deleteByQueryBatch(String.format("%s:%d", DOC_ID, id));
			logger.debug(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SolrServerException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	protected abstract Long getBeanId(T t);
	
	
	public void setSolrServerAdapter(SolrServerAdapter solrServerAdapter) {
		this.solrServerAdapter = solrServerAdapter;
	}
}
