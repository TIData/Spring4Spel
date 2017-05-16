<%-- 
    Document   : startGame
    Created on : 02-May-2017, 12:06:37
    Author     : sebastiaan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form method="POST" action="game.htm" modelAttribute="game">
            <p> <label>Number:</label>
                <form:input path="number" size = "20"/>&nbsp;
                <form:errors path="number" cssClass="error"/>
            </p>
            
            <p>
                <input type="submit" value="OK" />           
            </p>
        </form:form>
    </body>
</html>