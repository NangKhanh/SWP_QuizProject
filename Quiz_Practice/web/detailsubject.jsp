<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Quiz</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600;700&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">


        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <!-- Topbar Start -->
        <div class="container-fluid bg-dark">
            <div class="row py-2 px-lg-5">
                <div class="col-lg-6 text-center text-lg-left mb-2 mb-lg-0">
                    <div class="d-inline-flex align-items-center text-white">
                        <small><i class="fa fa-phone-alt mr-2"></i>+012 345 6789</small>
                        <small class="px-3">|</small>
                        <small><i class="fa fa-envelope mr-2"></i>minh@example.com</small>
                    </div>
                </div>
                <div class="col-lg-6 text-center text-lg-right">
                    <div class="d-inline-flex align-items-center">
                        <a class="text-white px-2" href="">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a class="text-white px-2" href="">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a class="text-white px-2" href="">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                        <a class="text-white px-2" href="">
                            <i class="fab fa-instagram"></i>
                        </a>
                        <a class="text-white pl-2" href="">
                            <i class="fab fa-youtube"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Topbar End -->


        <!-- Navbar Start -->
        <div class="container-fluid p-0">
            <nav class="navbar navbar-expand-lg bg-white navbar-light py-3 py-lg-0 px-lg-5">
                <a href="home?index=1" class="navbar-brand ml-lg-3">
                    <h1 class="m-0 text-uppercase text-primary"><i class="fa fa-book-reader mr-3"></i>Quiz</h1>
                </a> 
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>           
                <div class="collapse navbar-collapse justify-content-between px-lg-3" id="navbarCollapse">
                    <div class="navbar-nav mx-auto py-0">
                        <a href="home?index=1" class="nav-item nav-link">Home</a>
                        <c:if test="${user == null}">
                            <a href="Login.jsp" class="nav-item nav-link">Login</a>
                        </c:if>

                        <c:if test="${user != null}">
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">List</a>
                                <div class="dropdown-menu m-0">
                                    <a href="listPratice" class="dropdown-item">List Practice</a>
                                    <c:if test="${sessionScope.user.getRoleId() == 1|| sessionScope.user.getRoleId()==2}">
                                        <a href="subjectcrud" class="dropdown-item">List Subject</a>
                                    </c:if>
                                    <c:if test="${sessionScope.user.getRoleId() == 1}">
                                        <a href="listcustomer" class="dropdown-item">List Customer</a>
                                    </c:if>
                                    <c:if test="${sessionScope.user.getRoleId() == 1|| sessionScope.user.getRoleId()==2}">
                                        <form action="crudquiz" method="get" >
                                            <input type="submit" value="Edit Quiz" class="dropdown-item" />
                                        </form>
                                    </c:if>
                                </div>

                            </div>
                        </c:if>
                        <c:if test="${user != null}">
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">${sessionScope.user.getNameUser()}</a>
                                <div class="dropdown-menu m-0">
                                    <a href="UserProfile?userid=${sessionScope.user.getIdUser()}" class="dropdown-item">Profile</a>
                                   
                                    <a href="Logout" class="dropdown-item">Logout</a>
                                </div>

                            </div>
                        </c:if>
                        <c:if test="${user == null}">
                        </div>
                        <a href="Register.jsp" class="btn btn-primary py-2 px-4 d-none d-lg-block">Join Us</a>
                    </div>
                </c:if>
            </nav>
        </div>
        <!-- Navbar End -->


        <!-- Header Start -->
        <div class="jumbotron jumbotron-fluid page-header position-relative overlay-bottom" style="margin-bottom: 90px;">
            <div class="container text-center py-5">
                <h1 class="text-white display-1">${detail.getName_subject()}</h1>
                <div class="d-inline-flex text-white mb-5">
                    <p class="m-0 text-uppercase"><a class="text-white" href="home?index=1">Home</a></p>
                    <i class="fa fa-angle-double-right pt-1 px-3"></i>
                    <p class="m-0 text-uppercase">${detail.getName_subject()}</p>
                </div>
                <div class="mx-auto mb-5" style="width: 100%; max-width: 600px;">
                </div>
            </div>
        </div>
        <!-- Header End -->
        <!-- Detail Start -->
        <div class="container-fluid py-5">
            <div class="container py-5">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="mb-5">
                            <div class="section-title position-relative mb-5">
                                <h6 class="d-inline-block position-relative text-secondary text-uppercase pb-2">Course Detail</h6>
                                <h1 class="display-4">${detail.getName_subject()}</h1>
                            </div>

                            <p>${detail.getDescription_subject()}</p>


                        </div>
                        <h2 class="mb-3">Lesson</h2>
                        <ul class="list-group list-group-flush">
                            <c:forEach var="l" items="${lesson}">
                                <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                                    <h3><a href="detaillesson?lid=${l.getId_lesson()}" class="text-decoration-none h6 m-0">Lesson: ${l.getName_lesson()}</a></h3>                           
                                </li>
                            </c:forEach>
                            <!--                        <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                                                        <a href="mathl2.jsp" class="text-decoration-none h6 m-0">Lesson 2</a>                               
                                                    </li>
                                                    <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                                                        <a href="mathl3.jsp" class="text-decoration-none h6 m-0">Lesson 3</a>                               
                                                    </li>                        -->
                        </ul>

                    </div>

                    <div class="col-lg-4 mt-5 mt-lg-0">
                        <div class="bg-primary mb-5 py-3">
                            <h3 class="text-white py-3 px-4 m-0">Course Features</h3>
                            <div class="d-flex justify-content-between border-bottom px-4">
                                <h6 class="text-white my-3">Instructor</h6>
                                <h6 class="text-white my-3">Alex</h6>
                            </div> 
                            <div class="d-flex justify-content-between border-bottom px-4">
                                <h6 class="text-white my-3">Lesson</h6>
                                <h6 class="text-white my-3">5</h6>
                            </div>
                        </div> 
                        <div class="mb-5">
                            <h2 class="mb-4">Recent Courses</h2>
                            <a class="d-flex align-items-center text-decoration-none mb-4" href="english.jsp">
                                <img class="img-fluid rounded" src="assets/courses-80x80.jpg" alt="">
                                <div class="pl-3">
                                    <h6>English</h6>
                                    <div class="d-flex">
                                        <small class="text-body mr-3"><i class="fa fa-user text-primary mr-2"></i>Robert</small>

                                    </div>
                                </div>
                            </a>
                            <a class="d-flex align-items-center text-decoration-none mb-4" href="lite.jsp">
                                <img class="img-fluid rounded" src="assets/courses-80x80.jpg" alt="">
                                <div class="pl-3">
                                    <h6>Literature</h6>
                                    <div class="d-flex">
                                        <small class="text-body mr-3"><i class="fa fa-user text-primary mr-2"></i>John</small>

                                    </div>
                                </div>
                            </a>
                            <a class="d-flex align-items-center text-decoration-none mb-4" href="chemistry.jsp">
                                <img class="img-fluid rounded" src="assets/courses-80x80.jpg" alt="">
                                <div class="pl-3">
                                    <h6>Chemistry</h6>
                                    <div class="d-flex">
                                        <small class="text-body mr-3"><i class="fa fa-user text-primary mr-2"></i>Nico</small>

                                    </div>
                                </div>

                            </a>
                        </div>
                    </div>
                </div>
            </div>                                       
        </div>
    </div>
    <!-- Detail End -->


    <div class="container-fluid position-relative overlay-top bg-dark text-white-50 py-5" style="margin-top: 90px;">
        <div class="container mt-5 pt-5">
            <div class="row">
                <div class="col-md-6 mb-5">
                    <a href="home?index=1" class="navbar-brand">
                        <h1 class="mt-n2 text-uppercase text-white"><i class="fa fa-book-reader mr-3"></i>Quiz</h1>
                    </a>
                    <p class="m-0">Learn, Learn More, Learn Forever
                    </p>
                </div>
                <div class="col-md-6 mb-5">
                    <h3 class="text-white mb-4">Newsletter</h3>
                    <div class="w-100">
                        <div class="input-group">
                            <input type="text" class="form-control border-light" style="padding: 30px;" placeholder="Your Email Address">
                            <div class="input-group-append">
                                <button class="btn btn-primary px-4">Sign Up</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 mb-5">
                    <h3 class="text-white mb-4">Get In Touch</h3>
                    <p><i class="fa fa-map-marker-alt mr-2"></i>FPT UNIVERSITY</p>
                    <p><i class="fa fa-phone-alt mr-2"></i>+012 345 67890</p>
                    <p><i class="fa fa-envelope mr-2"></i>minh@example.com</p>
                    <div class="d-flex justify-content-start mt-4">
                        <a class="text-white mr-4" href="#"><i class="fab fa-2x fa-twitter"></i></a>
                        <a class="text-white mr-4" href="#"><i class="fab fa-2x fa-facebook-f"></i></a>
                        <a class="text-white mr-4" href="#"><i class="fab fa-2x fa-linkedin-in"></i></a>
                        <a class="text-white" href="#"><i class="fab fa-2x fa-instagram"></i></a>
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <h3 class="text-white mb-4">Our Courses</h3>
                    <div class="d-flex flex-column justify-content-start">
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Web Design</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Apps Design</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Marketing</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Research</a>

                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <h3 class="text-white mb-4">Quick Links</h3>
                    <div class="d-flex flex-column justify-content-start">
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Privacy Policy</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Terms & Condition</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Regular FAQs</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Help & Support</a>
                        <a class="text-white-50" href="#"><i class="fa fa-angle-right mr-2"></i>Contact</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary rounded-0 btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary rounded-0 btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    <!-- JavaScript Libraries -->  
    <script src="lib/counterup/counterup.min.js"></script>
    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    <script src="js/search.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>