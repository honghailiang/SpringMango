/**
 * 
 */
package com.mango.jtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author HHL
 * 
 * 
 *   管理员控制类
 */
@Controller
public class ManagerController {

	/**
	 * 管理中心首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/manager")
	public String login(Model model) {
		return "manager/index";
	}
	
	/**
	 * 显示登录页面用，主要是显示错误信息
	 * 
	 * @param model
	 * @param error
	 * @return
	 */
	@RequestMapping("/manager/login")
	public String login(Model model,
			@RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			model.addAttribute("error", "用户名或密码错误");
		}
		return "manager/login";
	}
}
