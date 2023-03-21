<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dal.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lời giải chuyên gia</title>
        <script src="https://kit.fontawesome.com/1c2c2462bf.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="css/explanations.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>


        <div class="Book-title row">
            <h2>Duyệt sách</h2>

            <div class="col-12 col-md-2 col-sm-4">
                <br>
                <img src="${b.getImage()}" alt="${b.getTitle()}" />
            </div>
            <div class="col-12 col-md-10 col-sm-8" >
                <h3>${b.getTitle()}</h3>
                <p>${b.getEdition()}</p>
                <p>ISBN: ${b.getIsbn()}</p>
                <p>${b.getAuthors()}</p>
            </div>


        </div>
        <div class="answer">
            <h5><strong>Lời giải sách giáo khoa</strong></h5>

            <c:forEach items="${listC}" var="c" varStatus="loop">

                <div class="accordion" id="accordionPanelsStayOpenExample">
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="panelsStayOpen-headingOne" >
                            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne" style="background-color: #2e3856">
                                ${c.getChapterName()}
                            </button>

                        </h2>

                        <div class="row">


                            <div id="panelsStayOpen-collapseOne" class="col-12 col-md-6 accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingOne">
                                <c:set var="listP" value="${d.getAllPageByChapterID(c.getChapterID())}" />
                                <div class="accordion-body accordion-body-left">
                                    <c:forEach items="${listP}" var="p">
                                        <c:set var="listE" value="${d.getAllExByPageID(p.getPageID())}" />
                                        <p onclick="handleSelectPage(${p.getPageID()}, ${listE.size()})">${p.getPageName()}</p>
                                    </c:forEach>
                                </div>

                            </div>

                            <div id="panelsStayOpen-collapseOne" class="col-12 col-md-6 accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingOne">

                                <div class="accordion-body accordion-body-right">
                                    <c:forEach items="${listP}" var="p">
                                        <c:set var="listE" value="${d.getAllExByPageID(p.getPageID())}" />
                                        
                                             <c:forEach items="${listE}" var="e">
                                            <a href="answer?id=${e.getExID()}&isbn=${b.getIsbn()}&pId=${p.getPageID()}&cid=${p.getChapterID()}" class="ex${p.getPageID()} exercises" >${e.getExName()}</a>
                                            
                                        </c:forEach>
                                        
                                    </c:forEach>
                                </div>

                            </div>

                        </div>

                    </div>
                </div>

            </c:forEach>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <script>
            var listEx = document.getElementsByClassName("exercises");
            
            function handleSelectPage(pId, numChap) {
                let className = "ex" +  pId;
                let listE = document.getElementsByClassName(className);
                console.log(listE);
                for(var j=0; j<listEx.length; j++) {
                    listEx[j].style.display = "none";
                }
                for(var i=0; i<listE.length; i++) { 
                    listE[i].style.display = "block";
                }
            }
        </script>
    </body>
</html>