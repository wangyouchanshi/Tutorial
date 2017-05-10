<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	
	<tr>
		<td>基金编号</td>
		<td>基金名称</td>
		<td>购买金额</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${aa}" var="bb">
	<tr>
	
		<td>${bb.mid }</td>
		<td>${bb.mname }</td>
		<td>${bb.mcount }</td>
		<td><a href="chexiao.controller?mid=${bb.mid }&mai=${bb.mcount }&did=${bb.id}">【撤销】</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>