<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>亲，您登陆成功，但是没有绑定呦</h3>
<form action="bangding.controller">
	亲，输入账号<input name="uname"><br/>
	亲，输入密码<input name="pwd"><br/>
	<input type="hidden" name="baidu" value="${baidu}">
	<input type="submit" value="亲，点击绑定">

</form>
</body>
</html>