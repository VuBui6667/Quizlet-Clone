<%-- 
    Document   : homeLogin
    Created on : Feb 1, 2023, 12:22:54 AM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dal.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ | Quizlet</title>
<!--        <link rel="stylesheet" href="css/home.css" />-->
        <link rel="stylesheet" href="css/homelogin.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="wrapper">
             <div class="content1">
            <img class="background-content item1"
                 src="images_1/q12.png"
                alt="">
            <div class="content1-container">
                <div class="content1-paragraph">
                    <h1>The best digital flashcards and study tools</h1>
                    <p>Join over 60 million students using Quizlet’s science-backed flashcards, practice tests and
                        expert solutions to improve their grades and reach their goals.</p>
                    <div class="btnsignupfree">
                        <a href="register.jsp" class="signupfree">Sign up for free</a>
                    </div>
                    <!-- <button class="signupfree">Sign up for free</button> -->
                </div>
            </div>
        </div>
        <div class="content2">
            <div class="content2-paragraph">
                <h2>90% of students who use Quizlet report receiving higher grades</h2>
            </div>
        </div>

        <div class="content3">
            <div class="content3-items">
                <div class="items3">
                    <h2>Memorize faster for free</h2>
                    <p>Research shows that testing yourself with flashcards is more effective than rereading your notes.
                        From math to medicine to modern languages, Quizlet is used by students in over 100 different
                        subjects.</p>
                    <div class="btngetstarted">
                        <a href="register.jsp" class="getstarted">Get Started</a>
                    </div>
                </div>
                <div class="items3-1">
                    <img class="imgitems3-1"
                        src="https://images.prismic.io/quizlet-prod/31c85d7d-9e36-40a4-9fae-5027c355ddee_Flashcards-1.gif?auto=compress,format"
                        alt="">
                </div>
            </div>
        </div>
        <div class="content4">
            <div class="content4-items">
                <div class="content4-paragraph">
                    <h2>See our flashcards in action</h2>
                </div>
                <div class="videoytb">
                    <iframe width="896" height="540" src="https://www.youtube.com/embed/E-wY2mJVlu0"
                        title="YouTube video player" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        allowfullscreen></iframe>
                </div>
            </div>
        </div>

        <div class="content5">
            <div class="content5-items">
                <div class="items5-1">
                    <img src="images_1/q1.png" alt="" class="imgitems5-1">
                </div>
                <div class="items5-paragraph">
                    <h2>Yesterday’s commute, today’s study session </h2>
                    <p>Study anywhere — even offline — with our iOS and Android apps. Your progress syncs across your
                        phone and computer.</p>
                        <div class="buttonapp">
                            <div class="appst">
                                <div class="btnappstore">
                                    <a href="https://apps.apple.com/us/app/quizlet-flashcards-study-tools/id546473125" class="appstore"></a>
                                    </div>
                            </div>
                            <div class="ggplay">
                                <div class="btnggplay">
                                    <a href="https://play.google.com/store/apps/details?id=com.quizlet.quizletandroid&hl=en&referrer=utm_source%3D&pli=1" class="googleplay"></a>
                                    </div>
                            </div>
                        </div>
                       
                       
                    <!-- <a href=""></a> -->
                </div>
            </div>
        </div>

        <div class="content6">
            <div class="content6-items">
                <div class="content6-1">
                    <span class="quizplus">QUIZLET PLUS</span>
                    <div class="items6-paragraph">
                        <h2>Be ready for test day with Learn and Test</h2>
                        <p>Turn your flashcards into customizable practice tests. Go beyond memorization with question
                            types that challenge your recall.</p>
                    </div>
                    <div class="pwl">
                        <div class="itemimg1">
                            <img src="images_1/learn.svg" alt="" class="learn">
                        </div>
                        <div class="items6-paragraph1">
                            <h3>Practice with Learn</h3>
                            <p>Get instant feedback while practicing with multiple choice, true or false, written
                                questions and more.</p>
                              
                        </div>

                    </div>
                    <div class="tat">
                        <div class="itemimg2">
                            <img src="images_1/Test.svg" alt="" class="test">
                        </div>
                        <div class="items6-paragraph2">
                            <h3>Take a Test</h3>
                            <p>Study effectively with practice tests so you’re prepared for your exams.</p>
                        </div>

                    </div>
                    <div class="asg">
                        <div class="itemimg3">
                            <img src="images_1/Smart Grading.svg" alt="" class="smart">
                        </div>
                        <div class="items6-paragraph3">
                            <h3>Access smart grading</h3>
                            <p>Quizlet’s smart grading feature ensures you aren’t marked incorrect for minor mistakes.
                            </p>
                        </div>
                    </div>
                    <div class="btntrylearnandtest">
                        <a href="" class="trylat">Try Learn and Test for free</a>
                    </div>
                </div>
                <div class="content6-2">
                    <img src="images_1/q3.png" alt="" class="imgitems6-2">
                </div>
            </div>
        </div>

        <div class="content7">
            <div class="content7-items">
                <div class="content7-1">
                    <img src="images_1/q4.png" alt="" class="imgitem7-1">
                </div>
                <div class="content7-2">
                    <span class="quizplus">QUIZLET PLUS</span>
                    <div class="content7-paragraph">
                        <h2>Get homework help with expert solutions</h2>
                        <p>Quizlet expert solutions show you step-by-step approaches to solve tough problems. Find
                            millions of solutions in 64 subjects.</p>
                    </div>
                    <div class="tot">
                        <div class="itemimg7-1">
                            <img src="images_1/Textbook Solutions.svg" alt="" class="textbook">
                        </div>
                        <div class="items7-paragraph1">
                            <h3>Thousands of textbooks</h3>
                            <p>Find solutions for textbook problems in math, science, business and more.</p>
                        </div>
                    </div>
                    <div class="ew">
                        <div class="itemimg7-2">
                            <img src="images_1/Solutions.svg" alt="" class="solutions">
                        </div>
                        <div class="items7-paragraph2">
                            <h3>Expert written</h3>
                            <p>Each textbook solution is carefully written and double-checked by our team of experts.
                            </p>
                        </div>
                    </div>
                    <div class="sbs">
                        <div class="itemimg7-3">
                            <img src="images_1/Step by Step.svg" alt="" class="step">
                        </div>
                        <div class="items7-paragraph3">
                            <h3>Step-by-step learning</h3>
                            <p>Don't just get it, learn it! Reveal one step at a time to lock in understanding, and
                                sample free solutions from every textbook.</p>
                        </div>
                    </div>
                    <div class="btndfs">
                        <a href="" class="dfs">Discover free solutions</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="content8">
            <div class="content8-paragraph">
                <h2>What students are saying about Quizlet</h2>
            </div>
        </div>
        <div class="content9">
            <div class="content9-1">
                <div class="imgct9-1">
                    <img src="images_1/a1.png" alt="" class="img9-1">
                </div>
                <div class="content9-paragraph1">
                    <h5>“Quizlet has been supporting my success since high school. Flashcards available on the go are single-handedly getting me through university.”</h5>
                        <p>Hamza, Senior, Medicine</p>
                        </div>
            </div>
            <div class="content9-2">
                <div class="imgct9-2">
                    <img src="images_1/a2.png" alt="" class="img9-2">
                </div>
                <div class="content9-paragraph2">
                    <h5>“Learn mode is the best thing that's ever come out of Quizlet. It shows you terms in a way that makes it easiest to remember.”</h5>
                        <p>Sydney, Sophomore, Biology</p>
                    </div>

            </div>
            <div class="content9-3">
                <div class="imgct9-3">
                    <img src="images_1/a3.png"
                        alt="" class="img9-3">
                </div>
                <div class="content9-paragraph3">
                    <h5>"All our friends use Quizlet. It's a fun way to study and we feel more confident preparing for our midterms and finals."</h5>
                        <p>Sydney, Sophomore, Biology</p>
                    </div>

            </div>
        </div>
            <div class="content10">
                <div class="content10-1">
                    <div class="content10-paragraph">
                        <h4>TEACHERS</h4>
                        <h1>Empower your students</h1>
                        <p>Help every student confidently learn anything, no matter what they’re striving to achieve. Using Quizlet’s free study sets, study modes and in-class game Checkpoint, you can instantly create a more engaged classroom. Students and teachers can sign up and study for free.</p>
                        <div class="btncafa">
                            <a href="register.jsp" class="cafa">Create a free account</a>
                        </div>
                    </div>
                </div>
                <div class="content10-2">
                    <div class="img10ct-2">
                        <img src="images_1/teacher.png" alt="" class="img10-2">
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
