<%--
  Created by IntelliJ IDEA.
  User: tutu
  Date: 2016/10/24
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/user/register.action" method="post">
    用户名：<input type="text" name="username" />
    密码：<input type="password" name="password" />
    联系方式：<input type="text" name="usertel" />
    <input type="submit"/>
  </form>

</body>
</html>
