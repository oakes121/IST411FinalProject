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
        <div>
            <img style="width:200px; padding: 10px;" align="left" src ="pig.png">
            
        </div>
                <div style ="padding: 20px; float: right; margin-right: 50%; border-left: solid;">
                    
                <h1>Shipping and Billing info:</h1>
                  
                <h2>  <%= request.getAttribute("CustName") %></h2>
                <h3> <%= request.getAttribute("Street Address") %><br/>
                  <%= request.getAttribute("City") %>,  <%= request.getAttribute("State") %><br/>
                  <%= request.getAttribute("zipCode") %></h3>
                  <hr>
                  <h1>Purchased items:</h1>  
                  
            <h2> Your total price is $<%= request.getAttribute("Price") %>.<br/>
            Your shipping charges are $<%= request.getAttribute("rate") %>.<br/></h2>
            
        </div>
    </body>
</html>
