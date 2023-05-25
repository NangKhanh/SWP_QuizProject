/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Quiz;
import model.QuizQuestion;

/**
 *
 * @author AD
 */
public class QuizQuestionDAO {

    public QuizQuestionDAO() {
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

    public void addQuestion(int idQuiz, String content) {

        String query = " INSERT INTO quiz_question (id_quiz, content_question) values (?,?)";
        try {
            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, idQuiz);
            stm.setString(2, content);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
    }

    public int getIdQuestionMax() {
        String sql = "select max(id_question) as max\n"
                + "from quiz_question;";
        int idQuestion = 0;
        try {
            stm = cnn.prepareStatement(sql);
            rs = stm.executeQuery();
            rs.next();
            idQuestion = rs.getInt("max");
            rs.close();

        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return idQuestion;
    }

    public void updateQuestion(String content, int idQuestion) {

        String query = " update quiz_question\n"
                + "set content_question = ?\n"
                + "where id_question = ?";
        try {

            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setString(1, content);
            stm.setInt(2, idQuestion);
            
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
    }
}
