<%-- 
    Document   : home
    Created on : Dec 9, 2022, 10:53:45 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dal.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ | Quizlet</title>
        <script src="https://kit.fontawesome.com/1c2c2462bf.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="css/explanation.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <% DAO d = new DAO(); int i=0;%>



        <div class="row book_list">
            <h3>Duyệt sách</h3>
            <!--            <form action="search">
                            <input type="search" name="search" class="search-input" placeholder="Tìm kiếm sach"/>
                            <input type="submit" hidden />
                        </form>-->


            <c:forEach items="${listB}" var="b">

                <div class="book_item">

                    <a class="row title" href="book?isbn=${b.getIsbn()}">
                        <form action="answer" method="get">
                            <input style="display: none" class="isbn" value="${b.getIsbn()}" name="Isbn"/>
                        </form>

                        <div class="col-12 col-md-4 col-sm-4"><img src="${b.getImage()}" alt=""></div>
                        <div class="col-12 col-md-8 col-sm-8 title-content">
                            ${b.getTitle()}
                            <div class="authors">${b.getAuthors()}</div>
                        </div>
                    </a>

                </div>  

            </c:forEach>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    </body>
</html>
