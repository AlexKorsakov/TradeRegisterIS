<%@page import="student.web.hello"%>
<%@page import="student.web.servlet"%>

<%-- 
    Document   : index
    Created on : 20.06.2016, 14:25:49
    Author     : admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="POST" action="/WebApplication1/servlet"/>
        <input type="text" name="username" />
        <input type="hidden" name="sdelat_pezdato" value="1"/>
        </form>
    </body>
</html>