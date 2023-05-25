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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lesson;
import model.Subject;

/**
 *
 * @author sonha
 */
public class LessonDAO {

    public LessonDAO() {
        connectDB();
    }

    Connection cnn;
    Statement stm;
    ResultSet rs;

    private void connectDB() {
        try {
            cnn = (new DBContext()).connection;
            System.out.println("Connect successfully");
        } catch (NumberFormatException e) {
            System.out.println("Connect error" + e.getMessage());
        }
    }

    public ArrayList<Lesson> getAllLessonBySubjectID(int id_subject) {
        ArrayList<Lesson> list = new ArrayList<>();
        String query = "select * from lesson where id_lesson = ?";
        try {
            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, id_subject);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Lesson(rs.getInt("id_lesson"),
                        rs.getInt("id_subject"),
                        rs.getString("name_lesson"),
                        rs.getString("description_lesson"),
                        rs.getString("video_lesson"),
                        rs.getInt("id_user")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Lesson getLessonByLessonID(int idLesson) {
        String query = "SELECT * FROM quiz_pratice.lesson where id_lesson = " + idLesson;
        try {
            PreparedStatement stm = cnn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int id_lesson = rs.getInt("id_lesson");
                int id_subject = rs.getInt("Id_subject");
                String name_lesson = rs.getString("name_lesson");
                String description_lesson = rs.getString("description_lesson");
                String video_lesson = rs.getString("video_lesson");
                int id_user = rs.getInt("id_user");
                return new Lesson(id_lesson, id_subject, name_lesson, description_lesson, video_lesson, id_user);
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return null;
    }

        public ArrayList<Lesson> getAllLessionBySubject(int id_subject) {
        ArrayList<Lesson> list = new ArrayList<Lesson>();
        try {
            String sql = "select * from lesson\n"
                    + "where id_subject= ? and id_user is null;";
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, id_subject);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                list.add(new Lesson(
                        rs.getInt("id_lesson"),
                        rs.getInt("id_subject"),
                        rs.getString("name_lesson"),
                        rs.getString("description_lesson")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Lesson> getAllLession() {
        ArrayList<Lesson> list = new ArrayList<Lesson>();
        try {
            String sql = "select * from lesson\n"
                    + "where id_user is null ;";
            PreparedStatement stm = cnn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                list.add(new Lesson(
                        rs.getInt("id_lesson"),
                        rs.getInt("id_subject"),
                        rs.getString("name_lesson"),
                        rs.getString("description_lesson")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return list;
    }

    public void addNewLesson(int idSubject, String lessonName, String lessonDescription) {
        String query = " INSERT INTO lesson (id_subject,name_lesson,description_lesson) VALUES (?,?,?)";
        try {
            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, idSubject);
            stm.setString(2, lessonName);
            stm.setString(3, lessonDescription);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }

    }

    public void addLesson(int id_user, int id_subject) {
        String query = " INSERT INTO lesson (id_user ,id_subject) VALUES (?,?)";
        try {
            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, id_user);
            stm.setInt(2, id_subject);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error getP: " + e.getMessage());
        }
    }

    public Lesson newLesson(int id_user) {
        String query = "SELECT * FROM `lesson` where id_user = ? ORDER BY id_lesson DESC LIMIT 1;";
        try {
            PreparedStatement stm = cnn.prepareStatement(query);
            stm.setInt(1, id_user);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return (new Lesson(rs.getInt("id_lesson"),
                        rs.getInt("id_subject"),
                        rs.getString("name_lesson"),
                        rs.getString("description_lesson"),
                        rs.getString("video_lesson"),
                        rs.getInt("id_user")));
            }
        } catch (Exception e) {
            System.out.println("Error get: " + e.getMessage());
        }
        return null;
    }
}
