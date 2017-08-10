package com.strust.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.strust.ov.DocInfo;
import com.strust.service.DaoService;

public class FileAction extends ActionSupport{
	private DaoService daoservice= new DaoService();
	private String docName;
	private File doc;
	private String docFileName;
	private String docContentType;
	public String getDocContentType() {
		return docContentType;
	}
	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public File getDoc() {
		return doc;
	}
	public void setDoc(File doc) {
		this.doc = doc;
	}
	public String getDocFileName() {
		return docFileName;
	}
	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}
	public InputStream getInputStream() {
		InputStream is = null;
		try {
			if (file != null) {
				is = new FileInputStream(file);
			}
		} catch (Exception e) {

		}
		return is;
	}

	/**
	 * 文件上传
	 * @return
	 */
	public String upload(){
		DocInfo docInfo =new DocInfo();
		docInfo.setDocName(this.docName);
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		if(this.doc!=null && this.doc.length()>0){
			String fileId=getFileId();
			docInfo.setFileId(fileId);
			docInfo.setFileName(this.docFileName);
			docInfo.setFileType(this.docContentType);
			try {
				FileUtils.copyFile(this.doc, new File(path,fileId));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		boolean result= this.daoservice.saveInfo(docInfo);
		super.addActionMessage(result ?"保存成功":"保存失败");
		return SUCCESS;
	}
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private static int count=0;
	private String getFileId(){
		String id=sdf.format(new Date())+(count++); 
		if(count>=10) count=0;
		return id;
	}
	
	public String list(){
			List<DocInfo> list= this.daoservice.getAllDoc();
			System.out.println(list+"haha");
			ActionContext.getContext().getValueStack().set("docList", list);
			return SUCCESS;
	}
	private DocInfo docInfo;
	private File file = null;
	private String disposition;
	
	public String getContentType(){
		if(docInfo!=null){
			return docInfo.getFileType();
		}
		return "application/octet-stream";
	}

	public DocInfo getDocInfo() {
		return docInfo;
	}

	public long getContentLength() {
		if (file != null) {
			return file.length();
		}
		return 0;
	}

	public String getDisposition() {
		return disposition;
	}

	/**
	 * 文件下载
	 */
	public String download() {
		String[] ids = (String[]) ActionContext.getContext().getParameters().get("fileId");
		String path = ServletActionContext.getServletContext().getRealPath("/upload");

		if (ids != null && ids.length > 0) {
			String fileId = ids[0];
			System.out.println("path:"+path);
			file = new File(path, fileId);
		//	System.out.println("文件Id"+fileId);
			docInfo = this.daoservice.getInfoByFileId(fileId);
			System.out.println("测试文件"+docInfo.getDocName());
		}

		if (docInfo != null && file.exists()) {
			try {
				String fileName = URLEncoder.encode(docInfo.getFileName(), "UTF-8");
				System.out.println("fileName"+fileName);
				this.disposition = "attachment; filename=" + fileName + "; filename*=UTF-8''" + fileName;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
}
