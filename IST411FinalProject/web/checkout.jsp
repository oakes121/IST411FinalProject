<%-- 
    Document   : checkout
    Created on : Apr 29, 2014, 11:33:37 AM
    Author     : Oakes / Roman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out</title>
    </head>
    <body style="background-color: #690;">
        <div style ="padding: 30px;">
        <img style="width:300px;" src ="pig.png">>
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
        
        <div>
            <h2>Your Shopping Cart</h2>
            <h3>Meat</h3>
            <!-- show product here -->
            <%= request.getAttribute("correct") %>
            <hr>
            <h3>Produce</h3>
            <!-- show product here -->
            <%= request.getAttribute("correct") %>
            <hr>
                
        </div>
        
        <form action="SecondServlet" method="post" >
            <span style="font-family: '@Arial Unicode MS'; font-weight: bold; font-style: normal; text-decoration:  underline; font-size: 12pt;"><head>Customer Information</head> </span>
                <p>
                <label for=""><span style="font-family: '@Arial Unicode MS'; font-weight: normal; font-style: normal; text-decoration: none; font-size: 12pt;">Customer Name</span></label> 
                <input type="text" name="CustName" value=""></p>
                <p>
                <label for="">Street Address</label>
                <input type="text" name="Street Address" value=""></p>
                <p>
                <label for="">City</label>
                <input type="text" name="City" value="">
                <label for="">State</label>
                <input type="text" name="State" value="" required>
                <label for="">Zip Code</label>
                <input type="text" name="ZipCode" value=""></p>
                <br />

                <p>
                <span style="font-family: '@Arial Unicode MS'; font-weight: bold; font-style: normal; text-decoration:  underline; font-size: 12pt;"><head>Payment Information</head></span></p>
                <label for="">Credit Card Number</label>
                <input type="text" name="cardNumber" value=""> 
                <label for="">Expiration Date</label>
                <input type="text" name="ExpDate" value=""> <label for="">Security Code</label><input type="text" name="SecCode" value="">
                <br />
                <br />
                <br />
                <input type="Submit" name="Submit" value="Submit" onClick="return allNumeric(form)">
        </form>
    </body>
</html>
