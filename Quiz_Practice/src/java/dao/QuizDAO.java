/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lesson;
import model.Quiz;
import model.QuizAnswer;
import model.QuizQuestion;

/**
 *
 * @author longc
 */
public class QuizDAO {

    public QuizDAO() {
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
    

   public ArrayList<Quiz> getQuizByID(int id_lesson) {
        ArrayList<Quiz> list = new ArrayList<Quiz>();
        try {
            String sql = "SELECT * FROM quiz_pratice.quiz where id_lesson="+ id_lesson;
            PreparedStatement stm = cnn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                list.add(new Quiz(
                        rs.getInt("id_quiz"),
                        rs.getInt("Id_lesson"),
                        rs.getString("name_quiz"),
                        rs.getString("description_quiz"),
                        rs.getInt("time"),
                        rs.getInt("question_number")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return list;
    }

    public QuizQuestion getQuizQuestionByID(int id_quiz) {
        String query = "SELECT * FROM quiz_pratice.quiz_question where id_quiz=" + id_quiz;
        try {
            PreparedStatement stm = cnn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int id_question = rs.getInt("id_question");
                int Id_quiz = rs.getInt("Id_quiz");
                String content_question = rs.getString("content_question");
                return new QuizQuestion(id_question, id_quiz, content_question);
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<QuizQuestion> getAllQuestionsByQuiz(int id_quiz) {
        QuizDAO ct = new QuizDAO();
        ArrayList<QuizQuestion> list = new ArrayList<QuizQuestion>();
        try {
            String sql = "SELECT * FROM quiz_pratice.quiz_question where id_quiz=" + id_quiz;
            PreparedStatement stm = cnn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new QuizQuestion(
                        rs.getInt("id_question"),
                        rs.getInt("id_quiz"),
                        rs.getString("content_question")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<QuizAnswer> getAllAnswers() {
        ArrayList<QuizAnswer> list = new ArrayList<QuizAnswer>();
        try {
            String sql = "SELECT * FROM quiz_pratice.quiz_answer;";
            PreparedStatement stm = cnn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new QuizAnswer(
                        rs.getInt("id_answer"),
                        rs.getInt("id_question"),
                        rs.getString("content_answer"),
                        rs.getBoolean("status"),
                        rs.getString("explaination")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<QuizAnswer> getAllAnswersByQuizId(int quizId) {
        ArrayList<QuizAnswer> list = new ArrayList<QuizAnswer>();
        try {
            String sql = "SELECT distinct * FROM quiz_answer join quiz_question on quiz_question.id_question = quiz_answer.id_question where quiz_question.id_quiz = ?;";
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, quizId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new QuizAnswer(
                        rs.getInt("id_answer"),
                        rs.getInt("id_question"),
                        rs.getString("content_answer"),
                        rs.getBoolean("status"),
                        rs.getString("explaination")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<QuizAnswer> getAllAnswersByQuestionId(int idQuestion) {
        ArrayList<QuizAnswer> list = new ArrayList<QuizAnswer>();
        try {
            String sql = "SELECT * FROM quiz_pratice.quiz_answer where id_question = ?;";
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, idQuestion);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new QuizAnswer(
                        rs.getInt("id_answer"),
                        rs.getInt("id_question"),
                        rs.getString("content_answer"),
                        rs.getBoolean("status"),
                        rs.getString("explaination")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return list;
    }

    public int getTotalQuestionByQuizId(int quizId) {
        int count = 0;
        try {
            String sql = "SELECT * FROM quiz_pratice.quiz_question where id_quiz = ?;";
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, quizId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return count;
    }

    public ArrayList<Quiz> getAllQuizByIdLesson(int id_lesson) {
        ArrayList<Quiz> list = new ArrayList<Quiz>();
        try {
            String sql = "SELECT * FROM quiz_pratice.quiz where id_lesson= " + id_lesson + " and status=1";
            PreparedStatement stm = cnn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Quiz(
                        rs.getInt("id_quiz"),
                        rs.getInt("id_lesson"),
                        rs.getString("name_quiz"),
                        rs.getString("description_quiz"),
                        rs.getInt("time"),
                        rs.getInt("question_number")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Quiz> getAllQuizByLessonId(int id_lesson) {
        ArrayList<Quiz> list = new ArrayList<>();
        String query = "select * from quiz where id_lesson = ?";
        try {
            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, id_lesson);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Quiz(rs.getInt("id_quiz"),
                        rs.getInt("id_lesson"),
                        rs.getString("name_quiz"),
                        rs.getString("description_quiz"),
                        rs.getInt("time"),
                        rs.getInt("question_number")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<QuizQuestion> getQuestionByQuizId(int id_quiz) {
        ArrayList<QuizQuestion> list = new ArrayList<>();
        String query = "select * from quiz_question where id_quiz = ?";
        try {
            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, id_quiz);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new QuizQuestion(rs.getInt("id_question"),
                        rs.getInt("id_quiz"),
                        rs.getString("content_question")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<QuizQuestion> getQuizQuestionBySubject(int id_subject, int limitQuestion) {
        ArrayList<QuizQuestion> listAllQuestion = new ArrayList<>();
        ArrayList<QuizQuestion> listRandomQuestion = new ArrayList<>();
        LessonDAO less1 = new LessonDAO();
        ArrayList<Lesson> less = less1.getAllLessonBySubjectID(id_subject);
        for (Lesson lesson : less) {
            ArrayList<Quiz> quiz1 = getAllQuizByLessonId(lesson.getId_lesson());
            for (Quiz quiz : quiz1) {
                ArrayList<QuizQuestion> questions = getQuestionByQuizId(quiz.getId_lesson());
                listAllQuestion.addAll(questions);
            }
        }

        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < limitQuestion) {
            int randomNumber = random.nextInt(limitQuestion);
            if (!set.contains(randomNumber) && !listRandomQuestion.contains(listAllQuestion.get(randomNumber))) {
                set.add(randomNumber);
                listRandomQuestion.add(listAllQuestion.get(randomNumber));
                i++;
            }
        }

        return listRandomQuestion;
    }

    public String insertQuiz(int id_lesson, String name_quiz, String description_quiz, int time, int question_number, int status) throws SQLException{
        String query = "INSERT INTO `quiz` ( id_lesson , name_quiz, description_quiz, `time`, question_number, status) values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = cnn.prepareStatement(query);
            ps.setInt(1, id_lesson);
            ps.setString(2, name_quiz);
            ps.setString(3, description_quiz);
            ps.setInt(4, time);
            ps.setInt(5, question_number);
            ps.setInt(6, status);
            ps.executeUpdate();
        } catch(Exception e){
            System.out.println(e);
        } 
        return null;
    }

    public void addQuiz(int idLesson, String quizName, String quizDescription, int quizTime, int quizNumberQuestion) {

        String query = " INSERT INTO quiz (id_lesson, name_quiz, description_quiz, time, question_number, status)\n"
                + "values (?,?,?,?,?,1);";
        try {

            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, idLesson);
            stm.setString(2, quizName);
            stm.setString(3, quizDescription);
            stm.setInt(4, quizTime);
            stm.setInt(5, quizNumberQuestion);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
    }

    public int getIdQuiz() {
        String sql = "select max(id_quiz) as max\n"
                + "from quiz;";
        int idQuiz = 0;
        try {
            stm = cnn.prepareStatement(sql);
            rs = stm.executeQuery();
            rs.next();
            idQuiz = rs.getInt("max");
            rs.close();

        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return idQuiz;
    }

    public void hideQuiz(int idQuiz) {

        String query = " update quiz\n"
                + "set status = 0\n"
                + "where id_quiz =? ;";
        try {

            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, idQuiz);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
    }

    public int getIdLessonByQuiz(int idQuiz) {
        String sql = "select id_lesson\n"
                + "from quiz\n"
                + "where id_quiz = ?";
        int idLesson = 0;
        try {
            stm = cnn.prepareStatement(sql);
            stm.setInt(1, idQuiz);
            rs = stm.executeQuery();
            rs.next();
            idLesson = rs.getInt("id_lesson");
            rs.close();

        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return idLesson;
    }

    public ArrayList<Quiz> getAllQuizByIdQuiz(int idQuiz) {
        ArrayList<Quiz> list = new ArrayList<Quiz>();
        try {
            String sql = "select * from quiz\n"
                    + "where id_quiz=" + idQuiz;
            PreparedStatement stm = cnn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                list.add(new Quiz(
                        rs.getInt("id_quiz"),
                        rs.getInt("id_lesson"),
                        rs.getString("name_quiz"),
                        rs.getString("description_quiz"),
                        rs.getInt("time"),
                        rs.getInt("question_number")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }

        return list;
    }
    
    public Quiz getQuizByIdLesson (int id_lesson){
        String query = "select * from `quiz` where id_lesson = ?";
        try{
            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, id_lesson);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                return(new Quiz(rs.getInt("id_quiz"),
                        rs.getInt("id_lesson"),
                        rs.getString("name_quiz"),
                        rs.getString("description_quiz"),
                        rs.getInt("time"),
                        rs.getInt("question_number")));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    

    public void updateQuiz( String quizName, String quizDescription, int quizTime, int quizNumberQuestion, int idQuiz) {

        String query = " update quiz\n"
                + "set  name_quiz=?, description_quiz=?, time =?, question_number =?, status =1\n"
                + "where id_quiz=?";
        try {

            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setString(1, quizName);
            stm.setString(2, quizDescription);
            stm.setInt(3, quizTime);
            stm.setInt(4, quizNumberQuestion);
            stm.setInt(5, idQuiz);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
    }
}
