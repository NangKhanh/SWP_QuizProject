/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Subject;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SubjectCategoryServlet", urlPatterns = {"/subcate"})
public class SubjectCategoryServlet extends HttpServlet {

    private int grade = -1;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (Integer.parseInt(request.getParameter("grade")) != -1 && request.getParameter("grade") != null) {
            grade = Integer.parseInt(request.getParameter("grade"));
        }
        SubjectDAO uDAO = new SubjectDAO();
        int currentPage = 1;
        int recordsPerPage = 6;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }

        ArrayList<Subject> subjectsList = uDAO.pagingSubjectCategory(currentPage, recordsPerPage, grade);
        int numberOfPages = uDAO.getNumberOfPagesCategory(recordsPerPage, grade);
        request.setAttribute("subjectsList", subjectsList);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("currentPage", currentPage);
        if (grade != -1) {
            request.setAttribute("grade", grade);
        }
        request.getRequestDispatcher("subjectCategoryHome.jsp").forward(request, response);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
