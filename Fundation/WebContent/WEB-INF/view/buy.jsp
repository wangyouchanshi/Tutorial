<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="buyend.controller" method="post">
	<input type="hidden" name="mid" value="${money.mid}">
	<input type="hidden" name="uid" value="${money.uid}">
	<input type="hidden" name="mname" value="${money.mname }">
		<table>
		
			<tr>
				<td>用户名</td>
				<td>${uname }</td>
			</tr>
			<tr>
				<td>基金名称</td>
				<td>${money.mname }</td>
			</tr>
			<tr>
				<td>剩余金额</td>
				<td>${money.rest }</td>
			</tr>
			<tr>
				<td>购买金额</td>
				<td><input type="text" name="mai"></td>
			</tr>
			<tr>
				<td>操作</td>
				<td><input type="submit" value="【确认购买】"><input type="button" value="【回到列表】"></td>
			</tr>
		
		</table>
	
	</form>
</body>
</html>