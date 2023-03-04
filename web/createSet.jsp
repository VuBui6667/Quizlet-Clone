<%-- 
    Document   : createSet
    Created on : Dec 12, 2022, 3:47:47 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="model.Card" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tạo học phần mới | Quizlet</title>
        <link rel="stylesheet" href="css/createSet.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <% ArrayList<Card> listC = (ArrayList<Card>)request.getSession().getAttribute("listC"); %>
        <div class="container-create">
            <form action="createSet" method="post">
                <div class="header-create">
                    <div class="create">Tạo học phần mới</div>
                    <input class="btn-create" value="Tạo" type="submit">
                </div>
                <input type="text" required name="titleSet" value="${requestScope.titleSet}" placeholder="Nhập tiêu đề, ví dụ: 'Sinh học - Chương 22: Tiến hóa'"  class="input-set"/><br/>
                <div class="title-input">TIÊU ĐỀ</div>
                <input type="text" name="descSet" value="${requestScope.descSet}" placeholder="Thêm mô tả..." class="input-set"/><br/>
                <div class="title-input">MÔ TẢ</div>
                <div class="container-share">
                    <input class="share-btn" id="isShare" name="isShare" type="checkbox" ${isShare ? "checked" : ""} value="${isShare}"/>
                    <label for="isShare" class="share-text">Chia sẻ với mọi người</label>
                </div>
                <div class="error-add" style="${err_card != null ? "" : "display: none"}">${requestScope.err_card}</div>
                <c:forEach var="i" begin="1" end="${requestScope.numberCard}" >
                    <div class="container-card">
                        <div class="card-header">
                            <div class="title-input">${i}</div>
                        </div>
                        <div class="card-body">
                            <div class="card-title">
                                <input type="text" name="card-title" class="input-card" value="${listC.get(i-1).getTerm()}"/><br/>
                                <div class="title-input">THUẬT NGỮ</div>
                            </div>
                            <div class="card-desc">
                                <input type="text" name="card-desc" class="input-card" value="${listC.get(i-1).getDefinition()}"/><br/>
                                <div class="title-input">ĐỊNH NGHĨA</div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="container-add">
                    <div class="number-card">${requestScope.numberCard+1}</div>
                    <input type="submit" name="btn-increase" class="title-add" value="+ THÊM THẺ"/>
                    <div></div>
                </div>
                <input type="submit" value="Tạo" class="add-footer"/>
            </form>
        </div>
    </body>
</html>
