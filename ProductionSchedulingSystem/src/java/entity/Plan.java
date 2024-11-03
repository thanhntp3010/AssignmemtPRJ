/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class Plan {
    private int plId;
    private String plName;
    private String startDate;
    private String endDate;
    private int dId;
    private Department department;

    public Plan() {
    }

    public Plan(String plName, String startDate, String endDate, int dId) {
        this.plName = plName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dId = dId;
    }

    public Plan(int plId, String plName, String startDate, String endDate, int dId) {
        this.plId = plId;
        this.plName = plName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dId = dId;
    }
    

    public Plan(int plId, String plName, String startDate, String endDate, int dId, Department department) {
        this.plId = plId;
        this.plName = plName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dId = dId;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    

    public int getPlId() {
        return plId;
    }

    public void setPlId(int plId) {
        this.plId = plId;
    }

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }
    
    
    
}
