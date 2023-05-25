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
            </div>s
            <!-- Navbar End -->


            <!-- Header Start -->
            <div class="jumbotron jumbotron-fluid page-header position-relative overlay-bottom" style="margin-bottom: 0px;">
                <div class="container text-center py-5">
                    <div class="d-inline-flex text-white mb-5">
                        <h1 class="text-white display-1">Edit Quiz</h1>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header End -->
        <!-- Header End -->
        <div class="">

        </div>
        <div class="nav-link" id="profile-tab" data-toggle="tab" data-target="#profile" 
             role="tab" aria-controls="profile" aria-selected="false">Edit Quiz</div>
        <form action="updatequiz" method="post" class="container col-11">
            <div class="">
                <c:forEach items="${listQuiz}" var="quiz">
                    <div class="d-flex">
                        <div class="d-flex" style="margin-left: 20px;">
                            <label for="quizName">Quiz's Name</label>
                            <input class="form-control" type="text" name="quizName" required  value="${quiz.getName_quiz()}"
                                   style="width: 200px; height: 38px;  margin-bottom: 38px; margin-left: 10px;">
                            <input type="hidden" name="idQuiz" value="${quiz.getId_quiz()}">
                        </div>
                        <div class="d-flex" style="margin-left: 20px;">
                            <label for="quizDescription">Quiz's Description</label>
                            <input class="form-control" type="text" name="quizDescription" required value="${quiz.getDescription_quiz()}"
                                   style="width: 200px; height: 38px;  margin-bottom: 38px; margin-left: 10px;">
                        </div>
                        <div class="d-flex" style="margin-left: 20px;">
                            <label for="quizTime">Time</label>
                            <input class="form-control" type="number" name="quizTime" min="1" max="60" required="" value="${quiz.getTime()}"
                                   style="width: 200px; height: 38px;  margin-bottom: 38px; margin-left: 10px;">
                        </div>
                        <div class="d-flex" style="margin-left: 20px;">
                            <label for="quizNumberQuestion">Number of question </label>
                            <input class="form-control" type="number" name="quizNumberQuestion" min="1" max="60" required="" value="${quiz.getQuestion_number()}"
                                   style="width: 200px; height: 38px;  margin-bottom: 38px; margin-left: 10px;">
                        </div>
                    </div>
                </c:forEach>

                <%
                    int currentrow = 0;        
                %>
                <table id="myTable" class="table">

                    <thead>
                        <tr>
                            <th scope="col">Question ID</th>
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
                        <c:forEach items="${listQuestion}" var="question">
                            <tr class="content">
                                <%
                                int count =0;
                                currentrow++;
                                int countanswer=1;
                                String namecol0 = "col0["+currentrow+"]";
                                String namecol1 = "col1["+currentrow+"]";
                                String correctAnswer = "correctAnswer["+currentrow+"]";
                                String explaination = "explaination["+currentrow+"]";
                                request.setAttribute("namecol1", namecol1);
                                request.setAttribute("namecol0", namecol0);
                                request.setAttribute("correctAnswer", correctAnswer);
                                request.setAttribute("explaination",explaination);
                                %>

                                <td scope="row"><input class="form-control" style="width: 60px; margin-top: 25px" name="${namecol0}" value="${question.getId_question()}" readonly=""></td>
                                <td><textarea class="form-control" name="${namecol1}" style="height: 38px;margin-top: 25px" required>${question.getContent_question()}</textarea>
                                </td>

                                <c:forEach items="${listAnswer}" var="answer">  

                                    <c:choose>
                                        <c:when test="${question.getId_question() == answer.getId_question()}">
                                            <%
                                                countanswer++;
                                                String namecol2 = "col"+countanswer+"["+currentrow+"]";
                                                String idAnswer = "idAnswer"+countanswer+"["+currentrow+"]";
                                                request.setAttribute("namecol2", namecol2);
                                                request.setAttribute("idAnswer", idAnswer);
                                            %>

                                            <td>
                                                <label for="${namecol2}"></label>
                                                <input class="form-control" type="text" name="${namecol2}" required value="${answer.getContent_answer()}"> 
                                                <label for="${idAnswer}"></label>
                                                <input type="hidden" name="${idAnswer}" value="${answer.getId_answer()}">
                                            </td>

                                        </c:when>
                                        <c:otherwise>
                                        </c:otherwise>

                                    </c:choose>
                                </c:forEach>
                                <c:forEach items="${listAnswer}" var="answer">                              
                                    <c:choose>
                                        <c:when test="${question.getId_question() == answer.getId_question()}">
                                            <%
                                                count++;
                                            %>
                                            <c:if test="${answer.getStatus() == true}">

                                                <%
                                                    request.setAttribute("count", count);
                                                %>
                                                <td><select class="form-control"
                                                            style=" height: 38px;  margin-bottom: 30px; border: 1px solid #000; margin-top: 25px" name="${correctAnswer}"
                                                            id="">

                                                        <c:choose>
                                                            <c:when test="${count==1}">
                                                                <option value="1" selected="selected">Answer 1</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="1">Answer 1</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <c:choose>
                                                            <c:when test="${count==2}">
                                                                <option value="2" selected="selected">Answer 2</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="2">Answer 2</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <c:choose>
                                                            <c:when test="${count==3}">
                                                                <option value="3" selected="selected">Answer 3</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="3">Answer 3</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <c:choose>
                                                            <c:when test="${count==4}">
                                                                <option value="4" selected="selected">Answer 4</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="4">Answer 4</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </select></td>
                                                    <td>
                                                        <label for="${explaination}"></label>
                                                        <input class="form-control" type="text" name="${explaination}" required="" value="${answer.getExplaination()}"> 
                                                    </td>
                                                </c:if>
                                            </c:when>
                                            <c:otherwise>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>  
                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div style="margin-bottom: 35px;">

                    <%
                        request.setAttribute("currentrow", currentrow);
                    %>
                    <input type="hidden" name="currentrow" value="${currentrow}">
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
                            <div class="input-group-append" >
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