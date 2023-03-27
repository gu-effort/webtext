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
<a href="/login">退出</a><br>

订单编号:<text>${payorder1.orderId}</text><br>
订单总额:<text><fmt:formatNumber type="number" value="${payorder1.money}" pattern="0.00" maxFractionDigits="2"/></text><br>
购买人姓名：<text>${payorder1.name}</text><br>
收货地址：<text>${payorder1.address}</text><br>
收货人电话：<text>${payorder1.tel}</text><br>
<c:if test="${payorder1.statusCode eq 0}">
    订单状态：订单未支付
</c:if><br>
<c:if test="${payorder1.statusCode eq 1}">
    订单状态：订单已支付
</c:if><br>
订单创建时间：<text>${payorder1.createTime}</text><br>

</body>
</html>
