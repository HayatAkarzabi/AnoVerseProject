<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <title>Anivers</title>
    <%@include file="Component/CSS.jsp" %>
</head>
<body>
<%@include file="Component/navbar.jsp" %>

<!-- Slideshow container -->
<div class="slideshow-container">
    <!-- Full-width images with number and caption text -->
    <div class="mySlides fade">
        <div class="numbertext">1 / 3</div>
        <img src="Images/anime1.jpg"  style="width:100%; height: 50vh;">
        <div class="text">Caption Text</div>
    </div>

    <div class="mySlides fade">
        <div class="numbertext">2 / 3</div>
        <img src="Images/anime2.jpg" style="width:100%; height: 50vh;">
        <div class="text">Caption Two</div>
    </div>

    <div class="mySlides fade">
        <div class="numbertext">3 / 3</div>
        <img src="Images/anime3.png" style="width:100%; height: 50vh;">
        <div class="text">Caption Three</div>
    </div>

    <!-- Next and previous buttons -->
    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
    <a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
<br>

<!-- The dots/circles -->
<div style="text-align:center">
    <span class="dot" onclick="currentSlide(1)"></span>
    <span class="dot" onclick="currentSlide(2)"></span>
    <span class="dot" onclick="currentSlide(3)"></span>
</div>


<footer>
    <p>&copy; 2025 Animé Réservations - Tous droits réservés</p>
</footer>
<script>
    let slideIndex = 0;
    showSlides();

    function showSlides() {
        let slides = document.getElementsByClassName("mySlides");
        let dots = document.getElementsByClassName("dot");

        for (let i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }

        slideIndex++;
        if (slideIndex > slides.length) {slideIndex = 1}

        for (let i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }

        slides[slideIndex-1].style.display = "block";
        dots[slideIndex-1].className += " active";

        setTimeout(showSlides, 3000); // Change image every 3 seconds
    }

    function plusSlides(n) {
        slideIndex += n;
        if (slideIndex < 1) {
            slideIndex = document.getElementsByClassName("mySlides").length;
        }
        showSlides();
    }

    function currentSlide(n) {
        slideIndex = n;
        showSlides();
    }
</script>

</body>
</html>
