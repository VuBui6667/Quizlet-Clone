<%-- 
    Document   : classSet
    Created on : Mar 1, 2023, 1:00:02 AM
    Author     : vieta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dal.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/85116df733.js"></script>
        <link rel="stylesheet" href="css/classSet.css" />
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="classSet-section">
            <div class="control-classSet">
                <div class="classSet-info">
                    <div class="icon-class">
                        <i class="fa-solid fa-user-group"></i>
                    </div>
                    <div class="class-author">
                        <p>${c.getName()}</p>
                    </div>
                </div>
               <div class="method-classSet">
                    <div class="add-studySet method-item">
                        <i class="fa-solid fa-plus"></i>
                    </div>
                    <div class="add-member method-item">
                        <i class="fa-solid fa-user-plus"></i>
                    </div>
                    <div class="add-class method-item">
                        <i class="fa-regular fa-folder"></i>
                    </div>

                    <div class="edit-class method-item">
                        <i class="fa-solid fa-ellipsis"></i>
                    </div>
                </div>
            </div>

            <!--<p class="class-desc">Class Description</p>-->
        </div>
    </body>
</html>