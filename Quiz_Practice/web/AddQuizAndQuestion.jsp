<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<c:if test="${sessionScope.user.getRoleId() == 1|| sessionScope.user.getRoleId()==2}">
    <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>CURD</title>
            <link rel="stylesheet" href="css/login.css">
            <!-- bootstrap file here -->
            <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
            <!-- Favicon -->
            <link href="img/favicon.ico" rel="icon">

            <!-- Google Web Fonts -->
            <link rel="preconnect" href="https://fonts.gstatic.com">
            <link
                href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600;700&family=Open+Sans:wght@400;600&display=swap"
                rel="stylesheet">

            <!-- Font Awesome -->
            <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

            <!-- Libraries Stylesheet -->


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
            <div class="jumbotron jumbotron-fluid page-header position-relative overlay-bottom" style="margin-bottom: 0px;">
                <div class="container text-center py-5">
                    <div class="d-inline-flex text-white mb-5">
                        <h1 class="text-white display-1">Add Quiz</h1>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header End -->
        <!-- Header End -->
        <div class="">

        </div>
        <div class="nav-link" id="profile-tab" data-toggle="tab" data-target="#profile" 
             role="tab" aria-controls="profile" aria-selected="false">Add Quiz</div>
        <form action="addquestion" method="post" class="container col-11">
            <div class="">
                <div class="d-flex">
                    <div class="d-flex" style="margin-left: 20px;">
                        Quiz's Name <input class="form-control" type="text" name="quizName" required=""
                                           style="width: 200px; height: 38px;  margin-bottom: 38px; margin-left: 10px;">
                    </div>
                    <div class="d-flex" style="margin-left: 20px;">
                        Quiz's Description <input class="form-control" type="text" name="quizDescription" required=""
                                                  style="width: 200px; height: 38px;  margin-bottom: 38px; margin-left: 10px;">
                    </div>
                    <div class="d-flex" style="margin-left: 20px;">
                        Time <input class="form-control" type="number" name="quizTime" required="" min="1" max="60"
                                    style="width: 200px; height: 38px;  margin-bottom: 38px; margin-left: 10px;">
                    </div>
                    <div class="d-flex" style="margin-left: 20px;">
                        Number of question <input class="form-control" type="number" name="quizNumberQuestion" min="1" max="60" required=""
                                                  id="numberquestion" style="width: 200px; height: 38px;  margin-bottom: 38px; margin-left: 10px;" readonly="">
                    </div>
                </div>
                <table id="myTable" class="table">

                    <thead>
                        <tr>
                            <th scope="col">Question</th>
                            <th scope="col">Question's Content</th>
                            <th scope="col">Answer 1</th>
                            <th scope="col">Answer 2</th>
                            <th scope="col">Answer 3</th>
                            <th scope="col">Answer 4</th>
                            <th scope="col">Correct answer</th>
                            <th scope="col">Explanation</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="content">
                            <td scope="row">1</td>
                            <td><textarea class="form-control" name="col1[1]" style="height: 38px;" required></textarea>
                            </td>
                            <td><input class="form-control" type="text" name="col2[1]" required /></td>
                            <td><input class="form-control" type="text" name="col3[1]" required /></td>
                            <td><input class="form-control" type="text" name="col4[1]" required/></td>
                            <td><input class="form-control" type="text" name="col5[1]" required /></td>
                            <td><select class="form-control"
                                        style=" height: 38px;  margin-bottom: 30px; border: 1px solid #000;" name="correctAnswer[1]"
                                        id="">
                                    <option value="1">Answer 1</option>
                                    <option value="2">Answer 2</option>
                                    <option value="3">Answer 3</option>
                                    <option value="4">Answer 4</option>
                                </select></td>
                            <td><textarea class="form-control" name="explaination[1]" style="height: 38px;" required></textarea>
<!--                            <td><input class="btn btn-danger" value="Delete" style="width: 100px;" readonly></td>-->
                        </tr>
                    </tbody>
                </table>
                <div style="margin-bottom: 35px;">
                    <input type="hidden" name="currentrow" id="currentrow">
                    <input id="addRow" class="btn btn-danger" value="+" style="height: 29.2px; width: 50px;"
                           readonly>
                    <%
                        int idLesson = Integer.parseInt(request.getParameter("idLesson"));
                        request.setAttribute("idLesson", idLesson);
                    %>
                    <input type="hidden" name="idLesson" value="${idLesson}">
                    <input type="submit" class="btn btn-primary" value="Submit" style="height: 29.2px;  width: 100px;"
                           readonly>
                </div>
            </div>
        </form>
    </div>

    <!-- Footer Start -->
    <div class="container-fluid position-relative overlay-top bg-dark text-white-50 py-5">
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
                            <input type="text" class="form-control border-light" style="padding: 30px;"
                                   placeholder="Your Email Address">
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
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Privacy
                            Policy</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Terms &
                            Condition</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Regular
                            FAQs</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Help &
                            Support</a>
                        <a class="text-white-50" href="#"><i class="fa fa-angle-right mr-2"></i>Contact</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer End -->
    <a href="#" class="btn btn-lg btn-primary rounded-0 btn-lg-square back-to-top"><i
            class="fa fa-angle-double-up"></i></a>
    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="js/addRow.js"></script>

</html>
</c:if>