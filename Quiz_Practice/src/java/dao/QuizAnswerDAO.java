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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.QuizAnswer;

/**
 *
 * @author AD
 */
public class QuizAnswerDAO {

    public QuizAnswerDAO() {
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

    public void addAnswer(int idQuestion, String contentAnswer, boolean status, String explaination) {

        String query = " insert into quiz_answer (id_question, content_answer, status, explaination)\n"
                + "values (?,?,?,?);";
        try {

            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, idQuestion);
            stm.setString(2, contentAnswer);
            stm.setBoolean(3, status);
            stm.setString(4, explaination);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return;
    }

    public ArrayList<QuizAnswer> getAllAnswersByIdQuiz(int idQuiz) {
        ArrayList<QuizAnswer> list = new ArrayList<QuizAnswer>();
        try {
            String sql = "select id_answer, quiz_answer.id_question, quiz_answer.content_answer, quiz_answer.status, quiz_answer.explaination\n"
                    + "from quiz_question, quiz_answer\n"
                    + "where  quiz_question.id_question=quiz_answer.id_question and quiz_question.id_quiz=?;";
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, idQuiz);
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

    public void updateAnswer(String contentAnswer, boolean status, int idAnswer, String explaination) {

        String query = " update quiz_answer\n"
                + "set content_answer = ?, status = ?, explaination = ?\n"
                + "where id_answer = ?;";
        try {

            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setString(1, contentAnswer);
            stm.setBoolean(2, status);
            stm.setString(3, explaination);
            stm.setInt(4, idAnswer);
            stm.executeUpdate();
            stm.close();
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return;
    }

//    String sql = "UPDATE users SET name=?, email=?, password=? WHERE id=?";
//        
//        // Tạo đối tượng PreparedStatement để chuẩn bị truy vấn SQL cập nhật thông tin
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, user.getName());
//        pstmt.setString(2, user.getEmail());
//        pstmt.setString(3, user.getPassword());
//        pstmt.setInt(4, user.getId());
//        
//        // Thực thi truy vấn SQL để cập nhật thông tin
//        int rowsUpdated = pstmt.executeUpdate();
//        
//        // Nếu số hàng được cập nhật lớn hơn 0 thì cập nhật thành công
//        if (rowsUpdated > 0) {
//            result = true;
//        }
//        
//        // Đóng các đối tượng PreparedStatement và Connection để giải phóng tài nguyên
//        pstmt.close();
//        conn.close();
//        
//        return result;
}
