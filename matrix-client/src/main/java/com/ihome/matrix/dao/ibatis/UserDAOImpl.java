/*
 * ihome inc.
 * igo
 */
package com.ihome.matrix.dao.ibatis;

import com.ihome.matrix.dao.UserDAO;
import com.ihome.matrix.domain.UserDO;

/**
 * 
 * @author sihai
 *
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public void insert(UserDO user) {
		insert("user.dao.insert", user);
	}

	@Override
	public UserDO get(Long id) {
		return get("user.dao.get", id);
	}

	@Override
	public UserDO getByUserName(String userName) {
		return get("user.dao.getByUserName", userName);
	}

	@Override
	public void update(UserDO user) {
		update("user.dao.update", user);
	}

	@Override
	public void delete(Long id) {
		delete("user.dao.delete", id);
	}
}
