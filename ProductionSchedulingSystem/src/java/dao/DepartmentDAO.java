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
}
