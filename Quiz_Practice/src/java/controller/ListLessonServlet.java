/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.LessonDAO;
import dao.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Lesson;
import model.Subject;

/**
 *
 * @author AD
 */
public class ListLessonServlet extends HttpServlet {

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
        int idSubject = Integer.parseInt(request.getParameter("idSubject"));
        int idLesson = Integer.parseInt(request.getParameter("idLesson"));
        SubjectDAO daoSubject = new SubjectDAO();
        LessonDAO daoLesson = new LessonDAO();
        ArrayList<Subject> infoSubject = daoSubject.getAllSubjects();
        ArrayList<Lesson> infoLession = daoLesson.getAllLession();
        request.setAttribute("infoSubject", infoSubject);
        request.setAttribute("infoLession", infoLession);
        request.getRequestDispatcher("curdlesson.jsp").forward(request, response);

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
        
        SubjectDAO daoSubject = new SubjectDAO();
        LessonDAO daoLesson = new LessonDAO();
        int idSubject = Integer.parseInt(request.getParameter("subject"));  
        ArrayList<Subject> infoSubject = daoSubject.getAllSubjects();
        ArrayList<Lesson> infoLession = daoLesson.getAllLessionBySubject(idSubject);
        request.setAttribute("infoSubject", infoSubject);
        request.setAttribute("infoLession", infoLession);
        request.getRequestDispatcher("curdlesson.jsp").forward(request, response);
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
