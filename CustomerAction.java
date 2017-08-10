package com.strust.action;

import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.strust.ov.CstInfo;
import com.strust.service.CstService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CustomerAction extends ActionSupport{
	
	private Integer cstId;
	private CstService cstService= new CstService();
	
	public Integer getCstId() {
		return cstId;

	}

	public void setCstId(Integer cstId) {
		this.cstId = cstId;
	}


	public void getcstById(){
		if(this.cstId!=null){
			CstInfo cst= this.cstService.getInfoById(this.cstId);
			HttpServletResponse resp= ServletActionContext.getResponse();
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("application/json");
			try{
				JSONObject.fromObject(cst).write(resp.getWriter());
				OutputStreamWriter w= new OutputStreamWriter(System.out,"utf-8");
				JSONArray.fromObject(cst).write(w);
				w.flush();
			}catch(IOException e){
				e.printStackTrace();
			}
			

		}
	}
}
