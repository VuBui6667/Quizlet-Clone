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
                <div class="nav-item container-dropdown-lib">
                    <a onclick="handleOpenDropdownLib()" id="dropdown-btn-lib">Thư viện của bạn &nbsp;<i class="fa-solid fa-chevron-down"></i></a>
                    <div id="content-lib" class="dropdown-content-lib">
                        <div class="content-lib-name">
                            <c:if test="${user!=null}" >
                                <span class="dropdown-item-lib" id="items" onclick="handleOpenStudySet()">Học phần</span>
                                <span class="dropdown-item-lib" id="items1" onclick="handleOpenBook()">Lời giải chuyên gia</span>
                                <span class="dropdown-item-lib" id="items2" onclick="handleOpenFolder()">Thư mục</span>
                                <span class="dropdown-item-lib" id="items3" onclick="handleOpenClass()">Lớp học</span>
                            </c:if>
                            <c:if test="${user==null}" >
                                <div class="before-login1">
                                    <a href="login.jsp">Đăng nhập để xem thư viện của bạn.</a>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <div id="content-libb" class="dropdown-content-libb">
                        <c:if test="${user!=null}" >
                            <div class="item-lib" id="studySet-container">
                                <div class="item-set">
                                    <c:forEach items="${listSet}" var="set">
                                        <a href="flashCards?id=${set.getId()}">
                                            <div class="study-set-item-lib">
                                                <div class="study-set-title-lib">${set.getTitle()}</div>
                                                <div class="user-info-lib">
                                                    <div class="user-avatar-lib">${nameS.charAt(0)}</div>
                                                    <div class="user-avatar-name">${nameS}</div>
                                                </div>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                                <div class="get-all">
                                    <a href="studysets">Xem tất cả học phần </a>
                                </div>
                            </div>
                            <div class="item-lib" id="book-container">
                                <div class="item-set">
                                    <c:forEach items="${listBook}" var="b">
                                        <a href="book?isbn=${b.getIsbn()}">
                                            <div class="book-item-lib">
                                                <div>
                                                    <div class="book-title-lib">${b.getTitle()}</div>
                                                    <div class="edition">${b.getEdition()}</div>
                                                </div>
                                                <img class="image-book" src="${b.getImage()}" alt="Book">
                                            </div>
                                        </a>
                                    </c:forEach> 
                                </div>
                                <div class="get-all">
                                    <a href="explanation.jsp">Xem tất cả lời giải chuyên gia</a>
                                </div>
                            </div>
                            <div class="item-lib" id="folder-container">
                                <div class="item-set">
                                    <c:forEach items="${listFd}" var="fd">
                                        <a href="folderSet?id=${fd.getId()}">
                                            <div class="study-set-item-lib">
                                                <div class="study-set-title-lib">${fd.getTitle()}</div>
                                                <div class="user-info-lib">
                                                    <div class="user-avatar-lib">${nameF.charAt(0)}</div>
                                                    <div class="user-avatar-name">${nameF}</div>
                                                </div>
                                            </div>
                                        </a>
                                    </c:forEach> 
                                </div>
                                <div class="get-all">
                                    <a href="folder">Xem tất cả thư mục</a>
                                </div>
                            </div>
                            <div class="item-lib" id="class-container">
                                <div class="item-set">
                                    <c:forEach items="${listClass}" var="cl">
                                        <a href="classSet?id=${cl.getId()}">
                                            <div class="study-set-item-lib">
                                                <div class="study-set-title-lib">${cl.getName()}</div>
                                                <div class="user-info-lib">
                                                    <div class="user-avatar-lib">${nameC.charAt(0)}</div>
                                                    <div class="user-avatar-name">${nameC}</div>
                                                </div>
                                            </div>
                                        </a>
                                    </c:forEach> 
                                </div>
                                <div class="get-all">
                                    <a href="class">Xem tất cả lớp học</a>
                                </div>
                            </div>

                        </c:if>
                        <c:if test="${user==null}" >
                            <div class="before-login2">
                                Nếu chưa có tài khoản. Xin mời đến mục <a href="register.jsp">Đăng kí </a>
                            </div>
                        </c:if>

                    </div>
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
                                        <h1 style="color: white">Tạo lớp mới</h1>
                                        <p>Sắp xếp tài liệu học của bạn và chia sẻ chúng với bạn học của bạn.</p>
                                        <form action="class" method="post">
                                            <input  class="class-na" type="text" name="classname" placeholder="Nhập tên lớp (khóa học, giáo viên, năm nay, phần vv)"></br>
                                            <input class="details-cl" type="text" name="detailsclass" placeholder="Nhập mô tả(tùy chọn)">
                                            <input class="accept" type="checkbox" name="adddel" value="True"/>cho phép các thành viên trong lớp thêm và bỏ học phần</br> </br> 
                                            <input class="accept" type="checkbox" name="addpeople" value="True"/>cho phép các thành viên trong lớp mời thành viên mới </br>
                                            <input  class="school-na" type="text" name="schoolname" placeholder="Nhập tên trường của bạn"></br>

                                            <div class="button-folder">
                                                <input type="submit" value="Tạo lớp" class="create-button-cl"/>
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
                                                <a href="changePass.jsp" class="dropdown-item">Đổi mật khẩu</a>
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
                                                var classContainer = document.getElementById("class-container");
                                                var bookContainer = document.getElementById("book-container");
                                                var under2 = document.getElementById("items2");
                                                var under = document.getElementById("items");
                                                var under1 = document.getElementById("items1");
                                                var under3 = document.getElementById("items3");

                                                function handleOpenFolder() {
                                                    folderContainer.style.display = "block";
                                                    studySetContainer.style.display = "none";
                                                    classContainer.style.display = "none";
                                                    bookContainer.style.display = "none";
                                                    under2.classList.toggle("under");
                                                    under.classList.remove("under");
                                                    under3.classList.remove("under");
                                                    under1.classList.remove("under");
                                                }
                                                function handleOpenStudySet() {
                                                    folderContainer.style.display = "none";
                                                    classContainer.style.display = "none";
                                                    studySetContainer.style.display = "block";
                                                    bookContainer.style.display = "none";

                                                    under.classList.toggle("under");
                                                    under2.classList.remove("under");
                                                    under3.classList.remove("under");
                                                    under1.classList.remove("under");
                                                }
                                                function handleOpenClass() {
                                                    folderContainer.style.display = "none";
                                                    studySetContainer.style.display = "none";
                                                    classContainer.style.display = "block";
                                                    bookContainer.style.display = "none";
                                                    under3.classList.toggle("under");
                                                    under2.classList.remove("under");
                                                    under.classList.remove("under");
                                                    under1.classList.remove("under");
                                                }
                                                function handleOpenBook() {
                                                    folderContainer.style.display = "none";
                                                    studySetContainer.style.display = "none";
                                                    classContainer.style.display = "none";
                                                    bookContainer.style.display = "block";
                                                    under1.classList.toggle("under");
                                                    under2.classList.remove("under");
                                                    under.classList.remove("under");
                                                    under3.classList.remove("under");
                                                }

                                                var modal = document.getElementById("myModal");
                                                var modal1 = document.getElementById("myModal1");


                                                function handleOpenDropdown() {
                                                    var element = document.getElementById("content");
                                                    element.classList.toggle("show");
                                                }
                                                function handleOpenDropdownLib() {
                                                    var contentLib = document.getElementsByClassName("dropdown-content-lib")[0];
                                                    var contentLibb = document.getElementsByClassName("dropdown-content-libb")[0];
                                                    if (contentLib.style.display === "") {
                                                        contentLib.style.display = "block";
                                                    } else {
                                                        contentLib.style.display = "";
                                                    }
                                                    if (contentLibb.style.display === "") {
                                                        contentLibb.style.display = "block";
                                                    } else {
                                                        contentLibb.style.display = "";
                                                    }

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
                                                    var elementLib = document.getElementById("content-lib");
                                                    if (!e.target.matches("#dropdown-btn-lib") && elementLib.style.display === "block" && !e.target.matches(".dropdown-item-lib")) {
                                                        elementLib.style.display = "";
                                                    }
                                                    var elementLibb = document.getElementById("content-libb");
                                                    if (!e.target.matches("#dropdown-btn-lib") && elementLibb.style.display === "block" && !e.target.matches(".dropdown-item-lib")) {
                                                        elementLibb.style.display = "";
                                                    }
                                                };

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
