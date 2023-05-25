/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.QuizResultAnswer;

/**
 *
 * @author AD
 */
public class QuizResultAnswerDAO {

    public QuizResultAnswerDAO() {
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

    public void addUserAnswer(int idResult, int idQuestion, int id_answer) {

        String query = " INSERT INTO quiz_resultanswer (id_result,id_question,id_answer) VALUES (?,?,?)";
        try {

            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, idResult);
            stm.setInt(2, idQuestion);
            stm.setInt(3, id_answer);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }

    }

    public QuizResultAnswer checkUserAnswer(int id_result, int id_question) {

//        QuizResultAnswer list = new ArrayList<>();
        String sql = " select * from quiz_resultanswer where id_result = ? and id_question= ? ";
        try {

            stm = cnn.prepareStatement(sql);
            stm.setInt(1, id_result);
            stm.setInt(2, id_question);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new QuizResultAnswer(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4));

            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return null;
    }

    public void updateUserAnswer(int idQuestion, int id_answer, int idResult) {

        String query = " UPDATE quiz_resultanswer SET id_answer = ? WHERE id_question = ? and id_result = ? ";
        try {

            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, id_answer);
            stm.setInt(2, idQuestion);
            stm.setInt(3, idResult);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }

    }

    public float numberOfCorrectAnswer(int idResult) {
        String sql = " select Count(*) as Score\n"
                + "from quiz_answer, quiz_resultanswer\n"
                + "where quiz_answer.id_answer=quiz_resultanswer.id_answer and quiz_answer.status= 1 and quiz_resultanswer.id_result= ?;";
        float count = 0;
        try {

            stm = cnn.prepareStatement(sql);
            stm.setInt(1, idResult);
            rs = stm.executeQuery();
            rs.next();
            count = rs.getInt("Score");
            rs.close();

        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return count;
    }

    public float totalOfNumberQuestion(int id_quiz) {
        String sql = " select Count(*) as Total\n"
                + "from quiz_question, quiz_answer\n"
                + "where quiz_question.id_quiz=? and  quiz_question.id_question=quiz_answer.id_question and quiz_answer.status=1";
        float total = 0;
        try {

            stm = cnn.prepareStatement(sql);
            stm.setInt(1, id_quiz);
            rs = stm.executeQuery();
            rs.next();
            total = rs.getInt("Total");
            rs.close();

        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return total;
    }
}
