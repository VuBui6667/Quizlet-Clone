<%-- 
    Document   : flashCards
    Created on : Dec 13, 2022, 12:43:59 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thẻ ghi nhớ | Quizlet</title>
        <link rel="stylesheet" href="css/flashCards.css" />
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container-body">
            <div class="title-study-set">${set.getTitle()}</div>
            <div class="container-slide">
                <c:forEach items="${listC}" var="c">
                    <div class="slide">
                        <label>
                            <input type="checkbox" />
                            <div class="flip-card">
                                <div class="front">
                                    ${c.getTerm()}
                                </div>
                                <div class="back">${c.getDefinition()}</div>
                            </div>
                        </label>
                    </div>
                </c:forEach>         
            </div>
            <div class="card-footer">
                <div class="btn-prev" onclick="goPrev()" >Prev</div>
                <div class="btn-next" onclick="goNext()" >Next</div>
            </div>
            <div class="container-cards">
                <div class="container-info">
                    <div class="contain-info">
                        <div class="avt">${requestScope.author.getName().charAt(0)}</div>
                        <div class="container-name">
                            <div>Tạo bởi</div>
                            <div>${requestScope.author.getName()}</div>
                        </div> 
                    </div>
                    <div class="contain-controller" style="${user.getId() != requestScope.author.getId() ? "display: none" : ""}">
                        <div><a href="update?id=${set.getId()}">Sửa</a></div>
                        <div onclick="handleDelete(${set.getId()})">Xóa</div>
                    </div>
                </div>
                <div class="number-card">Thuật ngữ trong phần này (${listC.size()})</div>
                <c:forEach items="${listC}" var="c">
                    <div class="card-item">
                        <div class="card-title">${c.getTerm()}</div>
                        <div class="card-desc">${c.getDefinition()}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
    <script>
        function handleDelete(id) {
            var isConfirm = confirm("Xóa học phần này?");
            if (isConfirm) {
                window.location.href = "http://localhost:8080/projectquizlet/delete?id=" + id;
            }
        }

        const slides = document.querySelectorAll(".slide");
        var count = 0;
        slides.forEach((slide, index) => {
            var pos = index * 100;
            slide.style.left = pos + "%";
        });
        const slideImage = () => {
            slides.forEach(slide => {
                var counter = count * 100;
                slide.style.transform = "translateX(-" + counter + "%)";
            });
        };
        const goNext = () => {
            console.log("next");
            count++;
            slideImage();
        };

        const goPrev = () => {
            count--;
            slideImage();
        };
    </script>
</html>
