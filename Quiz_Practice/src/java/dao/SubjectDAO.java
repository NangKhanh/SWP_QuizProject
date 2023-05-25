/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Lesson;
import model.Subject;

/**
 *
 * @author Admin
 */
public class SubjectDAO {

    public SubjectDAO() {
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

    public List<Subject> searchSubject(String txtSearch) {
        List<Subject> list = new ArrayList<>();
        String mysql = "select * from subject where `name_subject` like ?";

        try {
            Connection cnn = new DBContext().connection;
            PreparedStatement ps = cnn.prepareStatement(mysql);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getInt("id_subject"),
                        rs.getInt("id_user"),
                        rs.getString("name_subject"),
                        rs.getString("description_subject"),
                        rs.getString("icon"),
                        rs.getInt("id_subcate")));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Subject> getAllSubjects() {
        ArrayList<Subject> list = new ArrayList<Subject>();
        try {
            String sql = "SELECT * FROM quiz_pratice.subject";
            PreparedStatement stm = cnn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                list.add(new Subject(
                        rs.getInt("id_subject"),
                        rs.getInt("id_user"),
                        rs.getString("name_subject"),
                        rs.getString("description_subject"),
                        rs.getString("icon"),
                        rs.getInt("id_subcate"),
                        rs.getInt("grade")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Subject> getAllSubjectsById(int idSubject) {
        ArrayList<Subject> list = new ArrayList<Subject>();
        try {
            String sql = "select * from subject where id_subject=" + idSubject;
            PreparedStatement stm = cnn.prepareStatement(sql);
            while (rs.next()) {

                list.add(new Subject(
                        rs.getInt("id_subject"),
                        rs.getInt("id_user"),
                        rs.getString("name_subject"),
                        rs.getString("description_subject"),
                        rs.getString("icon"),
                        rs.getInt("id_subcate")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Subject> getAllGrade(int grade) {
        ArrayList<Subject> list = new ArrayList<Subject>();
        try {
            String sql = "select * from subject where grade = ? ";
            PreparedStatement stm = cnn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getInt("id_subject"),
                        rs.getInt("id_user"),
                        rs.getString("name_subject"),
                        rs.getString("description_subject"),
                        rs.getString("icon"),
                        rs.getInt("id_subcate"),
                        rs.getInt("grade")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Subject> getGrade() {
        ArrayList<Subject> list = new ArrayList<Subject>();
        try {
            String sql = "select * from quizpractice.subject where grade = ? ";
            PreparedStatement stm = cnn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getInt("id_subject"),
                        rs.getInt("id_user"),
                        rs.getString("name_subject"),
                        rs.getString("description_subject"),
                        rs.getString("icon"),
                        rs.getInt("id_subcate"),
                        rs.getInt("grade")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Subject getSubjectBySubjectID(int id_subject) {
        String query = "SELECT * FROM quiz_pratice.subject where id_subject=" + id_subject;
        try {
            PreparedStatement stm = cnn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int Id_subject = rs.getInt("ID_subject");
                int id_user = rs.getInt("id_user");
                String name_subject = rs.getString("name_subject");
                String description_subject = rs.getString("description_subject");
                String icon = rs.getString("icon");
                int id_subcate = rs.getInt("id_subcate");

                return new Subject(id_subject, id_user, name_subject, description_subject, icon, id_subcate);
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return null;
    }

    //delete subject
    public void deleteSubject(String pid) {
        String sql = "DELETE FROM quiz_pratice.lesson where id_subject= ? ;";
        try {
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setString(1, pid);
            stm.executeUpdate();
            sql = "DELETE FROM quiz_pratice.subject where id_subject= ? ;";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, pid);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    //insert
    public void insertSubject(int id_user, String name_subject, String description_subject, String icon, int id_subcate, int grade) {
        String sql = "INSERT INTO quiz_pratice.subject (id_user,name_subject,description_subject,icon,id_subcate,grade)\n"
                + "VALUES ( ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, id_user);
            stm.setString(2, name_subject);
            stm.setString(3, description_subject);
            stm.setString(4, icon);
            stm.setInt(5, id_subcate);
            stm.setInt(6, grade);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateSubject(int subjectId, int id_user, String name_subject, String description_subject, String icon, int id_subcate, int grade) {
        String sql = "UPDATE quiz_pratice.subject SET id_user = ?, name_subject = ?, description_subject = ?, id_subcate = ?, grade = ?";
        if (icon != null) {
            sql += ", icon = ?";
        }
        sql += " WHERE id_subject = ?";
        try {
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, id_user);
            stm.setString(2, name_subject);
            stm.setString(3, description_subject);
            stm.setInt(4, id_subcate);
            stm.setInt(5, grade);
            if (icon != null) {
                stm.setString(6, icon);
                stm.setInt(7, subjectId);
            } else {
                stm.setInt(6, subjectId);
            }
            int rowsUpdated = stm.executeUpdate();
            if (rowsUpdated == 0) {
                System.out.println("No rows were updated.");
            } else {
                System.out.println(rowsUpdated + " row(s) were updated.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateSubjectIcon(int subjectId, String icon) {
        String sql = "UPDATE quiz_pratice.subject SET icon = ? WHERE subject_id = ?";
        try {
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setString(1, icon);
            stm.setInt(2, subjectId);
            int rowsUpdated = stm.executeUpdate();
            if (rowsUpdated == 0) {
                System.out.println("No rows were updated.");
            } else {
                System.out.println(rowsUpdated + " row(s) were updated.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
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
                        rs.getString("description_lesson"),
                        rs.getString("video_lesson")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return list;
    }

    public Subject getSubjectBySubjectId(int id_subject) {
        Subject subject = null;
        String sql = "select * from subject where id_subject = ?";
        try {
            stm = cnn.prepareStatement(sql);
            stm.setInt(1, id_subject);
            rs = stm.executeQuery();
            if (rs.next()) {
                subject = new Subject();
                subject.setDescription_subject(rs.getString("description_subject"));
                subject.setId_subcate(rs.getInt("id_subcate"));
                subject.setId_subject(rs.getInt("id_subject"));
                subject.setIcon(rs.getString("icon"));
                subject.setId_user(rs.getInt("id_user"));
                subject.setName_subject(rs.getString("name_subject"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return subject;
    }

    public List<Subject> getSubjectByGrade(int grade) {
        String sql = "select * from Subject where grade = ?";
        ArrayList<Subject> subjects = new ArrayList<>();
        try {
            stm = cnn.prepareStatement(sql);
            stm.setInt(1, grade);
            rs = stm.executeQuery();
            while (rs.next()) {
                subjects.add(new Subject(rs.getInt("id_subject"),
                        rs.getInt("id_user"),
                        rs.getString("name_subject"),
                        rs.getString("description_subject"),
                        rs.getString("icon"),
                        rs.getInt("id_subcate"),
                        rs.getInt("grade")));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return subjects;
    }

    public int getNumberOfPages(int recordsPerPage) {
        int numberOfPages = 0;
        String sql = "select count(*) from subject";
        try {
            stm = cnn.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                int numberOfRows = rs.getInt(1);
                numberOfPages = (int) Math.ceil(numberOfRows * 1.0 / recordsPerPage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numberOfPages;
    }

    public int getNumberOfPagesCategory(int recordsPerPage, int grade) {

        int numberOfPages = 0;
        String sql = "select count(*) from subject where grade = ?";

        try {
            stm = cnn.prepareStatement(sql);
            stm.setInt(1, grade);
            rs = stm.executeQuery();
            if (rs.next()) {
                int numberOfRows = rs.getInt(1);
                numberOfPages = (int) Math.ceil(numberOfRows * 1.0 / recordsPerPage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numberOfPages;
    }

    public ArrayList<Subject> pagingSubject(int currentPage, int recordsPerPage) {
        ArrayList<Subject> list = new ArrayList<>();
        int start = currentPage * recordsPerPage - recordsPerPage;
        String sql = "SELECT * FROM subject LIMIT ?,?;";
        try {
            stm = cnn.prepareStatement(sql);
            stm.setInt(1, start);
            stm.setInt(2, recordsPerPage);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getInt("id_subject"),
                        rs.getInt("id_user"),
                        rs.getString("name_subject"),
                        rs.getString("description_subject"),
                        rs.getString("icon"),
                        rs.getInt("id_subcate"),
                        rs.getInt("grade")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Category> listCategory() {
        ArrayList<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM quiz_pratice.subjectcategory;";
        try {
            stm = cnn.prepareStatement(sql);

            rs = stm.executeQuery(sql);
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Subject> pagingSubjectCategory(int currentPage, int recordsPerPage, int grade) {
        ArrayList<Subject> list = new ArrayList<>();
        int start = currentPage * recordsPerPage - recordsPerPage;
        String sql = "SELECT * FROM subject where grade = ? LIMIT ?,? ";
        try {
            stm = cnn.prepareStatement(sql);
            stm.setInt(1, grade);
            stm.setInt(2, start);
            stm.setInt(3, recordsPerPage);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getInt("id_subject"),
                        rs.getInt("id_user"),
                        rs.getString("name_subject"),
                        rs.getString("description_subject"),
                        rs.getString("icon"),
                        rs.getInt("id_subcate"),
                        rs.getInt("grade")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        SubjectDAO dao = new SubjectDAO();
        dao.updateSubject(32, 1, "math", "ok", "", 1, 11);
    }
}
