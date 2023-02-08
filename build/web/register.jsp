<%-- 
    Document   : register
    Created on : Dec 8, 2022, 1:34:33 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng kí | Quizlet</title>
        <link rel="stylesheet" href="css/register.css"/>
    </head>
    <body>  
        <div class="wrapper-sign">
            <div class="container-img">
                <h1 class="title-img">Quẳng gánh lo đi mà vui học. Hãy đăng ký ngay hôm nay.</h1>
                <div class="logo">Quizlet</div>
            </div>
            <div class="container-form">
                <div class="wrapper-form">
                    <div class="methods">
                        <div class="register-btn">Đăng ký</div>
                        <a class="login-btn" href="login.jsp">Đăng nhập</a>
                    </div>      
                    <form action="register" method="post">
                        <div class="text-form">EMAIL</div> 
                        <input type="email" name="email" placeholder="user@quizlet.com" class="input-form"/>
                        <div class="text-form">TÊN NGƯỜI DÙNG</div> 
                        <input type="text" name="user" placeholder="andrew123" class="input-form"/>
                        <div class="text-form">MẬT KHẨU</div> 
                        <input type="password" name="pass" placeholder="********" class="input-form"/>
                        <div class="text-form">AVATAR</div> 
                        <input type="text" name="avatar" placeholder="image" class="input-form"/>
                        <div class="text-form">LANGUAGE</div> 
                        <input type="text" name="lang" placeholder="Choose language" class="input-form"/>
                        
                        <input type="submit" value="Đăng ký" class="register-button"/>
                        <p class="errInput" style="color: red;">${requestScope.errInvalidInput}</p>
                        <p class="errInput" style="color: red;">${requestScope.errEmpty}</p>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
