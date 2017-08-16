package com.spring_web.servlet;

import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.spring_web.service.UserService;

public class BaseServlet extends HttpServlet {

	/**
	 * 从Spring IoC容器中获取指定名称和类型的bean对象
	 * @param serviceName
	 * @param serviceClass
	 * @return
	 */
	public UserService getService(String serviceName, Class<UserService> serviceClass) {

		//得到service实例
		return WebApplicationContextUtils.findWebApplicationContext(super.getServletContext()).getBean(serviceName,
				serviceClass);
	}

}
