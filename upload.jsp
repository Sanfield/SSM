<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
 	<form action="/strust/file/upload.action" method="post" enctype="multipart/form-data">
 		文件名称:<input type="text" name="docName"><br/>
 		<input type="file" name="doc"><br/>
 		<input type="submit" value="上传">
 	</form>
 	<s:actionmessage/><br/>
 	<a href="/strust/file/list.action">文件列表</a>
</body>
</html>