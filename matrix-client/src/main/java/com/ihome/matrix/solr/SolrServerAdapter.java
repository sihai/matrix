/**
 * ihome inc.
 * igo.igo-client
 */
package com.ihome.matrix.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;

/**
 * 
 * @author sihai
 *
 */
public class SolrServerAdapter {
	
	public static final int DEFAULT_CONNECTION_TIMEOUT = 5000;
	public static final int DEFAULT_SOCKET_TIMEOUT = 3000;
	public static final int DEFAULT_ALIVE_CHECK_INTERVAL = 60 * 1000;
	
	private String serverAddress;		// solr server address
	private SolrServer solrServer;		// 
	
	private int connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
	private int socketTimeout = DEFAULT_SOCKET_TIMEOUT;
	private int aliveCheckInterval = DEFAULT_ALIVE_CHECK_INTERVAL;
	
	/**
	 * 初始化
	 */
	public void init() {
		solrServer = new HttpSolrServer(serverAddress);
		//((HttpSolrServer)solrServer).setConnectionTimeout(connectionTimeout);
		//((HttpSolrServer)solrServer).setSoTimeout(socketTimeout);
	}
	
	/**
	 * 
	 */
	public void destroy() {
		if(null != solrServer) {
			solrServer.shutdown();
		}
	}
	
	/**
	 * 
	 * @param bean
	 * @return
	 * @throws IOException
	 * @throws SolrServerException
	 */
	public UpdateResponse addBean(Object bean) throws IOException, SolrServerException {
		solrServer.addBean(bean);
		return solrServer.commit();
	}
	
	/**
	 * 
	 * @param bean
	 * @return
	 * @throws IOException
	 * @throws SolrServerException
	 */
	public UpdateResponse addBatch(Object bean) throws IOException, SolrServerException {
		return solrServer.addBean(bean);
	}
	
	/**
	 * 
	 * @param doc
	 * @return
	 * @throws IOException
	 * @throws SolrServerException
	 */
	public UpdateResponse add(SolrInputDocument doc) throws IOException, SolrServerException {
		solrServer.add(doc);
		return solrServer.commit();
	}
	
	/**
	 * 
	 * @param doc
	 * @return
	 * @throws IOException
	 * @throws SolrServerException
	 */
	public UpdateResponse addDocBatch(SolrInputDocument doc) throws IOException, SolrServerException {
		return solrServer.add(doc);
	}
	
	/**
	 * 
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws SolrServerException
	 */
	public QueryResponse query(SolrParams params) throws IOException, SolrServerException {
		return solrServer.query(params);
	}
	
	/**
	 * 
	 * @param query
	 * @return
	 * @throws IOException
	 * @throws SolrServerException
	 */
	public UpdateResponse deleteById(String id) throws IOException, SolrServerException {
		solrServer.deleteById(id);
		return solrServer.commit();	
	}
	
	/**
	 * 
	 * @param query
	 * @return
	 * @throws IOException
	 * @throws SolrServerException
	 */
	public UpdateResponse deleteByQueryBatch(String query) throws IOException, SolrServerException {
		return solrServer.deleteByQuery(query);
	}
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws SolrServerException
	 */
	public UpdateResponse commit() throws IOException, SolrServerException {
		return solrServer.commit();
	}
	
	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}
	
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public void setAliveCheckInterval(int aliveCheckInterval) {
		this.aliveCheckInterval = aliveCheckInterval;
	}
}
