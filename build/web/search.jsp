<%-- 
    Document   : search
    Created on : Dec 14, 2022, 3:15:14 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="model.Card" %>
<%@page import="dal.DAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tìm kiếm | Quizlet</title>
        <link rel="stylesheet" href="css/search.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <% DAO d = new DAO(); %>
        <div class="container-search">
            <div class="wrapper-input">
                <form action="search">
                    <input class="input-search" value="${requestScope.searchValue}"name="search" input="text" placeholder="Tìm kiếm học phần"/>
                    <input type="submit" hidden />
                </form>
            </div>
            <div class="study-set-container">
                <div class="title-container">Học phần</div>
                <div class="content-container">
                    <c:forEach items="${requestScope.listSearch}" var="s">
                        <a href="flashCards?id=${s.getId()}">
                        <div class="item-study-set">
                            <div class="title-study-set">${s.getTitle()}</div>
                            <div class="amount-card">${s.getNumberCard()} thuật ngữ</div>
                            <div class="author-study-set">
                                By ${s.getAuthor()}
                            </div>
                        </div>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
