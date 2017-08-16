package com.spring_web.servlet;

import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.spring_web.service.UserService;

public class BaseServlet extends HttpServlet {

	/**
	 * ��Spring IoC�����л�ȡָ�����ƺ����͵�bean����
	 * @param serviceName
	 * @param serviceClass
	 * @return
	 */
	public UserService getService(String serviceName, Class<UserService> serviceClass) {

		//�õ�serviceʵ��
		return WebApplicationContextUtils.findWebApplicationContext(super.getServletContext()).getBean(serviceName,
				serviceClass);
	}

}
