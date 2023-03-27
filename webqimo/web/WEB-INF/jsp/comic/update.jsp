<%--
  Created by IntelliJ IDEA.
  User: WQ
  Date: 2022/12/5
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <base href="http://${header.host}${pageContext.request.contextPath}/comic/"/>
  <meta charset="utf-8"/>
    <title>修改动漫</title>
</head>
<body>
<h1>修改动漫</h1>
<form action="/comic/update" method="post" enctype="multipart/form-data">
  comicName:<input type="text" name="comicName" value="${comic.comicName}"><br>
  nickname:<input type="text" name="nickname" value="${comic.nickname}"><br>
  cover:<input type="file" name="cover" value="${comic.cover}"><br>
  region:<input type="text" name="region" value="${comic.region}"><br>
  label:<input type="text" name="label" value="${comic.label}"><br>
  description:<input type="text" name="description" value="${comic.description}"><br>
  remark:<input type="text" name="remark" value="${comic.remark}"><br>
  year:<input type="text" name="year" value="${comic.year}"><br>
  updateTime:<input type="text" name="updateTime" value="${comic.updateTime}"><br>
  number:<input type="text" name="number" value="${comic.number}"><br>
  popularity:<input type="text" name="popularity" value="${comic.popularity}"><br>
  url:<input type="text" name="popularity" value="${comic.url}"><br>
  <input type="submit" value="提交">
</form>
</body>
</html>
