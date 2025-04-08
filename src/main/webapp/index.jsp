<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="Dao.ImplFilm" %>
<%@ page import="Metier.Film" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <title>Anivers</title>
    <%@include file="Component/CSS.jsp" %>
</head>
<body>
<%@include file="Component/navbar.jsp" %><br><br>

<!-- Slideshow container -->
<div class="slideshow-container">

    <div class="mySlides fade">
        <img src="Images/perfectBlue.jpg" style="width:100%" >
    </div>
    <div class="mySlides fade">
        <img src="Images/home-img-3.png" style="width:100%" >
    </div>

    <div class="mySlides fade">
        <img src="Images/home-img-2.png" style="width:100%" >
    </div>

    <div class="mySlides fade">
        <img src="Images/sololeveling.jpg" style="width:100%" >
    </div>
    <div class="mySlides fade">
        <img src="Images/monoke.jpg" style="width:100%" >
    </div>


    <div class="mySlides fade">
        <img src="Images/madara.png" style="width:100%" >
    </div>

    <div class="mySlides fade">
        <img src="Images/hunterXhunter.jpg" style="width:100%" >
    </div>

    <div class="mySlides fade">
        <img src="Images/codeGeass.jpg" style="width:100%" >
    </div>

    <div class="mySlides fade">
        <img src="Images/ghibli1.jpg" style="width:100%" >
    </div>

    <div class="mySlides fade">
        <img src="Images/dandadan.jpg" style="width:100%" >
    </div>

    <div class="mySlides fade">
        <img src="Images/vinland%20saga.png" style="width:100%" >
    </div>



    <!-- Full-width images with number and caption text -->

<<<<<<< HEAD
    <div class="mySlides fade">
        <img src="Images/anime2.webp">
    </div>

    <div class="mySlides fade">
        <img src="Images/anime1.jpg" >
    </div>
=======
>>>>>>> devfront




    <div class="mySlides fade">
        <img src="Images/anime2.png" >
    </div>

    <div class="mySlides fade">
        <img src="Images/anime4.png" >
    </div>

    <div class="mySlides fade">
        <img src="Images/anime5.png" >
    </div>

    <div class="mySlides fade">
        <img src="Images/anime6.png" >
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

<div class="container">
    <h3 class="text-center">Action</h3>
    <div class="row">
        <%
            ImplFilm implFilm1 = new ImplFilm();
            List<Film> filmsA = implFilm1.getAllFilmsbygenre("Action");
            if (filmsA != null) {
                for (Film filmA : filmsA) {
        %>
        <div class="card crd-ho mx-2">
            <div class="card-body text-center">
                <img src="<%=filmA.getImageUrl_home()%>" style="width: 200px;height: 300px" class="img-thumblin">
                <p><%=filmA.getTitle()%></p>
                <a href="description?Id=<%=filmA.getId()%>">view more</a>
            </div>
        </div>
        <%
                }
            }

        %>
    </div>
</div>
<div class="text-center">
    <a href="" class="btn btn-danger btn-sm">View All</a>
</div>
<hr width="50%" size="3" color="#000" noshade align="center">



<div class="container">
    <h3 class="text-center">Child</h3>
    <div class="row">
        <%
            ImplFilm implFilm2 = new ImplFilm();
            List<Film> filmsC =implFilm2.getAllFilmsbygenre("Child");
         if(filmsC !=null){
            for (Film filmC : filmsC) {

            %>
        <div class="card crd-ho mx-2">
            <div class="card-body text-center">
                <img src="<%=filmC.getImageUrl_home()%>" style="width: 200px;height: 300px" class="img-thumblin">
                <p><%=filmC.getTitle()%></p>
                <a href="description?Id=<%=filmC.getId()%>">view more</a>
            </div>
        </div>

        <%
                }
        }
        %>
    </div>
</div>
<div class="text-center">
    <a href="" class="btn btn-danger btn-sm">View All</a>
</div>
<hr width="50%" size="3" color="#000" noshade align="center">


<div class="container">
    <h3 class="text-center">Family</h3>
    <div class="row">
        <%
            ImplFilm implFilm3 = new ImplFilm();
            List<Film> filmsF =implFilm2.getAllFilmsbygenre("Family");
            if(filmsF !=null){
                for (Film filmF : filmsF) {

        %>
        <div class="card crd-ho mx-2">
            <div class="card-body text-center">
                <img src="<%=filmF.getImageUrl_home()%>" style="width: 200px;height: 300px" class="img-thumblin">
                <p><%=filmF.getTitle()%></p>
                <a href="description?Id=<%=filmF.getId()%>">view more</a>
            </div>
        </div>

        <%
                }
            }
        %>
    </div>
</div>
<div class="text-center">
    <a href="" class="btn btn-danger btn-sm">View All</a>
</div>
<%@include file="Component/footer.jsp"%>
<script>
    let slideIndex = 0;
    const slides = document.getElementsByClassName("mySlides");
    const dots = document.getElementsByClassName("dot");
    let slideInterval;

    function showSlides() {
        // Hide all slides
        for (let i = 0; i < slides.length; i++) {
            slides[i].style.opacity = "0";
            slides[i].style.transition = "opacity 0.7s ease-in-out";
            slides[i].style.display = "none";
        }

        // Reset dot active states
        for (let i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }

        // Increment slide index
        slideIndex++;
        if (slideIndex >= slides.length) {
            slideIndex = 0;
        }

        // Show current slide with fade effect
        slides[slideIndex].style.display = "block";
        setTimeout(() => {
            slides[slideIndex].style.opacity = "1";
        }, 50);

        // Activate current dot
        dots[slideIndex].className += " active";
    }

    function plusSlides(n) {
        // Stop automatic sliding when manually changing slides
        clearInterval(slideInterval);

        slideIndex += n;

        // Wrap around slide index
        if (slideIndex >= slides.length) {
            slideIndex = 0;
        }
        if (slideIndex < 0) {
            slideIndex = slides.length - 1;
        }

        // Show slides immediately
        for (let i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
            slides[i].style.opacity = "0";
        }

        slides[slideIndex].style.display = "block";
        setTimeout(() => {
            slides[slideIndex].style.opacity = "1";
        }, 50);

        // Reset dot active states
        for (let i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        dots[slideIndex].className += " active";

        // Restart automatic sliding
        startSlideShow();
    }

    function currentSlide(n) {
        // Stop automatic sliding when manually selecting a slide
        clearInterval(slideInterval);

        slideIndex = n - 1;

        // Show slides immediately
        for (let i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
            slides[i].style.opacity = "0";
        }

        slides[slideIndex].style.display = "block";
        setTimeout(() => {
            slides[slideIndex].style.opacity = "1";
        }, 50);

        // Reset dot active states
        for (let i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        dots[slideIndex].className += " active";

        // Restart automatic sliding
        startSlideShow();
    }

    function startSlideShow() {
        // Clear any existing interval
        clearInterval(slideInterval);

        // Start new interval
        slideInterval = setInterval(showSlides, 4000); // Change slide every 4 seconds
    }

    // Initialize slideshow on page load
    document.addEventListener('DOMContentLoaded', () => {
        // Add initial styling
        for (let slide of slides) {
            slide.style.transition = "opacity 0.7s ease-in-out";
            slide.style.opacity = "0";
        }

        // Start the slideshow
        startSlideShow();
    });
</script>

</body>
</html>
