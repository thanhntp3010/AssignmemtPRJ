/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

public class UserDAO {

    public User checkLogin(String username, String password) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection1();
            String sql = "SELECT u.uid, r.rid, u.eid, u.username, u.password, u.active, u.email "
                    + "FROM [Users] u JOIN UserRoles ur ON u.uid = ur.uid "
                    + "JOIN Roles r ON r.rid = ur.rid "
                    + "WHERE u.username = ? AND u.password = ?";
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, username);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int uid = rs.getInt("uid");
                    int eid = rs.getInt("eid");
                    String username1 = rs.getString("username");
                    int active = rs.getInt("active");
                    String email = rs.getString("email");
                    int roleId = rs.getInt("rid"); 

                    user = new User(uid, eid, username1, "", active, email, roleId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

}
