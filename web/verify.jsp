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
        <title>Xác thực | Quizlet</title>
        <link rel="stylesheet" href="css/verify.css"/>
    </head>
    <body>
        <div class="container-verify">
            <div class="container-img">
                <h1 class="title-img">Quẳng gánh lo đi mà vui học. Hãy đăng ký ngay hôm nay.</h1>
                <div class="logo">Quizlet</div>
            </div>
            <div class="container-form">
                <a class="back-btn" href="login">< Quay về đăng nhập</a>
                <div class="wrapper-form">
                    <div class="verify-title">Xác thực tài khoản</div>
                    <form action="verify" method="post">
                        <div class="text-form">MÃ XÁC THỰC</div> 
                        <input type="number" name="code" placeholder="Nhập mã" class="input-form"/>
                        <input type="submit" value="Xác thực" class="verify-button"/>
                    </form>
                </div>
                <h2 style="color: red; margin-left: 2rem">${requestScope.err_verify}</h2>
            </div>
        </div>
    </body>
</html>
