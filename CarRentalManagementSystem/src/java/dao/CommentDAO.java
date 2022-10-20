package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Comment;
import model.Order;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class CommentDAO extends BaseDAO<Comment> {

    public List<Comment> getCommentByCarId(int carId) {
        List<Comment> list = new ArrayList<>();
        AccountDAO adb = new AccountDAO();
        CarDAO cdb = new CarDAO();
        try {
            String sql = "SELECT * FROM Comments WHERE carid=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, carId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Comment(rs.getInt("commentID"),
                        adb.getAcountById(rs.getString("username")),
                        cdb.getCarByID(rs.getInt("carid")),
                        rs.getDate("CreateOn"), rs.getString("content")));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("GetComment " + e);
        }
        return null;
    }

    public int countCommentByCarId(int carid) {
        try {
            String sql = "SELECT COUNT(CommentID) FROM Comments WHERE CarID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, carid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("countComment" + e);
        }
        return -1;
    }

    public void insert(Comment c) {
        String sql = "INSERT INTO [dbo].[Comments]([Username],"
                + "[CarID],[CreateOn],[Content]) VALUES(?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getAccount().getUsername());
            st.setInt(2, c.getCar().getId());
            st.setDate(3, c.getCreateOn());
            st.setString(4, c.getContent());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean validComment(String username, int carid) {
        OrderDAO odb = new OrderDAO();
        List<Order> listOrder = odb.getOrderByUsernameForRenter(username);
        for (Order o : listOrder) {
            if (o.getCar().getId() == carid && (o.getStatus().equalsIgnoreCase("Completed") || o.getStatus().equalsIgnoreCase("CompletedHidden"))) {
                return true;
            }
        }
        return false;
    }
}
