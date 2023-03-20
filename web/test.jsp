<%-- 
    Document   : test
    Created on : Dec 14, 2022, 7:50:54 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="css/test.css" />
    </head>
    <body>
        <div class="container-test">
            <div class="header-test">
                <div class="controll-item">Kiểm tra &nbsp;<i class="fa-solid fa-chevron-down"></i></div>
                <div class="controll-item">
                    <div class="num-card">1/15</div>
                    <div class="title-flashCard">${set.getTitle()}</div>
                </div>
                <div class="controll-item">
                    <div>Tùy chọn</div>
                    <div id="close-btn"><a href="flashCards?id=${set.getId()}"><i class="fa-solid fa-xmark"></i></a></div>
                </div>
            </div>

            <div class="container-result">
                <h1>Đừng bỏ cuộc lúc này! Hãy vững tin.</h1>
                <div class="contain-result">
                    <div class="container-info">
                        <p>Kết quả:</p>
                        <div class="contain-right">
                            <span>Đúng</span>
                            <div class="num-right">4</div>
                        </div>
                        <div class="contain-wrong">
                            <span>Sai</span>
                            <div class="num-wrong">11</div>
                        </div>
                    </div>
                    <div class="container-continue">
                        <p>Bước tiếp theo</p>
                        <div class="mode">
                            <a href="learn?id=${set.getId()}">
                                <p>Ôn luyện thuật ngữ trong chế độ học</p>
                                <p>Ôn luyện các thuật ngữ bạn bỏ lỡ cho đến khi bạn nắm chắc.</p>
                            </a>
                        </div>
                        <div class="mode">
                            <a href="test?id=${set.getId()}">
                                <p>Làm bài kiểm tra mới</p>
                                <p>Hãy thử một bài kiểm tra khác để tăng sự tự tin của bạn</p>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container-question">
                <c:forEach var="i" begin="0" end="${listCTF.size()-1}">
                    <div class="question-item">
                        <div class="content-question">
                            <div class="title-question">
                                <p>Thuật ngữ</p>
                                <p>${listCTF.get(i).getTerm()}</p>
                            </div>
                            <div class="desc-question">
                                <p>Định nghĩa</p>
                                <p>${listATF.get(i).getDefinition()}</p>
                            </div>
                        </div>
                        <div class="select-title">Chọn câu trả lời</div>
                        <div class="container-answer">
                            <div class="btn-right select-hover" onclick="handleSelectRight(${listCTF.get(i).getId()}, ${listATF.get(i).getId()}, ${i})">Đúng</div>
                            <div class="btn-wrong select-hover" onclick="handleSelectWrong(${listCTF.get(i).getId()}, ${listATF.get(i).getId()}, ${i})">Sai</div>
                        </div>
                        <div class="container-right">
                            <div class="right-ans-title">Định nghĩa đúng</div>
                            <div class="right-ans-btn">${listCTF.get(i).getDefinition()}</div>
                        </div>
                    </div>
                </c:forEach>
                <c:forEach items="${listCMC}" var="x">
                    <div class="card-container">
                        <div class="type-card">
                            Thuật ngữ
                        </div>
                        <div class="content-card">${x.getTerm()}</div>
                        <div class="container-multiple">
                            <div class="title-type">Chọn định nghĩa đúng</div>
                            <div class="contain-answer">
                                <c:set var="listA" value="${d.getAnswer(listCMC, x)}" />
                                <c:set var="idxRightAns" value="${d.checkDup(listA, x)}" />
                                <c:forEach items="${listA}" var="a">
                                    <div class="answer-item select-hover" onclick="handleSelectAnswer(${x.getId()}, ${a.getId()}, ${listA.indexOf(a)+1}, ${listCMC.indexOf(x)}, ${idxRightAns+1})">${a.getDefinition()}</div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:forEach>  
            </div>
            <div class="container-submit">
                <img src="https://assets.quizlet.com/a/j/dist/app/i/test_results_redesign/practice_test_icon.05a527b6537677b.svg" alt="alt"/>
                <h1>Tất cả đã xong! Bạn đã sẵn sàng gửi bài kiểm tra?</h1>
                <div class="btn-submit" onclick="handleSubmit()">Gửi bài kiểm tra</div>
            </div>
        </div>
        <div id="sizeCTF">${listCTF.size()}</div>
        <div id="sizeCMC">${listCMC.size()}</div>
    </body>
    <script src="https://kit.fontawesome.com/85116df733.js"></script>
    <script>
        var listRight = document.querySelectorAll(".btn-right");
        var listWrong = document.querySelectorAll(".btn-wrong");
        var containerResult = document.getElementsByClassName("container-result")[0];
        var selectTitle = document.getElementsByClassName("select-title");
        var containerRight = document.getElementsByClassName("container-right");
        var titleType = document.getElementsByClassName("title-type");
        let listA = document.getElementsByClassName("answer-item");
        let numRight = document.getElementsByClassName("num-right")[0];
        let numWrong = document.getElementsByClassName("num-wrong")[0];

        var count = 0;

        var right = 0;
        var wrong = 0;

        let arrayAns = [];

        var numCardTF = parseInt(document.getElementById("sizeCTF").innerHTML);
        var numCardMC = parseInt(document.getElementById("sizeCMC").innerHTML);
        var totalCard = numCardMC + numCardTF;
        for (var i = 0; i < totalCard; i++) {
            arrayAns[i] = null;
        }

        function handleSelectRight(questionId, ansId, i) {
            if (listWrong[i].classList.contains("select-ans")) {
                listWrong[i].classList.toggle("select-ans");
                listWrong[i].classList.toggle("select-hover");
            }
            listRight[i].classList.toggle("select-ans");
            listRight[i].classList.toggle("select-hover");
            if (questionId === ansId) {
                arrayAns[i] = true;
            } else {
                arrayAns[i] = false;
            }
            console.log(arrayAns);
        }

        function handleSelectWrong(questionId, ansId, i) {
            if (listRight[i].classList.contains("select-ans")) {
                listRight[i].classList.toggle("select-ans");
                listRight[i].classList.toggle("select-hover");
            }
            listWrong[i].classList.toggle("select-ans");
            listWrong[i].classList.toggle("select-hover");
            if (questionId !== ansId) {
                arrayAns[i] = true;
            } else {
                arrayAns[i] = false;
            }
            console.log(arrayAns);
        }


        function handleSelectAnswer(c, a, idx, numQuest, idxRightAns) {
            var ansSelect = numQuest * 4 + idx - 1;
            var i = numQuest * 4;
            var n = i + 4;
            var idxRight = (numQuest*4) + idxRightAns - 1;
            listA[idxRight].classList.add("right-ans");
            for (i; i < n; i++) {
                if (listA[i].classList.contains("select-ans")) {
                    listA[i].classList.toggle("select-ans");
                    listA[i].classList.toggle("select-hover");
                }
            }
            listA[ansSelect].classList.toggle("select-ans");
            listA[ansSelect].classList.toggle("select-hover");
            if (idxRightAns === idx) {
                arrayAns[numQuest + numCardTF] = true;
            } else {
                arrayAns[numQuest + numCardTF] = false;
            }
            console.log(arrayAns);
        }
        
        function handleSubmit() {
            containerResult.style.display = "flex";
            window.scrollTo({ top: 0, behavior: 'smooth' });
            console.log(arrayAns);
            for(var i=0; i<numCardTF; i++) {
                if(arrayAns[i]) {
                    if(listRight[i].classList.contains("select-ans")) {
                        listRight[i].classList.add("show-right");
                        selectTitle[i].innerHTML = "Tuyệt vời!";
                        selectTitle[i].style.color = "#23b26d";
                    } else {
                        listWrong[i].classList.add("show-right");
                        selectTitle[i].innerHTML = "Bạn đang làm rất tuyệt!";
                        selectTitle[i].style.color = "#23b26d";
                        containerRight[i].style.display = "block";
                    }
                } else {
                    if(listRight[i].classList.contains("select-ans")) {
                        listRight[i].classList.add("show-wrong");
                        selectTitle[i].innerHTML = "Đừng lo, bạn vẫn đang học mà!";
                        selectTitle[i].style.color = "#ff725b";
                        containerRight[i].style.display = "block";
                    } else {
                        listWrong[i].classList.add("show-wrong");
                        selectTitle[i].innerHTML = "Đừng lo, bạn vẫn đang học mà!";
                        selectTitle[i].style.color = "#ff725b";
                    }
                }
            }
            for(var i=numCardMC; i<totalCard; i++) {
                var j = 4*(i-5);
                var n = j+4;
                for(var j; j<n; j++) {
                    if(arrayAns[i]) {
                        if(listA[j].classList.contains("select-ans")) {
                            listA[j].classList.add("show-right");
                            titleType[i-5].innerHTML = "Bạn sẽ làm được!";
                            titleType[i-5].style.color = "#59e8b5";
                        } 
                    } else {
                        if(listA[j].classList.contains("select-ans")) {    
                            listA[j].classList.add("show-wrong");
                            titleType[i-5].innerHTML = "Đừng nản chí, học là một quá trình!";
                            titleType[i-5].style.color = "#ff7873";
                        }
                        if(listA[j].classList.contains("right-ans")) {
                            listA[j].classList.add("show-right");
                        }
                    }
                }
            }
            var countRight = 0;
            for(var i=0; i<arrayAns.length; i++) {
                if(arrayAns[i]) {
                    countRight++;
                }
            }
            var countWrong = arrayAns.length - countRight;
            numRight.innerHTML = countRight;
            numWrong.innerHTML = countWrong;
        }


    </script>
</html>
