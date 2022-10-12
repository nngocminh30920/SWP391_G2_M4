/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Order;

/**
 *
 * @author dung
 */
public class CarDAO extends BaseDAO<Order>{
     public List<Car> getCar() {
        String sql = "SELECT * FROM Cars";
        List<Car> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Car(
                        rs.getInt("carid"),
                        rs.getString("owner"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("type"),
                        rs.getString("tranmission"),
                        rs.getInt("seat"),
                        rs.getInt("door"),
                        rs.getDouble("price"),
                        rs.getString("image"),
                        rs.getString("description")
                )
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
     
      public Car getCarByID(int id) {
        String sql = "SELECT * FROM Cars WHERE carid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Car(rs.getInt("carid"),
                        rs.getString("owner"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("type"),
                        rs.getString("tranmission"),
                        rs.getInt("seat"),
                        rs.getInt("door"),
                        rs.getDouble("price"),
                        rs.getString("image"),
                        rs.getString("description"));
            }
        } catch (SQLException e) {
            System.out.println("getCar " + e);
        }
        return null;
    }
      
      public void insert(Car c) {
        String sql = "INSERT INTO [dbo].[Cars] ([Owner], [Brand], [Model], [Type], "
                + "[Tranmission], [Seat], [Door], [Price],[Image],[Description]) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getOwner());
            st.setString(2, c.getBrand());
            st.setString(3, c.getModel());
            st.setString(4, c.getType());
            st.setString(5, c.getTranmission());
            st.setInt(6, c.getSeat());
            st.setInt(7, c.getDoor());
            st.setDouble(8, c.getPrice());
            st.setString(9, c.getImage());
            st.setString(10, c.getDescription());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
