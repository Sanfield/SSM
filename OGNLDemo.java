package com.strust.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class OGNLDemo extends ActionSupport {
	public String value="成员变量value";
	
	public String getValue(){
		return "getValue()方法";
	}
	public String test(){
		ValueStack vs= ActionContext.getContext().getValueStack();
		vs.set("value1", "值栈中的value");
		return SUCCESS;
	}

}
