<%--
  Created by IntelliJ IDEA.
  User: WQ
  Date: 2022/11/21
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <title>订单</title>
</head>
<body>
<h1>订单详情</h1>
<text>${name}</text>
<a href="/product/list">继续购物</a>
<a href="/login">退出</a>
<a href="/deleteall">清空购物车</a><br>

订单编号:<text>${payorder.orderId}</text><br>
订单总额:<text><fmt:formatNumber type="number" value="${payorder.money}" pattern="0.00" maxFractionDigits="2"/></text><br>
购买人姓名：<text>${payorder.name}</text><br>
收货地址：<text>${payorder.address}</text><br>
收货人电话：<text>${payorder.tel}</text><br>
订单状态：<c:if test="${payorder.statusCode eq 0}">
    订单已下载
</c:if><br>
<c:if test="${payorder.statusCode eq 1}">
    订单还没支付
</c:if><br>
订单创建时间：<text>${payorder.createTime}</text><br>

<a href="payorder">支付完成</a>
<a href="order">取消订单</a>
</body>
</html>
