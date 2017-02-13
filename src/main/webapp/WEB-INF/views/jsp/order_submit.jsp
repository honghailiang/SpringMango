<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="../includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Mango-OrderPay</title>
	<meta name="menu" content="home" />    
</head>

<body>

<h1>订单信息</h1>

<form action="<c:url value='/order/${order.orderId}/pay'/>" method="post">
	<div style="text-align:center">
	<p><span >订单编号：${order.orderId}</span></p>
	<p><span >订单总额：￥${order.totalPrice}</span></p>
	<input type="submit" value="立即支付" />
	</div>
</form>

</body>
</html>
