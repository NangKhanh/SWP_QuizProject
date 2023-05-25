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
import java.util.List;
import model.QuizQuestion;

/**
 *
 * @author AD
 */
public class AddQuestionServlet extends HttpServlet {

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
            out.println("<title>Servlet AddQuestionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddQuestionServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        //QuizQuestion listContent = new QuizQuestion(request.getParameter("col1[]"));
        String listContent, answer1, answer2, answer3, answer4, explaination;
        String quizName, quizDescription;
        int idLesson = Integer.parseInt(request.getParameter("idLesson"));
        quizName = request.getParameter("quizName");
        quizDescription = request.getParameter("quizDescription");
        int quizTime = Integer.parseInt(request.getParameter("quizTime"));
        int quizNumberQuestion = Integer.parseInt(request.getParameter("quizNumberQuestion"));
        QuizDAO daoQuiz = new QuizDAO();
        QuizAnswerDAO daoAnswer = new QuizAnswerDAO();
        daoQuiz.addQuiz(idLesson, quizName, quizDescription, quizTime, quizNumberQuestion);
        QuizQuestionDAO daoQuestion = new QuizQuestionDAO();
        int idQuiz = daoQuiz.getIdQuiz();
        int idQuestion;
        int currentRow = Integer.parseInt(request.getParameter("currentrow"));
        int correctAnswer = 0;
        for (int i = 1; i <= currentRow; i++) {
            listContent = request.getParameter("col1[" + i + "]");
            daoQuestion.addQuestion(idQuiz, listContent);
            idQuestion = daoQuestion.getIdQuestionMax();
            answer1 = request.getParameter("col2[" + i + "]");
            answer2 = request.getParameter("col3[" + i + "]");
            answer3 = request.getParameter("col4[" + i + "]");
            answer4 = request.getParameter("col5[" + i + "]");
            correctAnswer = Integer.parseInt(request.getParameter("correctAnswer["+ i +"]"));
            explaination = request.getParameter("explaination["+ i +"]");
            if (correctAnswer == 1) {
                daoAnswer.addAnswer(idQuestion, answer1, true, explaination);
            } else {
                daoAnswer.addAnswer(idQuestion, answer1, false, null);
            }
            if (correctAnswer == 2) {
                daoAnswer.addAnswer(idQuestion, answer2, true, explaination);
            } else {
                daoAnswer.addAnswer(idQuestion, answer2, false, null);
            }
            if (correctAnswer == 3) {
                daoAnswer.addAnswer(idQuestion, answer3, true, explaination);
            } else {
                daoAnswer.addAnswer(idQuestion, answer3, false, null);
            }
            if (correctAnswer == 4) {
                daoAnswer.addAnswer(idQuestion, answer4, true, explaination);
            } else {
                daoAnswer.addAnswer(idQuestion, answer4, false, null);
            }

        }
        request.setAttribute("idLessonFromSerlet", idLesson);
        request.getRequestDispatcher("listquiz").forward(request, response);
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
