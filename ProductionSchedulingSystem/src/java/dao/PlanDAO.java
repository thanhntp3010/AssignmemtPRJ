/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Department;
import entity.Plan;
import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class PlanDAO {

    public List<Plan> getAllPlan() {
        List<Plan> plans = new ArrayList<>();
        String query = "SELECT [plid], [plname], [startdate], [enddate], [did] FROM [Plans]";

        try (PreparedStatement pstmt = DBUtils.getConnection1().prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Plan plan = new Plan();
                plan.setPlId(rs.getInt("plid")); 
                plan.setPlName(rs.getString("plname")); 
                plan.setStartDate(rs.getString("startdate")); 
                plan.setEndDate(rs.getString("enddate")); 

                int departmentId = rs.getInt("did");
                DepartmentDAO departmentDAO = new DepartmentDAO();
                Department department = departmentDAO.getDepartmentById(departmentId);
                plan.setDepartment(department);

                plans.add(plan);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return plans;
    }

}
