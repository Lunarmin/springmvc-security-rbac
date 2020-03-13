<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<script src="${pageContext.request.contextPath }/static/js/jquery-2.1.0.js"></script>
</head>
<body>
	<c:if test="${not empty param.error }">
		<font color="red">用户名或者密码错误</font>
	</c:if>
	<h3>登录页面</h3>
	<form id="loginFrom">
		用户名:<input type="text" name="username"><br>
		密码:<input type="password" name="password"><br>
		验证码:<input type="text" name="imagecode"><img src="${pageContext.request.contextPath }/image"/><br>
		记住我:<input type="checkbox" name="remember-me" value="true"><br>
		<input type="button" id="loginBtn" onclick="login();" value="登录">
	</form>
	
	<script type="text/javascript">
	
		function login() {
			var form=$("#loginFrom").serialize();
        	$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath }/securityLogin',
				dataType:'json',
				data:form,
				async:false,
				error:function(result){
					alert(result);
				},
				success:function(result){
					if(result.success){
						window.location.href="${pageContext.request.contextPath }/index";
					}else{
						alert("登录失败:"+result.errorMsg);
					}
				}
			});
		}
		
	</script>
</body>
</html>