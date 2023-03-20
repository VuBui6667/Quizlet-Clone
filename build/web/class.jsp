<%-- 
    Document   : class
    Created on : Feb 20, 2023, 3:46:52 PM
    Author     : vieta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dal.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<title>Trang chủ | Quizlet</title>-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/85116df733.js"></script>
        <link rel="stylesheet" href="css/class.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">

    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="class-section">
            <div class="user-info">
                <a class="user-avatar-folder"><%= user.getName().charAt(0)%></a>
                <div class="author">
                    ${user.getName()}
                    <p class="author-mail">
                        ${user.getEmail()} 
                    </p> 
                </div>    
            </div>

            <div class="container-home">
                <div class="class-container">
                    <div class="cate-class">
                        <a href="home.jsp" class="title-container-class">Học phần</a>
                        <a href="folder.jsp" class="title-container-class">Lời giải chuyên gia</a>
                        <a href="folder.jsp" class="title-container-class">Thư Mục</a>
                        <a href="class.jsp" class="title-container-class">Lớp học</a>
                    </div>
                     <div>
                        <button  class="btn-folder">Đã Tạo &nbsp;&nbsp;<i class="fa-solid fa-chevron-down"></i></button>
                        
                    </div>
                 
                </div>
                
                <div class="content-container">
                        <c:forEach items="${listC}" var="c">
                            <a href="classSet?id=${c.getId()}">
                                <div class="item-class" >
                                    <div class="class"></div>
                                    <div class="title-class">${c.getName()} </div>
                                </div>
                            </a>
                        </c:forEach>
                    </div>

            </div>



        </div>
    </div>
</body>
</html>
