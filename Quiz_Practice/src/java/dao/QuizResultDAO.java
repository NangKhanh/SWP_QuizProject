/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Lesson;
import model.Quiz;
import model.QuizResult;
import model.QuizResultAnswer;
import model.QuizResultInformation;
import model.Subject;

/**
 *
 * @author sonha
 */
public class QuizResultDAO {
    public QuizResultDAO() {
        connectDB();
    }

    Connection cnn;
    PreparedStatement stm;
    ResultSet rs;

    private void connectDB() {
        try {
            cnn = (new DBContext()).connection;
            System.out.println("Connect successfuly");
        } catch (NumberFormatException e) {
            System.err.println("Connect error" + e.getMessage());
        }
    }
    
    public List<QuizResult> getAllQuizResultFromStudentId(int studentId) {
        List<QuizResult> quizResultList = new ArrayList<>();
        String sql = "select * from quiz_result where id_user = ?";
        try {
            stm = cnn.prepareStatement(sql);
            stm.setInt(1, studentId);
            rs = stm.executeQuery();
            while (rs.next()) {
                QuizResult qr = new QuizResult();
                qr.setId_quiz(rs.getInt("id_quiz"));
                qr.setId_result(rs.getInt("id_result"));
                qr.setId_user(rs.getInt("id_user"));
                quizResultList.add(qr);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return quizResultList;
    }
    
    public List<QuizResultInformation> getAllQuizResultFromStudentIdPaging(int studentId, int currentPage, int subjectID) {
        List<QuizResultInformation> quizes = new ArrayList<>();
        SubjectDAO subjectDAO = new SubjectDAO();
        LessonDAO lessonDao = new LessonDAO();
        QuizDAO quizDAO = new QuizDAO();
        String sql = "select * from quiz_result where id_user = ? LIMIT ?,?";
        try {
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, studentId);
            stm.setInt(2, 0);
            stm.setInt(3, (currentPage + 1) * 4);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                QuizResultInformation quizResultInformation = new QuizResultInformation();
                QuizResult qr = new QuizResult();
                qr.setId_quiz(rs.getInt("id_quiz"));
                qr.setId_result(rs.getInt("id_result"));
                qr.setId_user(rs.getInt("id_user"));
                qr.setDate_taken(rs.getDate("date_taken"));
                
                quizResultInformation.setQuizResult(qr);
                quizResultInformation.setQuiz(getQuizFromQuizResultId(qr.getId_quiz()));
                quizResultInformation.setLesson(lessonDao.getLessonByLessonID(quizResultInformation.getQuiz().getId_lesson()));
                quizResultInformation.setSubject(subjectDAO.getSubjectBySubjectId(quizResultInformation.getLesson().getId_subject()));
                quizResultInformation.setQuizQuestion(quizDAO.getAllQuestionsByQuiz(qr.getId_quiz()));
                quizResultInformation.setQuizAnswers(quizDAO.getAllAnswersByQuizId(qr.getId_quiz()));
                quizResultInformation.setQuizResultAnswers(getQuizResultAnswerByID(qr.getId_result()));
                
                if (subjectID == -1) {
                    quizes.add(quizResultInformation);
                } else {
                    if (quizResultInformation.getSubject().getId_subject() == subjectID) {
                        quizes.add(quizResultInformation);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return quizes;
    }
    
    public QuizResultInformation getQuizResultFromStudentIdAndQuizResultId(int studentId, int quizResultId) {
        SubjectDAO subjectDAO = new SubjectDAO();
        LessonDAO lessonDao = new LessonDAO();
        QuizDAO quizDAO = new QuizDAO();
        String sql = "select * from quiz_result where id_user = ? and id_result = ?";
        try {
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, studentId);
            stm.setInt(2, quizResultId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                QuizResultInformation quizResultInformation = new QuizResultInformation();
                QuizResult qr = new QuizResult();
                qr.setId_quiz(rs.getInt("id_quiz"));
                qr.setId_result(rs.getInt("id_result"));
                qr.setId_user(rs.getInt("id_user"));
                qr.setDate_taken(rs.getDate("date_taken"));
                
                quizResultInformation.setQuizResult(qr);
                quizResultInformation.setQuiz(getQuizFromQuizResultId(qr.getId_quiz()));
                quizResultInformation.setLesson(lessonDao.getLessonByLessonID(quizResultInformation.getQuiz().getId_lesson())); 
                quizResultInformation.setSubject(subjectDAO.getSubjectBySubjectId(quizResultInformation.getLesson().getId_subject()));
                quizResultInformation.setQuizQuestion(quizDAO.getAllQuestionsByQuiz(qr.getId_quiz()));
                quizResultInformation.setQuizAnswers(quizDAO.getAllAnswersByQuizId(qr.getId_quiz()));
                quizResultInformation.setQuizResultAnswers(getQuizResultAnswerByID(qr.getId_result()));
                return quizResultInformation;         
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<QuizResultAnswer> getQuizResultAnswerByID(int quizResultId) {
        List<QuizResultAnswer> quizResultList = new ArrayList<>();
        String sql = "select * from quiz_resultanswer where id_result = ?";
        try {
            stm = cnn.prepareStatement(sql);
            stm.setInt(1, quizResultId);
            rs = stm.executeQuery();
            while (rs.next()) {
                QuizResultAnswer qr = new QuizResultAnswer();
                qr.setId_answer(rs.getInt("id_answer"));
                qr.setId_question(rs.getInt("id_question"));
                qr.setId_resans(rs.getInt("id_resans"));
                qr.setId_result(rs.getInt("id_result"));
                quizResultList.add(qr);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return quizResultList;
    }
        
    public Quiz getQuizFromQuizResultId(int quizId) {
        Quiz quiz = null;
        String sql = "select * from quiz where id_quiz = ?";
        try {
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, quizId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                quiz = new Quiz();
                quiz.setDescription_quiz(rs.getString("description_quiz"));
                quiz.setId_lesson(rs.getInt("id_lesson"));
                quiz.setId_quiz(rs.getInt("id_quiz"));
                quiz.setName_quiz(rs.getString("name_quiz"));
                quiz.setQuestion_number(rs.getInt("question_number"));
                quiz.setTime(rs.getInt("time"));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return quiz;
    }
    
    public int countAllQuizResultFromStudentId(int studentId) {
        int count = 0;
        String sql = "select * from quiz_result where id_user = ?";
        try {
            stm = cnn.prepareStatement(sql);
            stm.setInt(1, studentId);
            rs = stm.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }
    
    public List<Subject> getAllSubjectFromAllQuizResultFromStudentId(int idStudent) {
        LessonDAO lessonDao = new LessonDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        Set<Subject> targetSet = new HashSet<>();
        List<QuizResult> listQuizResult = getAllQuizResultFromStudentId(idStudent);
        for (QuizResult q: listQuizResult) {
            Quiz quiz = getQuizFromQuizResultId(q.getId_quiz());
            Lesson lesson = lessonDao.getLessonByLessonID(quiz.getId_lesson());
            Subject subject = subjectDAO.getSubjectBySubjectId(lesson.getId_subject());
            targetSet.add(subject);
        }
        List<Subject> distinceListSubject = new ArrayList<>(targetSet);
        return distinceListSubject;
    }
    
     public void addNewRecordResult(int idUser, int id_quiz, Date dateTaken) {

        String query = " INSERT INTO quiz_result (id_user,id_quiz,date_taken) VALUES (?,?,?);";
        try {

            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, idUser);
            stm.setInt(2, id_quiz);
            stm.setDate(3, dateTaken);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }

    }

    public int getResultId(int id_quiz, int id_user) {
        String sql = " select  Max(id_result) as idResult \n"
                + "from quiz_result\n"
                + "where id_quiz = ?  and id_user=? ;";
        int idResult = 0;
        try {
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, id_quiz);
            stm.setInt(2, id_user);
            rs = stm.executeQuery();
            rs.next();
            idResult = rs.getInt("idResult");
            rs.close();

        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return idResult;
    }

    public ArrayList<QuizResult> getInfoPractice(int idResult) {

        ArrayList<QuizResult> list = new ArrayList<>();
        try {
            String sql = " select *\n"
                    + "from quiz_result\n"
                    + "where id_result =?; ";
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, idResult);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new QuizResult(
                        rs.getInt("id_result"),
                        rs.getInt("id_user"),
                        rs.getInt("id_quiz"),
                        rs.getFloat("score_quiz")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return list;
    }

    public void addScore(float score, int idResult) {

        String query = " UPDATE quiz_result\n"
                + "set score_quiz = ?\n"
                + "where id_result = ?;";
        try {

            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setFloat(1, score);
            stm.setInt(2, idResult);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }

    }

}
