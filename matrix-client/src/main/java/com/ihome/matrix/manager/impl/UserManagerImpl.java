/*
 * ihome inc.
 * igo
 */
package com.ihome.matrix.manager.impl;

import com.iacrqq.util.PasswordUtil;
import com.ihome.matrix.dao.UserDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.UserDO;
import com.ihome.matrix.manager.UserManager;

/**
 * User Manager 实现
 * @author sihai
 *
 */
public class UserManagerImpl implements UserManager {
	
	private UserDAO userDAO;
	
	@Override
	public UserDO get(Long id) {
		return userDAO.get(id);
	}

	@Override
	public UserDO getByUserName(String userName) {
		return userDAO.getByUserName(userName);
	}

	@Override
	public void update(UserDO user) throws ValidateException {
		userDAO.update(user);
	}

	@Override
	public void delete(Long id) {
		userDAO.delete(id);
	}

	@Override
	public void register(UserDO user) throws ValidateException {
		validate(user);
		user.setPassword(PasswordUtil.encrypt(user.getPassword()));
		UserDO other = getByUserName(user.getName());
		if(null != other) {
			throw new ValidateException(String.format("用户名：%s，已经被注册，请选择其他用户名。", user.getName()));
		}
		userDAO.insert(user);
	}

	@Override
	public UserDO login(String userName, String password) {
		UserDO user = getByUserName(userName);
		if(null != user) {
			if(!PasswordUtil.equals(password, user.getPassword())) {
				user = null;
			}
		}
		return user;
	}
	
	/**
	 * 参数校验, 不包含复杂的业务逻辑校验, 如重名校验
	 * @param user
	 * @throws ValidateException
	 */
	private void validate(UserDO user) throws ValidateException {
		// TODO
	}
	
	//=================================================================================
	//							setter/getter
	//=================================================================================
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
