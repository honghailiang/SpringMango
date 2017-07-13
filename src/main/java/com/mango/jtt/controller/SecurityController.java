package com.mango.jtt.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * security控制类
 *
 * @author HHL
 *
 * @date 2016年12月20日
 */
@Controller
public class SecurityController {

	/**
	 * 拒绝访问时跳转页面
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/security/deny")
	public String deny(HttpServletRequest request,HttpServletResponse response){
		return "security_deny";
	}
}
