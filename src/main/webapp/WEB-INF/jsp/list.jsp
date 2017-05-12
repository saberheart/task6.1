<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: 56929--%>
  <%--Date: 2017/4/14--%>
  <%--Time: 18:24--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="com.heitian.ssm.model.User" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GB2312">
    <title>用户信息列表</title>
</head>
<body>
<h1>用户信息列表<a href="/user/add">添加</a></h1>
<table width="60%" border=1px  cellpadding="0" cellspacing="0">
    <tr>
        <td>id</td>
        <td>姓名</td>


    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
