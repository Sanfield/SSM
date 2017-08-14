<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>edit</title>
</head>
<body>
<form action="/store/ProductServlet?method=update" method="post">
	<input type="hidden" name="pid" value="${prodcut.product_id }">
	名称:<input type="text" name="prdName" value="${product.name }"/><br/>
	类别:<select name="typeId">
	<option value="0">--请选择--</option>
	<c:forEach items="${typeList }" var="type">
	 	<option value="${type.product_type_id }" <c:if test="${tpye.product_type_id==prodcut.product_type_id }" >selected="selected"</c:if>
	 	>${type.name }</option>
	</c:forEach>
	</select><br/>
	价格：<input type="text" name="price" value="${product.price }"><br/>
	描述:<textarea rows="3" cols="50" name="decs">${product.description }</textarea><br/>
	<input type="submit" value="提交"/>
</form>
</body>
</html>