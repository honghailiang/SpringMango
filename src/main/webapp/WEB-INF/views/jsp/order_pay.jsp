<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="../includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Mango-OrderPaySuccess</title>
	<meta name="menu" content="home" />    
</head>

<body>

	<h1>订单支付信息</h1>
	<div style="text-align:center">
	<p><span >订单编号：${order.orderId}</span></p>
	<p><span >订单时间：${order.createTime}</span></p>
	<p><span >订单总额：￥${order.totalPrice}</span></p>
	<p><span >订单状态：<c:if test="${order.status=='0'}">未付款</c:if><c:if test="${order.status=='1'}">已付款</c:if></span></p>
	<p><span >支付时间：${order.payTime}</span></p>
	<p><span >购买用户：${order.userName}</span></p>
	</div>

</body>
</html>
