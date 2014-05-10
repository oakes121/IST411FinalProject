<%-- 
    Document   : ProductPage
    Created on : May 4, 2014, 10:06:52 PM
    Author     : Shubham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products Page</title>
    </head>
    <body>
        <div><%= request.getAttribute("products")%></div>
    </body>
</html>
