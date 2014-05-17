<%-- 
    Document   : checkout
    Created on : Apr 29, 2014, 11:33:37 AM
    Author     : Oakes / Roman
--%>
<%@page import="prodToCheckout.ProductToCheckout"%>
<%@page import="shipping.ShippingCalc"%>
<%@page import="java.util.ArrayList"%>
<%@page import="product.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out</title>
    </head>
    <body style="background-color: #690;">
        <%
            ArrayList<Product> selected = (ArrayList<Product>) request.getAttribute("selected");
        %>
            
       
        <div style="width: 20%; float: left; padding: 10px;">
            <img style="width:200px;"  src ="pig.png"><br/>
            <h2>Check Out</h2>
                
        </div>
        
         
        <script src="allNumeric.js"></script>
        <div style ="padding: 10px; margin-left: 20%; border-left: solid;">
        
        
       <%
            int weight = 0;
            int price = 0;
            
            
          
        %>
        
        
            
            
            <h2>Your Shopping Cart</h2>
            <h3>Products</h3>            
            <%
            
                for (int i = 0; i<selected.size();i++) {
                    out.println("<table width='' border='0'>");
                    out.println("<tr>");
                    out.println("<td>");
                    out.println("Product: " + selected.get(i).getTitle());
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("<td>");
                    out.println("Weight " + selected.get(i).getWeight() + "lbs");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("Price $" + selected.get(i).getPrice());
                    out.println("</td></tr></table><br><br>");
                    
                    weight += Integer.parseInt(selected.get(i).getWeight());
                    price += Integer.parseInt(selected.get(i).getPrice());
                    
                    
                }
                
            %>
        
       
        
        <form action="SecondServlet" method="post" >
            
                <h2>Customer Information</h2> </span>
            <table width="" border="0">
                
                <tr>
                  <td><label for="">Full Name</label></td>
                  <td><input type="text" name="CustName" value=""></td>
                  
                </tr>
                <tr>
                  
                  <td><label for="">Street Address</label></td>
                  <td><input type="text" name="Street Address" value=""></td>
                  
                </tr>
                <tr>
                  <td><label for="">City</label></td>
                  <td><input type="text" name="City" value="" required></td>
                  
                </tr>
                <tr>
                  <td><label for="">State</label></td>
                  <td><input type="text" name="State" value="" required></td>
                </tr>
                <tr>
                  <td><label for="">Zip Code</label></td>
                  <td><input type="text" name="zipCode" value="" required></td>
                  
                </tr>
            </table>
            <br />
            <br />
            <h2>Payment Information</h2>
          <table width="" border="0">
              
                <tr>
                  <td><label for="">Credit Card Number</label></td>
                  <td><input type="text" name="cardNumber" value=""> </td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td><label for="">Expiration Date</label></td>
                  <td><input type="text" name="ExpDate" value=""> </td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td><label for="">Security Code</label></td>
                  <td><input type="text" name="SecCode" value=""></td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
          </table>

       
                <%
                
                   // request.setAttribute("price", price);
                    request.setAttribute(Integer.toString(price), price);
                    request.setAttribute(Integer.toString(weight), weight);
                                      
                %>
                                
                <input type="Submit" name="Submit" value="Submit" onClick="return allNumeric(form)">
        </form>
        </div>
    </body>
</html>
