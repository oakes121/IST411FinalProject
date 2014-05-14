<%-- 
    Document   : ProductPage
    Created on : May 4, 2014, 10:06:52 PM
    Author     : Shubham
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="product.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p" %>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products Page</title>
    </head>
    <%
        ArrayList<Product> fruits = (ArrayList<Product>) request.getAttribute("fruits");
        ArrayList<Product> meats = (ArrayList<Product>) request.getAttribute("meats");
       
        %>
        
        
    <body body style="background-color: #690;">
        <img style="width:300px;" src ="pig.png">
        <br/>
        <br/>
        <table style="width:500px">
            <form action="PTC" method="post">
     
                        
                <%
                    for (int i = 0;i < fruits.size();i++) {
                        out.println("<tr>");
                        out.println("<td>");
                        out.println("Product: " + fruits.get(i).getTitle());
                        out.println("</td>");
                        out.println("<td>");
                        out.println("Price " + fruits.get(i).getPrice() + "$");
                        out.println("</td>");
                        out.println("<td>");
                        out.println("Weight " + fruits.get(i).getWeight() + "lbs");
                        out.println("</td>");
                        out.println("<td>");
                        out.println("<input type=checkbox name=fruitCheck" + i + ">" + "");
                        out.println("</td>");                        
                    }        
                %>
                
                <%
                    for (int i = 0;i < fruits.size();i++) {
                        out.println("<tr>");
                        out.println("<td>");
                        out.println("Product: " + meats.get(i).getTitle());
                        out.println("</td>");
                        out.println("<td>");
                        out.println("Price " + meats.get(i).getPrice() + "$");
                        out.println("</td>");
                        out.println("<td>");
                        out.println("Weight " + meats.get(i).getWeight() + "lbs");
                        out.println("</td>");
                        out.println("<td>");
                        out.println("<input type=checkbox name=meatCheck" + i + ">" + "");
                        out.println("</td>");                        
                    }        
                %>
                    
                    <input type="Submit" name="Submit" value="Proceed To Checkout">
            </form>
         </table>
        
    </body>
</html>
