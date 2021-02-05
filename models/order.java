/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Timestamp;

/**
 *
 * @author moham
 */
public class order {
    public int costumerid ,itemid,quantity;
    public Timestamp date;

    public order(int costumerid, int itemid, int quantity, Timestamp date) {
        this.costumerid = costumerid;
        this.itemid = itemid;
        this.quantity = quantity;
        this.date = date;
    }

    public int getCostumerid() {
        return costumerid;
    }

    public int getItemid() {
        return itemid;
    }

    public int getQuantity() {
        return quantity;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setCostumerid(int costumerid) {
        this.costumerid = costumerid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
    
    
    
}
