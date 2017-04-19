/**
 * 
 */
package com.mango.jtt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mango.jtt.dao.IMangoDao;
import com.mango.jtt.po.MangoUser;

/**
 * @author HHL
 *
 * @date 2016��12��8��
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IMangoDao dao;

	/* (non-Javadoc)
	 * @see com.mango.jtt.service.IUserService#getUserByName()
	 */
	@Override
	public MangoUser getUserByName(String name) {
		String sql = "from MangoUser user where user.userName='" + name + "'";
		List list = dao.list(sql);
		MangoUser user = null;
		if (list != null && list.size() > 0) {
			user = (MangoUser) list.get(0);
		}
		return user;
	}

}