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
    <title>购物车</title>
</head>
<body>
<h1>购物车</h1>
<text>${name}</text>
<a href="/product/list">取消订单，返回购物</a>
<a href="/login">退出</a>
<table>
    <tr>
        <th>id</th>
        <th>图片</th>
        <th>商品名称</th>
        <th>原价</th>
        <th>折后价</th>
        <th>购买数量</th>
    </tr>
    <c:set value="0" var="sum" />
    <c:forEach items="${orderbook}" var="book" varStatus="s">
        <tr>
            <td>${book.book.id}</td>
            <td><img src="${book.book.imgUrl}" style="width: 120px;height: 100px"></td>
            <td>${book.book.name}</td>
            <td>${book.book.price}</td>
            <td>
                <fmt:formatNumber type="number" value="${book.book.price * book.book.sale * 0.01}" pattern="0.00" maxFractionDigits="2"/></td>
            <c:set value="${sum + book.book.price * book.book.sale * 0.01}" var="sum" />
            <td>${book.number}</td>
        </tr>
    </c:forEach>
</table>
<h1> <fmt:formatNumber type="number" value="${sum}" pattern="0.00" maxFractionDigits="2"/></h1>
<form action="cart" method="post">
    价钱:<input type="text" name="money" value="${sum}" readonly="readonly"><br>
    收货人<input type="text" name="name"><br>
    收货人电话<input type="text" name="tel"><br>
    收货地址<input type="text" name="address"><br>

    <input type="submit" value="确定订单，准备支付"><br>
</form>
</body>
</html>
