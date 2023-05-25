/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.LessonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import dao.SubjectDAO;
import model.Subject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Lesson;

/**
 *
 * @author AD
 */
@WebServlet(name = "CRUDQuizServlet", urlPatterns = {"/crudquiz"})
public class CRUDQuizServlet extends HttpServlet {

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

        SubjectDAO daoSubject = new SubjectDAO();
        LessonDAO daoLesson = new LessonDAO();
        ArrayList<Subject> infoSubject = daoSubject.getAllSubjects();
        ArrayList<Lesson> infoLession = daoLesson.getAllLession();
        request.setAttribute("infoSubject", infoSubject);
        request.setAttribute("infoLession", infoLession);
        request.getRequestDispatcher("ListLessonToSearchQuiz.jsp").forward(request, response);

    }

    /**
     * ru Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SubjectDAO daoSubject = new SubjectDAO();
        LessonDAO daoLesson = new LessonDAO();
        int idSubject = Integer.parseInt(request.getParameter("subject"));
        ArrayList<Subject> infoSubject = daoSubject.getAllSubjects();
        if (idSubject == 0) {
            ArrayList<Lesson> infoLession = daoLesson.getAllLession();
            request.setAttribute("infoSubject", infoSubject);
            request.setAttribute("infoLession", infoLession);
            request.getRequestDispatcher("ListLessonToSearchQuiz.jsp").forward(request, response);
        } else {
            ArrayList<Lesson> infoLession = daoLesson.getAllLessionBySubject(idSubject);
            request.setAttribute("infoSubject", infoSubject);
            request.setAttribute("infoLession", infoLession);
            request.getRequestDispatcher("ListLessonToSearchQuiz.jsp").forward(request, response);
        }

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
