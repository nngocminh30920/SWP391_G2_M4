/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class AccountDAO extends BaseDAO<Account> {

    public Account getAcount(String username, String password, int type) throws SQLException {
        try {
            String sql;
            PreparedStatement st;
            if (type == 1) {
                sql = "SELECT * FROM Account a FULL JOIN UserDetail u "
                        + "ON a.username = u.username "
                        + "WHERE a.username=? and password=?";
                st = connection.prepareStatement(sql);
                st.setString(1, username);
                st.setString(2, password);
            } else {
                sql = "SELECT * FROM Account a FULL JOIN UserDetail u "
                        + "ON a.username = u.username "
                        + "WHERE a.username=?";
                st = connection.prepareStatement(sql);
                st.setString(1, username);
            }
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(username, password,
                        rs.getInt("accounttype"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getInt("phone"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    public boolean existedEmail(String email, String username, int type) throws SQLException{
        //Type:
        //1: register
        //2: profile
        try {
            PreparedStatement st;
            String sql;
            if (type == 1) {
                sql = "SELECT * FROM UserDetail WHERE email = ?";
                st = connection.prepareStatement(sql);
                st.setString(1, email);
            } else {
                sql = "SELECT * FROM UserDetail WHERE email = ? "
                        + "EXCEPT "
                        + "SELECT * FROM UserDetail WHERE Username = ?";
                st = connection.prepareStatement(sql);
                st.setString(1, email);
                st.setString(2, username);
            }
            ResultSet rs = st.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw e;   
        }
    }

    public boolean existedPhone(int phone, String username, int type) {
        //Type:
        //1: register
        //2: profile
        try {
            PreparedStatement st;
            String sql;
            if (type == 1) {
                sql = "SELECT * FROM UserDetail WHERE phone = ?";
                st = connection.prepareStatement(sql);
                st.setInt(1, phone);
            } else {
                sql = "SELECT * FROM UserDetail WHERE phone = ? \n"
                        + "EXCEPT \n"
                        + "SELECT * FROM UserDetail WHERE Username = ?";
                st = connection.prepareStatement(sql);
                st.setInt(1, phone);
                st.setString(2, username);
            }
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("existedPhone" + e);
        }
        return false;
    }

    public void insertAccount(Account account) {
        String sql = "INSERT INTO Account (Username, Password, AccountType) VALUES(?,?,?)\n"
                + "INSERT INTO UserDetail (Username, Fullname, Email, Address, City, Phone) VALUES(?,?,?,?,?,?)";
        int i = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, account.getUsername());
            st.setString(2, account.getPassword());
            st.setInt(3, account.getType());
            st.setString(4, account.getUsername());
            st.setString(5, account.getFullname());
            st.setString(6, account.getEmail());
            st.setString(7, account.getAddress());
            st.setString(8, account.getCity());
            st.setInt(9, account.getPhone());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insert " + e);
        }
    }

    public Account getAcountById(String username) {
        try {
            String sql = "SELECT * FROM Account a full join UserDetail u "
                    + "on a.username = u.username "
                    + "WHERE a.username=? ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(username, rs.getString("password"),
                        rs.getInt("accounttype"), rs.getString("fullname"),
                        rs.getString("email"), rs.getString("address"),
                        rs.getString("city"), rs.getInt("phone"));
            }
        } catch (SQLException e) {
            System.out.println("getAccount " + e);
        }
        return null;
    }

    public List<Account> getAllAcountExceptType(int type) {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM Account a full join UserDetail u on a.username = u.username "
                + "EXCEPT "
                + "SELECT * FROM Account a full join UserDetail u on a.username = u.username WHERE AccountType = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, type);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString("username"), rs.getString("password"),
                        rs.getInt("accounttype"), rs.getString("fullname"),
                        rs.getString("email"), rs.getString("address"),
                        rs.getString("city"), rs.getInt("phone")));
            }
        } catch (SQLException e) {
            System.out.println("getAccount " + e);
        }
        return list;
    }

    public void updateAccount(Account account) {
        String sql = "UPDATE Account SET [Password] = ?, [AccountType] = ? where [Username] = ? \n"
                + "UPDATE [UserDetail] SET [Fullname] = ?, [Email] = ?, "
                + "[Address] = ?, [City] = ?, [Phone] = ? where [Username] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, account.getPassword());
            st.setInt(2, account.getType());
            st.setString(3, account.getUsername());
            st.setString(4, account.getFullname());
            st.setString(5, account.getEmail());
            st.setString(6, account.getAddress());
            st.setString(7, account.getCity());
            st.setInt(8, account.getPhone());
            st.setString(9, account.getUsername());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update " + e);
        }
    }

    public List<Account> getAccountsByType(int type) {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM Account a full join UserDetail u "
                + "on a.username = u.username "
                + "WHERE a.AccountType=? ";
        try {

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, type);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString("username"), rs.getString("password"),
                        rs.getInt("accounttype"), rs.getString("fullname"),
                        rs.getString("email"), rs.getString("address"),
                        rs.getString("city"), rs.getInt("phone")));
            }
        } catch (SQLException e) {
            System.out.println("getAccount " + e);
        }
        return list;
    }

    public void delete(String username) {
        String sql = "DELETE FROM [CarDetailImage] WHERE CarId = (select CarID from Cars where Owner = ?) \n"
                + "DELETE FROM [Comments] WHERE Username=? \n"
                + "DELETE FROM [Orders] WHERE Username=? \n"
                + "DELETE FROM [Cars] WHERE [Owner]=? \n"
                + "DELETE FROM [UserDetail] WHERE Username=? \n"
                + "DELETE FROM Account WHERE Username=? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, username);
            st.setString(3, username);
            st.setString(4, username);
            st.setString(5, username);
            st.setString(6, username);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
