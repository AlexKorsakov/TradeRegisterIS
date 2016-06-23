<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
    <sql:query var="result" scope="request" dataSource="jdbc:mysql/trade">
        SELECT column_name(s) FROM table_name
    </sql:query>
        
    <table border="1">
            <!-- column headers -->
        <tr>
            <c:forEach var="columnName" items="${result.columnNames}">
                <th><c:out value="${columnName}"/></th>
            </c:forEach>
        </tr>
        <!-- column data -->
        <c:forEach var="row" items="${result.rowsByIndex}">
            <tr>
            <c:forEach var="column" items="${row}">
                <td><c:out value="${column}"/></td>
            </c:forEach>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>