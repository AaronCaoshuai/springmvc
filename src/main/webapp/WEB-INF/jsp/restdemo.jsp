<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参数绑定演示demo</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/user/1/张三">GET查询用户</a>

<form action="${pageContext.request.contextPath}/user/"
method="post">
用户名称：<input type="text" name="username"><br />
用户年龄：<input type="text" name="age"><br />
所属省份：<input type="text" name="address.provinceName"><br />
所属城市：<input type="text" name="address.cityName"><br />
<input type="submit" value="POST保存">
</form>

    </body>
</html>