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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/header.css" />
    </head>
    <body>
        <% User user = (User)session.getAttribute("user"); %>
        <div class="container-nav">
            <div class="nav-left">
                <div class="nav-item">
                    <a href="home">Quizlet</a>
                </div>
                <div class="nav-item">
                    <a href="home">Trang chủ</a>
                </div>
                <div class="nav-item">
                    <a href="#">Lời giải chuyên gia</a>
                </div>
                <div class="nav-item container-dropdown-lib">
                    <a onclick="handleOpenDropdownLib()" id="dropdown-btn-lib">Thư viện của bạn &nbsp;<i class="fa-solid fa-chevron-down"></i></a>
                    <div id="content-lib" class="dropdown-content-lib">
                        <c:if test="${user!=null}" >
                            <span class="dropdown-item-lib" onclick="handleOpenStudySet()">Học phần</span>
                            <span class="dropdown-item-lib">Lời giải chuyên gia</span>
                            <span class="dropdown-item-lib" onclick="handleOpenFolder()">Thư mục</span>
                            <span class="dropdown-item-lib">Lớp học</span>
                        </c:if>
                        <c:if test="${user==null}" >
                            <a href="login.jsp">Đăng nhập để xem thư viện của bạn.</a>
                        </c:if>
                    </div>
                    <div id="content-libb" class="dropdown-content-libb">
                        <c:if test="${user!=null}" >
                            <div class="item-lib" id="studySet-container">
                                <c:forEach items="${listSet}" var="set">
                                    <a href="flashCards?id=${set.getId()}">
                                        <div class="study-set-item-lib">
                                            <div class="study-set-title-lib">${set.getTitle()}-hoc phan</div>
                                            <div class="user-info-lib">
                                                <div class="user-avatar-lib">${nameS.charAt(0)}</div>
                                                <div class="user-avatar-name">${nameS}</div>
                                            </div>
                                        </div>
                                    </a>
                                </c:forEach>
                                <a href="url">Xem tất cả học phần </a>
                            </div>
                            <div class="item-lib" id="folder-container">
                                <c:forEach items="${listFd}" var="fd">
                                    <a href="folderSet?id=${fd.getId()}">
                                        <div class="study-set-item-lib">
                                            <div class="study-set-title-lib">${fd.getTitle()}-thu muc</div>
                                            <div class="user-info-lib">
                                                <div class="user-avatar-lib">${nameF.charAt(0)}</div>
                                                <div class="user-avatar-name">${nameF}</div>
                                            </div>
                                        </div>
                                    </a>
                                </c:forEach>
                                <a href="folder">Xem tất cả thư mục</a>
                            </div>
                        </c:if>
                        <c:if test="${user==null}" >
                            Nếu chưa có tài khoản. Xin mời đến mục <a href="register.jsp">Đăng kí </a>
                        </c:if>

                    </div>
                </div>
                <div class="nav-item container-dropdown">
                    <a onclick="handleOpenDropdown()" id="dropdown-btn">Tạo</a>
                    <div id="content" class="dropdown-content">
                        <a href="createSet" class="dropdown-item">Học phần</a>
                        <button id="myBtn" class="dropdown-item" onClick="handleOpenModal()">Thư mục</a> 
                    </div>
                </div>
                <div id="myModal" class="modal">
                    <div class="modal-content">
                        <span class="close" onClick="handleCloseModal()">×</span>
                        <h1 style="color: black">Tạo thư mục mới</h1>
                        <form action="folder" method="post">
                            <input class="title" type="text" name="title" placeholder="Nhập tiêu đề"></br>
                            <input class="details" type="text" name="details" placeholder="Nhập mô tả(tùy chọn)">
                            <div class="button-folder">
                                <input type="submit" value="Tạo thư mục" class="create-button"/>
                            </div>
                        </form>
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
                            <div class="user-info">
                                <span class="user-avatar"><%= user.getName().charAt(0)%></span>
                                <div>
                                    <p class="info-name"><%= user.getName()%></p>
                                    <p class="info-email"><%= user.getEmail() %></p>
                                </div>
                            </div>
                            <div class="border-line"></div>
                            <a class="dropdown-item">Hồ sơ</a>
                            <a class="dropdown-item">Cài đặt</a>
                            <a class="dropdown-item">Chế độ tối</a>
                            <div class="border-line"></div>
                            <a href="logout" class="dropdown-item">Đăng xuất</a>
                        </div>
                    </c:if>
                    <c:if test="${user==null}" >
                        <div >
                            <a href="login" class="dropdown-item btn-login">Đăng nhập</a>
                        </div>
                        <div >
                            <a href="register" class="dropdown-item btn-register">Đăng kí</a>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
    <script src="https://kit.fontawesome.com/85116df733.js"></script>
    <script>
                            var folderContainer = document.getElementById("folder-container");
                            var studySetContainer = document.getElementById("studySet-container");

                            function handleOpenFolder() {
                                folderContainer.style.display = "block";
                                studySetContainer.style.display = "none";

                            }

                            function handleOpenStudySet() {
                                folderContainer.style.display = "none";
                                studySetContainer.style.display = "block";
                            }


                            var modal = document.getElementById("myModal");

                            function handleOpenDropdown() {
                                var element = document.getElementById("content");
                                element.classList.toggle("show");
                            }

                            function handleOpenDropdownLib() {
                                var element = document.getElementById("content-lib");
                                element.classList.toggle("show");
                                var element = document.getElementById("content-libb");
                                element.classList.toggle("show");
                            }

                            window.onclick = function (e) {
                                var element = document.getElementById("content");
                                if (!e.target.matches("#dropdown-btn") && element.classList.contains("show")) {
                                    element.classList.remove("show");
                                }
                                if (e.target.matches("#myModal")) {
                                    modal.style.display = "none";
                                }
                            };

                            window.onclick = function (e) {
                                var element = document.getElementById("content-lib");
                                if (!e.target.matches("#dropdown-btn-lib") && element.classList.contains("show") && !e.target.matches(".dropdown-item-lib")) {
                                    element.classList.remove("show");
                                }
                                var elementt = document.getElementById("content-libb");
                                if (!e.target.matches("#dropdown-btn-lib") && elementt.classList.contains("show") && !e.target.matches(".dropdown-item-lib")) {
                                    elementt.classList.remove("show");
                                }
                            };

                            function handleOpenSetting() {
                                var element = document.getElementById("content2");
                                element.classList.toggle("show");
                            }

                            function handleOpenModal() {
                                modal.style.display = "block";
                            }

                            function handleCloseModal() {
                                modal.style.display = "none";
                            }

    </script>
</html>
