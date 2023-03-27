<%--
  Created by IntelliJ IDEA.
  User: WQ
  Date: 2022/11/21
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="myfn" uri="http://cdu.nls/functions" %>
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
   <a href="../login">未登录</a>
</c:if>
<a href="../order">查看购物车</a>
<c:if test="${name!=null}">
    <a href="../login">退出</a>
</c:if>

<table style="border: 1px">
    <tr>
        <th>图片</th>
        <th>id</th>
        <th>商品名称</th>
        <th>价格</th>
        <th>折扣</th>
        <th>库存</th>
        <th>上架时间</th>
        <c:if test="${name!=null}">
            <th>加入购物车</th>
        </c:if>
    </tr>
    <c:forEach items="${bookList}" var="book" varStatus="s">
        <tr>
            <td><img src="${book.imgUrl}" style="width: 120px;height: 100px"></td>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.sale}%</td>
            <td>${book.stock}</td>
            <td>${myfn:formatDatetime(book.marketDate)}</td>
            <c:if test="${name!=null}">
                <td><a href="mod?id=${book.id }">加入购物车</a></td>
            </c:if>

        </tr>
    </c:forEach>
</table>

<c:if test="${bpage>1}">
    <a href="list?bpage=${bpage-1}">上一页</a>
</c:if>
<c:if test="${bpage<bpageCount}">
    <a href="list?bpage=${bpage+1}">下一页</a>
</c:if>
<a href="add.do">添加书籍</a>
</body>
</html>
