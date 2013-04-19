/*
 * ihome inc.
 * igo
 */
package com.ihome.matrix.dao;

import com.ihome.matrix.domain.UserDO;

/**
 * User DAO
 * @author sihai
 *
 */
public interface UserDAO {
	
	/**
	 * 
	 * @param user
	 */
	void insert(UserDO user);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	UserDO get(Long id);
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	UserDO getByUserName(String userName);
	
	/**
	 * 
	 * @param user
	 */
	void update(UserDO user);
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
}
