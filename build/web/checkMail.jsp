<%-- 
    Document   : checkMail
    Created on : Mar 6, 2023, 7:20:45 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check your email! | Quizlet</title>
        <link rel="stylesheet" href="css/check.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container-check">
            <h1>Check your email! | Quizlet</h1>
            <p>We've sent an email to ${mail}</p>
            <p>Please check your spam folder if you don't see the email in your inbox.</p>
            <a href="url">Need more help?</a>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
