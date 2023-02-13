<%-- 
    Document   : folderSet
    Created on : Feb 13, 2023, 10:19:25 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dal.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/85116df733.js"></script>
        <link rel="stylesheet" href="css/folderSet.css" />
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="folderSet-section">
            <div class="control-folderSet">
                <div class="folderSet-info">
                    <p>0 học phần</p>
                    <p> tạo bởi vubui</p>                   
                </div>
                <div class="method-folderSet">
                    <div class="add-studySet method-item">
                        <i class="fa-solid fa-plus"></i>
                    </div>
                    <div class="share-folderSet method-item">
                        <i class="fa-solid fa-arrow-up-from-bracket"></i>
                    </div>
                    <div class="edit-folderSet method-item">
                        <i class="fa-solid fa-ellipsis"></i>
                    </div>
                </div>
            </div>
            <div class="folder-author">
                <i class="fa-regular fa-folder"></i>
                <p>Folder Name</p>
            </div>
            <p class="folder-desc">Folder Description</p>
        </div>
    </body>
</html>
