/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author moham
 */
public class costumer {
    public int id,phone ;
    public String email,name,adress;

    public costumer(int id, String email, String name, int phone, String adress) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdresse(String adress) {
        this.adress = adress;
    }
    
}
