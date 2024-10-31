/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class PlanHeader {
    private int phId;
    private int plId;
    private int pId;
    private int quantity;
    private float estimatedEffort;
    private String productName;

    public PlanHeader() {
    }

    public PlanHeader(int plId, int pId, int quantity, float estimatedEffort) {
        this.plId = plId;
        this.pId = pId;
        this.quantity = quantity;
        this.estimatedEffort = estimatedEffort;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public PlanHeader(int phId, int plId, int pId, int quantity, float estimatedEffort) {
        this.phId = phId;
        this.plId = plId;
        this.pId = pId;
        this.quantity = quantity;
        this.estimatedEffort = estimatedEffort;
    }

    public int getPhId() {
        return phId;
    }

    public void setPhId(int phId) {
        this.phId = phId;
    }

    public int getPlId() {
        return plId;
    }

    public void setPlId(int plId) {
        this.plId = plId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getEstimatedEffort() {
        return estimatedEffort;
    }

    public void setEstimatedEffort(float estimatedEffort) {
        this.estimatedEffort = estimatedEffort;
    }
    
    
}
