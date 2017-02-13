package com.mango.jtt.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mango.jtt.po.MangoUser;
import com.mango.jtt.service.IUserService;

/**
 * 从数据库中获取信息的自定义类
 * 
 * @author HHL
 * 
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserService userService;

	/**
	 * 获取用户信息，设置角色
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// 获取用户信息
		MangoUser mangoUser = userService.getUserByName(username);
		if (mangoUser != null) {
			// 设置角色
			return new User(mangoUser.getUserName(), mangoUser.getPassword(),
					AuthorityUtils.createAuthorityList(mangoUser.getRole()));
		}

		throw new UsernameNotFoundException("User '" + username
					+ "' not found.");
	}
	
}
