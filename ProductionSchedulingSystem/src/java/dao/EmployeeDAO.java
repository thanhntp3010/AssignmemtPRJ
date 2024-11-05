/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class EmployeeDAO {

    public List<Employee> getAllEmployeeByDid(int did) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection1();
            String sql = "SELECT [eid], [ename], [did], [phonenumber], [address], e.sid, s.sname FROM [Employees] e \n"
                    + "JOIN Shifts s\n"
                    + "ON s.sid = e.sid WHERE e.did = ?";
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setInt(1, did);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int eid = rs.getInt("eid");
                    String ename = rs.getString("ename");
                    String phoneNumber = rs.getString("phonenumber");
                    String address = rs.getString("address");
                    int sid = rs.getInt("sid");

                    Employee employee = new Employee();
                    employee.setEid(eid);
                    employee.setEname(ename);
                    employee.setDid(did);
                    employee.setPhoneNumber(phoneNumber);
                    employee.setAddress(address);
                    employee.setSid(sid);
                    employee.setSname(rs.getString("sname"));
                    
                    employeeList.add(employee);
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
        return employeeList;
    }
}
