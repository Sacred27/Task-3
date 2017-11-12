<%-- 
    Document   : result
    Created on : 08.11.2017, 22:39:08
    Author     : Shark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Регрессия: результаты</title>
        <style type="text/css">
        <%@include file="/resourses/style.css" %>
        </style>
    </head>
    <body>
        ${formula}
        ${table}
        <img src="${pageContext.request.contextPath}/resourses/linearregression.png">
    </body>
</html>
