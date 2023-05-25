/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.QuizAnswerDAO;
import dao.QuizDAO;
import dao.QuizQuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Quiz;
import model.QuizAnswer;
import model.QuizQuestion;

/**
 *
 * @author AD
 */
public class UpdateQuizServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateQuizServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateQuizServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idQuiz = 0;
        if (request.getAttribute("idQuizFromServlet") != null) {
            idQuiz = (int) request.getAttribute("idQuizFromServlet");
        } else {
            idQuiz = Integer.parseInt(request.getParameter("idQuiz"));
        }

        QuizDAO daoQuiz = new QuizDAO();
        ArrayList<Quiz> listQuiz = daoQuiz.getAllQuizByIdQuiz(idQuiz);
        request.setAttribute("listQuiz", listQuiz);
        ArrayList<QuizQuestion> listQuestion = daoQuiz.getQuestionByQuizId(idQuiz);
        request.setAttribute("listQuestion", listQuestion);
        QuizAnswerDAO daoAnswer = new QuizAnswerDAO();
        ArrayList<QuizAnswer> listAnswer = daoAnswer.getAllAnswersByIdQuiz(idQuiz);
        request.setAttribute("listAnswer", listAnswer);
        request.getRequestDispatcher("UpdateQuiz.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String listContent, answer1, answer2, answer3, answer4, explaination;
        String quizName, quizDescription;
        int idQuiz = Integer.parseInt(request.getParameter("idQuiz"));
        quizName = request.getParameter("quizName");
        quizDescription = request.getParameter("quizDescription");
        int quizTime = Integer.parseInt(request.getParameter("quizTime"));
        int quizNumberQuestion = Integer.parseInt(request.getParameter("quizNumberQuestion"));
        QuizDAO daoQuiz = new QuizDAO();
        QuizAnswerDAO daoAnswer = new QuizAnswerDAO();
        daoQuiz.updateQuiz(quizName, quizDescription, quizTime, quizNumberQuestion, idQuiz);
        QuizQuestionDAO daoQuestion = new QuizQuestionDAO();
        int idAnswer1, idAnswer2, idAnswer3, idAnswer4;
        int currentRow = Integer.parseInt(request.getParameter("currentrow"));
        int correctAnswer = 0 ;
        ArrayList<Quiz> listQuiz = daoQuiz.getAllQuizByIdQuiz(idQuiz);
        int idLesson = listQuiz.get(0).getId_lesson();
        for (int i = 1; i <= currentRow; i++) {
            int idQuestion = Integer.parseInt(request.getParameter("col0[" + i + "]"));
            listContent = request.getParameter("col1[" + i + "]");
            daoQuestion.updateQuestion(listContent, idQuestion);
            answer1 = request.getParameter("col2[" + i + "]");
            answer2 = request.getParameter("col3[" + i + "]");
            answer3 = request.getParameter("col4[" + i + "]");
            answer4 = request.getParameter("col5[" + i + "]");
            idAnswer1 = Integer.parseInt(request.getParameter("idAnswer2[" + i + "]"));
            idAnswer2 = Integer.parseInt(request.getParameter("idAnswer3[" + i + "]"));
            idAnswer3 = Integer.parseInt(request.getParameter("idAnswer4[" + i + "]"));
            idAnswer4 = Integer.parseInt(request.getParameter("idAnswer5[" + i + "]"));
            correctAnswer = Integer.parseInt(request.getParameter("correctAnswer["+ i +"]"));
            explaination = request.getParameter("explaination["+ i +"]");
            if (correctAnswer == 1) {
                daoAnswer.updateAnswer(answer1, true ,idAnswer1, explaination);
            } else {
                daoAnswer.updateAnswer(answer1, false, idAnswer1, null);
            }
            if (correctAnswer == 2) {
                daoAnswer.updateAnswer(answer2, true, idAnswer2, explaination);
            } else {
                daoAnswer.updateAnswer(answer2, false, idAnswer2, null);
            }
            if (correctAnswer == 3) {
                daoAnswer.updateAnswer(answer3, true, idAnswer3, explaination);
            } else {
                daoAnswer.updateAnswer(answer3, false, idAnswer3, null);
            }
            if (correctAnswer == 4) {
                daoAnswer.updateAnswer(answer4, true, idAnswer4, explaination);
            } else {
                daoAnswer.updateAnswer(answer4, false, idAnswer4, null);
            }
        }
        request.setAttribute("idQuizFromSerlet", idQuiz);
        doGet(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
