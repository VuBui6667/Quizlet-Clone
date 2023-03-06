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
        <c:if test="${isShare}">
        <div class="container-body">
            <div class="title-study-set">${set.getTitle()}</div>
            <div class="study-preview">
                <div class="preview-item">
                    <a href="study?id=${set.getId()}">Thẻ ghi nhớ</a>
                </div>
                <div class="preview-item">Học</div>
                <div class="preview-item">Kiểm tra</div>
                <div class="preview-item">Ghép thẻ</div>
            </div>
            <div class="container-slide">
                <c:forEach items="${listC}" var="c">
                    <div class="slide">
                        <div class="flip-container" onclick="handleFlipCard(${u.getNumberCard(listC, c)} - 1)">
                            <div class="card-container">
                                <div class="front">
                                    <div class="container-info">
                                        <div>
                                            Thuật ngữ
                                            <i class="fa-regular fa-volume"></i>
                                        </div>
                                        <div class="num-card">${u.getNumberCard(listC, c)} / ${listC.size()}</div>
                                        <i class="fa-solid fa-star"></i>
                                    </div>
                                    <div class="container-content">${c.getTerm()}</div>
                                </div>
                                <div class="back">
                                    <div class="container-info">
                                        <div>Định nghĩa</div>
                                        <div class="num-card">${u.getNumberCard(listC, c)} / ${listC.size()}</div>
                                        <i class="fa-solid fa-star"></i>
                                    </div>
                                    <div class="container-content">${c.getDefinition()}</div>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer">
                            <div class="btn-prev" onclick="goPrev()" ><i class="fa-solid fa-angle-left"></i></div>
                            <div class="btn-next" onclick="goNext(${u.getNumberCard(listC, c)}, ${listC.size()})" ><i class="fa-solid fa-angle-right"></i></div>
                        </div>
                    </div>
                </c:forEach>    
                <div id="list-size">${listC.size()}</div>
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
                        <div class="item-controller"><i class="fa-solid fa-plus"></i></div>
                        <div class="item-controller"><i class="fa-regular fa-share-from-square"></i></div>
                        <div class="item-controller"><a href="update?id=${set.getId()}"><i class="fa-solid fa-pencil"></i></a></div>
                        <div class="item-controller" onclick="handleOpenModalDel()"><i class="fa-regular fa-trash-can"></i></div>
                    </div>
                </div>
                <div id="myModalDel" class="modalDel">
                    <div class="modalDel-content">
                        <div class="modal-container">
                            <span class="close" onClick="handleCloseModalDel()">×</span>
                            <h1>Xóa học phần này?</h1>
                            <h2>${set.getTitle()}</h2>
                            <h4>Bạn sắp xoá học phần này và toàn bộ dữ liệu trong đó. Không ai có thể truy cập vào học phần này nữa.</h4>
                            <p>Bạn có chắc chắn không? Bạn sẽ không được hoàn tác.</p>
                        </div>
                        <div class="container-controll">
                            <div class="btn-cancel" onClick="handleCloseModalDel()">Hủy</div>
                            <div class="btn-del" onclick="handleDelete(${set.getId()})">
                                Vâng, hãy xóa học phần
                            </div>
                        </div>
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
        </c:if>
        <c:if test="${!isShare}">
            <div class="container-block">
                <h1 class="title-block">Học phần đã được bảo vệ</h1>
                <p class="sub-title">Rất tiếc, chúng tôi cần sự riêng tư!</p>
            </div>
        </c:if>
    </body>
    <script>

        function handleFlipCard(i) {
            var cards = document.querySelectorAll(".card-container");
            if (cards[i].style.transform === "") {
                cards[i].style.transform = "rotateX(180deg)"
            } else {
                cards[i].style.transform = "";
            }
        }

        function handleDelete(id) {
                window.location.href = "http://localhost:8080/projectquizlet/delete?id=" + id;
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
            cards = document.querySelectorAll(".card-container");
            cards.forEach(card => {
                card.style.transform = "";
            });
        };
        
        
        var listSize = document.getElementById("list-size");
        var size = parseInt(listSize.innerHTML);
        
        const goNext = () => {
            if (count < size - 1) {
                count++;
                slideImage();
            }
        };

        const goPrev = () => {
            if(count > 0) {
                count--;
            }
            slideImage();
        };

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
        };
        
        window.onkeydown = function(e) {
            if(e.keyCode === 39) {
                goNext();
            }
            if(e.keyCode === 37) {
                goPrev();
            }
            if(e.keyCode === 32) {
                e.preventDefault();
                handleFlipCard(count);
            }
        };
    </script>
</html>
