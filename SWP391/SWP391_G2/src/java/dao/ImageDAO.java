package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Image;

public class ImageDAO extends BaseDAO<Image> {

    public List<Image> getImageByCarid(int id) {
        String sql = "SELECT * FROM CarDetailImage WHERE CarID = ?";
        List<Image> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Image(rs.getInt("ImageID"), rs.getInt("CarID"), rs.getString("Name")));
            }
            System.out.println(id);
        } catch (SQLException e) {
            System.out.println("getImage " + e);
        }
        return list;
    }

    public void insert(Image i) {
        String sql = "INSERT INTO [dbo].[CarDetailImage] ([CarID], [Name]) VALUES(?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, i.getCarid());
            st.setString(2, i.getName());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[CarDetailImage] WHERE CarID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
