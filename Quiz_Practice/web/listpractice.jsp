<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${user != null}">
    <!DOCTYPE html>
    <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="css/main3.css">
            <title>Document</title>
            <link href="img/favicon.ico" rel="icon">
            <!-- Google Web Fonts -->
            <link rel="preconnect" href="https://fonts.gstatic.com">
            <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600;700&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet"> 
            <!-- Font Awesome -->
            <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

            <!-- Customized Bootstrap Stylesheet -->
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
            <div class="container-fluid bg-dark">
                <div class="row py-2 px-lg-5">
                    <div class="col-lg-6 text-center text-lg-left mb-2 mb-lg-0">
                        <div class="d-inline-flex align-items-center text-white">
                            <small><i class="fa fa-phone-alt mr-2"></i>+012 345 6789</small>
                            <small class="px-3">|</small>
                            <small><i class="fa fa-envelope mr-2"></i>info@example.com</small>
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
                                <input type="hidden" value="${detail.getId_subject()}" name="idSubject"/>           
                                <input type="hidden" value="${lesson.getId_lesson()}" name="idLesson" />
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
                    <h1 class="text-white display-1">List Practice</h1>
                    <div class="mx-auto mb-5" style="width: 100%; max-width: 600px;">
                    </div>
                </div>
            </div>
            <!-- Header End -->
            <div id="div1">
                <div id="container">
                    <div id="item-center">
                        <h1 style="margin-bottom: 30px;">
                            Practices List
                        </h1>
                        <div style="display: flex; justify-content: space-between;">
                            <form action = "listPratice" method="post">
                                <select onchange="this.form.submit()" style="width: 200px; height: 30px;  margin-bottom: 30px; border: 1px solid #000;" name="subject" id="">
                                    <option ${subjectId == -1 ? 'selected="selected"' : ''} value = "-1" >ALL Subjects</option>
                                    <c:forEach items="${subjects}" var="sub">
                                        <option ${subjectId == sub.getId_subject() ? 'selected="selected"' : ''} value = "${sub.getId_subject()}" >${sub.name_subject}</option>
                                    </c:forEach>
                                </select>
                            </form>
                            <div>
                                <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">New Practice</button>
                                <button href="" type="button" class="btn btn-secondary">Simulation Exam</button>
                            </div>
                        </div>
                        <div style="padding-bottom: 5px">
                            <c:forEach items="${results}" var="res">
                                <div class="grid-item">
                                    <div style="display: flex; flex-direction: column; align-items: flex-start;">
                                        <p>${res.getSubject().getName_subject()}</p>
                                        <p>${res.getQuiz().getName_quiz()}</p>
                                    </div>
                                    <div>
                                        <p>${res.getQuizResult().getDate_taken()}</p>
                                        <p>Date taken</p>
                                    </div>
                                    <div>
                                        <p>${res.getCorrectAnswer()} Correct</p>
                                        <p>${res.getQuizQuestion().size()} Question</p>
                                    </div>
                                    <div>
                                        <p>${res.getCorrectPercentage()} %</p>
                                        <p>Correct</p>
                                    </div>
                                    <div>
                                        <a href="">View Details</a>
                                    </div>
                                </div>

                                <div class="item-last">
                                    <p>Duration - ${res.getQuiz().getTime()} minutes</p>
                                </div>
                            </c:forEach>
                        </div>
                        <div style="display: flex; justify-content: center; align-items: center;">
                            <form method = "post" action = "listPratice">
                                <c:if test = "${canNotLoadMore == true}"> 
                                    <button type="submit" class="btn btn-info" name="load_more" value="Loading">Load more</button> 
                                </c:if>

                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div id="div2" style="display:none;">
                <div id="formsubmit">
                    <form  action="">
                        <div class="save">
                            <div>
                                <h1>Practice Details</h1>
                            </div>
                            <div>
                                <p>Subject</p>
                                <select>
                                    <option value="">ALL</option>
                                    <option value="">1</option>
                                </select>
                            </div>

                            <div>
                                <p>Number of practicing questions</p>
                                <input style="border: 1px solid #000 ; height: 25px; width: 70%;" type="number" name="" >
                            </div>

                            <div>
                                <p>Question are selected by topic ?</p>
                                <select>
                                    <option value="">By subject</option>
                                    <option value="">1</option>
                                </select>
                            </div>

                            <div>
                                <p>Question group ?</p>
                                <select>
                                    <option value="">ALL</option>
                                    <option value="">1</option>
                                </select>
                            </div>
                            <div style="display: flex;">
                                <input style="width: 30%; font-size: 20px; border-radius: 3px; border: 1px solid #000; margin-top: 20px; margin-right: 20px;" type="submit" value="Practice">
                                <input style="width: 30%; font-size: 20px; border-radius: 3px; border: 1px solid #000; margin-top: 20px;" type="submit" value="Cancel">
                            </div>
                        </div>
                    </form>
                </div>
            </div>


            <!--    <script>
                    function showDiv2() {
                        var div1 = document.getElementById('div1');
                        var div2 = document.getElementById('div2');
                        div2.style.display = 'block';
                        div2.style.zIndex = '9999';
                    }
                </script>-->

            <!-- Modal New Practice -->      
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h2 class="modal-title" id="exampleModalLabel">Practice Details</h2>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action = "listPratice" method="post">
                                <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Subject ${subjectID}</label>
                                    <select name="subjectId" class="custom-select"> 
                                        <option selected>Open this select menu</option>
                                        <c:forEach items ="${subjectsList}" var="subj">
                                            <option value="${subj.getId_subject()}">${subj.getName_subject()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="number-questions"  class="col-form-label">Number of practicing questions</label>
                                    <input type="text" name ="limitQuestion" class="form-control" id="number-questions">
                                </div>

                                <div class="form-group">
                                    <label for="quizName"  class="col-form-label">Quiz Name</label>
                                    <input type="text"  name ="quizName" class="form-control" id="">
                                </div>

                                <div class="form-group">
                                    <label for="quizDescription"  class="col-form-label">Quiz Description</label>
                                    <input type="text" name ="quizDes" class="form-control" id="">
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" name="practice" class="btn btn-success">Practice</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </body>
        <!--    <script>
                function showDiv2() {
                    var div1 = document.getElementById('div1');
                    var div2 = document.getElementById('div2');
                    div2.style.display = 'block';
                    div2.style.zIndex = '9999';
                }
            </script>-->

        <div class="container-fluid position-relative overlay-top bg-dark text-white-50 py-5" style="margin-top: 90px;">
            <div class="container mt-5 pt-5">
                <div class="row">
                    <div class="col-md-6 mb-5">
                        <a href="home" class="navbar-brand">
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

        <!-- Modal of New Practice -->  
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h2 class="modal-title" id="exampleModalLabel">Practice Details</h2>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="subject" class="col-form-label">Subject</label>
                                <select class="custom-select">
                                    <option selected>Open this select menu</option>
                                    <c:forEach items ="${subjectsList}" var="subj">
                                        <option value="${subj.getId_subject()}">${subj.getName_subject()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="number-questions" class="col-form-label">Number of practicing questions</label>
                                <input type="text" class="form-control" id="number-questions">
                            </div>    

                            <div class="form-group">
                                <label for="quizName" class="col-form-label">Quiz Name</label>
                                <input type="text" class="form-control" id="">
                            </div>

                            <div class="form-group">
                                <label for="quizDesciption" class="col-form-label">Quiz Description</label>
                                <input type="text" class="form-control" id="">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-success">Practice</button>
                    </div>
                </div>
            </div>
        </div>
    </body>



    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
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

</html>
</c:if>