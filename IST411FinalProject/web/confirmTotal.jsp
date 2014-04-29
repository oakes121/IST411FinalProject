<%-- 
    Document   : confirmTotal
    Created on : Apr 29, 2014, 11:30:36 AM
    Author     : Oakes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        String price = (String) request.getAttribute("totalPrice"); 
        String fullName = (String) request.getAttribute("fullName");
    %>
    
    <body>
        <h1><%= fullName %> your total price is $<%= price %>.</h1>
    </body>
</html>
