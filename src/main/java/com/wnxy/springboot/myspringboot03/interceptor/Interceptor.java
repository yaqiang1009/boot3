package com.wnxy.springboot.myspringboot03.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class Interceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 拦截器
		Object user = request.getSession().getAttribute("user");
		if(user==null) {
			request.setAttribute("mes", "请先登录");
			request.getRequestDispatcher("/login.html").forward(request, response);
			return false;
		}
		return true;
	}
}
