<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#sub").click(function(){
		$("#check").focus(function(){
			$("#yan").text(" ");
		})
		var name=$("#check").val();
		$.ajax({
			url:"yanzheng.controller",
			type:"post",
			data:{name:name},
			dataType:"json",
			success:function(obj){
				if(obj){
					
					$("#yan").text("用户名已经存在")
				}else{
					$("form").submit();
					
				}
				
			}
		});
		
		
	});
	
	
	
});
</script>
<body>

	<form action="addend.controller" method="post">
		用户名<input id="check" name="uname"><span id="yan"></span><br>
		密码<input name="pwd"><br>
		性别<input name="usex"><br>
		<input id="sub" type="button" value="注册">
	</form>

</body>
</html>