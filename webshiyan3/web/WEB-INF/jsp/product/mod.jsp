<%--
  Created by IntelliJ IDEA.
  User: WQ
  Date: 2022/11/21
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/product/"/>
    <meta charset="utf-8"/>
    <title>书籍列表</title>
</head>
<body>
<h1>书籍列表</h1>
<c:if test="${name!=null}">
    <text>${name}</text>
</c:if>
<c:if test="${name==null}">
    <a href="../login.jsp">未登录</a>
</c:if>
<a href="list">继续购物</a>
<a href="#">退出</a>
<table>
    <tr>
        <th>图片</th>
        <th>id</th>
        <th>商品名称</th>
        <th>价格</th>
        <th>折扣</th>
        <th>库存</th>
        <th>上架时间</th>
        <th>加入购物车</th>
    </tr>
    <c:forEach items="${orderbook}" var="book" varStatus="s">
        <tr>
            <td><img src="${book.imgUrl}" style="width: 120px;height: 100px"></td>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.sale}%</td>
            <td>${book.stock}</td>
            <td>${book.marketDate}</td>
            <td><a href="delbook?id=${book.id }">删除</a></td>
        </tr>
    </c:forEach>
</table>

<c:if test="${bpage>1}">
    <a href="list?bpage=${bpage-1}">上一页</a>
</c:if>
<c:if test="${bpage<bpageCount}">
    <a href="list?bpage=${bpage+1}">下一页</a>
</c:if>
<a href="../add.jsp">加入了购物车了撒</a>
</body>
</html>
