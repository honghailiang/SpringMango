<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="../includes/taglibs.jsp"%>
<!doctype html>
<html>
<head>
	<title><sitemesh:write property='title' /></title>
	<link rel="Shortcut Icon" href="<c:url value='/resources/images/favicon.ico'/>" type="image/x-icon"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>" />
	<sitemesh:write property='head' />
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
</head>		
    <div id="page">
        <div id="header">
            <jsp:include page="../includes/header.jsp"/>
        </div>
        <div id="content">
        	<ul id="tabmenu">
        		<li><a href="<c:url value='/'/>" class="current">首页</a></li>
        		<sec:authorize access="!hasRole('ROLE_USER') && !hasRole('ROLE_MANAGER')">
        			<li>你好，欢迎来到Mango！<a href="<c:url value='/login'/>" class="current">登录</a></li>
        		</sec:authorize>
        		<sec:authorize access="hasRole('ROLE_USER')">
        			<li><sec:authentication property="principal.username"/>  欢迎光临Mango！<a href="<c:url value='/logout'/>" class="current">退出</a></li>
        		</sec:authorize>
        		<sec:authorize access="hasRole('ROLE_MANAGER')">
        			<li><sec:authentication property="principal.username"/>  欢迎光临Mango！<a href="<c:url value='/logout'/>" class="current">退出</a></li>
        		</sec:authorize>
        		<li><a href="<c:url value='/manager'/>" class="current">管理中心</a></li>
        	</ul>
			<div id="tabcontent">
				<sitemesh:write property='body'></sitemesh:write>
			</div>
        </div>
        <div id="footer">
            <jsp:include page="../includes/footer.jsp"/>
        </div>
    </div>
</body>
</html>
