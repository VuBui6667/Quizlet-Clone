<%-- 
    Document   : login
    Created on : Dec 8, 2022, 10:39:13 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập | Quizlet</title>
        <link rel="stylesheet" href="css/login.css" />
    </head>
    <body>
        <div class="wrapper-sign">
            <div class="container-img">
                <h1 class="title-img" style="color: white">Học hiệu quả mà thật thoải mái.</h1>
                <div class="logo">Quizlet</div>
            </div>
            <div class="container-form">
                <div class="wrapper-form">
                    <div class="methods">
                        <a class="register-btn" href="register.jsp">Đăng ký</a>
                        <div class="login-btn">Đăng nhập</div>
                    </div>      
                    <form action="login" method="post">
                        <input type="text" name="user" placeholder="Nhập email hoặc tên người dùng của bạn" class="input-form"/>
                        <div class="text-form">TÊN NGƯỜI DÙNG</div> 
                        <input type="password" name="pass" placeholder="Nhập mật khẩu" class="input-form"/>
                        <div class="text-form">MẬT KHẨU</div> 
                        <input type="submit" value="Đăng nhập" class="login-button"/>
                    </form>
                </div>
                <div style="color: red; margin-left: 32px">${requestScope.errInput}</div>
            </div>
            <div>
                <a href="homeLogin.jsp" class="close-login"></a>
            </div>
        </div>
    </body>
</html>
