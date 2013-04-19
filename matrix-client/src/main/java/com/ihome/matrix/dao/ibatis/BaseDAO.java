
package com.ihome.matrix.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ihome.matrix.model.BaseQueryModel;

public abstract class BaseDAO {
	
	/**
	 * 
	 */
	protected SqlMapClient sqlMapClient;

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	/**
	 * Insert one record
	 * 
	 * @param statement
	 * @param t
	 */
	protected <T> void insert(String statement, T t) {
		try {
			sqlMapClient.insert(statement, t);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Query by primary key (id)
	 * @param statement
	 * @param id
	 */
	protected <T> T get(String statement, Long id) {
		try {
			return (T)sqlMapClient.queryForObject(statement, id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @param statement
	 * @param parameter
	 * @return
	 */
	protected <T> T get(String statement, Object parameter) {
		try {
			return (T)sqlMapClient.queryForObject(statement, parameter);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @param statement
	 * @param queryModel
	 * @return
	 */
	protected <T> List<T> query(String statement, BaseQueryModel queryModel) {
		try {
			return (List<T>)sqlMapClient.queryForList(statement, queryModel);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @param statement
	 * @param queryModel
	 * @return
	 */
	protected Long count(String statement, BaseQueryModel queryModel) {
		try {
			return (Long)sqlMapClient.queryForObject(statement, queryModel);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @param statement
	 * @param t
	 */
	protected <T> void update(String statement, T t) {
		try {
			//sqlMapClient.startTransaction();
			int count = sqlMapClient.update(statement, t);
			/*if(count == 1) {
				sqlMapClient.commitTransaction();
			} else {
				throw new RuntimeException("Not possiable");
			}*/
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				throw new RuntimeException("End transaction failed", e);
			}
		}
	}
	
	protected <T> void delete(String statement, Long id) {
		try {
			sqlMapClient.startTransaction();
			int count = sqlMapClient.delete(statement, id);
			if(count == 1) {
				sqlMapClient.commitTransaction();
			} else {
				//throw new RuntimeException("Not possiable");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				throw new RuntimeException("End transaction failed", e);
			}
		}
	}
}
