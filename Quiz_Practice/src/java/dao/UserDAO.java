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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDAO {

    public UserDAO() {
        connectDB();
    }

    Connection cnn;
    Statement stm;
    ResultSet rs;

    private void connectDB() {
        try {
            cnn = (new DBContext()).connection;
            System.out.println("Connect successfuly");
        } catch (NumberFormatException e) {
            System.err.println("Connect error" + e.getMessage());
        }
    }

    public User checkLogin(String email, String password) {
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select * from `user` where `email` = '" + email + "' and `password` = '" + password + "'";
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                return new User(rs.getString("name_user"),
                        rs.getString("id_user"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("address"),
                        rs.getInt("id_role"),
                        rs.getDate("birthDate"),
                        rs.getBoolean("gender"),
                        rs.getInt("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String insertUser(String userName, Date birthDate, String phone, boolean gender, int roleId, String email, String address, String password, int status) {
        String insert = "INSERT INTO user (name_user, birthDate, phone, gender, id_role, email, address, password,status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            if (checkMailExist(email) == true && checkPhoneExist(phone) == true) {
                return "Email or phone has been exited";
            } else {
                PreparedStatement ps = cnn.prepareStatement(insert);
                ps.setString(1, userName);
                ps.setDate(2, birthDate);
                ps.setString(3, phone);
                ps.setBoolean(4, gender);
                ps.setInt(5, roleId);
                ps.setString(6, email);
                ps.setString(7, address);
                ps.setString(8, password);
                ps.setInt(9, status);
                ps.executeUpdate();
                return "Success";
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
    }

    public boolean sendEmailCode(String email, String code) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.debug", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.password", "wvkeirkwbpxdfumf");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.ssl.trust", "*");
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("hongthang394@gmail.com", "wvkeirkwbpxdfumf");
                }
            });
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("hongthang394@gmail.com"));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(email));
            message.setSubject("This is reset code for your account");
            message.setText("This is a message from Quiz's system.\n Your verification code is: " + code + "\nThank you for trusting our store");
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean checkMailExist(String email) {
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select * from user where email = ?";
            PreparedStatement ps = cnn.prepareStatement(strSelect);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean checkPhoneExist(String phone) {
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select * from user where phone = ?";
            PreparedStatement ps = cnn.prepareStatement(strSelect);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public String randomString() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    public String changePassword(String password, String email) {
        String updatePassword = "UPDATE `user` SET password = ? WHERE (email = ?);";
        try {
            PreparedStatement ps = cnn.prepareStatement(updatePassword);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.executeUpdate();
            return "Success";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
     public User getUserByid(String userid) {
        String sql;
        sql = "SELECT * FROM quiz_pratice.user where id_user=?";

        User user = null;
        try {
            //tao khay chua cau lenh
            PreparedStatement st = cnn.prepareStatement(sql);
            st.setString(1, userid);
            //chay cau lenh va tao khay chua
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                //get value by column

                String name_user = rs.getString("name_user");
                String id = rs.getString("id_user");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String pass = rs.getString("password");
                Date dob = rs.getDate("birthDate");
                boolean gender = rs.getBoolean("gender");
                //create model
                user = new User(name_user, id, phone, email, pass ,address, 1, dob, gender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void EditProfile(User u) {
        String sql = "UPDATE user\n"
                + "   SET name_user = ?\n"
                + "      ,phone = ?\n"
                + "      ,birthDate = ?\n"
                + "      ,address = ?\n"
                + " WHERE id_user = ?";
        try {
           
            // tạo khay chứa câu lệnh 
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, u.getNameUser());
            pre.setString(2, u.getPhone());
            pre.setDate(3, u.getBirthDate());
            pre.setString(4, u.getAddress());
            pre.setString(5, u.getIdUser());
            pre.executeUpdate();
        } catch (Exception e) {
            String mess = e.toString();
            System.out.println("Update account information: " + mess);

        }
    }
         public ArrayList<User> getAllCustomer() {
        ArrayList<User> list = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM quiz_pratice.user";
            PreparedStatement stm = cnn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                list.add(new User(
                        rs.getString("name_user"),
                        rs.getString("id_user"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getInt("id_role"),
                        rs.getDate("birthDate"),
                        rs.getBoolean("gender"),
                        rs.getInt("status")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getPro: " + e.getMessage());
        }
        return list;
    }
     public void EditProfiles(User u) {
        String sql = "UPDATE user\n"
                + "   SET name_user = ?\n"     
                + " WHERE id_user = ?";
        try {
           
            // tạo khay chứa câu lệnh 
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, u.getNameUser());
            pre.setString(2, u.getIdUser());
            pre.executeUpdate();
        } catch (Exception e) {
            String mess = e.toString();
            System.out.println("Update account information: " + mess);

        }
    }
         public void BlockUser(User u) {
        String sql = "UPDATE user\n"
                + "   SET status = 0\n"     
                + " WHERE id_user = ?";
        try {
           
            // tạo khay chứa câu lệnh 
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, u.getIdUser());
            pre.executeUpdate();
        } catch (Exception e) {
            String mess = e.toString();
            System.out.println("Update account information: " + mess);

        }
    }
         public void UnBlockUser(User u) {
        String sql = "UPDATE user\n"
                + "   SET status = 1\n"     
                + " WHERE id_user = ?";
        try {
           
            // tạo khay chứa câu lệnh 
            PreparedStatement pre = cnn.prepareStatement(sql);
            pre.setString(1, u.getIdUser());
            pre.executeUpdate();
        } catch (Exception e) {
            String mess = e.toString();
            System.out.println("Update account information: " + mess);

        }
    }
         
}
