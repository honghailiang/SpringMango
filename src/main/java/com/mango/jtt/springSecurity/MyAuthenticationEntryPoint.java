/**
 *
 */
package com.mango.jtt.springSecurity;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * 被认证请求向登录页面跳转的控制 根据被请求所需权限向不同登录页面跳转
 *
 * @author HHL
 *
 * @date 2016年12月20日
 */
public class MyAuthenticationEntryPoint extends
		LoginUrlAuthenticationEntryPoint {

	public MyAuthenticationEntryPoint(String loginFormUrl) {
		super(loginFormUrl);
	}

	private Map<String, String> authEntryPointMap;
	private PathMatcher pathMatcher = new AntPathMatcher();

	// 根据请求路径返回不同的登录页路径
	@Override
	protected String determineUrlToUseForThisRequest(
			HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) {
		String requestURI = request.getRequestURI().replace(
				request.getContextPath(), "");
		for (String url : this.authEntryPointMap.keySet()) {
			if (this.pathMatcher.match(url, requestURI)) {
				return this.authEntryPointMap.get(url);
			}
		}
		return super.determineUrlToUseForThisRequest(request, response,
				exception);
	}


	public PathMatcher getPathMatcher() {
		return pathMatcher;
	}

	public void setPathMatcher(PathMatcher pathMatcher) {
		this.pathMatcher = pathMatcher;
	}


	public Map<String, String> getAuthEntryPointMap() {
		return authEntryPointMap;
	}

	public void setAuthEntryPointMap(Map<String, String> authEntryPointMap) {
		this.authEntryPointMap = authEntryPointMap;
	}

}
