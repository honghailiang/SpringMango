/**
 *
 */
package com.mango.jtt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mango.jtt.dao.IMangoDao;
import com.mango.jtt.po.MangoUser;

/**
 * @author HHL
 *
 * @date 2016年12月8日
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
		String sql = "from MangoUser user where user.userName=:userName";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userName", name);
		List list = dao.list(sql, paramMap);
		MangoUser user = null;
		if (list != null && list.size() > 0) {
			user = (MangoUser) list.get(0);
		}
		return user;
	}

	@Override
	public List<MangoUser> getUserList() {
		String sql = "from MangoUser ";
		return dao.list(sql, null);
	}

	@Override
	public void saveUser(MangoUser mangoUser) {
		dao.saveBean(mangoUser);
	}

}
