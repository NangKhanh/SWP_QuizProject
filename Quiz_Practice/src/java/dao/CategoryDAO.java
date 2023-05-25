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
import model.Category;

/**
 *
 * @author sonha
 */
public class CategoryDAO {
    
    public CategoryDAO() {
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
    
    public List<Category> getListAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from subjectcategory";
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(
                        rs.getInt("id_subcate"),
                        rs.getString("name_subcate"),
                        rs.getString("description_subcate")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
}
