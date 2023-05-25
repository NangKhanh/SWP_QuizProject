<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:if test="${sessionScope.user.getRoleId() == 1}">
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="bootstrap-icons/font/bootstrap-icons.css">
        <!-- Google Web Fonts -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600;700&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/main4.css" rel="stylesheet">
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
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">List</a>
                            <div class="dropdown-menu m-0">
                                <a href="listPratice" class="dropdown-item">List Practice</a>
                                <a href="subjectcrud" class="dropdown-item">List Subject</a>
                                <a href="listcustomer" class="dropdown-item">List Customer</a>
                                <form action="crudquiz" method="get" >
                                            <input type="submit" value="Edit Quiz" class="dropdown-item" />
                                        </form>
                            </div>

                        </div>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">${user.getNameUser()}</a>
                            <div class="dropdown-menu m-0">
                                <a href="userdetail.jsp" class="dropdown-item">Profile</a>
                                
                                <a href="Logout" class="dropdown-item">Logout</a>
                            </div>
                        </div>
                    </div>

                </div>
            </nav>
        </div>

        <div class="jumbotron jumbotron-fluid page-header position-relative overlay-bottom" style="margin-bottom: 90px;">
            <div class="container text-center py-5">
                <h1 class="text-white display-1">List Customer</h1>
                <div class="mx-auto mb-5" style="width: 100%; max-width: 600px;">
                    <div class="input-group">
                    </div>
                </div>
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="debit-manage card">
                    <!--                    <div class=" card-header">
                                            <div class="row">
                                                <div class="col-12">
                                                    <div class="left">
                                                        <button type="button" class="btn btn-info">Add New</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>-->
                    <form action="" method="">
                        <div class="card-body" style="text-align: center;padding:1.5rem;">
                            <div class="row">

                                <div class="table-responsive">

                                    <table id="debtTable" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th class="col-1">ID</th>
                                                <th class="col-2">Name</th>
                                                <th class="col-2">Role</th>
                                                <th class="col-1">Date of Birth</th>
                                                <th class="col-2">Address</th>
                                                <th class="col-2">Phone Number </th>
                                                <th class="col-3">Email</th>
                                                <th class="col-1">Action</th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="o" items="${userList}">
                                            <c:if test="${o.getStatus()>0}">
                                            <tbody>
                                                <tr>
                                                    <td>${o.getIdUser()}</td>
                                                    <td>${o.getNameUser()}</td>
                                                    <c:if test="${o.getRoleId()==1}">
                                                    <td>Admin</td>
                                                    </c:if>
                                                    <c:if test="${o.getRoleId()==2}">
                                                    <td>Expert</td>
                                                    </c:if>
                                                    <c:if test="${o.getRoleId()==3}">
                                                    <td>Student</td>
                                                    </c:if>
                                                    <td>${o.getBirthDate()}</td>
                                                    <td>${o.getAddress()}</td>
                                                    <td>${o.getPhone()}</td>
                                                    <td>${o.getEmail()}</td>
                                                    <td>
                                                        
                                                        <a href="#editEmployeeModal" class="edit" title="Edit" data-toggle="modal" data-target="#exampleModal"><i class="material-icons">&#xE254;</i></a>
                                                        <c:if test="${o.getRoleId()==2||o.getRoleId()==3}">
                                                            <a href="blockUser?userid=${o.getIdUser()}"  onclick="checkBlock(); return false;"  class="delete" title="Block" data-toggle="tooltip"><i
                                                                    class="material-icons">&#xe86c;</i>
                                                            </a>
                                                                    </c:if>
                                                    </td>
                                                </tr>
                                            </tbody>
                                            </c:if>
                                            <c:if test="${o.getStatus()<1}">
                                            <tbody>
                                                <tr>
                                                    <td>${o.getIdUser()}</td>
                                                    <td>${o.getNameUser()}</td>
                                                    <c:if test="${o.getRoleId()==1}">
                                                    <td>Admin</td>
                                                    </c:if>
                                                    <c:if test="${o.getRoleId()==2}">
                                                    <td>Expert</td>
                                                    </c:if>
                                                    <c:if test="${o.getRoleId()==3}">
                                                    <td>Student</td>
                                                    </c:if>
                                                    <td>${o.getBirthDate()}</td>
                                                    <td>${o.getAddress()}</td>
                                                    <td>${o.getPhone()}</td>
                                                    <td>${o.getEmail()}</td>
                                                    <td>
                                                        <a href="#editEmployeeModal" class="edit" title="Edit" data-toggle="modal" data-target="#exampleModal"><i class="material-icons">&#xE254;</i></a>
                                                        <c:if test="${o.getRoleId()==2||o.getRoleId()==3}">
                                                        
                                                            <a href="unblockUser?userid=${o.getIdUser()}"  onclick="checkUnblock(); return false;"  class="delete" title="UnBlock" data-toggle="tooltip"><i
                                                                    class="material-icons">&#xE5C9;</i>
                                                            </a>
                                                        </c:if>
                                                        
                                                    </td>
                                                </tr>
                                            </tbody>
                                            </c:if>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                            <!--                            <div class="under-card row">
                                                            <div class="col-3">
                                                                <div class="previous" style="margin-top: 10px;">
                                                                    <button type="button" disabled="" class="btn">Previous</button>
                                                                </div>
                                                            </div>
                                                            <div class="col-6">
                                                                <div class="row" style="align-items: flex-end;">
                                                                    <div class="col-6">
                                                                        <div class="pagination-bottom">
                                                                            <div id="pagination">
                                                                                <div class="center" style="margin-top: 10px;">
                            
                                                                                    <span class="pageInfo">
                                                                                        <div class="row">
                                                                                            <div class="col-6" style="text-align: end"> Page
                                                                                            </div>
                                                                                            <div class="pageJump ">
                                                                                                <div class="col-3">
                                                                                                    <input id="jumpToPage" type="number" value="1"
                                                                                                           min="1" max="0">
                                                                                                </div>
                                                                                            </div>
                                                                                            <div>
                                                                                                <span class="totalPages">0</span>
                            
                                                                                            </div>
                                                                                        </div>
                                                                                    </span>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-6" style="text-align: center;">
                                                                        <div class="new" style="margin-top: 10px;">
                            
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-3" style="text-align: end;">
                                                                <div class="next" style="margin-top: 10px;">
                                                                    <button type="button" class="btn">Next</button>
                                                                </div>
                                                            </div>
                                                        </div>-->
                        </div>
                    </form>

                </div>

            </div>
        </div>

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
    <div id="deleteEmployeeModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form>
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

    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="modal-title" id="exampleModalLabel">Edit</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form  action="listcustomer" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <input type="text" class="form-control userId-hidden" name="userid" hidden>
                        </div>

                        <div class="form-group">
                            <label for="name" class="col-form-label">Name</label>

                            <input name="name_user" type="text" class="form-control userName-hidden" value="" required >
                        </div>
                        
                        <div class="form-group">
                            <label for="dateOfbirth" class="col-form-label">Date of Birth</label>
                            <input name="" type="text" class="form-control userDate-hidden" value="" disabled>
                        </div>
                        
                        <div class="form-group">
                            <label for="address" class="col-form-label">Address</label>
                            <input name="" type="text" class="form-control userAddress-hidden" value="" disabled>
                        </div>
                        
                        <div class="form-group">
                            <label for="phoneNum" class="col-form-label">Phone Number</label>
                            <input name="" type="text" class="form-control userPhone-hidden" value="" disabled>
                        </div>
                        
                        <div class="form-group">
                            <label for="email" class="col-form-label">Email</label>
                            <input name="" type="text" class="form-control userEmail-hidden" value="" disabled>
                        </div>                                          
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-success" value="Save">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

</html>
<script>
    $(document).ready(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });
    function checkBlock() {
        if (confirm('Are you sure you want to block?'))
        {
            your_form_variable.submit();
        }
    }
</script>
<script>
    $(document).ready(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });
    function checkUnblock() {
        if (confirm('Are you sure you want to unblock?'))
        {
            your_form_variable.submit();
        }
    }
</script>
<script>
    const querySelectorId = "#debtTable > tbody > tr > td:nth-child(1)";
    const querySelectorName = "#debtTable > tbody > tr > td:nth-child(2)";
    const querySelectorDate = "#debtTable > tbody > tr > td:nth-child(4)";
    const querySelectorAddress = "#debtTable > tbody > tr > td:nth-child(5)";
    const querySelectorPhone = "#debtTable > tbody > tr > td:nth-child(6)";
    const querySelectorEmail = "#debtTable > tbody > tr > td:nth-child(7)";
    const buttonSelector = "#debtTable > tbody > tr > td:nth-child(8) > a.edit";
    document.querySelectorAll(buttonSelector).forEach((element, index) => {
        element.addEventListener("click", function () {
            document.querySelector(".userId-hidden").value = document.querySelectorAll(querySelectorId)[index].innerHTML
             document.querySelector(".userName-hidden").value = document.querySelectorAll(querySelectorName)[index].innerHTML
             document.querySelector(".userDate-hidden").value = document.querySelectorAll(querySelectorDate)[index].innerHTML
             document.querySelector(".userAddress-hidden").value = document.querySelectorAll(querySelectorAddress)[index].innerHTML
             document.querySelector(".userPhone-hidden").value = document.querySelectorAll(querySelectorPhone)[index].innerHTML
             document.querySelector(".userEmail-hidden").value = document.querySelectorAll(querySelectorEmail)[index].innerHTML
        });
    });
</script>
<script src="node_modules/jquery/dist/jquery.min.js"></script>
<script src="node_modules/popper.js/dist/popper.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@2.9.3/dist/umd/popper.min.js"
        integrity="sha384-9apDh2e7scHlvpgEAGzgKx88huhp5Y3q5b5P5G5A5vdaS2U6Cfzpwod+tU6Pn4l4"
crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous"></script>
</c:if>
