<%-- 
    Document   : folderSet
    Created on : Feb 13, 2023, 10:19:25 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/85116df733.js"></script>
        <link rel="stylesheet" href="./css/folderSet.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="folderSet-section">
            <div class="control-folderSet">
                <div class="folderSet-info">
                    <p>${listSS.size()} học phần</p>
                    <p>${d.getUserByUserId(f.getUserId()).getName()}</p>                   
                </div>
                <div class="method-folderSet">
                    <div class="add-studySet method-item">
                        <i class="fa-solid fa-plus" onClick="handleOpenModal2()"></i>
                        <div id="myModal2" class="modal1">
                            <div class="modal-content1">
                                <span class="close" onClick="handleCloseModal2()">×</span>
                                <div class="header-studySet">
                                    THÊM HỌC PHẦN
                                </div>
                                <div class="create-studySet">
                                    <a href="createSet?folderId=${f.getId()}" class="button-studySet">+ TẠO HỌC PHẦN MỚI</a>
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
                                                        <c:set var="checkAdded" scope="request" value="${d.isAddedInFolder(folderId,s.getId())}" />
                                                        <c:if test="${checkAdded}">
                                                            <form action="folderSet" method="POST" id="form-delete">
                                                                <input name="folderId" value="${folderId}" class="input-send"/>
                                                                <input name="studySetId" value="${s.getId()}" class="input-send"/>
                                                                <input name="method-form" value="delete" class="input-send"/>
                                                                <i class="fa-solid fa-minus" onclick="submitDelete()"></i>
                                                            </form>
                                                        </c:if>
                                                        <c:if test="${!checkAdded}">
                                                            <form action="folderSet" method="POST" id="form-add">
                                                                <input name="folderId" value="${folderId}" class="input-send"/>
                                                                <input name="studySetId" value="${s.getId()}" class="input-send"/>
                                                                <input name="method-form" value="add" class="input-send"/>
                                                                <i class="fa-solid fa-plus add-icon" onclick="submitAdd()"></i>
                                                            </form>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </span>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="share-folderSet method-item">
                        <i class="fa-solid fa-arrow-up-from-bracket"></i>
                    </div>
                    <div class="edit-folderSet method-item">
                        <i class="fa-solid fa-ellipsis"></i>
                    </div>
                </div>
            </div>

            <div class="folder-author">
                <i class="fa-regular fa-folder"></i>
                <p>${f.getTitle()}</p>
            </div>

            <p class="folder-desc">${f.getDesc()}</p>
            <c:forEach items="${listSS}" var="ss">
                <a href="flashCards?id=${ss.getId()}">
                    <div class="item-study-set">
                        <div class="title-study-set">${ss.getTitle()}</div>
                        <div class="amount-card">${ss.getNumberCard()} thuật ngữ</div>
                        <div class="author-study-set">
                            By ${d.getUserByUserId(ss.getUserId()).getName()}
                        </div>
                    </div>
                </a>
            </c:forEach>
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
        }

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
        
        function submitDelete() {
            var formDelete = document.getElementById("form-delete");
            formDelete.submit();
        }
        
        function submitAdd() {
            var formAdd = document.getElementById("form-add");
            formAdd.submit();
            
        }

    </script>
</html>
