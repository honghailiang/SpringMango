<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="../includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Mango-Index</title>
	<meta name="menu" content="home" />    
</head>

<body>

<h1>欢迎光临!</h1>

<div style="text-align:center">
	<ul>
		<c:forEach var="product" items="${productList}">
			<li>
				<a href="product/${product.productId}" >
					<c:choose>
						<c:when test="${empty product.picture}">
							<img src="<c:url value='/resources/images/team.jpg'/>" />
						</c:when>
						<c:otherwise>
							<img src="${product.picture }" />
						</c:otherwise>
					</c:choose>
				<h4>${product.productName}<h4>
				<p>
					<span >￥${product.unitPrice}</span>
				</p>
				</a>
			</li>
		</c:forEach>
	</ul>
</div>

</body>
</html>
