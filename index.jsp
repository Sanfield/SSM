<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/mybatis/UserServlet?method=login" method="post">
	 账户:<input type="text" name="id">
	密码:<input type="password" name="pwd">
	<input type="submit" value="登录">
	</form>
	${msg }
</body>
</html>