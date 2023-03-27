<%--
  Created by IntelliJ IDEA.
  User: WQ
  Date: 2022/12/3
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/comic/"/>
    <meta charset="utf-8"/>
    <title>动漫列表</title>
    <style>
        .box_song{
            display: flex;
            flex-direction: row;
        }
        .box{
            display: flex;
            flex-direction: column;
        }
        .img{
            width: 100px;
            height: 100px;
        }
    </style>
</head>
<body>
<a href="add.do">添加动漫</a>

<div>
    <form action="/comic/search" method="post" >
        <input type="text" name="value">
        <input type="submit" value="搜索">
    </form>
</div>
<div class="text_box">
    <a href="list?region=0">首页</a>
    <a href="list?region=10">国产动漫</a>
    <button  value="国产动漫">国产动漫</button>
    <button  value="日本动漫">日本动漫</button>
    <button  value="动漫电影">动漫电影</button>
    <button  value="最近更新">最近更新</button>
</div>
<div class="box_song">
    <c:forEach items="${searchlist}" var="comic" varStatus="s">
        <div class="box">
            <img src="${comic.cover}" class="img">
            <a href="https://www.baidu.com/" class="name">${comic.comicName}</a>
            <a href="update?id=${comic.id}">修改</a>
            <a href="detail?id=${comic.id}">查看详情</a>
            <a href="delComic?id=${comic.id}">删除</a>
        </div>
    </c:forEach>
</div>
<a href="search?page=1">首页</a>
<c:if test="${page==1}">
    <a style="pointer-events: none;">上一页</a>
</c:if>
<c:if test="${page>1}">
    <a href="search?page=${page-1}">上一页</a>
</c:if>
<c:if test="${page<pageCount}">
    <a href="search?page=${page+1}">下一页</a>
</c:if>
<c:if test="${page==pageCount}">
    <a style="pointer-events: none;">下一页</a>
</c:if>
<a href="search?page==${pageCount}">尾页</a>


</body>
</html>
