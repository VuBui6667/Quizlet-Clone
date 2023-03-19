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
        <link rel="stylesheet" href="css/home.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <% DAO d = new DAO(); int i=0;%>
        <div class="container-home">
            <div class="study-set-container">
                <div class="title-container">Học phần</div>
                <div class="content-container">
                    <c:forEach items="${listN}" var="s">
                        <a href="flashCards?id=${s.getId()}">
                            <div class="item-study-set">
                                <div class="title-study-set">${s.getTitle()}</div>
                                <div class="amount-card">${s.getNumberCard()} thuật ngữ</div>
                                <div class="author-study-set">
                                    By ${user.getName()}
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
