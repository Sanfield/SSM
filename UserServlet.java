package com.spring_web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring_web.ov.UserInfo;
import com.spring_web.service.UserService;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet{


	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method= req.getParameter("method");
		if("login".equals(method)){
			String account= req.getParameter("account");
			String pwd=req.getParameter("pwd");
			UserService userService= super.getService("userService",UserService.class);
			UserInfo userInfo = userService.getInfoByAccount(account);
			if(userInfo==null){
				req.setAttribute("msg", "帐号不存在");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}else{
				if(userInfo.getPwd().equals(pwd)){
					req.getSession().setAttribute("user_info", userInfo);
					req.getRequestDispatcher("/main.jsp").forward(req, resp);
				}else{
					req.setAttribute("msg", "密码不正确");
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
				}
			}
		}
	}

	
}
