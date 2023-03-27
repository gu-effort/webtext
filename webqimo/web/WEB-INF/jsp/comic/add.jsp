<%--
  Created by IntelliJ IDEA.
  User: WQ
  Date: 2022/12/3
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加动漫</title>
</head>
<body>
<h1>添加动漫</h1>
    <form action="/comic/add" method="post" enctype="multipart/form-data">
        comicName:<input type="text" name="comicName"><br>
        nickname:<input type="text" name="nickname"><br>
        cover:<input type="file" name="cover"><br>
        region:<input type="text" name="region"><br>
        label:<input type="text" name="label"><br>
        description:<input type="text" name="description"><br>
        remark:<input type="text" name="remark"><br>
        year:<input type="text" name="year"><br>
        updateTime:<input type="text" name="updateTime"><br>
        number:<input type="text" name="number"><br>
        popularity:<input type="text" name="popularity"><br>
        popularity:<input type="text" name="url"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
