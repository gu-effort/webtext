<%--
  Created by IntelliJ IDEA.
  User: WQ
  Date: 2022/11/30
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8"/>
    <title>留言本</title>
</head>
<body>
<h1>用户注册</h1>
<form action="register" method="post">
    用户名：<input type="text" name="name"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="注 册">
    <input type="reset" value="重 置">
</form>
</body>
</html>
