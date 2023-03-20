<%-- 
    Document   : classSet
    Created on : Mar 1, 2023, 1:00:02 AM
    Author     : vieta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dal.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/85116df733.js"></script>
        <link rel="stylesheet" href="css/classSet.css" />
    </head>
    <body>

        <%@include file="header.jsp" %>
        <div class="classSet-section">
            <div class="control-classSet">
                <div class="classSet-info">
                    <div class="icon-class">
                        <i class="fa-solid fa-user-group"></i>
                    </div>
                    <div class="class-author">
                        <p style ="margin-top: 0px;">${c.getName()}</p>

                    </div>
                </div>
                <div class="method-classSet">
                    <div class="add-studySet method-item">
                        <i class="fa-solid fa-plus" onClick="handleOpenModal2()"></i>
                        <div id="myModal2" class="modal1">
                            <div class="modal-content1">
                                <span class="close" onClick="handleCloseModal2()">×</span>
                                <div class="header-studySet">
                                    THÊM HỌC PHẦN
                                </div>
                                <div class="create-studySet">
                                    <a href="createSet?classId=${f.getId()}" class="button-studySet">+ TẠO HỌC PHẦN MỚI</a>
                                </div>
                                <div class="combo-box">
                                    <select class="combo-box1"> <i class="fa-solid fa-chevron-down"></i>
                                        <option style="color: black" value="yourSets">Học phần của bạn</option>
                                        <option style="color: black" value="classSets">Học phần của lớp</option>
                                        <option style="color: black" value="studiedSets">Học phần đã học</option>
                                    </select> 
                                </div>
                                <div class="content-container">
                                    <c:forEach items="${listS}" var="s">
                                        <span > 
                                            <div class="item-study-set1">
                                                <div class="title-study-set1">
                                                    ${s.getTitle()}
                                                    <c:set var="checkAdded" scope="request" value="${d.isAddedInClass(classId,s.getId())}" />
                                                    <c:if test="${checkAdded}">
                                                        <i class="fa-solid fa-minus" onclick="sendMethod(${s.getId()}, ${classId}, 'delete')"></i>
                                                    </c:if>
                                                    <c:if test="${!checkAdded}">
                                                        <i class="fa-solid fa-plus add-icon" onclick="sendMethod(${s.getId()}, ${classId}, 'add')"></i>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </span>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="add-member method-item">
                        <i class="fa-solid fa-user-plus"></i>
                    </div>
                    <div class="add-class method-item">
                        <i class="fa-regular fa-folder"></i>
                    </div>

                    <div class="edit-class method-item">
                        <i class="fa-solid fa-ellipsis"></i>
                    </div>
                </div>
            </div>

            <div class="contai-home">
                <div class="class-contai">
                    <div class="cate-class">
                        <a href="" class="title-container-class">Các học phần</a>
                        <a href="" class="title-container-class">Thành Viên</a>
                    </div>
                </div>
            </div>


            <div class=descrip id="description">
                <div class = "main">
                    <div class="task-bar">
                        <div class="arrange">
                            <div> 
                                <h6>SẮP XẾP</h6>
                            </div>
                            <div>
                                <button  class="btn-folder">Gần đây &nbsp;&nbsp;<i class="fa-solid fa-chevron-down"></i></button>
                            </div>
                        </div>
                        <div class="filter">
                            <p>search</p>
                        </div>

                    </div>



                    <div class="container-studySet">
                        <c:forEach items="${listSS}" var="ss">
                            <div class="item-study-set" onclick="handleSelectStudy(${ss.getId()})">
                                <div>
                                    <div class="amount-card">${ss.getNumberCard()} thuật ngữ</div>
                                    <p class="bar">|</p>
                                    <div class="author-study-set">
                                        <span class="user-avatar-sub"><%= user.getName().charAt(0)%></span>
                                        By ${d.getUserByUserId(ss.getUserId()).getName()}
                                    </div>
                                    <p class="bar">|</p>
                                    <div class="desc-studySet">
                                        ${ss.getDescription()}
                                    </div>
                                </div>
                                <div class="title-studySet">${ss.getTitle()}</div>
                            </div>
                        </c:forEach>
                    </div>
                </div>


                <div class="pagedetail">
                    <p>Chi tiết lớp học</p>
                    <div class="item-deltail">
                        <div class ="items-mini1">
                            <i class="fa-solid fa-school"></i>
                            <p>${c.getSchoolName()}</p>
                        </div>
                        <div class ="items-mini1">
                            <i class="fa-regular fa-folder"></i>
                            <p>${listSS.size()} Học phần</p>
                        </div>
                        <div class ="items-mini1">
                            <i class="fa-regular fa-user"></i>
                            <p>1 people</p>
                        </div>
                        <div class ="items-mini1">
                            <i class="fa-solid fa-circle-info"></i>
                            <p>${c.getDesc()}</p>
                        </div>
                    </div>

                </div>

            </div>

        </div>
    </body>

    <script>
        var modal = document.getElementById("myModal");
        var modal2 = document.getElementById("myModal2");


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
            if (e.target.matches("#myModal2")) {
                modal2.style.display = "none";
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

        function handleOpenModal2() {
            modal2.style.display = "block";
        }

        function handleCloseModal2() {
            modal2.style.display = "none";
        }

        function handleSelectStudy(studySetId) {
            window.location.href = "flashCards?id=" + studySetId;
        }

        function sendMethod(studySetId, classId, method) {
            console.log(studySetId);
            window.location.href = "http://localhost:8080/projectquizlet/controllerClassSet?studySetId=" + studySetId + "&classId=" + classId + "&method=" + method;
        }

        var dropdownController = document.getElementById("dropdown-controller");

        function handleOpenDropdown() {
            dropdownController.classList.toggle("show");
        }

        var modalDel = document.getElementById("myModalDel");

        function handleOpenModalDel() {
            modalDel.style.display = "block";
        }

        function handleCloseModalDel() {
            modalDel.style.display = "none";
        }

        window.onclick = function (e) {
            if (e.target.matches("#myModalDel")) {
                modalDel.style.display = "none";
            }
            if (!e.target.matches(".fa-ellipsis") && dropdownController.classList.contains("show")) {
                dropdownController.classList.remove("show");
            }
        };

    </script>
</html>