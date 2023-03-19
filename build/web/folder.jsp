<%-- 
    Document   : folder
    Created on : Feb 9, 2023, 2:23:40 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dal.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ | Quizlet</title>
        <link rel="stylesheet" href="css/folder.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/85116df733.js"></script>

    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="folder-section">
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
                <div class="folder-container">
                    <div class="cate-folder">
                        <a href="folder.jsp" class="title-container-folder">Thành tựu</a>
                        <a href="folder.jsp" class="title-container-folder">Học phần</a>
                        <a href="folder.jsp" class="title-container-folder">Lời giải chuyên gia</a>
                        <a href="folder.jsp" class="title-container-folder">Thư Mục</a>
                        <a href="class.jsp" class="title-container-folder">Lớp học</a>
                    </div>
                    <div>
                        <button  class="btn-folder">Đã Tạo &nbsp;&nbsp;<i class="fa-solid fa-chevron-down"></i></button>
                        
                    </div>
                    <div class="content-container">
                        <c:forEach items="${listF}" var="f">
                            <a href="folderSet?id=${f.getId()}">
                                <div class="item-folder" >
                                    <div class="folder"></div>
                                    <div class="title-folder">${f.getTitle()}</div>
    <!--                                <div class="amount-card">${f.getDesc()} thuật ngữ</div>-->
                                    <!--     By ${d.getUserByUserId(f.getUserId()).getName()} -->
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
    </body>
</html>
