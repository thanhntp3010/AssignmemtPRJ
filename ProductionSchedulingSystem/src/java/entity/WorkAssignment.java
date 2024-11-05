/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class WorkAssignment {
    private int waId;
    private int pdId; 
    private int eid; 
    private int quantity;

    public WorkAssignment() {
    }

    public WorkAssignment(int waId, int pdId, int eid, int quantity) {
        this.waId = waId;
        this.pdId = pdId;
        this.eid = eid;
        this.quantity = quantity;
    }

    public int getWaId() {
        return waId;
    }

    public void setWaId(int waId) {
        this.waId = waId;
    }

    public int getPdId() {
        return pdId;
    }

    public void setPdId(int pdId) {
        this.pdId = pdId;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
