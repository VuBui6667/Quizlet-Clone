<%-- 
    Document   : test
    Created on : Dec 14, 2022, 7:50:54 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/test.css" />
    </head>
    <body>
        <main class="container-slide">
            <div class="slide">1</div>
            <div class="slide">2</div>
            <div class="slide">3</div>
            <div class="slide">4</div>
        </main>
        <div>
            <button onclick="goPrev()">Prev</button>
            <button onclick="goNext()">Next</button>
        </div>
    </body>
    <script>
        const slides = document.querySelectorAll(".slide");
        var count = 0;
        slides.forEach((slide, index) => {
            var pos = index*100;
            slide.style.left = pos + "%";
        });
        const slideImage = () => {
            slides.forEach(slide => {
                var counter = count*100;
                slide.style.transform = "translateX(-" + counter + "%)";
            })
        }
        const goNext = () => {
            count++;
            slideImage();
        }
        
        const goPrev = () => {
            count--;
            slideImage();
        }
        
    </script>
</html>
