package com.strust.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class OGNLDemo extends ActionSupport {
	public String value="��Ա����value";
	
	public String getValue(){
		return "getValue()����";
	}
	public String test(){
		ValueStack vs= ActionContext.getContext().getValueStack();
		vs.set("value1", "ֵջ�е�value");
		return SUCCESS;
	}

}
