<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>文件列表</h2>
		<ul>
		<c:forEach items="${docList }" var="doc">
					<li><a href="/strust/file/download.action?fileId=${doc.fileId}">${doc.docName}哈哈</a></li>
		</c:forEach>
		</ul>
</body>
</html>