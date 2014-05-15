<%-- 
    Document   : errors
    Created on : Apr 12, 2014, 4:10:11 PM
    Author     : Roman Galysh rwg5215
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body style="background-color: #690;">
        <div style ="padding: 30px;">
        <img style="width:300px;" src ="pig.png">
        <br/>
        <FORM><INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;"></FORM>
        <br/>
            <div style="margin-left:10%;float: left; padding:0px; width:50%;">
                <h1 style = "color: white; padding:0px 0px 0px 10px;">ERROR!</h1>
                <!-- display error with number not matching database -->
                <h2><%= request.getAttribute("error") %> is not a valid credit card number.<br>
                    Use the 'Back' button to try again</h2>
                
            </div>
          
        </div>      
          
        </body>
</html>
