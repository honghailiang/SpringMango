<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="../includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Mango-Product</title>
	<meta name="menu" content="home" />    
</head>

<body>

<h1>${product.productName}</h1>

<form action="<c:url value='/order/submit' />" method="post">
	<input type="hidden" name="productId" value="${product.productId}"/>
	<input type="hidden" name="productName" value="${product.productName}"/>
	<input type="hidden" name="unitPrice" value="${product.unitPrice}"/>
	<div style="text-align:center">
	<c:choose>
		<c:when test="${empty product.picture}">
			<img src="<c:url value='/resources/images/team.jpg'/>" />
		</c:when>
		<c:otherwise>
			<img src="${product.picture }" />
		</c:otherwise>
	</c:choose>
	<h4>商品名称：${product.productName}</h4>
	<p>
		<span >商品价格：￥${product.unitPrice}</span>
	</p>
	<p>
		购买数量：<input name="number" value="1"/>
	</p>
		<p>
			收货人地址，街道：<input name="address.street"/> 城市：<input name="address.city"/>
		</p>
	<input type="submit" value="立即购买" />
	</div>
</form>

</body>
</html>
