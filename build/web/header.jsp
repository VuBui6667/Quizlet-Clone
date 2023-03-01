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
                    <a href="home.jsp">Quizlet</a>
                </div>
                <div class="nav-item">
                    <a href="home.jsp">Trang chủ</a>
                </div>
                <div class="nav-item">
                    <a href="#">Lời giải chuyên gia</a>
                </div>
                <div class="nav-item">
                    <a href="#">Thư viện của bạn &nbsp;<i class="fa-solid fa-chevron-down"style="font-size: 10px"></i></a>
                </div>
                <div class="nav-item container-dropdown">
                    <a onclick="handleOpenDropdown()" id="dropdown-btn">Tạo</a>
                    <div id="content" class="dropdown-content">
                        <a href="createSet" class="dropdown-item">Học phần</a>
                        <button id="myBtn" class="dropdown-item" onClick="handleOpenModal()">Thư mục</a> 
                            <button id="myBtn" class="dropdown-item" onClick="handleOpenModal1()">Lớp học</a> 
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
                                <div id="myModal1" class="modal">
                                    <div class="modal-content">
                                        <span class="close" onClick="handleCloseModal1()">×</span>
                                        <h1 style="color: black">Tạo lớp mới </h1>
                                        <p>Sắp xếp tài liệu học của bạn và chia sẻ chúng với bạn học của bạn.</p>
                                        <form action="class" method="post">
                                            <input  class="classname" type="text" name="classname" placeholder="Nhập tên lớp (khóa học, giáo viên, năm nay, phần vv)"></br>
                                            <input class="details" type="text" name="detailsclass" placeholder="Nhập mô tả(tùy chọn)">
                                            <input class="accept" type="checkbox" name="adddel" value="ok"/>cho phép các thành viên trong lớp thêm và bỏ học phần</br> </br> 
                                             <input class="accept" type="checkbox" name="addpeople" value="ok"/>cho phép các thành viên trong lớp mời thành viên mới

                                            <div class="button-folder">
                                                <input type="submit" value="Tạo lớp" class="create-button"/>
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
                                                var modal = document.getElementById("myModal");
                                                var modal1 = document.getElementById("myModal1");


                                                function handleOpenDropdown() {
                                                    var element = document.getElementById("content");
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
                                                       if (e.target.matches("#myModal1")) {
                                                        modal1.style.display = "none";
                                                    }
                                                }
                                                   

                                                function handleOpenSetting() {
                                                    var element = document.getElementById("content2");
                                                    element.classList.toggle("show");
                                                }

                                                function handleOpenModal() {
                                                    modal.style.display = "block";
                                                }
                                                 function handleOpenModal1() {
                                                    modal1.style.display = "block";
                                                }
                                         

                                                function handleCloseModal() {
                                                    modal.style.display = "none";

                                                }  
                                                function handleCloseModal1() {
                                                    modal1.style.display = "none";

                                                }  
                                         

                                </script>
                                
                                
                                </html>
