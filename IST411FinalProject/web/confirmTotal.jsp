<%-- 
    Document   : confirmTotal
    Created on : Apr 29, 2014, 11:30:36 AM
    Author     : Oakes / Roman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Total</title>
    </head>
    <%
        String price = (String) request.getAttribute("totalPrice"); 
        String custName = (String) request.getAttribute("CustName");
    %>
    
    <body style="background-color: #690;">
        <div style ="padding: 30px;">
        <img style="width:300px;" src ="pig.png">
        <h3><%= custName %> your total price is $<%= price %>.</h3>
        </div>
    </body>
</html>
