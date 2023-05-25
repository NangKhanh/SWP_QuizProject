/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.QuizResultAnswerDAO;
import dao.QuizDAO;
import dao.QuizResultDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.QuizAnswer;
import model.QuizQuestion;
import model.QuizResult;
import model.QuizResultAnswer;

/**
 *
 * @author longc
 */
public class TakeQuizServlet extends HttpServlet {

    private List<QuizQuestion> questionList;
    private int currentIndex = 0;
    private int currentQuiz = 0;
    private boolean isInit = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (Integer.parseInt(request.getParameter("qid")) != currentQuiz || request.getParameter("qid") != null) {
            isInit = false;
            currentQuiz = 0;
            currentIndex = 0;
        }
        if (isInit == false) {
            QuizDAO dao1 = new QuizDAO();
            QuizResultDAO daoResult = new QuizResultDAO();
            int id_quiz = Integer.parseInt(request.getParameter("qid"));
            int id_user = Integer.parseInt(request.getParameter("idUser"));
            if (currentQuiz == 0) {
                if (request.getParameter("qid") != null) {
                    currentQuiz = Integer.parseInt(request.getParameter("qid"));
                }
            }
            HttpSession session = request.getSession(true);
            ArrayList<QuizResult> listResult = (ArrayList<QuizResult>) session.getAttribute("listResult");
            if (listResult == null) {
                LocalDate localDate = LocalDate.now();
                Date oldDate = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                java.sql.Date sqlDate = new java.sql.Date(oldDate.getTime());
                daoResult.addNewRecordResult(id_user, id_quiz, sqlDate);
                int idResult = daoResult.getResultId(id_quiz, id_user);
                listResult = daoResult.getInfoPractice(idResult);
                session.setAttribute("listResult", listResult);
            }
            session.removeAttribute("currentAnswer");
            session.removeAttribute("answerOfQuestion");
            session.removeAttribute("currentQuestion");
            session.removeAttribute("currentAnswer");
            session.removeAttribute("currentIndex");
            session.removeAttribute("questionTotal");
            session.removeAttribute("allQuestion");
            session.removeAttribute("isShowProgress");
            currentIndex = 0;
            questionList = new ArrayList<>();
            int count = 1;
            for (QuizQuestion q : dao1.getAllQuestionsByQuiz(currentQuiz)) {
                q.setMarkedStatus(false);
                q.setQuestionOrderNumber(count);
                q.setListAnswer(new HashSet<>());
                questionList.add(q);
                count++;
            }
            ArrayList<QuizAnswer> quizAnswer = dao1.getAllAnswersByQuestionId(questionList.get(currentIndex).getId_question());
            session.setAttribute("answerOfQuestion", quizAnswer);
            session.setAttribute("allQuestion", questionList);
            session.setAttribute("currentQuestion", questionList.get(currentIndex));
            session.setAttribute("currentIndex", currentIndex);
            session.setAttribute("questionTotal", dao1.getTotalQuestionByQuizId(currentQuiz));
            session.setAttribute("isShowProgress", false);
            isInit = true;
            request.getRequestDispatcher("takequiz.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("takequiz.jsp").forward(request, response);
        }
//        QuizDAO dao1 = new QuizDAO();
//        int id_quiz = Integer.parseInt(request.getParameter("qid"));
//        int id_user = Integer.parseInt(request.getParameter("idUser"));
//        QuizResultDAO daoResult = new QuizResultDAO();
//        HttpSession session = request.getSession(true);
//        ArrayList<QuizResult> listResult = (ArrayList<QuizResult>) session.getAttribute("listResult");
//        if (listResult == null) {
//            daoResult.addNewRecordResult(id_user, id_quiz);
//            int idResult = daoResult.getResultId(id_quiz, id_user);
//            listResult = daoResult.getInfoPractice(idResult);
//            session.setAttribute("listResult", listResult);
//        }
//        session.removeAttribute("currentAnswer");
//        session.removeAttribute("answerOfQuestion");
//        session.removeAttribute("currentQuestion");
//        session.removeAttribute("currentAnswer");
//        session.removeAttribute("currentIndex");
//        session.removeAttribute("questionTotal");
//        session.removeAttribute("allQuestion");
//        session.removeAttribute("isShowProgress");
//        currentIndex = 0;
//        questionList = new ArrayList<>();
//        int count = 1;
//        for (QuizQuestion q : dao1.getAllQuestionsByQuiz(id_quiz)) {
//            q.setMarkedStatus(false);
//            q.setQuestionOrderNumber(count);
//            q.setListAnswer(new HashSet<>());
//            questionList.add(q);
//            count++;
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("btnNext") != null) {
            int answerId = -1;
            if (request.getParameter("answer") != null) {
                answerId = Integer.parseInt(request.getParameter("answer"));
                questionList.get(currentIndex).getListAnswer().add(answerId);
                QuizResultAnswerDAO dao = new QuizResultAnswerDAO();
                HttpSession session = request.getSession();
                ArrayList<QuizResult> listResult = (ArrayList<QuizResult>) session.getAttribute("listResult");
                QuizResultAnswer quizResultAnswers = dao.checkUserAnswer(listResult.get(0).getIdResult(), questionList.get(currentIndex).getId_question());
                if (quizResultAnswers == null) {
                    dao.addUserAnswer(listResult.get(0).getId_result(), questionList.get(currentIndex).getId_question(), answerId);
                } else {
                    dao.updateUserAnswer(questionList.get(currentIndex).getId_question(), answerId, listResult.get(0).getId_result());
                }
            }
            moveToNextQuestion(request, response);
            return;
        }

        if (request.getParameter("btnSubmit") != null) {
            if (request.getParameter("answer") != null) {
                int answerId = Integer.parseInt(request.getParameter("answer"));
                HttpSession session = request.getSession();
                ArrayList<QuizResult> listResult = (ArrayList<QuizResult>) session.getAttribute("listResult");
                QuizResultAnswerDAO dao = new QuizResultAnswerDAO();
                QuizResultAnswer quizResultAnswers = dao.checkUserAnswer(listResult.get(0).getIdResult(), questionList.get(currentIndex).getId_question());
                if (quizResultAnswers == null) {
                    dao.addUserAnswer(listResult.get(0).getIdResult(), questionList.get(currentIndex).getId_question(), answerId);
                } else {
                    dao.updateUserAnswer(questionList.get(currentIndex).getId_question(), answerId, listResult.get(0).getIdResult());
                }
            }
            isInit = false;
            request.getSession().setAttribute("isDoingQuiz", false);
            request.getRequestDispatcher("CalculateScoreServlet").forward(request, response);
            return;
            //response.sendRedirect("CalculateScoreServlet");
        }

        if (request.getParameter("btnBefore") != null) {
            int answerId = -1;
            if (request.getParameter("answer") != null) {
                answerId = Integer.parseInt(request.getParameter("answer"));
                QuizResultAnswerDAO dao = new QuizResultAnswerDAO();
                questionList.get(currentIndex).getListAnswer().add(answerId);
                HttpSession session = request.getSession();
                ArrayList<QuizResult> listResult = (ArrayList<QuizResult>) session.getAttribute("listResult");
                QuizResultAnswer quizResultAnswers = dao.checkUserAnswer(1, questionList.get(currentIndex).getId_question());
                if (quizResultAnswers == null) {
                    dao.addUserAnswer(listResult.get(0).getIdResult(), questionList.get(currentIndex).getId_question(), answerId);
                } else {
                    dao.updateUserAnswer(questionList.get(currentIndex).getId_question(), answerId, listResult.get(0).getIdResult());
                }
            }
            moveToPreviousQuestion(request, response);
            return;
        }

        if (request.getParameter("getAllQuestions") != null) {
            showAllQuestion(request, response);
            return;
        }

        if (request.getParameter("getAnsweredQuestion") != null) {
            showAnswerdQuestion(request, response);
            return;
        }

        if (request.getParameter("getMarkedQuestion") != null) {
            showAllMarkedQuestion(request, response);
            return;
        }

        if (request.getParameter("getUnanswerQuestion") != null) {
            showUnansweredQuestion(request, response);
            return;
        }

        if (request.getParameter("selectedQuestion") != null) {
            int selectedQuestionId = Integer.parseInt(request.getParameter("selectedQuestion"));
            selectQuestionAtId(request, response, selectedQuestionId);
            return;
        }

        if (request.getParameter("markQuestion") != null) {
            markQuestion(request, response);
            return;
        }

        if (request.getParameter("answer") != null) {
            HttpSession session = request.getSession(true);
            QuizDAO dao1 = new QuizDAO();
            int answerId = Integer.parseInt(request.getParameter("answer"));
            QuizResultAnswerDAO dao = new QuizResultAnswerDAO();
            questionList.get(currentIndex).getListAnswer().clear();
            questionList.get(currentIndex).getListAnswer().add(answerId);
            ArrayList<QuizResult> listResult = (ArrayList<QuizResult>) session.getAttribute("listResult");
            QuizResultAnswer quizResultAnswers = dao.checkUserAnswer(listResult.get(0).getIdResult(), questionList.get(currentIndex).getId_question());
            if (quizResultAnswers == null) {
                dao.addUserAnswer(listResult.get(0).getIdResult(), questionList.get(currentIndex).getId_question(), answerId);
            } else {
                dao.updateUserAnswer(questionList.get(currentIndex).getId_question(), answerId, listResult.get(0).getIdResult());
            }
            Set<Integer> answeredList = questionList.get(currentIndex).getListAnswer();
            ArrayList<QuizAnswer> quizAnswer = dao1.getAllAnswersByQuestionId(questionList.get(currentIndex).getId_question());
            for (Integer i : answeredList) {
                for (QuizAnswer q : quizAnswer) {
                    if (q.getId_answer() == i) {
                        q.setIsChoose(true);
                    } else {
                        q.setIsChoose(false);
                    }
                }
            }
            session.setAttribute("answerOfQuestion", quizAnswer);
            session.setAttribute("currentQuestion", questionList.get(currentIndex));
            session.setAttribute("currentIndex", currentIndex);
            session.setAttribute("isShowProgress", false);
            session.setAttribute("questionTotal", dao1.getTotalQuestionByQuizId(currentQuiz));
            session.setAttribute("allQuestion", questionList);
            request.getRequestDispatcher("takequiz.jsp").forward(request, response);
            //response.sendRedirect("/quizpractice/takequiz?qid=" + currentQuiz);
            return;
        }

        request.getSession().setAttribute("isDoingQuiz", false);
        request.getRequestDispatcher("CalculateScoreServlet").forward(request, response);
        //response.sendRedirect("CalculateScoreServlet");
    }

    private void markQuestion(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            QuizDAO dao1 = new QuizDAO();
            if (questionList.get(currentIndex).isMarkedStatus()) {
                questionList.get(currentIndex).setMarkedStatus(false);
            } else {
                questionList.get(currentIndex).setMarkedStatus(true);
            }
            Set<Integer> answeredList = questionList.get(currentIndex).getListAnswer();
            ArrayList<QuizAnswer> quizAnswer = dao1.getAllAnswersByQuestionId(questionList.get(currentIndex).getId_question());
            for (Integer i : answeredList) {
                for (QuizAnswer q : quizAnswer) {
                    if (q.getId_answer() == i) {
                        q.setIsChoose(true);
                    } else {
                        q.setIsChoose(false);
                    }
                }
            }
            session.setAttribute("answerOfQuestion", quizAnswer);
            session.setAttribute("currentQuestion", questionList.get(currentIndex));
            session.setAttribute("currentIndex", currentIndex);
            session.setAttribute("isShowProgress", false);
            session.setAttribute("questionTotal", dao1.getTotalQuestionByQuizId(currentQuiz));
            session.setAttribute("allQuestion", questionList);
            request.getRequestDispatcher("takequiz.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(TakeQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void submitAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        QuizDAO dao1 = new QuizDAO();
        session.setAttribute("isShowProgress", false);
        ArrayList<QuizAnswer> quizAnswer = dao1.getAllAnswersByQuestionId(questionList.get(currentIndex).getId_question());
        session.setAttribute("answerOfQuestion", quizAnswer);
        session.setAttribute("currentQuestion", questionList.get(currentIndex));
        session.setAttribute("currentIndex", currentIndex);
        session.setAttribute("questionTotal", dao1.getTotalQuestionByQuizId(currentQuiz));
        request.getRequestDispatcher("Score.jsp").forward(request, response);
    }

    private void moveToNextQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        QuizDAO dao1 = new QuizDAO();
        currentIndex += 1;
        Set<Integer> answeredList = questionList.get(currentIndex).getListAnswer();
        ArrayList<QuizAnswer> quizAnswer = dao1.getAllAnswersByQuestionId(questionList.get(currentIndex).getId_question());
        for (Integer i : answeredList) {
            for (QuizAnswer q : quizAnswer) {
                if (q.getId_answer() == i) {
                    q.setIsChoose(true);
                } else {
                    q.setIsChoose(false);
                }
            }
        }
        session.setAttribute("answerOfQuestion", quizAnswer);
        session.setAttribute("currentQuestion", questionList.get(currentIndex));
        session.setAttribute("currentIndex", currentIndex);
        session.setAttribute("isShowProgress", false);
        session.setAttribute("questionTotal", questionList.size());
        session.setAttribute("allQuestion", questionList);
        request.getRequestDispatcher("takequiz.jsp").forward(request, response);
    }

    private void moveToPreviousQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        QuizDAO dao1 = new QuizDAO();
        currentIndex -= 1;
        Set<Integer> answeredList = questionList.get(currentIndex).getListAnswer();
        ArrayList<QuizAnswer> quizAnswer = dao1.getAllAnswersByQuestionId(questionList.get(currentIndex).getId_question());
        for (Integer i : answeredList) {
            for (QuizAnswer q : quizAnswer) {
                if (q.getId_answer() == i) {
                    q.setIsChoose(true);
                } else {
                    q.setIsChoose(false);
                }
            }
        }
        session.setAttribute("answerOfQuestion", quizAnswer);
        session.setAttribute("currentQuestion", questionList.get(currentIndex));
        session.setAttribute("currentIndex", currentIndex);
        session.setAttribute("questionTotal", dao1.getTotalQuestionByQuizId(currentQuiz));
        session.setAttribute("isShowProgress", false);
        session.setAttribute("allQuestion", questionList);
        request.getRequestDispatcher("takequiz.jsp").forward(request, response);
    }

    private void selectQuestionAtId(HttpServletRequest request, HttpServletResponse response, int idQuestion) {
        try {
            HttpSession session = request.getSession(true);
            QuizDAO dao1 = new QuizDAO();
            for (QuizQuestion q : questionList) {
                if (q.getId_question() == idQuestion) {
                    currentIndex = q.getQuestionOrderNumber() - 1;
                    currentQuiz = q.getId_question();
                    break;
                }
            }
            Set<Integer> answeredList = questionList.get(currentIndex).getListAnswer();
            ArrayList<QuizAnswer> quizAnswer = dao1.getAllAnswersByQuestionId(questionList.get(currentIndex).getId_question());
            for (Integer i : answeredList) {
                for (QuizAnswer q : quizAnswer) {
                    if (q.getId_answer() == i) {
                        q.setIsChoose(true);
                    } else {
                        q.setIsChoose(false);
                    }
                }
            }
            session.setAttribute("answerOfQuestion", quizAnswer);
            session.setAttribute("currentQuestion", questionList.get(currentIndex));
            session.setAttribute("currentIndex", currentIndex);
            session.setAttribute("isShowProgress", false);
            session.setAttribute("questionTotal", dao1.getTotalQuestionByQuizId(currentQuiz));
            session.setAttribute("allQuestion", questionList);
            request.getRequestDispatcher("takequiz.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(TakeQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showAllMarkedQuestion(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<QuizQuestion> newQuestions = new ArrayList<>();
            HttpSession session = request.getSession(true);
            for (QuizQuestion q : questionList) {
                if (q.isMarkedStatus()) {
                    newQuestions.add(q);
                }
            }
            session.setAttribute("isShowProgress", true);
            session.setAttribute("allQuestion", newQuestions);
            request.getRequestDispatcher("takequiz.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(TakeQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showAllQuestion(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            session.setAttribute("allQuestion", this.questionList);
            session.setAttribute("isShowProgress", true);
            request.getRequestDispatcher("takequiz.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(TakeQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showAnswerdQuestion(HttpServletRequest request, HttpServletResponse response) {
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
            request.getRequestDispatcher("takequiz.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(TakeQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showUnansweredQuestion(HttpServletRequest request, HttpServletResponse response) {
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
            request.getRequestDispatcher("takequiz.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(TakeQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
