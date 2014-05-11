<%-- 
    Document   : ProductPage
    Created on : May 4, 2014, 10:06:52 PM
    Author     : Shubham
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="product.Product"%>
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
        
        
    <body>
        <table style="width:500px">
            <form>
        <%        
            for (int i = 0; i < fruits.size(); i++) {
                out.print("<tr>");
                out.print("<td>" + " Product : " + fruits.get(i).getTitle() + "</td>");        
                out.print("<td>" + " Price   : " + fruits.get(i).getPrice() + "$ </td>"); 
                out.print("<td>" + " Weight  : " + fruits.get(i).getWeight() + "lbs </td>");                
                out.print("</tr>");
            }
         
        %>
            </form>
         </table>
        
    </body>
</html>
