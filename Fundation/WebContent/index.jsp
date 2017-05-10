<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
	function zhuce(){
		
		location.href="add.controller";
		
	}
</script>
<body>
<form action="login.controller" method="post">
<table>

	<tr>
		<td>账号</td>
		<td>【<input type="text" name="uname">】</td>
	</tr>
	<tr>
		<td>密码</td>
		<td>【<input type="text" name="pwd">】</td>
	</tr>
	<tr>
		<td><input type="submit" value="登录"><input type="button" value="注册" onclick="zhuce()"></td>
	</tr>
	
</table>
<a href="http://openapi.baidu.com/oauth/2.0/authorize?client_id=9oNY87wp9SLyhX80HD1I3RkA&response_type=code&redirect_uri=http://localhost:8080/Fundation/loginSuccess.controller">百度</a>
</form>
</body>
</html>