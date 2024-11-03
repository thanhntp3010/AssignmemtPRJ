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

    public List<PlanHeader> getPlanHeadersByPlanId(int planId) {
        List<PlanHeader> planHeaders = new ArrayList<>();
        String query = "SELECT phid, plid, pid, quantity, estimatedeffort FROM PlanHeaders WHERE plid = ?";

        try (PreparedStatement pstmt = DBUtils.getConnection1().prepareStatement(query)) {
            pstmt.setInt(1, planId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                PlanHeader planHeader = new PlanHeader();
                planHeader.setPhId(rs.getInt("phid"));
                planHeader.setPlId(rs.getInt("plid"));
                planHeader.setpId(rs.getInt("pid"));
                planHeader.setQuantity(rs.getInt("quantity"));
                planHeader.setEstimatedEffort(rs.getFloat("estimatedeffort"));

                ProductDAO productDAO = new ProductDAO();
                Product product = productDAO.getProductById(planHeader.getpId());
                planHeader.setProductName(product.getpName());

                planHeaders.add(planHeader);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return planHeaders;
    }

    public static void main(String[] args) {
        PlanDAO d = new PlanDAO();
        System.out.println(d.getPlanHeadersByPlanId(1));
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

    public boolean editPlan(Plan plan) {
        String query = "UPDATE [Plans] SET [plname] = ?, [startdate] = ?, [enddate] = ?, [did] = ? WHERE [plid] = ?";
        boolean isSuccess = false;

        try (PreparedStatement pstmt = DBUtils.getConnection1().prepareStatement(query)) {
            pstmt.setString(1, plan.getPlName());
            pstmt.setString(2, plan.getStartDate());
            pstmt.setString(3, plan.getEndDate());
            pstmt.setInt(4, plan.getdId());
            pstmt.setInt(5, plan.getPlId());

            int rowsAffected = pstmt.executeUpdate();
            isSuccess = (rowsAffected > 0);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return isSuccess;
    }

}
