<%--
  Created by IntelliJ IDEA.
  User: WQ
  Date: 2022/11/21
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <h1>登录</h1>
    <form action="login" method="post">
        用户名:<input type="text" name="name"><br>
        密码:<input type="password" name="password"><br>
        <input type="submit" value="确定">
        <input type="reset" value="重置">
    </form><br>
<h1>没有账号点这里去注册</h1><br>
<a href="register.do">注册</a>
</body>
</html>
