<%-- 
    Document   : checkout
    Created on : Apr 29, 2014, 11:33:37 AM
    Author     : Oakes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script src="allNumeric.js"></script>
        <h1>Checkout</h1>
        
        <%
            try {
                String error = (String) request.getAttribute("error");

                if (error.equals("You have entered an invalid card number. Please Try Again!")){
                    out.print("<h2>"+error+"</h2>");
                }
            } catch(NullPointerException e) {
                
            }
        %>
        
        <form action="SecondServlet" method="post" >
            Please enter your name as it appears on your credit/debit card.
            <input type="text" name ="fullName" required/>
            <br />
            Please enter your credit card number
            <input type="text" name ="cardNumber" required/>
            <br />
            Press submit when you are done
            <input type="submit" onClick="return allNumeric(form)"/>
            </form>  
    </body>
</html>
