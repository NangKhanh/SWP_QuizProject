/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.LessonDAO;
import dao.QuizAnswerDAO;
import dao.QuizDAO;
import dao.QuizQuestionDAO;
import dao.QuizResultDAO;
import dao.SubjectDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lesson;
import model.Quiz;
import model.QuizAnswer;
import model.QuizQuestion;
import model.QuizResultInformation;
import model.Subject;
import model.User;

/**
 *
 * @author sonha
 */
public class ListPraticeServlet extends HttpServlet {

    private int currentPage = 0;
    private int subjectId = -1;
    private boolean canNotLoadmore = false;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.currentPage = 0;
        this.subjectId = -1;
        this.canNotLoadmore = false;
        loadListSubjectForPracticeListModal(request, response);
        loadListPratice(request, response);  
    }
    
    private void loadListPratice(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            QuizResultDAO quizResultDAO = new QuizResultDAO();
            List<Subject> listSubject = quizResultDAO.getAllSubjectFromAllQuizResultFromStudentId(Integer.parseInt(user.getIdUser()));
            List<QuizResultInformation> listResult = quizResultDAO.getAllQuizResultFromStudentIdPaging(Integer.parseInt(user.getIdUser()), currentPage, subjectId);
            
            this.canNotLoadmore = listResult.size() < quizResultDAO.countAllQuizResultFromStudentId(Integer.parseInt(user.getIdUser())) ;
            
            request.setAttribute("results", listResult);
            request.setAttribute("subjects", listSubject);
            request.setAttribute("subjectId", subjectId);
            request.setAttribute("canNotLoadMore", canNotLoadmore);
            
            request.getRequestDispatcher("listpractice.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ListPraticeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        loadListSubjectForPracticeListModal(request, response);
        if (request.getParameter("load_more") != null) {
            this.currentPage++;            
            loadMore(request, response);
        }
        
        if (request.getParameter("subject") != null) {
            this.subjectId = Integer.parseInt(request.getParameter("subject"));
            loadListPratice(request, response);
        }
        
        if(request.getParameter("practice") != null){
            createQuizPractice(request, response);
        }
    }
   
    private void loadMore(HttpServletRequest request, HttpServletResponse response) {
        loadListPratice(request, response);
    }
    
    private void createQuizPractice(HttpServletRequest request, HttpServletResponse response){
        try {
            int id_subject = Integer.parseInt(request.getParameter("subjectId"));
            int limitQuestion = Integer.parseInt(request.getParameter("limitQuestion"));
            String quizName = request.getParameter("quizName");
            String quizDes = request.getParameter("quizDes");
            HttpSession session = request.getSession();
            LessonDAO lesDAO = new LessonDAO();
            QuizDAO quizDAO = new QuizDAO();
            User user = (User) session.getAttribute("user");
            QuizAnswerDAO daoAnswer = new QuizAnswerDAO();
            lesDAO.addLesson(Integer.parseInt(user.getIdUser()), id_subject);
            Lesson lesson = lesDAO.newLesson(Integer.parseInt(user.getIdUser()));
            ArrayList<QuizQuestion> quizRandom = quizDAO.getQuizQuestionBySubject(id_subject, limitQuestion);
            quizDAO.insertQuiz(lesson.getId_lesson(), quizName,quizDes, 20, limitQuestion, 1);
            Quiz quiz = quizDAO.getQuizByIdLesson(lesson.getId_lesson());
            QuizQuestionDAO quizquesDAO = new QuizQuestionDAO();
            for(int i = 0; i < quizRandom.size(); i++){
                quizquesDAO.addQuestion(quiz.getId_quiz(), quizRandom.get(i).getContent_question());
            }
            int i = 0;
            for (QuizQuestion q : quizDAO.getQuestionByQuizId(quiz.getId_quiz())) {
                for (QuizAnswer qa : quizDAO.getAllAnswersByQuestionId(quizRandom.get(i).getId_question())) {
                    daoAnswer.addAnswer(q.getId_question(), qa.getContent_answer(), qa.getStatus(), qa.getExplaination());
                }
                i++;
            }
            response.sendRedirect("takequiz?qid="+quiz.getId_quiz()+"&idUser="+user.getIdUser()+"&accessquiz=Take+Quiz");
        } catch (Exception ex) {
            Logger.getLogger(ListPraticeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    private void createQuizPractice(HttpServletRequest request, HttpServletResponse response) {
//    try {
//        int id_subject = Integer.parseInt(request.getParameter("subjectId"));
//        HttpSession session = request.getSession();
//        LessonDAO lesDAO = new LessonDAO();
//        QuizDAO quizDAO = new QuizDAO();
//        User user = (User) session.getAttribute("user");
//        lesDAO.addLesson(Integer.parseInt(user.getIdUser()), id_subject);
//        Lesson lesson = lesDAO.newLesson(Integer.parseInt(user.getIdUser()));
//        
//        // Create a new thread to insert the quiz
//        Thread quizThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                quizDAO.insertQuiz(lesson.getId_lesson(), "", "", 20, 20);
//            }
//        });
//        
//        // Start the thread
//        quizThread.start();
//        
//        // TODO: Add code to inform the user that the quiz creation process has started
//    } catch (Exception ex) {
//        Logger.getLogger(ListPraticeServlet.class.getName()).log(Level.SEVERE, null, ex);
//        // TODO: Add code to inform the user that an error occurred
//    }
//}
    
    private void loadListSubjectForPracticeListModal(HttpServletRequest request, HttpServletResponse response){
        SubjectDAO dao = new SubjectDAO();
        ArrayList<Subject> list = dao.getAllSubjects();
        request.setAttribute("subjectsList", list);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
