/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

public class DepartmentDAO {

    public List<Department> getAllWorkshop() {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT [did]\n"
                + "      ,[dname]\n"
                + "      ,[type]\n"
                + "  FROM [Departments] WHERE type = 'Production'";

        try (PreparedStatement pstmt = DBUtils.getConnection1().prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Department department = new Department();
                department.setdId(rs.getInt("did"));
                department.setdName(rs.getString("dname"));
                department.setType(rs.getString("type"));
                departments.add(department);
            }
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return departments;
    }

    public Department getDepartmentById(int id) {
        Department department = null;
        String query = "SELECT [did], [dname], [type] FROM [Departments] WHERE [did] = ?";

        try (PreparedStatement pstmt = DBUtils.getConnection1().prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                department = new Department();
                department.setdId(rs.getInt("did"));
                department.setdName(rs.getString("dname"));
                department.setType(rs.getString("type"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return department;
    }

    public Department getDepartmentByEid(int eid) {
        Department department = null;
        String query = "SELECT d.did, d.dname, d.type\n"
                + "FROM Departments d JOIN Employees e\n"
                + "ON d.did = e.did\n"
                + "WHERE e.eid = ?";

        try (PreparedStatement pstmt = DBUtils.getConnection1().prepareStatement(query)) {
            pstmt.setInt(1, eid);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                department = new Department();
                department.setdId(rs.getInt("did"));
                department.setdName(rs.getString("dname"));
                department.setType(rs.getString("type"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return department;
    }

}
