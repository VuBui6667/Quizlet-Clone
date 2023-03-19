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
                                    Thêm học phần
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
                    <div class="add-member method-item" onClick ="handleOpenModal5()">
                        <i class="fa-solid fa-user-plus" ></i>
                    </div>
                    <div id="myModal5" class="modal">
                        <div class="modalDel-content">
                            <span class="close" onClick="handleCloseModal5()">×</span>
                            <div class="invite-content">
                                <h2 style="color: white">Mời thành viên</h2>
                            </div>
                            <div class="invite-cont">
                                <p style="padding:5px 20px">Để mời thành viên tham gia lớp học này, hãy nhập tên người dùng hoặc email Quizlet của họ bên dưới (phân tách bằng dấu phẩy hoặc ngắt dòng).</p>
                            </div>
                            <form action="inviteMember" method="post">
                                <div class="content-member">
                                    <div class="content-invite">
                                        <div>
                                            <input class="addmember" type="text" name="addmem" placeholder="Nhập tên người dùng hoặc email">
                                            <span class="tag"></span>
                                        </div>
                                        <span class="invite">Mời thành viên</span>
                                        <input class="classId" value="${c.getId()}" name="classId" />
                                    </div>
                                    <div class="button-member">
                                        <button type="submit" class="invite-button-cl"/>
                                        gửi lời mời
                                    </div>
                                </div>
                            </form>


                        </div>
                    </div>       

                    <div class="add-class method-item" onClick="handleOpenModal3()">
                        <i class="fa-regular fa-folder" ></i>
                    </div>

                    <div id="myModal3" class="modal3">
                        <div class="modal-content3">
                            <span class="close" onClick="handleCloseModal3()">×</span>
                            <div class="header-studySet">
                                Thêm thư mục
                            </div>
                            <div class="create-studySet">
                                <a href="createSet?classId=${f.getId()}" class="button-studySet">+ TẠO THƯ MỤC MỚI</a>
                            </div>
                            <div class="content-container">
                                <c:forEach items="${listFS}" var="f">
                                    <span > 
                                        <div class="item-study-set1">
                                            <div class="title-study-set1">
                                                ${f.getTitle()}
                                                <c:set var="checkAdded" scope="request" value="${d.isAddedFolderInClass(classId,f.getId())}" />
                                                <c:if test="${checkAdded}">
                                                    <i class="fa-solid fa-minus" onclick="sendMethod1(${f.getId()}, ${classId}, 'delete')"></i>
                                                </c:if>
                                                <c:if test="${!checkAdded}">
                                                    <i class="fa-solid fa-plus add-icon" onclick="sendMethod1(${f.getId()}, ${classId}, 'add')"></i>
                                                </c:if>
                                            </div>
                                        </div>
                                    </span>
                                </c:forEach>
                            </div>   
                        </div>
                    </div>
                    <div class="nav-item1 container-dropdown1">
                        <div class="edit-class method-item" onClick ="handleOpenDropdown()">
                            <i class="fa-solid fa-ellipsis"></i>
                        </div>
                        <div id="dropdown-controller" class="dropdown-controller">
                            <button id="myBtn" class="dropdown-item" onClick="handleOpenModal4()">Sửa</a> 
                                <button id="myBtn" class="dropdown-item" onclick="handleOpenModalDel()">Xóa</a> 

                                    </div>
                                    </div>
                                    <div id="myModal4" class="modal">
                                        <div class="modal-content">
                                            <span class="close" onClick="handleCloseModal4()">×</span>
                                            <h1 style="color: white">Sửa lớp</h1>
                                            <p>Sắp xếp tài liệu học của bạn và chia sẻ chúng với bạn học của bạn.</p>
                                            <form action="updateClass" method="post">
                                                <input  class="class-na" type="text" name="classname1" placeholder="Nhập tên lớp (khóa học, giáo viên, năm nay, phần vv)"></br>
                                                <input class="details-cl" type="text" name="detailsclass1" placeholder="Nhập mô tả(tùy chọn)">
                                                <!--<input class="accept" type="checkbox" name="adddel" value="True"/>cho phép các thành viên trong lớp thêm và bỏ học phần</br> </br>--> 
                                                <!--<input class="accept" type="checkbox" name="addpeople" value="True"/>cho phép các thành viên trong lớp mời thành viên mới </br>-->
                                                <input  class="school-na" type="text" name="schoolname1" placeholder="Nhập tên trường của bạn"></br>
                                                <input class="classId" value="${c.getId()}" name="classId" />
                                                <div class="button-folder">
                                                    <input type="submit" value="Sửa lớp" class="create-button-cl"/>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div id="myModalDel" class="modalDel">
                                        <div class="contentdel">
                                            <div class="modalDel-content">
                                                <div class="modal-container">
                                                    <span class="close" onClick="handleCloseModalDel()">×</span>
                                                    <div class="delcontent">
                                                        <div>
                                                            <h3>Xóa lớp này?</h3>
                                                        </div>
                                                    </div>
                                                    <div class="delcontent1">
                                                        <h4>${c.getName()}</h4>
                                                        <h5>Bạn chuẩn bị xoá lớp này. Không ai có thể truy cập vào lớp này nữa.</h5>
                                                        <h5>Bạn có chắc chắn không? Bạn sẽ không được hoàn tác.</h5>
                                                    </div>

                                                </div>
                                                <div class="container-controll">
                                                    <div class="btn-cancel" onClick="handleCloseModalDel()">Hủy</div>
                                                    <form action="classSet" method="POST">
                                                        <input name="classId" value="${classId}" class="input-send"/>
                                                        <button type="submit" class="btn-del">
                                                            Vâng, hãy xóa lớp
                                                    </form>
                                                </div>
                                            </div>
                                        </div>

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
                                                    <form action="search">
                                                        <input type="search" name="search" class="search-input" placeholder="Lọc"/>
                                                        <input type="submit" hidden />
                                                    </form>
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
                                                <c:forEach items="${listFAdded}" var="f">
                                                    <div class="item-study-set" onclick ="handleSelectFolder(${f.getId()})" >
                                                        <div class="size">${f.getNumberStudySet()}</div>
                                                        <div>
                                                            <div class="desc-studySet">
                                                                <div>
                                                                    <i class="fa-regular fa-folder"></i>
                                                                </div>
                                                                <div class="title-studySet">${f.getTitle()}</div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>


                                        <div class="pagedetail">
                                            <div class="link">
                                                <p>Liên kết mời</p>
                                                <input  type="text" value="http://localhost:8080/projectquizlet/classSet?id=${c.getId()}" id="myInput" disabled>
                                                <button onclick="myFunction()" class="btn-copy">Sao chép</button>
                                            </div>
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
                                        var modal3 = document.getElementById("myModal3");
                                        var modal4 = document.getElementById("myModal4");
                                        var modal5 = document.getElementById("myModal5");



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
                                            if (e.target.matches("#myModal3")) {
                                                modal3.style.display = "none";
                                            }
                                            if (e.target.matches("#myModal5")) {
                                                modal5.style.display = "none";
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

                                        function handleOpenModal3() {
                                            modal3.style.display = "block";
                                        }
                                        function handleCloseModal3() {
                                            modal3.style.display = "none";
                                        }
                                        function handleOpenModal4() {
                                            modal4.style.display = "block";
                                        }
                                        function handleCloseModal4() {
                                            modal4.style.display = "none";
                                        }

                                        function handleOpenModal5() {
                                            modal5.style.display = "block";
                                        }
                                        function handleCloseModal5() {
                                            modal5.style.display = "none";
                                        }


                                        function handleSelectStudy(studySetId) {
                                            window.location.href = "flashCards?id=" + studySetId;
                                        }
                                        function handleSelectFolder(folderId) {
                                            window.location.href = "folderSet?id=" + folderId;
                                        }

                                        function sendMethod(studySetId, classId, method) {
                                            console.log(studySetId);
                                            window.location.href = "http://localhost:8080/projectquizlet/controllerClassSet?studySetId=" + studySetId + "&classId=" + classId + "&method=" + method;
                                        }


                                        function sendMethod1(folderId, classId, method) {
                                            window.location.href = "http://localhost:8080/projectquizlet/controllerClassSet?folderId=" + folderId + "&classId=" + classId + "&method=" + method;
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

                                        function myFunction() {
                                            // Get the text field
                                            var copyText = document.getElementById("myInput");

                                            // Select the text field
                                            copyText.select();
                                            copyText.setSelectionRange(0, 99999); // For mobile devices

                                            // Copy the text inside the text field
                                            navigator.clipboard.writeText(copyText.value);

                                            // Alert the copied text
                                            alert("Đã sao chép!");
                                        }

                                    </script>
                                    </html>