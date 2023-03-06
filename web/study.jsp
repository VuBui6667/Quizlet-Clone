<%-- 
    Document   : study
    Created on : Mar 5, 2023, 5:41:16 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thẻ ghi nhớ</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="css/study.css" />
    </head>
    <body>
        <div id="load"></div>
        <div class="container-study">
            <div class="header-study">
                <div class="controll-item">Thẻ ghi nhớ &nbsp;<i class="fa-solid fa-chevron-down"></i></div>
                <div class="controll-item">
                    <c:forEach items="${listC}" var="c">
                        <div class="num-card">${u.getNumberCard(listC, c)} / ${listC.size()}</div>
                    </c:forEach>
                    <div class="title-flashCard">${set.getTitle()}</div>
                </div>
                <div class="controll-item">
                    <div>Tùy chọn</div>
                    <div id="close-btn"><i class="fa-solid fa-xmark"></i></div>
                </div>
            </div>
            <div id="progress-study"></div>
            <div class="body-study">
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
                    <div id="user-id">${user.getId()}</div>
                    <div id="studySet-id">${set.getId()}</div>
                    <div id="current-numCard">${currentNumCard}</div>
                </div>
            </div>
        </div>
    </body>
    <script src="https://kit.fontawesome.com/85116df733.js"></script>
    <script>
        function handleFlipCard(i) {
            var cards = document.querySelectorAll(".card-container");
            if (cards[i].style.transform === "") {
                cards[i].style.transform = "rotateX(180deg)";
            } else {
                cards[i].style.transform = "";
            }
        }
        
        const slides = document.querySelectorAll(".slide");
        const numCards = document.querySelectorAll(".num-card");
        const currentNumCard = document.getElementById("current-numCard").innerHTML;
        
        var listSize = document.getElementById("list-size");
        var size = parseInt(listSize.innerHTML);
        
        var numStudiedCard = currentNumCard;
        
        var count = currentNumCard;  
        
        slides.forEach((slide, index) => {
            var pos = index * 100;
            slide.style.left = pos + "%";
        });
        const slideImage = () => {  
            numCards.forEach(numCard => {
                if(numCard === numCards[count]) {
                    numCard.style.display = "block";
                } else {
                    numCard.style.display = "none";
                }
            });
            const progressStudy = document.getElementById("progress-study");
            var width = count*(100/size) + "%";
            progressStudy.style.width = width;
            slides.forEach(slide => {
                var counter = count * 100;
                slide.style.transform = "translateX(-" + counter + "%)";
            });
            cards = document.querySelectorAll(".card-container");
            cards.forEach(card => {
                card.style.transform = "";
            });
        };
        
        const goNext = () => {
            if(count < size-1) {
                count++;
                slideImage();
                if(numStudiedCard < size) {
                    numStudiedCard++;
                }
            }
        };
        
        var load = document.getElementById("load");
        
        setTimeout(function() {
            slideImage();
        }, 0);
        
        setTimeout(function() {
            load.style.display = "none";
        }, 500);

        const goPrev = () => {
            if(count > 0) {
                count--;
                numStudiedCard--;
            }
            slideImage();
        };
        
        window.onkeydown = function(e) {
            e.preventDefault();
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
        
        var userId = document.getElementById("user-id").innerHTML;
        var studySetId = document.getElementById("studySet-id").innerHTML;
        
        let closeBtn = document.getElementById("close-btn");
        closeBtn.onclick = function(e) {
            console.log("test");
            window.location.href = "http://localhost:8080/projectquizlet/addStudiedCard?userId=" + userId + "&studySetId=" + studySetId + "&numCard=" + numStudiedCard;
        };
        

    </script>
</html>
