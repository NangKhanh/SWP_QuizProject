<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
              integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
              crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="bootstrap-icons/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/answer.css">
    </head>

    <body ${sessionScope.isShowProgress == true  ? "style = 'padding-right: 17px;' class = 'modal-open'" : "" } id = "body">
        <form id="quizresult" action = "reviewQuiz" method="post">
            <header class="head">
                <div class="container">
                    <div class="row justify-content-between">
                        <div class="col-10 text-white">
                            <h5>Question ${sessionScope.currentIndex + 1}: </h5>
                        </div>
                        <div class="col-2 text-white">
                            <h5>Question ID: ${sessionScope.currentQuestion.getId_question()}</h5>
                        </div>
                    </div>

                </div>
            </header>

            <div class="container">
                <div class="content">
                    <div class="row">
                        <div class="hh col-sm-12">
                            <h5>${sessionScope.currentQuestion.getContent_question()}</h5>
                        </div>
                    </div>
                </div>

                <div class="form_check">
                    <div col-sm-12>
                        <c:forEach items="${sessionScope.answerOfQuestion}" var="answer">
                            <div class="custom-control custom-radio my-2 ml-5">
                                <c:if test="${answer.isStatus() == true}">
                                    <input type="radio" id="true" value="" name="" class="custom-control-input" checked
                                           readonly>
                                </c:if>

                                <c:if test="${answer.isStatus() == false && answer.isIsChoose() == false}">
                                    <input type="radio" id="" value="" name="" class="custom-control-input"
                                           readonly>
                                </c:if>

                                <c:if test="${answer.isStatus() == false && answer.isIsChoose() == true}">
                                    <input type="radio" id="false" value="" name="" class="custom-control-input" checked
                                           readonly>
                                </c:if>

                                <label class="custom-control-label">
                                    <h5 style="margin-left:30px; display: inline-block">${answer.getContent_answer()}</h5>
                                </label>

                                <c:if test="${answer.isStatus() == true && answer.isIsChoose() == false }">
                                    <i class="fa fa-check-circle"></i>
                                </c:if>

                                <c:if test="${answer.isStatus() == true && answer.isIsChoose() == true }">
                                    <i class="fa fa-check-circle"></i>
                                    <span class="correct_arrow">Your answer here</span>
                                </c:if>

                                <c:if test="${answer.isIsChoose() == true && answer.isStatus() == false  }">
                                    <i class="fa fa-exclamation-circle"></i>
                                    <span class="arrow">Your answer here</span>
                                </c:if>
                            </div>    
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="modal_button mr-3 mb-2">
                <!-- Button trigger modal -->
                <div class="row">
                    <div class="col-md-8 ">
                        <button type="button" class="btn btn-primary ml-4 " data-toggle="modal"
                                data-target="#reivewPro">
                            Review Progress
                        </button>
                    </div>

                    <div class="col-md-4">
                        <div class="ml-5">
                            <button type="button" class="btn btn-outline-secondary ml-5 " data-toggle="modal"
                                    data-target="#peekAnswer">
                                Peek at Answer
                            </button>
                            <button type="submit" name = "exit" class="btn btn-primary "> <i class="bi bi-bookmark"></i> Exit </button>
                        </div>

                    </div>


                </div>
            </div>

            <footer class="footer">
                <div class="container">
                    <footer class="footer py-5">
                        <div class="container">
                            <div class="row">
                                <div class="col align-self-start">
                                    <c:if test="${sessionScope.currentIndex > 0}">
                                        <input type="submit" name = "btnBefore" class="btn btn-light my-1" value = "Before"/>
                                    </c:if>
                                </div>
                                <c:if test="${sessionScope.currentIndex < sessionScope.questionTotal - 1}">
                                    <input type="submit" name="btnNext" class="btn btn-light my-1" value = "Next"></input> 
                                </c:if>
                            </div>
                        </div>
                </div>
            </footer>
        </div>
    </footer>


    <!-- Modal Peek at Answer -->
    <div class="modal fade show" id="peekAnswer" data-backdrop="static" data-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Peek at Answer</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>${correctAnswer}</p>
                    <p>${explaination}</p>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal Review progress -->
    <div ${sessionScope.isShowProgress == true ? "class = 'modal fade show'" : "class = 'modal fade'" } id="reivewPro" data-backdrop="static" data-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel" aria-hidden="true" ${sessionScope.isShowProgress == true ? "style ='display: block; padding-right: 17px;'" : "" }>
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Review Progress</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span onclick="onCloseReviewModal()" aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Review before scoring exam.
                    <br />
                    <br />
                    <button type="submit" name = "getUnansweredQuestion" class="btn btn-outline-success"> <i class="bi bi-app"></i> Unanswered
                    </button>
                    <button type="submit" name = "getAnsweredQuestion" class="btn btn-outline-success"> <i
                            class="bi bi-dash-square-fill"></i>
                        Answered</button>
                    <button type="submit" name = "getAllQuestion" class="btn btn-outline-success">All Question</button>
                    <br />
                    <div class="card-boy mt-3">
                        <div class="row">
                            <c:forEach items="${allQuestion}" var="ques">
                                <button type="submit" name = "selectedQuestion" value ="${ques.getId_question()}" ${ques.getListAnswer().size() > 0 ? "class='btn btn-success mx-1 my-1 col-md-1' style = '' " : "class='btn btn-outline-secondary mx-1 my-1 col-md-1'"}>${ques.getQuestionOrderNumber()} ${ques.isMarkedStatus() == true ? "<i class='bi bi-bookmark-fill'></i>" : ""} </button>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <!-- <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> -->
                    <button type="button"  onclick="onCloseReviewModal()" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<script>
    function onCloseReviewModal() {
        document.getElementById("body").className = "";
        document.getElementById("modal-backdrop").className = "";
        document.getElementById("reivewPro").style = "";
    }
</script>
<c:if test="${sessionScope.isShowProgress && sessionScope.isShowProgress != null }">
    <div id = "modal-backdrop" class="modal-backdrop fade show"></div>
</c:if>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="lib/counterup/counterup.min.js"></script>

</html>