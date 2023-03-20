<%-- 
    Document   : learn
    Created on : Mar 11, 2023, 10:55:12 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
        <link rel="stylesheet" href="css/learn.css" />
    </head>
    <body>
        <div class="container-study">
            <div class="header-study">
                <div class="controll-item">Học &nbsp;<i class="fa-solid fa-chevron-down"></i></div>
                <div class="controll-item">
                    <c:forEach items="${listC}" var="c">
                        <div class="num-card">${u.getNumberCard(listC, c)} / ${listC.size()}</div>
                    </c:forEach>
                    <c:if test="${(listC.size() + listCM.size()) / allCard.size() == 1}">
                        ${d.getStudySetById(studySetId).getTitle()}
                    </c:if>
                </div>
                <div class="controll-item">
                    <div>Tùy chọn</div>
                    <div id="close-btn" onclick="handleAddLearnedCard()"><i class="fa-solid fa-xmark"></i></div>
                </div>
            </div>
            <div id="progress-study"></div>
            <div class="container-slide">
                <div id="contain-slide">
                    <c:set var="listCard" value="${listC}" />
                    <c:forEach items="${listCard}" var="c">
                        <div class="slide">
                            <div class="card-container">
                                <div class="type-card">
                                    Định nghĩa
                                    <div class="try-again">Hãy thử lại lần nữa</div>
                                </div>
                                <div class="content-card">${c.getTerm()}</div>
                                <div class="container-answer">
                                    <div class="title-type">Chọn thuật ngữ đúng</div>
                                    <div class="contain-answer">
                                        <c:set var="listA" value="${d.getAnswer(listC, c)}" />
                                        <c:set var="idxRightAns" value="${d.checkDup(listA, c)}" />
                                        <c:forEach items="${listA}" var="a">
                                            <div class="answer-item" onclick="handleSelectAnswer(${c.getId()}, ${a.getId()}, ${listA.indexOf(a)+1}, ${listC.indexOf(c)+1}, ${idxRightAns})">${a.getDefinition()}</div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>  
                </div>
            </div>
            <div class="continue-question animate__animated animate__fadeInRight" onclick="goNext()">Tiếp tục</div>
            <div class="container-complete animate__animated animate__zoomIn">
                <div class="header-complete">
                    <h1 class="title-complete">Bạn sẽ làm được, tiếp tục cố gắng nhé!</h1>
                    <p class="progress-title">${listC.size() + listCM.size()} / ${allCard.size()} thuật ngữ</p>
                    <div id="progress-bar">
                        <div id="progress-control" style="width: ${(listC.size() + listCM.size()) / allCard.size() * 100}%"></div>
                    </div>
                </div>
                <div class="contain-complete">
                    <p class="contain-title">Thuật ngữ đã học trong vòng này</p>
                    <c:forEach items="${listC}" var="c">
                        <div class="card-item">
                            <div class="card-title">${c.getTerm()}</div>
                            <div class="card-desc">${c.getDefinition()}</div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="container-done animate__animated animate__zoomIn">
                <div class="container-img">
                    <img src="https://assets.quizlet.com/a/j/dist/app/i/tasks/sequence_completion/non_plus/Quizlet_Trophy@1x.622781cfc40c59e.png" alt="alt"/>
                </div>
                <h1>Chúc mừng! Bạn đã học hết các nội dung.</h1>
                <p>Học lại để luyện tập các câu hỏi tương tự, hoặc thử một chế độ học khác.</p>
                <div class="container-btn">
                    <div class="btn-test">Học xong</div>
                    <div class="btn-reset" onclick="handleReset(${studySetId})">Học lại</div>
                </div>
            </div>
            <div id="studySetId">${studySetId}</div>
            <div id="learn-size">${listC.size()}</div>
            <div id="mastered-size">${listCM.size()}</div>
            <div id="allCard-size">${allCard.size()}</div>
        </div>
    </body>
    <script src="https://kit.fontawesome.com/85116df733.js"></script>
    <script>
        
        let slides = document.querySelectorAll(".slide");
        let learnSize = parseInt(document.getElementById("learn-size").innerHTML);
        let masteredSize = parseInt(document.getElementById("mastered-size").innerHTML);
        let allCardSize = parseInt(document.getElementById("allCard-size").innerHTML);
        let containerComplete = document.getElementsByClassName("container-complete")[0];
        let containerSlide = document.getElementsByClassName("container-slide")[0];
        let containerDone = document.getElementsByClassName("container-done")[0];
        var count = 0;
        const numCards = document.querySelectorAll(".num-card");
        
        setTimeout(function () {
            if((masteredSize + count) - allCardSize === 0) {
                slideImage();
            }
            numCards.forEach(numCard => {
                if (numCard === numCards[count]) {
                    numCard.style.display = "block";
                } else {
                    numCard.style.display = "none";
                }
            });
        }, 0);
        
        slides.forEach((slide, index) => {
            var pos = index * 100;
            slide.style.left = pos + "%";
        });
        const slideImage = () => {
            numCards.forEach(numCard => {
                if (numCard === numCards[count]) {
                    numCard.style.display = "block";
                } else {
                    numCard.style.display = "none";
                }
            });
            slides.forEach(slide => {
                var counter = count * 100;
                slide.style.transform = "translateX(-" + counter + "%)";
            });
            if(learnSize - count === 0) {
                containerSlide.style.display = "none";
                containerComplete.style.display = "block";
            }
            if((masteredSize + count) - allCardSize === 0) {
                containerComplete.style.display = "none";
                containerDone.style.display = "block";
            }
        };
        const goNext = () => {
            count++;
            slideImage();
            continueBtn.style.display = "none";
        };
        
        let continueBtn = document.getElementsByClassName("continue-question")[0];
        
        var containSlide = document.getElementById("contain-slide");
        
        var numSlide = slides.length;
        
        let listQuestion = [];
        
        var studySetId = document.getElementById("studySetId").innerHTML;
        
        const numAns = learnSize < 4 ? learnSize : 4;
        
        
        function handleSelectAnswer(c, a, idx, numQuest, idxRightAns) {   
            let listA = document.getElementsByClassName("answer-item");
            slides = document.querySelectorAll(".slide");
            var ansSelect = listA[count*numAns+idx-1];
            if(c !== a) {
                learnSize++;
                allCardSize++;
                var currentSlide = slides[count];
                var newSlide = currentSlide.cloneNode(true);
                newSlide.style.left = numSlide*100 + "%";
                numSlide++;
                tryBtn = newSlide.getElementsByClassName("try-again")[0];
                tryBtn.style.display = "block";
                containSlide.appendChild(newSlide);
                continueBtn.style.display = "block";
                ansSelect.classList.add("wrong-answer");
                var rightAns = listA[(numQuest-1)*4 + idxRightAns];
                rightAns.classList.add("right-answer");
            } else {
                listQuestion.push(c);
                ansSelect.classList.add("right-answer");
                setTimeout(function () {
                    goNext();
                    ansSelect.classList.remove("right-answer");
                }, 1500);
            }
        }
      
        
        function handleAddLearnedCard() {
            if(listQuestion.length !== 0) {
                window.location.href = "http://localhost:8080/projectquizlet/addLearnedCard?studySetId=" + studySetId + "&cardId=" + listQuestion.join(',');
            } else {
                window.location.href = "http://localhost:8080/projectquizlet/flashCards?id=" + studySetId;
            }
        }
        
        function handleReset(studySetId) {
            window.location.href = "http://localhost:8080/projectquizlet/resetLearnedCard?studySetId=" + studySetId;
        }
    </script>
</html>
