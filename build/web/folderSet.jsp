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
        <link rel="stylesheet" href="css/folderSet.css"/>
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
                                                        <i class="fa-solid fa-minus" onclick="sendMethod(${s.getId()}, ${folderId}, 'delete')"></i>
                                                    </c:if>
                                                    <c:if test="${!checkAdded}">
                                                        <i class="fa-solid fa-plus add-icon" onclick="sendMethod(${s.getId()}, ${folderId}, 'add')"></i>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </span>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="share-folderSet method-item"  >
                        <i class="fa-solid fa-arrow-up-from-bracket" onclick="handleOpenModalShare()"></i>
                    </div>
                    <div class="edit-folderSet method-item">
                        <i class="fa-solid fa-ellipsis" onclick="handleOpenDropdown()"></i>
                        <div id="dropdown-controller" class="dropdown-controller">
                            <button id="myBtn" class="dropdown-item" onclick="handleOpenModalEdit()">Sửa</button>
                            <button id="myBtn" class="dropdown-item" onclick="handleOpenModalDel()">Xóa</a> 
                        </div>
                        <div id="myModalEdit" class="modal">
                            <div class="modal-content">
                                <span class="close" onClick="handleCloseModalEdit()">×</span>
                                <h1 >Sửa thư mục</h1>
                                <form action="updateFolder" method="post">
                                    <input class="folderId" value="${f.getId()}" name="folderId" /></br>
                                    <input class="title" value="${f.getTitle()}" type="text" name="title" placeholder="Nhập tiêu đề"></br>
                                    <input class="details" value="${f.getDesc()}" type="text" name="desc" placeholder="Nhập mô tả(tùy chọn)">
                                    <div class="button-folder">
                                        <input type="submit" value="Lưu" class="create-button"/>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div id="myModalShare" class="modal">
                            <div class="modal-content-share">
                                <span class="close" onClick="handleCloseModalShare()">×</span>
                                <div class="share-container">
                                    <div class="title-share">Chia sẻ thư mục này</div>
                                </div>

                                <div class="share-body">
                                    <form action="share" method="post">
                                        <input class="folderId" value="${f.getId()}" name="folderId" /></br>
                                        <input class="email" type="text" name="title" placeholder="Chia sẻ liên kết qua email">
                                        <input type="submit" value="Gửi email" class="shared-button"/>
                                    </form>

                                    <div class="links">
                                        <input disabled type="text" value="http://localhost:8080/projectquizlet/folderSet?id=${f.getId()}"  id="myInput">
                                        <button onclick="myFunction()">Chép liên kết</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="myModalDel" class="modalDel">
                        <div class="modalDel-content">
                            <div class="modal-container">
                                <span class="close" onClick="handleCloseModalDel()">×</span>
                                <h1>Xóa thư mục</h1>
                                <h2>${set.getTitle()}</h2>
                                <h4>Xóa thư mục là thao tác VĨNH VIỄN. Bạn không thể hoàn tác.</h4>
                                <h4>Bạn chắc chắn muốn xóa thư mục này? Học phần trong thư mục này sẽ không bị xoá.</h4>
                            </div>
                            <div class="container-controll">
                                <div class="btn-cancel" onClick="handleCloseModalDel()">Hủy</div>
                                <form action="folderSet" method="POST">
                                    <input name="folderId" value="${folderId}" class="input-send"/>
                                    <button type="submit" class="btn-del">
                                        Xóa thư mục
                                        </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="folder-author">
                <i class="fa-regular fa-folder"></i>
                <p>${f.getTitle()}</p>
            </div>
            <p class="folder-desc">${f.getDesc()}</p>
            <c:if test="${listSS.size() != 0}">
                <div class="container-studySet">
                    <c:forEach items="${listSS}" var="ss">
                        <div class="item-study-set" onclick="handleSelectStudy(${ss.getId()})">
                            <div class="title-study-set">${ss.getTitle()}
                                <i class="fa-solid fa-folder-minus" onclick="sendMethod(${ss.getId()}, ${folderId}, 'delete')"></i>
                            </div>
                            <div class="amount-card">${ss.getNumberCard()} thuật ngữ</div>
                            <div class="author-study-set">
                                By ${d.getUserByUserId(ss.getUserId()).getName()}
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${listSS.size() == 0}">
                <div class="empty-folder">
                    <h3>Thư mục này chưa có học phần</h3>
                    <p>Sắp xếp học phần cho bạn và học sinh của bạn.</p>
                    <button onClick="handleOpenModal2()">Thêm Học Phần</button>
                </div>
            </c:if>
        </div>

    </body>
    <script>
        var modal = document.getElementById("myModal");
        var modal2 = document.getElementById("myModal2");
        var modalEdit = document.getElementById("myModalEdit");
        var modalShare = document.getElementById("myModalShare");


        function handleOpenDropdown() {
            var element = document.getElementById("content");
            element.classList.toggle("show");
        }

        function myFunction() {
            var copyText = document.getElementById("myInput");
            copyText.select();
            copyText.setSelectionRange(0, 99999); // For mobile devices
            navigator.clipboard.writeText(copyText.value);
        }

        window.onclick = function (e) {
            var element = document.getElementById("content");
            if (!e.target.matches("#dropdown-btn") && element.classList.contains("show")) {
                element.classList.remove("show");
            }
            if (!e.target.matches(".fa-ellipsis") && dropdownController.classList.contains("show")) {
                dropdownController.classList.remove("show");
            }
            if (e.target.matches("#myModal")) {
                modal.style.display = "none";
            }
            if (e.target.matches("#myModal2")) {
                modal2.style.display = "none";
            }
            if (e.target.matches("#myModalEdit")) {
                modalEdit.style.display = "none";
            }
            if (e.target.matches("#myModalShare")) {
                modalShare.style.display = "none";
            }
            if (e.target.matches("#myModalDel")) {
                modalDel.style.display = "none";
            }

        };

        function handleOpenSetting() {
            var element = document.getElementById("content2");
            element.classList.toggle("show");
        }

        function handleOpenModal() {
            modal.style.display = "block";
        }

        function handleOpenModalEdit() {
            modalEdit.style.display = "block";
        }
        function handleOpenModalShare() {
            modalShare.style.display = "block";
        }
        function handleCloseModalShare() {
            modalShare.style.display = "none";
        }

        function handleCloseModalEdit() {
            modalEdit.style.display = "none";
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

        function sendMethod(studySetId, folderId, method) {
            window.location.href = "http://localhost:8080/projectquizlet/controllerFolderSet?studySetId=" + studySetId + "&folderId=" + folderId + "&method=" + method;
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

//        window.onclick = function (e) {
//            if (e.target.matches("#myModalDel")) {
//                modalDel.style.display = "none";
//            }
//            if(!e.target.matches(".fa-ellipsis") && dropdownController.classList.contains("show")) {
//                dropdownController.classList.remove("show");
//            }
//        };

    </script>
</html>
