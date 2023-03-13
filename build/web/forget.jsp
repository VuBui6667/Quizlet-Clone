<%-- 
    Document   : verify
    Created on : Dec 8, 2022, 3:14:19 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgotten Password |Quizlet</title>
        <link rel="stylesheet" href="css/forget.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container-reset">
            <div class="container-form">
                <div class="wrapper-form">
                    <h2 class="verify-title">Reset your password</h2>
                    <p>Enter your Quizlet username or the email address you signed up with. We'll email you a link to log in and reset your password.</p>
                    <form action="forget" method="post">
                        <input type="text" name="email" placeholder="Username or email address" class="input-form"/>
                        <div class="text-form">Username or email address</div> 
                        <input type="submit" value="Submit" class="submit-button"/>
                    </form>
                </div>
                <p style="color: red">${requestScope.error}</p>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
