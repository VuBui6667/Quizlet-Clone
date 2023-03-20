<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset password | Quizlet</title>
        <link rel="stylesheet" href="css/change.css"/>
    </head>

    <body>
        <%@include file="header.jsp" %>
        <c:if test="${checkVerifyLink}">
            <div class="change-body">
                <h2 class="text-center">Reset password</h2>  
                <form action="change" method = "post" class="change-form mt-4">
                    <p style="color: red">${requestScope.error}</p>
                    <p style="color: red">${requestScope.invalidpass}</p>
                    <input type="password" class="form-change-pass" name ="pass" required/>
                    <p>MẬT KHẨU MỚI </p>
                    <input type="password" class="form-change-pass" name="repass" required/>
                    <p>XÁC NHẬN MẬT KHẨU MỚI</p>
                    <button type = "submit" class="btn-change-pass">LƯU MẬT KHẨU</button>
                </form>
            </div>
        </c:if>
            <div class="change-body">
                <h2 class="text-center">Reset password</h2>  
                <form action="change" method = "post" class="change-form mt-4">
                    <p style="color: red">${requestScope.error}</p>
                    <p style="color: red">${requestScope.invalidpass}</p>
                    <input type="password" class="form-change-pass" name ="pass" required/>
                    <p>MẬT KHẨU MỚI </p>
                    <input type="password" class="form-change-pass" name="repass" required/>
                    <p>XÁC NHẬN MẬT KHẨU MỚI</p>
                    <button type = "submit" class="btn-change-pass">LƯU MẬT KHẨU</button>
                </form>
            </div>

        <%@include file="footer.jsp" %>

    </body>

</html>