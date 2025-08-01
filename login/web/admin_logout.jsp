<%-- 
    Document   : admin_logout
    Created on : 07-May-2025, 7:13:33 pm
    Author     : administration
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
         
            session.invalidate();
            out.println("<h2>You have successfully logged out.</h2>");
        
            %>
            <%@ include file="admin_login.html" %>
       
    
    </body>
</html>
