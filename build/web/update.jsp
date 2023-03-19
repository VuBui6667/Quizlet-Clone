<%-- 
    Document   : update
    Created on : Dec 13, 2022, 11:33:27 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.Card" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sửa học phần | Quizlet</title>
        <link rel="stylesheet" href="css/update.css" />
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container-create">
            <form action="update" method="post">
                <div class="header-create">
                    <div class="create"><a href="flashCards?id=${requestScope.id}"><i class="fa-solid fa-chevron-left"></i> Trở về học phần</a></div>
                    <input class="btn-create" value="Hoàn tất" type="submit">
                </div>
                <input type="text" required name="titleSet" value="${requestScope.titleSet}" placeholder="Nhập tiêu đề, ví dụ: 'Sinh học - Chương 22: Tiến hóa'"  class="input-set"/><br/>
                <div class="title-input">TIÊU ĐỀ</div>
                <input type="text" name="descSet" value="${requestScope.descSet}" placeholder="Thêm mô tả..." class="input-set"/><br/>
                <div class="title-input">MÔ TẢ</div>
                <div class="container-share">
                    <input class="share-btn" id="isShare" name="isShare" type="checkbox" ${requestScope.isShare ? "checked" : ""} value="${isShare}"/>
                    <label for="isShare" class="share-text">Chia sẻ với mọi người</label>
                </div>
                <c:forEach var="i" begin="1" end="${requestScope.numCard}" >
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
                        <input type="text" name="id-card" value="${listC.get(i-1).getId()}" hidden />
                    </div>
                </c:forEach>
                <div class="container-add">
                    <div class="number-card">${requestScope.numCard+1}</div>
                    <input type="submit" name="btn-increase" class="title-add" value="+ THÊM THẺ"/>
                    <div></div>
                </div>
                <input type="submit" value="Hoàn tất" class="add-footer"/>
            </form>
        </div>
    </body>
</html>
