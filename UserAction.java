package com.ssm.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssm.ov.UserInfo;
import com.ssm.service.UserService;

public class UserAction extends ActionSupport{
	
	private UserInfo userInfo;
	@Resource
	private UserService userService;
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public String login(){
		UserInfo info=this.userService.getInfoByName(this.userInfo.getUserName());
		if(info==null){
			super.addActionError("帐号不存在");
			return LOGIN;
		}
		if(info.getPwd().equals(this.userInfo.getPwd())){
			ActionContext.getContext().getSession().put("user_info", userInfo);
			return SUCCESS;
		}
		super.addActionError("密码不正确");
		return LOGIN;
		
	}

}
