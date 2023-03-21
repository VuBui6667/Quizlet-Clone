<%-- 
    Document   : exercises
    Created on : Mar 6, 2023, 2:55:58 PM
    Author     : MSII
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercises</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
            />
        <link rel="stylesheet" href="css/exercises.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="Title">
            <h3>Duyệt sách</h3>
            <div>
                <h5>${e.getExName()}</h5>
                <h6>Chương ${c.getChapterName().substring(7,8)}, trang ${p.getPageName().substring(6,7)}</h6>

                <hr>
            </div>

            <div class="Book row" >

                <div class="col-12 col-md-1 col-sm-4">
                    <img src="https://d2nchlq0f2u6vy.cloudfront.net/cache/f0/5b/f05b21063194c1b8a8c430c213bdce16.jpg" alt="alt"/>
                </div>
                <div class="col-12 col-md-11 col-sm-8" >
                    <h6>${b.getTitle()}</h6>
                    <p>ISBN: ${b.getIsbn()}</p>
                    <a href="">  </a>
                </div>
            </div>
        </div>
        <br>

        <div class="Step">
            <h6>lời giải Trả lời 4 tháng trước</h6>
            <div class="First-Step">
                <h5>Bước 1</h5>
                <h6>${la.get(0).getAnswer()}</h6>
            </div>
            <div>
                <div class="Hidden-Step" >
                    <button type="button" class="btn btn-primary" onclick="handleShowStep()">Tất cả các bước</button>
                </div>
            </div>
            <c:forEach items="${la}" begin="1" end="${la.size()-1}" var="i">
                <div class="Display-Step-Box animate__animated animate__fadeIn">

                    <div class="Display-Step">
                        <h5>Bước ${la.indexOf(i)+1}</h5>
                        <h6>
                            ${i.getAnswer()}
                        </h6>
                    </div>
                </div>
            </c:forEach>

        </div>
    </body>

    <script>
        var step1 = document.getElementsByClassName("Display-Step-Box")[0];
        var showStepBtn = document.getElementsByClassName("Hidden-Step")[0];
        function handleShowStep() {
            showStepBtn.style.display = "none";
            step1.style.display = "block";
        }
    </script> 

</html>
