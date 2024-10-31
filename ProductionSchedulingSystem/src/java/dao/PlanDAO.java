/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Department;
import entity.Plan;
import entity.PlanHeader;
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

    public boolean addPlan(Plan plan) {
        String query = "INSERT INTO [Plans] ([plname], [startdate], [enddate], [did]) VALUES (?, ?, ?, ?)";
        boolean isSuccess = false;

        try (PreparedStatement pstmt = DBUtils.getConnection1().prepareStatement(query)) {
            pstmt.setString(1, plan.getPlName());
            pstmt.setString(2, plan.getStartDate());
            pstmt.setString(3, plan.getEndDate());
            pstmt.setInt(4, plan.getdId());

            int rowsAffected = pstmt.executeUpdate();
            isSuccess = (rowsAffected > 0);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return isSuccess;
    }

    public boolean createPlanHeader(PlanHeader planHeader) {
        String query = "INSERT INTO [PlanHeaders] ([plid], [pid], [quantity], [estimatedeffort]) VALUES (?, ?, ?, ?)";
        boolean isSuccess = false;

        try (PreparedStatement pstmt = DBUtils.getConnection1().prepareStatement(query)) {
            pstmt.setInt(1, planHeader.getPlId());
            pstmt.setInt(2, planHeader.getpId());
            pstmt.setInt(3, planHeader.getQuantity());
            pstmt.setFloat(4, planHeader.getEstimatedEffort());

            int rowsAffected = pstmt.executeUpdate();
            isSuccess = (rowsAffected > 0);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return isSuccess;
    }

}
