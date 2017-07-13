package com.mango.jtt.springSecurity;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.mango.jtt.po.MangoUser;
import com.mango.jtt.service.IUserService;

/**
 * 登录授权成功后操作控制，如果是直接点击登录的情况下，根据授权权限跳转不同页面； 否则跳转到原请求页面
 *
 * @author HHL
 * @date
 *
 */
public class MyAuthenticationSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {
	private Map<String, String> authDispatcherMap;
	private RequestCache requestCache = new HttpSessionRequestCache();

	@Autowired
	private IUserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
										HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// 获取用户权限
		Collection<? extends GrantedAuthority> authCollection = authentication
				.getAuthorities();
		if (authCollection.isEmpty()) {
			return;
		}

		// 认证成功后，获取用户信息并添加到session中
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		MangoUser user = userService.getUserByName(userDetails.getUsername());
		request.getSession().setAttribute("user", user);

		String url = null;
		// 从别的请求页面跳转过来的情况，savedRequest不为空
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if (savedRequest != null) {
			url = savedRequest.getRedirectUrl();
		}

		// 直接点击登录页面，根据登录用户的权限跳转到不同的页面
		if (url == null) {
			for (GrantedAuthority auth : authCollection) {
				url = authDispatcherMap.get(auth.getAuthority());
			}
			getRedirectStrategy().sendRedirect(request, response, url);
		}

		super.onAuthenticationSuccess(request, response, authentication);

	}


	public RequestCache getRequestCache() {
		return requestCache;
	}

	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}


	public Map<String, String> getAuthDispatcherMap() {
		return authDispatcherMap;
	}

	public void setAuthDispatcherMap(Map<String, String> authDispatcherMap) {
		this.authDispatcherMap = authDispatcherMap;
	}

}
