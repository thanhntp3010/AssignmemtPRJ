/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;


public class WorkAssignmentDTO {
    private int planId;
    private String planName;
    private String startDate;
    private String endDate;
    private int quantity;
    private int productId;
    private int departmentId;
    private int estimateEffort;
    private int shiftId;
    private int employeeQuantity;
    private int employeeId;
    private String name;

    public WorkAssignmentDTO() {
    }

    public WorkAssignmentDTO(int planId, String planName, String startDate, String endDate, int quantity, int productId, int departmentId, int estimateEffort, int shiftId, int employeeQuantity, int employeeId, String name) {
        this.planId = planId;
        this.planName = planName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.quantity = quantity;
        this.productId = productId;
        this.departmentId = departmentId;
        this.estimateEffort = estimateEffort;
        this.shiftId = shiftId;
        this.employeeQuantity = employeeQuantity;
        this.employeeId = employeeId;
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }


    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getEstimateEffort() {
        return estimateEffort;
    }

    public void setEstimateEffort(int estimateEffort) {
        this.estimateEffort = estimateEffort;
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public int getEmployeeQuantity() {
        return employeeQuantity;
    }

    public void setEmployeeQuantity(int employeeQuantity) {
        this.employeeQuantity = employeeQuantity;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
