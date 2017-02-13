/**
 * 
 */
package com.mango.jtt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HHL
 * 
 * @date 2016年12月8日
 * 
 *       用户控制类
 */
@Controller
public class UserController {
	
	/**
	 * 显示登录页面用，主要是显示错误信息
	 * 
	 * @param model
	 * @param error
	 * @return
	 */
	@RequestMapping("/login")
	public String login(Model model,
			@RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			model.addAttribute("error", "用户名或密码错误");
		}
		return "login";
	}

	@RequestMapping("/user")
	@ResponseBody
	public Map<String, Object> getUserById(String userId,
			HttpServletResponse res) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("state", "1");
		ret.put("data", 123456);
		return ret;
	}
}
