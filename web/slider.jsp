<%-- 
   Document   : slider.jsp
   Created on : Dec 13, 2022, 1:32:11 AM
   Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/slider.css" />
    </head>
    <body>
        <div class="container-slide">
            <div class="slide">
                <label>
                    <input type="checkbox" />
                    <div class="flip-card">
                        <div class="front">FONT CARD1</div>
                        <div class="back">BACK CARD1</div>
                    </div>
                </label>
            </div>
            <div class="slide">
                <label>
                    <input type="checkbox" />
                    <div class="flip-card">
                        <div class="front">FONT CARD2</div>
                        <div class="back">BACK CARD2</div>
                    </div>
                </label>
            </div>  
            <div class="slide">
                <label>
                    <input type="checkbox" />
                    <div class="flip-card">
                        <div class="front">FONT CARD3</div>
                        <div class="back">BACK CARD3</div>
                    </div>
                </label>
            </div>
        </div>
        <div class="card-footer">
            <div class="btn-prev" onclick="goPrev()" >Prev</div>
            <div class="btn-next" onclick="goNext()" >Next</div>
        </div>
    </body>
    <script>
        const slides = document.querySelectorAll(".slide");
        var count = 0;
        slides.forEach((slide, index) => {
            var pos = index * 100;
            slide.style.left = pos + "%";
        });
        const slideImage = () => {
            slides.forEach(slide => {
                var counter = count * 100;
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
