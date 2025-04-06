<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="Dao.ImplFilm" %>
<%@ page import="Metier.Film" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <title>Client</title>
    <%@include file="Component/CSS.jsp" %>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="text-custom" >
        <img src="Images/logo1.jpeg" class="logo">
    </div>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link active" href="index.jsp"><i class="fa-solid fa-house"></i> Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#Action"> Action</a>
            </li><li class="nav-item">
            <a class="nav-link" href="#Drama"> Drama</a>
        </li>
            <li class="nav-item">
                <a class="nav-link " href="#Family"> Family</a>
            </li>
        </ul>
        <div class="d-flex justify-content-center">
            <div class="box">
                <input type="text" placeholder="Search....">
                <a href="#"><i class="fas fa-search"></i></a>
            </div>
        </div>


        <div class="col-md-3">
            <a href="index.jsp" class="btn nav-item " ><i class="fa-solid fa-right-from-bracket"></i> Logout</a>
        </div>
    </div>
</nav>



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
    <h3 class="text-center" id="Action">Action</h3>
    <div class="row">
        <%
            ImplFilm implFilm1 = new ImplFilm();
            List<Film> filmsA = implFilm1.getAllFilmsbygenre("Action");
            if (filmsA != null) {
                for (Film filmA : filmsA) {
        %>
        <div class="card crd-ho mx-2">
            <div class="card-body text-center">
                <img src="<%=filmA.getImageUrl()%>" style="width: 150px;height: 200px" class="img-thumblin">
                <p><%=filmA.getTitle()%></p>
                <a href="description?Id=<%=filmA.getId()%>">view more</a>
            </div>
        </div>
        <%
                }
            }

        %>
    </div>
</div><br><br><br>
<hr width="50%" size="3" color="#000" noshade align="center">



<div class="container">
    <h3 class="text-center" id="Drama">Drama</h3>
    <div class="row">
        <%
            ImplFilm implFilm2 = new ImplFilm();
            List<Film> filmsC =implFilm2.getAllFilmsbygenre("Drama");
            if(filmsC !=null){
                for (Film filmC : filmsC) {

        %>
        <div class="card crd-ho mx-2">
            <div class="card-body text-center">
                <img src="<%=filmC.getImageUrl()%>" style="width: 150px;height: 200px" class="img-thumblin">
                <p><%=filmC.getTitle()%></p>
                <a href="description?Id=<%=filmC.getId()%>">view more</a>
            </div>
        </div>

        <%
                }
            }
        %>
    </div>
</div><br><br><br>
<hr width="50%" size="3" color="#000" noshade align="center">


<div class="container">
    <h3 class="text-center" id="Family">Family</h3>
    <div class="row">
        <%
            ImplFilm implFilm3 = new ImplFilm();
            List<Film> filmsF =implFilm3.getAllFilmsbygenre("Family");
            if(filmsF !=null){
                for (Film filmF : filmsF) {

        %>
        <div class="card crd-ho mx-2">
            <div class="card-body text-center">
                <img src="<%=filmF.getImageUrl()%>" style="width: 150px;height: 200px" class="img-thumblin">
                <p><%=filmF.getTitle()%></p>
                <a href="description?Id=<%=filmF.getId()%>">view more</a>
            </div>
        </div>

        <%
                }
            }
        %>
    </div>
</div><br><br><br>
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
