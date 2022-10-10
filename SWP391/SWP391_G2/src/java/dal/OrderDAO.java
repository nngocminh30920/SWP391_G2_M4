/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Order;

/**
 *
 * @author dung
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
}
