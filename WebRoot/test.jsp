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
  <form action="${pageContext.request.contextPath}/test/update.action" method="post">
    <input type="text" name="dept_code" />
    
    <input type="submit"/>
  </form>

</body>
</html>
