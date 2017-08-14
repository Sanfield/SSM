<%@page import="org.eclipse.jdt.internal.compiler.lookup.TagBits"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>prd_add</title>
</head>
<body>
<form action="/mybatis/PrdServlet?method=add" method="post">
	<input type="hidden" name="pid" >
	名称:<input type="text" name="prdName"/><br/>
	类别:<select name="typeId">
	<option value="0">--请选择--</option>
	<c:forEach items="${typeList }" var="type">
	 	<option value="${type.typeId }">${type.typeName }</option>
	</c:forEach>
	</select><br/>
	价格：<input type="text" name="price"><br/>
	描述:<textarea rows="3" cols="50" name="decs"></textarea><br/>
	<input type="submit" value="提交"/>&nbsp;&nbsp;<input type="reset" value="重置">
</form>
<a href="/mybatis/PrdServlet?method=list">商品列表</a>
</body>
</html>