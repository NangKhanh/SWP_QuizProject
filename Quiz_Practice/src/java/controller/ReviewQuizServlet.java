 package controller;

import dao.QuizDAO;
import dao.QuizResultDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.QuizAnswer;
import model.QuizQuestion;
import model.QuizResultAnswer;
import model.QuizResultInformation;
import model.User;

public class ReviewQuizServlet extends HttpServlet {

    private List<QuizQuestion> questionList;
    private int currentIndex = 0;
    private int currentQuiz = 0;
    private boolean isInit = false;
    private int quizResultId = -1;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (Integer.parseInt(request.getParameter("quizResult")) != quizResultId || request.getParameter("quizResult") != null ) {
            isInit = false;
            quizResultId = 0;
            currentIndex = 0;
        }
        if (isInit == false) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            QuizDAO dao1 = new QuizDAO();
            QuizResultDAO daoResult = new QuizResultDAO();
            session.removeAttribute("currentAnswer");
            session.removeAttribute("answerOfQuestion");
            session.removeAttribute("currentQuestion");
            session.removeAttribute("currentAnswer");
            session.removeAttribute("currentIndex");
            session.removeAttribute("questionTotal");
            session.removeAttribute("allQuestion");
            session.removeAttribute("isShowProgress");
            quizResultId = Integer.parseInt(request.getParameter("quizResult"));
            questionList = new ArrayList<>();
            QuizResultInformation quizResult = daoResult.getQuizResultFromStudentIdAndQuizResultId(Integer.parseInt(user.getIdUser()), quizResultId);
            int count = 1;
            currentQuiz = quizResult.getQuiz().getId_quiz();
            String correctAnwser = "The correct answer is ";
            String explaination = "";
            ArrayList<QuizResultAnswer> quizResultAnswers = (ArrayList) quizResult.getQuizResultAnswers();
            for (QuizQuestion q : quizResult.getQuizQuestion()) {
                q.setQuestionOrderNumber(count);
                q.setListAnswer(new HashSet<>());
                for (QuizResultAnswer qa : quizResultAnswers) {
                    if (qa.getId_question() == q.getId_question() && qa.getId_result() == quizResultId) {
                        q.getListAnswer().add(qa.getId_answer());
                    }
                }
                questionList.add(q);
                count++;
            }
            ArrayList<QuizAnswer> quizAnswer = dao1.getAllAnswersByQuestionId(questionList.get(currentIndex).getId_question());
            for (QuizAnswer qa : quizAnswer) {
                qa.setIsChoose(false);
                
                if (qa.getStatus()) {
                    correctAnwser += qa.getContent_answer();
                    explaination = qa.getExplaination();
                }
                for (QuizResultAnswer qra : quizResultAnswers) {
                    if (qra.getId_answer() == qa.getId_answer()) {
                        qa.setIsChoose(true);
                        break;
                    }
                }
            }
            session.setAttribute("correctAnswer", correctAnwser);
            session.setAttribute("explaination", explaination);
            session.setAttribute("answerOfQuestion", quizAnswer);
            session.setAttribute("allQuestion", questionList);
            session.setAttribute("currentQuestion", questionList.get(currentIndex));
            session.setAttribute("currentIndex", currentIndex);
            session.setAttribute("questionTotal", questionList.size());
            session.setAttribute("isShowProgress", false);
            isInit = true;
            request.getRequestDispatcher("reviewAnswer.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("reviewAnswer.jsp").forward(request, response);
        }
    }

    private void moveToNextQuestion(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            String correctAnwser = "The correct answer is ";
            String explaination = "";
            User user = (User) session.getAttribute("user");
            QuizResultDAO daoResult = new QuizResultDAO();
            QuizDAO dao1 = new QuizDAO();
            currentIndex += 1;
            QuizResultInformation quizResult = daoResult.getQuizResultFromStudentIdAndQuizResultId(Integer.parseInt(user.getIdUser()), quizResultId);
            ArrayList<QuizAnswer> quizAnswer = dao1.getAllAnswersByQuestionId(questionList.get(currentIndex).getId_question());
            ArrayList<QuizResultAnswer> quizResultAnswers = (ArrayList) quizResult.getQuizResultAnswers();
            for (QuizAnswer qa : quizAnswer) {
                qa.setIsChoose(false);
                
                if (qa.getStatus()) {
                    correctAnwser += qa.getContent_answer();
                    explaination = qa.getExplaination();
                }
                for (QuizResultAnswer qra : quizResultAnswers) {
                    if (qra.getId_answer() == qa.getId_answer()) {
                        qa.setIsChoose(true);
                        questionList.get(currentIndex).getListAnswer().add(qa.getId_answer());
                        break;
                    }
                }
            }
            session.setAttribute("correctAnswer", correctAnwser);
            session.setAttribute("explaination", explaination);
            session.setAttribute("answerOfQuestion", quizAnswer);
            session.setAttribute("currentQuestion", questionList.get(currentIndex));
            session.setAttribute("currentIndex", currentIndex);
            session.setAttribute("isShowProgress", false);
            session.setAttribute("allQuestion", questionList);
            request.getRequestDispatcher("reviewAnswer.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ReviewQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void moveToPreviousQuestion(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            String correctAnwser = "The correct answer is ";
            String explaination = "";
            User user = (User) session.getAttribute("user");
            QuizResultDAO daoResult = new QuizResultDAO();
            QuizDAO dao1 = new QuizDAO();
            currentIndex -= 1;
            QuizResultInformation quizResult = daoResult.getQuizResultFromStudentIdAndQuizResultId(Integer.parseInt(user.getIdUser()), quizResultId);
            ArrayList<QuizAnswer> quizAnswer = dao1.getAllAnswersByQuestionId(questionList.get(currentIndex).getId_question());
            ArrayList<QuizResultAnswer> quizResultAnswers = (ArrayList) quizResult.getQuizResultAnswers();
            for (QuizAnswer qa : quizAnswer) {
                qa.setIsChoose(false);
                if (qa.getStatus()) {
                    correctAnwser += qa.getContent_answer();
                    explaination = qa.getExplaination();
                }
                for (QuizResultAnswer qra : quizResultAnswers) {
                    if (qra.getId_answer() == qa.getId_answer()) {
                        qa.setIsChoose(true);
                        questionList.get(currentIndex).getListAnswer().add(qa.getId_answer());
                        break;
                    }
                }
            }
            session.setAttribute("correctAnswer", correctAnwser);
            session.setAttribute("explaination", explaination);
            session.setAttribute("answerOfQuestion", quizAnswer);
            session.setAttribute("currentQuestion", questionList.get(currentIndex));
            session.setAttribute("currentIndex", currentIndex);
            session.setAttribute("isShowProgress", false);
            session.setAttribute("allQuestion", questionList);
            request.getRequestDispatcher("reviewAnswer.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ReviewQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void selectQuestionAt(HttpServletRequest request, HttpServletResponse response, int questionId) {
        try {
            HttpSession session = request.getSession(true);
            String correctAnwser = "The correct answer is ";
            String explaination = "";
            User user = (User) session.getAttribute("user");
            QuizResultDAO daoResult = new QuizResultDAO();
            QuizDAO dao1 = new QuizDAO();
            for (QuizQuestion q : questionList) {
                if (q.getId_question() == questionId) {
                    currentIndex = q.getQuestionOrderNumber() - 1;
                    currentQuiz = q.getId_question();
                    break;
                }
            }
            QuizResultInformation quizResult = daoResult.getQuizResultFromStudentIdAndQuizResultId(Integer.parseInt(user.getIdUser()), quizResultId);
            ArrayList<QuizAnswer> quizAnswer = dao1.getAllAnswersByQuestionId(questionList.get(currentIndex).getId_question());
            ArrayList<QuizResultAnswer> quizResultAnswers = (ArrayList) quizResult.getQuizResultAnswers();
            for (QuizAnswer qa : quizAnswer) {
                qa.setIsChoose(false);
                
                if (qa.getStatus()) {
                    correctAnwser += qa.getContent_answer();
                    explaination = qa.getExplaination();
                }
                
                for (QuizResultAnswer qra : quizResultAnswers) {
                    if (qra.getId_answer() == qa.getId_answer()) {
                        qa.setIsChoose(true);
                        questionList.get(currentIndex).getListAnswer().add(qa.getId_answer());
                        break;
                    }
                }
            }
            session.setAttribute("correctAnswer", correctAnwser);
            session.setAttribute("explaination", explaination);
            session.setAttribute("answerOfQuestion", quizAnswer);
            session.setAttribute("currentQuestion", questionList.get(currentIndex));
            session.setAttribute("currentIndex", currentIndex);
            session.setAttribute("isShowProgress", false);
            session.setAttribute("allQuestion", questionList);
            request.getRequestDispatcher("reviewAnswer.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ReviewQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getAllQuestions(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            session.setAttribute("allQuestion", this.questionList);
            session.setAttribute("isShowProgress", true);
            request.getRequestDispatcher("reviewAnswer.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(TakeQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getUnanswerQuestions(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<QuizQuestion> newQuestions = new ArrayList<>();
            HttpSession session = request.getSession(true);
            for (QuizQuestion q : questionList) {
                if (q.getListAnswer().isEmpty()) {
                    newQuestions.add(q);
                }
            }
            session.setAttribute("allQuestion", newQuestions);
            session.setAttribute("isShowProgress", true);
            request.getRequestDispatcher("reviewAnswer.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(TakeQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getAnsweredQuestions(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<QuizQuestion> newQuestions = new ArrayList<>();
            HttpSession session = request.getSession(true);
            for (QuizQuestion q : questionList) {
                if (!q.getListAnswer().isEmpty()) {
                    newQuestions.add(q);
                }
            }
            session.setAttribute("allQuestion", newQuestions);
            session.setAttribute("isShowProgress", true);
            request.getRequestDispatcher("reviewAnswer.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(TakeQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("btnNext") != null) {
            moveToNextQuestion(request, response);
        }

        if (request.getParameter("btnBefore") != null) {
            moveToPreviousQuestion(request, response);
        }

        if (request.getParameter("getAllQuestion") != null) {
            getAllQuestions(request, response);
        }

        if (request.getParameter("getAnsweredQuestion") != null) {
            getAnsweredQuestions(request, response);
        }

        if (request.getParameter("getUnansweredQuestion") != null) {
            getUnanswerQuestions(request, response);
        }

        if (request.getParameter("selectedQuestion") != null) {
            int questionId = Integer.parseInt(request.getParameter("selectedQuestion"));
            selectQuestionAt(request, response, questionId );
        }
        
        if (request.getParameter("exit") != null) {
            request.getRequestDispatcher("CalculateScoreServlet").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
