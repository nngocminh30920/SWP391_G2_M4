/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Car;

/**
 *
 * @author ADMIN
 */
public class CarDAO extends BaseDAO<Car> {

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

    public List<String> getCarBrand() {
        String sql = "SELECT DISTINCT Brand FROM Cars";
        List<String> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<String> getCarType() {
        String sql = "SELECT DISTINCT Type FROM Cars";
        List<String> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Car> searchBy(String brand, String type, String direct) {
        String sql = "SELECT * FROM Cars WHERE 1 = 1 ";
        List<Car> list = new ArrayList<>();
        if (!brand.isEmpty()) {
            sql += " and brand='" + brand + "'";
        }
        if (!type.isEmpty()) {
            sql += " and type='" + type + "'";
        }
        sql += " ORDER BY Price " + direct;
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

    public List<Car> getCarByPage(List<Car> list, int start, int end) {
        List<Car> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<Car> getCarForOwner(String username) {
        String sql = "SELECT * FROM Cars WHERE [Owner] = ?";
        List<Car> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
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
                        rs.getString("description"))
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void delete(int id) {
        String sql = "DELETE FROM Cars WHERE [CarID]=?";
        String sql1 = "DELETE FROM [CarDetailImage] WHERE [CarID]=?";
        String sql2 = "DELETE FROM [Comments] WHERE [CarID]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql2);
            st.setInt(1, id);
            st.executeUpdate();
            st = connection.prepareStatement(sql1);
            st.setInt(1, id);
            st.executeUpdate();
            st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateCar(Car car) {
        String sql = "UPDATE Cars SET [Type]=?, [Tranmission]=?, [Seat]=?, "
                + "[Door]=?, [Price]=?, [Image]=?, [Description]=? where CarID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, car.getType());
            st.setString(2, car.getTranmission());
            st.setInt(3, car.getSeat());
            st.setInt(4, car.getDoor());
            st.setDouble(5, car.getPrice());
            st.setString(6, car.getImage());
            st.setString(7, car.getDescription());
            st.setInt(8, car.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
