<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>prdlist</title>
<script type="text/javascript">
	function delConfirm(prdId){
		if(confirm("你确定要删除吗?")){
			window.location.href="/store/ProductServlet?method=delete&prdId="+prdId;
		}
		
	}
</script>
</head>
<body>
	<table>
		<thead>
			<td>编号</td>
			<td>类别</td>
			<td>名称</td>
			<td>描述</td>
			<td>价格</td>
			<td>操作</td>
		</thead>
		<tbody>
		<c:forEach items="${list }" var="prd">
		<tr>
			<td>${prd.product_id }</td>
			<td>${prd.protype.name }</td>
			<td>${prd.name }</td>
			<td>${prd.description}</td>
			<td>${prd.price }</td>
			<td>
						<a href="/store/ProductServlet?method=edit&id=${prd.product_id }">编辑</a>
						<a href="javascript:void(0)" onclick="delConfirm(${prd.product_id });">删除</a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<div  align="left">
		当前页:${pageNum }  总页数:${pageCount }
		<c:if test="${pageNum==1 }">上一页</c:if>
		<c:if test="${pageNum!=1 }">
		<a href="/store/ProductServlet?method=list&pageNo=${pageNum }&dir=pre">上一页 </a>
		</c:if>&nbsp;
		<c:if test="${pageNum==pageCount }">下一页</c:if>
		<c:if test="${pageNum!=pageCount }">
		<a href="/store/ProductServlet?method=list&pageNo=${pageNum }&dir=next">下一页</a>
		</c:if>
		<%
			int pageCount=(int)request.getAttribute("pageCount");
			for(int i=1;i<=pageCount;i++){
		%>
			&nbsp;<a href="/store/ProductServlet?method=list&pageNo=<%=i%>"><%=i%></a>
		<%} %>
	</div>
	<c:choose>
		<c:when test="${param.editFlag=='editSuccess'}">编辑成功！</c:when>
		<c:when test="${param.editFlag=='editFailure'}">编辑失败！</c:when>
	</c:choose>
	<a href="/store/index.jsp">返回主页</a>
</body>
</html>