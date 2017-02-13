<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="../includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Mango-deny</title>
    <link rel="Shortcut Icon" href="<c:url value='/resources/images/favicon.ico'/>" type="image/x-icon"/>
	<meta name="menu" content="home" />    
</head>
<body>
<h1>对不起，您没有权限访问该页面!</h1>
       
<div style="text-align:center">
	<img src="<c:url value='/resources/images/nonono.jpg'/>"/>
	<p>
		<a href="<c:url value='/'/>">首页</a>
		<a href="<c:url value='/manager'/>">管理中心</a>
		<a href="<c:url value='/logout'/>" >退出登录</a>
	</p>
</div>
</body>
</html>