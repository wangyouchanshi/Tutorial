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
<form action="list.controller" method="post">
按基金名称搜索：【<input name="mohu" >】【<input type="submit" value="搜索">】

</form>
<table>
	<tr>
		<td>序号</td>
		<td>基金编号</td>
		<td>基金名称</td>
		<td>发行金额</td>
		<td>剩余金额</td>
		<td>发行时间</td>
		<td><a href="check.controller?uid=${xuid}">【查看已购基金】</a></td>
	</tr>
	<c:forEach items="${aa }" var="bb" varStatus="no">
		<tr>
			<td>${no.first }</td>
			<td>${bb.mid }</td>
			<td>${bb.mname }</td>
			<td>${bb.msum }</td>
			<td>${bb.rest }</td>
			<td>${bb.madate }</td> 
			<td><a href="buy.controller?mid=${bb.mid }&uid=${xuid}">【购买】</a></td>
		</tr>
		
	</c:forEach>
<tr>
	<td colspan="11">${firstPage },${precursorPage },${nextPage },${lastPage }</td>
</tr>
</table>

</body>
</html>