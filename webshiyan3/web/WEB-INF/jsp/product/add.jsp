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
    <title>添加用户</title>
</head>
<body>
    <form action="/product/add" method="post" enctype='multipart/form-data'>
        name<input type="text" name="name"><br>
        price<input type="text" name="price"><br>
        sale<input type="text" name="sale"><br>
        stock<input type="text" name="stock"><br>
        imgUrl<input type="file" name="imgUrl"><br>
        info<input type="text" name="info"><br>
        marketDate<input type="date" name="marketDate"><br>
        <input type="submit" value="确定添加"><br>
    </form>
</body>
</html>
