<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:if test="${sessionScope.user.getRoleId() == 1|| sessionScope.user.getRoleId()==2}">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Google Web Fonts -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600;700&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

        <link href="css/style.css" rel="stylesheet">
<!--        <link href="css/main4.css" rel="stylesheet">-->

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
        <div class="jumbotron jumbotron-fluid page-header position-relative overlay-bottom" style="margin-bottom: 90px;">
            <div class="container text-center py-5">
                <h1 class="text-white display-1">List Subject</h1>

                <div class="mx-auto mb-5" style="width: 100%; max-width: 600px;">
                    <div class="input-group">

                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-8"><h2>Subject Manager</h2></div>
                        <div class="col-sm-4">
                            <a href="#addEmployeeModal" class="btn btn-info add-new" data-toggle="modal" >Add New</a>
                        </div>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Image</th>
                            <th scope="col">Lecture</th>
                            <th scope="col">Name</th>
                            <th scope="col">Grade</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listN}" var="lit">
                            <tr>
                                <th  scope="row">${lit.id_subject}</th>
                                <td>${lit.icon}</td>
                                <td>${lit.id_user}</td>
                                <td>${lit.name_subject}</td>
                                <td>${lit.grade}</td>
                                <td>

                                    <a href="#editEmployeeModal" class="edit" data-toggle="modal" title="Edit"><i onclick="getSubject(${lit.id_subject})" class="material-icons">&#xE254;</i></a>

                                    <a href="#deleteEmployeeModal" data-toggle="modal" class="delete" title="Delete" ><i onclick="setId(${lit.id_subject})" class="material-icons">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="addSubject" method="post" enctype="multipart/form-data" >
                        <div class="modal-header">						
                            <h4 class="modal-title">Add </h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <textarea name="description" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Grade</label>                               
                                <select class="custom-select" name="grade">                                 
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select class="custom-select" name="cate">
                                    <c:forEach var="o" items="${listC}">
                                        <option value="${o.categoryID}">${o.categoryName}</option>
                                    </c:forEach>

                                </select>
                            </div>
                            <div class="form-group">
                                <label>Image</label>

                                <input required="" type="file" name="image" placeholder="image link" class="form-control"/>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div id="editEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="subjectcrud" method="post" enctype="multipart/form-data">
                        <input id="sid" name="id" hidden />
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit </h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>

                        <div class="modal-body">	
                            <input id="sid" name="id" hidden />
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" type="text" id="editName"  class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <textarea name="description" id="editDes" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Grade</label>

                                <select class="custom-select" id="" name="grade">                                 
                                    <option  ${u.grade==10? "selected":""} value="10">10</option>
                                    <option  ${u.grade==11? "selected":""} value="11">11</option>
                                    <option  ${u.grade==12? "selected":""} value="12">12</option>

                                </select>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select class="custom-select" id="editCategory" name="cate">
                                    <c:forEach var="o" items="${listC}">
                                        <option  value="${o.categoryID}">${o.categoryName}</option>
                                    </c:forEach>

                                </select>
                            </div>

                            <label>Image</label>
                            <input type="file" name="image" id="icon" class="form-control" />


                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Submit">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div id="deleteEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="deletesubject">
                        <input id="deleteid" name="id" hidden=""/>
                        <div class="modal-header">						
                            <h4 class="modal-title">Delete?</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <p>Are you sure you want to delete this subject?</p>
                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-danger" value="Delete">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </a>
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
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script>
                                        const setId = (id) => {
                                            document.getElementById('deleteid').value = id;
                                        };
                                        async function getSubject(id) {
                                            const res = await ((await fetch("api?action=subject&id=" + id)).json());
                                            document.getElementById("sid").value = res.id_subject;
                                            document.getElementById("editName").value = res.name_subject;
                                            document.getElementById("editDes").innerHTML = res.description_subject;
                                            document.getElementById("icon").value = res.icon;
                                            document.getElementById("grade").value = res.grade
                                            document.getElementById("icon").value = res.icon
                                            document.getElementById("editCategory").value = res.id_subcate;
                                        }
    </script>
    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    <!-- JavaScript Libraries -->  
    <script src="lib/counterup/counterup.min.js"></script>
    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    <script src="js/search.js"></script>     

</body>
</html>
</c:if>