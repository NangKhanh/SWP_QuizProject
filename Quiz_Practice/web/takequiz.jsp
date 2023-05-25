<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take Quiz</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="bootstrap-icons/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/takequiz.css">
    </head>

    <body ${sessionScope.isShowProgress == true  ? "style = 'padding-right: 17px;' class = 'modal-open'" : "" } id = "body">
        <form id="quizresult" action = "takequiz" method="post">
            <div class="head row justify-content-between  ">
                <div class="col-7 text-white">
                    <h5>Question ${sessionScope.currentIndex + 1}: </h5>
                </div>
                <div class="col-3 text-white align-items-center"><i class="fa fa-hourglass-half"></i> <span id="countdown"></span> </div>
                <div class="col-2 text-white" >
                    <h5>Question ID: ${sessionScope.currentQuestion.getId_question()} </h5>
                </div>
            </div> 

            <div class="container mt-5">
                <div class="content">
                    <div class="row">
                        <div class="hh col-sm-12 ml-3">
                            <h5>${sessionScope.currentQuestion.getContent_question()}</h5>
                        </div>
                    </div>
                </div>

                <div class="form_check">
                    <div col-sm-12>
                        <c:forEach items="${sessionScope.answerOfQuestion}" var="answer">
                            <div class="custom-control custom-radio my-2 ml-5">
                                <input type="radio" onclick="HTMLFormElement.prototype.submit.call(this.form)"  id="${answer.getId_answer()}" value = "${answer.getId_answer()}" name = "answer"  ${answer.isIsChoose() == true ? "checked" : ""} class="custom-control-input">
                                <label class="custom-control-label" for="${answer.getId_answer()}"><h5 style="margin-left:30px; display: inline-block">${answer.getContent_answer()}</h5> </label>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="modal_button mr-3 mb-2">
                <!-- Button trigger modal -->
                <div class="row">
                    <div class="col-md-8">
                        <button type="button" class="btn btn-primary ml-4 " data-toggle="modal" data-target="#reivewPro">
                            Review Progress
                        </button>
                    </div>

                    <div class="col-md-4">
                        <div class="ml-5">
                            <button type="button" class="btn btn-outline-secondary ml-5 " data-toggle="modal"
                                    data-target="#peekAnswer">
                                Peek at Answer
                            </button>
                            <button type="submit" name = "markQuestion" class="btn btn-primary "> <i class="bi bi-bookmark"></i>${sessionScope.currentQuestion.isMarkedStatus() == true ? "Unmark Question" : "Mark Question"}</button>
                        </div>
                    </div>
                </div>
            </div>

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


                        <!-- Button modal-->
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#submitModal">
                            Submit
                        </button>
                        <div class="modal fade" id="submitModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="staticBackdropLabel">Score Exam?</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>

                                    <div class="modal-body">
                                        By clicking on the [Submit] button below, you will complete your current exam and 
                                        receive your score. You will not be able to change any answer after this point 
                                    </div>

                                    <form>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-outline-dark"" data-dismiss="modal"> <i class="bi bi-arrow-left"></i>Back</button>
                                            <input style="margin-left: 10px" id="submit" type="submit" name = "btnSubmit" onclick="getresult()"  class="btn btn-light my-1" value = "Submit"></input>
                                        </div>
                                    </form>

                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </footer>
        </form>


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
                        <p>The correct answer is D.</p>
                        <p>Agile Manifesto principle 6 states that face-to-face conversation is the most
                            effective way of conveying information to and within the development team. The other
                            options also have a role in aglie, but they aren't the answer the question</p>
                        <p>Domain: Agile Principle and Mindset. </p>
                        <p>Source: PMI-ACP Exam Prep</p>
                        <p>Page: 34</p>

                    </div>
                </div>
            </div>
        </div>


        <!-- Modal Review progress -->
        <div ${sessionScope.isShowProgress == true ? "class = 'modal fade show'" : "class = 'modal fade'" }  id="reivewPro" data-backdrop="static" data-keyboard="false" tabindex="-1"
                                                                                                             aria-labelledby="staticBackdropLabel" aria-hidden="true" ${sessionScope.isShowProgress == true ? "style ='display: block; padding-right: 17px;'" : "" }>
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="">Review Progress</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span onclick="onCloseReviewModal()" aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" style="overflow: hidden; height: 350px; overflow-y: auto;">
                        <form method="post" action = "takequiz">
                            Review before scoring exam.
                            <br />
                            <br />
                            <button type="submit" name = "getUnanswerQuestion" class="btn btn-outline-success"> <i class="bi bi-app"></i> Unanswered
                            </button>
                            <button type="submit" name = "getMarkedQuestion" class="btn btn-outline-success"> <i class="bi bi-bookmark-fill"></i>
                                Marked</button>
                            <button type="submit" name = "getAnsweredQuestion" class="btn btn-outline-success"> <i class="bi bi-dash-square-fill"></i>
                                Answered</button>
                            <button type="submit" name = "getAllQuestions" class="btn btn-outline-success">All Question</button>

                            <div class="card-boy mt-3" >
                                <div class="row">
                                    <c:forEach items="${allQuestion}" var="ques">
                                        <button type="submit" name = "selectedQuestion" value ="${ques.getId_question()}" ${ques.getListAnswer().size() > 0 ? "class='btn btn-success mx-1 my-1 col-md-1' style = '' " : "class='btn btn-outline-secondary mx-1 my-1 col-md-1'"}>${ques.getQuestionOrderNumber()} ${ques.isMarkedStatus() == true ? "<i class='bi bi-bookmark-fill'></i>" : ""} </button>
                                    </c:forEach>
                                </div>    
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" onclick="onCloseReviewModal()" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>


        <!-- Modal Button Submit -->
        <div class="modal fade" id="submitModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Score Exam?</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">
                        By clicking on the [Score Exam] button below, you will complete your current exam and 
                        receive your score. You will not be able to change any answer after this point 
                    </div>

                    <form>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-dark"" data-dismiss="modal"> <i class="bi bi-arrow-left"></i>Back</button>
                            <button type="button" class="btn btn-outline-success">Score Exam</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>

    </body>
    <c:if test="${sessionScope.isShowProgress && sessionScope.isShowProgress != null }">
        <div id = "modal-backdrop" class="modal-backdrop fade show"></div>
    </c:if>
    <script>
        function mark() {
            localStorage.setItem("bookmark1", "true");

            document.getElementById("markValue1").innerHTML = ' 1 <i class="bi bi-bookmark-fill"></i>';
            if (localStorage.getItem("bookmark1") === "true") {
                document.getElementById("markValue1").innerHTML = ' 1 <i class="bi bi-bookmark-fill"></i>';
            }

            const remainingMinutes = Math.floor(remainingTime / (60 * 1000));
            const remainingSeconds = Math.floor((remainingTime % (60 * 1000)) / 1000);
            countdownElement.textContent = `Time remaining: ` + remainingMinutes + `:` + remainingSeconds.toString().padStart(2, '0');

            window.localStorage.setItem('countdownEndTime', someMinutesLater);
        }

        function getresult() {
            window.localStorage.removeItem('countdownEndTime');
            document.getElementById("quizresult").submit();
            window.localStorage.setItem('countdownEndTime', null);
        }

        function onCloseReviewModal() {
            document.getElementById("body").className = "";
            document.getElementById("modal-backdrop").className = "";

            document.getElementById("reivewPro").style = "";
        }

//        function mark() {
//            localStorage.setItem("bookmark1", "true");
//            const markValueEl = document.getElementById("markValue1");
//            const iconEl = document.createElement("i");
//            iconEl.classList.add("bi", "bi-bookmark-fill");
//            markValueEl.innerHTML = "";
//            markValueEl.append(" 1 ", iconEl);
//            if (localStorage.getItem("bookmark1")) {
//                markValueEl.innerHTML = "";
//                markValueEl.append(" 1 ", iconEl);
//            }
//        }
    </script>


    <!-- JavaScript Libraries -->
    <script src="js/timeFinish.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="js/Hidepass.js"></script>    
</html>

</html>