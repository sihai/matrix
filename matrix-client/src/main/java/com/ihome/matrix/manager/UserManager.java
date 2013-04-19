/*
 * ihome inc.
 * igo
 */
package com.ihome.matrix.manager;

import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.UserDO;

/**
 * 
 * @author sihai
 *
 */
public interface UserManager {
	
	//=================================================================================
	//							Base method
	//=================================================================================
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
	 * @throws ValidateException
	 */
	void update(UserDO user) throws ValidateException;
	
	/**
	 * 
	 * @param id
	 */
	void delete(Long id);
	
	//=================================================================================
	//							Advance method
	//=================================================================================
	/**
	 * 注册
	 * @param user
	 * @throws ValidateException
	 */
	void register(UserDO user) throws ValidateException;
	
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 */
	UserDO login(String userName, String password);
}
