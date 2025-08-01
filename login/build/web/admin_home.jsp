<%-- 
    Document   : admin_home
    Created on : 05-May-2025, 7:56:59 pm
    Author     : administration
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Home</title>
    <style>
        body {
            margin: 0;
            height: 100vh;
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(to right, #141e30, #243b55);
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background: rgba(255, 255, 255, 0.05);
            padding: 40px 50px;
            border-radius: 20px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
            text-align: center;
            backdrop-filter: blur(10px);
        }

        h1 {
            font-size: 38px;
            margin-bottom: 20px;
        }

        .link-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 25px;
            font-size: 16px;
            border: none;
            border-radius: 8px;
            background: linear-gradient(to right, #00c6ff, #0072ff);
            color: white;
            text-decoration: none;
            font-weight: 500;
            transition: 0.3s ease;
        }

        .link-btn:hover {
            transform: scale(1.05);
            opacity: 0.9;
        }

        .logout-bar {
            position: absolute;
            top: 20px;
            center: 30px;
        }
    </style>
</head>
<body>

<%
    String email = (String) session.getAttribute("email");
    if (email != null) {
%>

    <div class="logout-bar">
        <%@ include file="admin_logout.html" %>
    </div>

    <div class="container">
        <h1>Welcome, Admin</h1>
        <p>You are logged in as: <strong><%= email %></strong></p>
        <a href="add_song.jsp" class="link-btn">➕ Add Song</a>
    </div>

<%
    } else {
%>
    <div class="container">
        <h1>Please login first</h1>
        <%@ include file="admin_login.html" %>
    </div>
<%
    }
%>

</body>
</html>
