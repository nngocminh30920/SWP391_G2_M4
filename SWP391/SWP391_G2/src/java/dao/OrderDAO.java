/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import model.Order;

/**
 *
 * @author ADMIN
 */
public class OrderDAO extends BaseDAO<Order> {

    CarDAO db = new CarDAO();

    public void insert(Order o) {
        String sql = "INSERT INTO [dbo].[Orders] ([Username],[CarID],[RenterFullname],"
                + "[RenterEmail],[RenterAddress],[RenterCity],[RenterPhone],"
                + "[PickupDate],[DropoffDate],[PickupAddress],[DropoffAddress],"
                + "[Amount],[Status]) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, o.getUsername());
            st.setInt(2, o.getCar().getId());
            st.setString(3, o.getRenterFullname());
            st.setString(4, o.getRenterEmail());
            st.setString(5, o.getRenterAddress());
            st.setString(6, o.getRenterCity());
            st.setInt(7, o.getRenterPhone());
            st.setDate(8, o.getPickupDate());
            st.setDate(9, o.getDropoffDate());
            st.setString(10, o.getPickupAddress());
            st.setString(11, o.getDropoffAddress());
            st.setDouble(12, o.getAmount());
            st.setString(13, o.getStatus());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Order> getOrder() {
        String sql = "SELECT * FROM Orders ";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt("OrderID"),
                        rs.getString("Username"),
                        db.getCarByID(rs.getInt("CarID")),
                        rs.getString("RenterFullname"),
                        rs.getString("RenterEmail"),
                        rs.getString("RenterAddress"),
                        rs.getString("RenterCity"),
                        rs.getInt("RenterPhone"),
                        rs.getString("PickupAddress"),
                        rs.getString("DropoffAddress"),
                        rs.getDate("PickupDate"),
                        rs.getDate("DropoffDate"),
                        rs.getDouble("Amount"),
                        rs.getString("Status"))
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Order> getOrderByUsernameForRenter(String username) {
        String sql = "SELECT * FROM Orders WHERE username = ?";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt("OrderID"),
                        rs.getString("Username"),
                        db.getCarByID(rs.getInt("CarID")),
                        rs.getString("RenterFullname"),
                        rs.getString("RenterEmail"),
                        rs.getString("RenterAddress"),
                        rs.getString("RenterCity"),
                        rs.getInt("RenterPhone"),
                        rs.getString("PickupAddress"),
                        rs.getString("DropoffAddress"),
                        rs.getDate("PickupDate"),
                        rs.getDate("DropoffDate"),
                        rs.getDouble("Amount"),
                        rs.getString("Status"))
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Order> getOrderByUsernameForJobber(String username) {
        String sql = "SELECT o.orderID, o.username, o.carid, \n"
                + "o.renterfullname, o.renteremail, o.renteraddress, \n"
                + "o.rentercity, o.renterphone, o.pickupDate, o.dropoffdate, \n"
                + "o.pickupaddress, o.dropoffaddress, o.amount, o.status \n"
                + "FROM Orders o join Cars c ON o.carid = c.carid \n"
                + "WHERE c.Owner = ?";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt("OrderID"),
                        rs.getString("Username"),
                        db.getCarByID(rs.getInt("CarID")),
                        rs.getString("RenterFullname"),
                        rs.getString("RenterEmail"),
                        rs.getString("RenterAddress"),
                        rs.getString("RenterCity"),
                        rs.getInt("RenterPhone"),
                        rs.getString("PickupAddress"),
                        rs.getString("DropoffAddress"),
                        rs.getDate("PickupDate"),
                        rs.getDate("DropoffDate"),
                        rs.getDouble("Amount"),
                        rs.getString("Status"))
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void updateStatus(String status, int orderId) {
        String sql = "UPDATE Orders set status=? WHERE orderID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, status);
            st.setInt(2, orderId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Orders WHERE orderID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Order getOrderById(int id) {
        String sql = "SELECT * FROM Orders WHERE OrderId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Order(rs.getInt("OrderID"),
                        rs.getString("Username"),
                        db.getCarByID(rs.getInt("CarID")),
                        rs.getString("RenterFullname"),
                        rs.getString("RenterEmail"),
                        rs.getString("RenterAddress"),
                        rs.getString("RenterCity"),
                        rs.getInt("RenterPhone"),
                        rs.getString("PickupAddress"),
                        rs.getString("DropoffAddress"),
                        rs.getDate("PickupDate"),
                        rs.getDate("DropoffDate"),
                        rs.getDouble("Amount"),
                        rs.getString("Status"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Order> getOrderByCarId(int carId) {
        String sql = "SELECT * FROM Orders WHERE CarId = ?";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, carId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt("OrderID"),
                        rs.getString("Username"),
                        db.getCarByID(rs.getInt("CarID")),
                        rs.getString("RenterFullname"),
                        rs.getString("RenterEmail"),
                        rs.getString("RenterAddress"),
                        rs.getString("RenterCity"),
                        rs.getInt("RenterPhone"),
                        rs.getString("PickupAddress"),
                        rs.getString("DropoffAddress"),
                        rs.getDate("PickupDate"),
                        rs.getDate("DropoffDate"),
                        rs.getDouble("Amount"),
                        rs.getString("Status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean validOrder(int carId, Date from, Date to) {
        String sql = "SELECT DISTINCT PickupDate,DropoffDate "
                + "FROM Orders WHERE carId = ? and "
                + "(status = 'Accept' or status = 'DeliverCar' or status= 'Inprogress')";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, carId);
            System.out.println(carId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                LocalDate pickupDateP1 = LocalDate.parse(rs.getDate("PickupDate").toString());
                LocalDate dropoffDateD1 = LocalDate.parse(rs.getDate("DropoffDate").toString());
                LocalDate pickupDateRequestP2 = LocalDate.parse(from.toString());
                LocalDate dropoffDateRequestD2 = LocalDate.parse(to.toString());
                //ChronoUnit.DAYS.between(s1, s2) : s2 - s1
                //ngày yêu cầu trả xe d2 phải < ngày đã được thuê
                //ngày yêu cầu lấy xe p2 phải < ngày đã được trả xe
                if (ChronoUnit.DAYS.between(pickupDateP1, dropoffDateRequestD2) < 0 || ChronoUnit.DAYS.between(pickupDateRequestP2, dropoffDateD1) < 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Valid: " + e);
        }
        return true;
    }

    public void updateOrder(Order o) {
        String sql = "UPDATE Orders set \n"
                + "[RenterFullname] = ?, \n"
                + "[RenterEmail] =?, \n"
                + "[RenterAddress] =?, \n"
                + " [RenterCity] =?, \n"
                + " [RenterPhone] =?, \n"
                + " [PickupDate] =?, \n"
                + " [DropoffDate] =?,   \n"
                + " [PickupAddress] =?,  \n"
                + " [DropoffAddress] =?,  \n"
                + " [Amount] =?,  \n"
                + " [Status] =?  \n"
                + " WHERE orderID=?   ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, o.getRenterFullname());
            st.setString(2, o.getRenterEmail());
            st.setString(3, o.getRenterAddress());
            st.setString(4, o.getRenterCity());
            st.setInt(5, o.getRenterPhone());
            st.setDate(6, o.getPickupDate());
            st.setDate(7, o.getDropoffDate());
            st.setString(8, o.getPickupAddress());
            st.setString(9, o.getDropoffAddress());
            st.setDouble(10, o.getAmount());
            st.setString(11, o.getStatus());
            st.setInt(12, o.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update:  " + e);
        }
    }
    
}
