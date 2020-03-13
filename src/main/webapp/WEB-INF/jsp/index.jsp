<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
以下是网站的功能<br>
<security:authorize access="hasAuthority('ROLE_ADD_PRODUCT')">
<a href="${pageContext.request.contextPath}/product/add">商品添加</a><br>
</security:authorize>
<security:authorize access="hasAuthority('ROLE_DELETE_PRODUCT')">
<a href="${pageContext.request.contextPath}/product/delete">商品删除</a><br>
</security:authorize>
<security:authorize access="hasAuthority('ROLE_LIST_PRODUCT')">
<a href="${pageContext.request.contextPath}/product/list">商品列表</a><br>
</security:authorize>
<security:authorize access="hasAuthority('ROLE_UPDATE_PRODUCT')">
<a href="${pageContext.request.contextPath}/product/update">商品更新</a><br>
</security:authorize>
</body>
</html>