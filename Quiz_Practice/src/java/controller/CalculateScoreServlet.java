/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.QuizResultAnswerDAO;
import dao.QuizResultDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.QuizResult;

/**
 *
 * @author AD
 */
public class CalculateScoreServlet extends HttpServlet {

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
        QuizResultAnswerDAO dao = new QuizResultAnswerDAO();
        //int idUser = Integer.parseInt(request.getParameter("idUser"));
        //int idResult = Integer.parseInt(request.getParameter("idResult"));
        QuizResultDAO daoResult = new QuizResultDAO();
        HttpSession session = request.getSession();
        ArrayList<QuizResult> listResult = (ArrayList<QuizResult>) session.getAttribute("listResult");
        int idResult = listResult.get(0).getIdResult();
        float count = dao.numberOfCorrectAnswer(idResult);
        float total = dao.totalOfNumberQuestion(listResult.get(0).getId_quiz());
        float score = (count / total) * 10;
        float numberFail = total - count;
        daoResult.addScore(score, idResult);
        request.setAttribute("numberFail", numberFail);
        request.setAttribute("count", count);
        request.setAttribute("total", total);
        request.setAttribute("score", score);
        request.setAttribute("quizResult", idResult);
        request.getRequestDispatcher("Score.jsp").forward(request, response);

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
        processRequest(request, response);
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
