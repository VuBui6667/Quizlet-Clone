<%-- 
    Document   : header
    Created on : Dec 8, 2022, 11:37:41 PM
    Author     : LENOVO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/header.css"/>
    </head>
    <body>
        <% User user = (User)session.getAttribute("user"); %>
        <div class="container-nav">
            <div class="nav-left">
                <div class="nav-item">
                    <a href="home.jsp">Quizlet</a>
                </div>
                <div class="nav-item">
                    <a href="home.jsp">Trang chủ</a>
                </div>
                <div class="nav-item">
                    <a href="#">Lời giải chuyên gia</a>
                </div>
                <div class="nav-item">
                    <a href="#">Thư viện của bạn</a>
                </div>
                <div class="nav-item container-dropdown">
                    <a onclick="handleOpenDropdown()" id="dropdown-btn">Tạo</a>
                    <div id="content" class="dropdown-content">
                        <a href="createSet" class="dropdown-item">Học phần</a>
                        <a href="#" class="dropdown-item">Lớp</a> 
                    </div>
                </div>
            </div>
            <div class="nav-right">
                <form action="search">
                    <input type="search" name="search" class="search-input" placeholder="Tìm kiếm học phần"/>
                    <input type="submit" hidden />
                </form>
                <div class="container-dropdown" style="display: flex; margin-right: 10px;">
                    <c:if test="${user!=null}" >
                        <a class="user-avatar" onclick="handleOpenSetting()"><%= user.getName().charAt(0)%></a>
                        <div id="content2" class="dropdown-content">
                            <a href="logout" class="dropdown-item">Đăng xuất</a>
                        </div>
                    </c:if>
                    <c:if test="${user==null}" >
                        <div >
                            <a href="login" class="dropdown-item">Đăng nhập</a>
                        </div>
                        <div >
                            <a href="register" class="dropdown-item">Đăng kí</a>
                        </div>
                    </c:if>


                </div>
            </div>
        </div>
    </body>
    <script>
        function handleOpenDropdown() {
            var element = document.getElementById("content");
            element.classList.toggle("show");
        }

        window.onclick = function (e) {
            var element = document.getElementById("content");
            if (!e.target.matches("#dropdown-btn") && element.classList.contains("show")) {
                element.classList.remove("show");
            }
        }

        function handleOpenSetting() {
            var element = document.getElementById("content2");
            element.classList.toggle("show");
        }
    </script>
</html>
