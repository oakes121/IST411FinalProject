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
       // String price = (String) request.getAttribute("totalPrice"); 
       // String custName = (String) request.getAttribute("CustName");
    %>
    
    <body style="background-color: #690;">
        <div style ="padding: 20px;">
            <h1><img style="width:300px; padding: 30px;" align="left" src ="pig.png">
                Shipping and billing info:</h1>
            <hr>
            <h2>  <%= request.getAttribute("CustName") %><br/>
                  <%= request.getAttribute("Street Address") %>
                   <%= request.getAttribute("City") %>,  <%= request.getAttribute("State") %><br/>
                    <%= request.getAttribute("zip") %>
            <h2> Your total price is $<%= request.getAttribute("price") %>.<br/>
            Your shipping charges are $<%= request.getAttribute("rate") %>.<br/></h2>
            <p style ="margin-left: 30px;">Thank you for shopping with us!</p>
        </div>
    </body>
</html>
