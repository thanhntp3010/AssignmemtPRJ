/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.WorkAssignmentDTO;
import entity.Department;
import entity.Plan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class WorkAssignmentDAO {

    public List<WorkAssignmentDTO> getAllByDepartmentId(int departmentId) {
        List<WorkAssignmentDTO> plans = new ArrayList<>();
        String query = "SELECT pl.plid as plid, pl.plname, pl.did as did, pl.startdate, pl.enddate,\n"
                + "ph.quantity as quantity, ph.pid as pid, ph.estimatedeffort, pd.sid as sid, a.quantity AS currentQuantity, "
                + "e.eid as eid, e.ename\n"
                + "FROM Plans pl\n"
                + "LEFT JOIN PlanHeaders ph ON pl.plid = ph.plid\n"
                + "LEFT JOIN PlanDetails pd ON ph.phid = pd.phid\n"
                + "LEFT JOIN WorkAssignments a ON a.pdid = pd.pdid\n"
                + "LEFT JOIN Employees e ON e.eid = a.eid WHERE pl.did = ?";

        try (PreparedStatement pstmt = DBUtils.getConnection1().prepareStatement(query)) {
            pstmt.setInt(1, departmentId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                WorkAssignmentDTO plan = new WorkAssignmentDTO();
                plan.setPlanId(rs.getInt("plid"));
                plan.setPlanName(rs.getString("plname"));
                plan.setStartDate(rs.getString("startdate"));
                plan.setEndDate(rs.getString("enddate"));
                plan.setQuantity(rs.getInt("quantity"));
                plan.setProductId(rs.getInt("pid"));
                plan.setDepartmentId(rs.getInt("did"));
                plan.setEstimateEffort(rs.getInt("estimatedeffort"));
                plan.setShiftId(rs.getInt("sid"));
                plan.setEmployeeQuantity(rs.getInt("currentQuantity"));
                plan.setEmployeeId(rs.getInt("eid"));
                plan.setName(rs.getString("ename"));

                plans.add(plan);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return plans;
    }
    
    
}
