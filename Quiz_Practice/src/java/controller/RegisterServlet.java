/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import model.User;

/**
 *
 * @author sonha
 */
public class RegisterServlet extends HttpServlet {

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
        request.getRequestDispatcher("Register.jsp").forward(request, response);
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
        if (request.getParameter("btnRegister") != null) {
            register(request, response);
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userdao = new UserDAO();
        String nameUser = request.getParameter("userName");
        Date birthDate = new Date(getDateFromString(request.getParameter("birthDate")));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        boolean gender = false;
        gender = "1".equals(request.getParameter("gender"));
        int status = Integer.parseInt(request.getParameter("status"));
        User user = new User(nameUser, birthDate, phone, email, address, password, true, status);
        if (userdao.checkMailExist(email)) {
            request.setAttribute("errorMessage", "Email  existed");
            request.setAttribute("userName", nameUser);
            request.setAttribute("birthDate ", "birthDate");
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.setAttribute("address", address);
            request.setAttribute("password", password);
            request.setAttribute("gender", gender);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else if (userdao.checkPhoneExist(phone)) {
            request.setAttribute("errorMessage", "Phone existed");
            request.setAttribute("userName", nameUser);
            request.setAttribute("birthDate ", "2007-11-14");
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.setAttribute("address", address);
            request.setAttribute("password", password);
            request.setAttribute("gender", gender);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else {
            userdao.insertUser(nameUser, birthDate, phone, gender, 3, email, address, password, status);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }
    
    private String getDateFromString1(String date){
         String stringDate = date;
        SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
        try {
            java.util.Date d = f.parse(stringDate);
            return d.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
            
    private long getDateFromString(String date) {
        String stringDate = date;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date d = f.parse(stringDate);
            long milliseconds = d.getTime();
            return milliseconds;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0L;
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
