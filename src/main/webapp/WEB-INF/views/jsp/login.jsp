<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="../includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Mango-userLogin</title>
	<meta name="menu" content="home" />    
</head>

<body>

<h1>请用户登录!</h1>

<div style="text-align:center">
	<form action="<c:url value='/login' />" method="post">
		<c:if test="${not empty error}">
			<p style="color:red">${error}</p>
		</c:if>
      <table>
         <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"/></td>
         </tr>
         <tr>
            <td>密码：</td>
            <td><input type="password" name="password"/></td>
         </tr>
         <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </td>
         </tr>
      </table>
   </form>
</div>

</body>
</html>
