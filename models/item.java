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
public class item {
    public int id;
    public String name;
    public String color;
    public String categorie;
    public String size;
    public float price;

    public item( int id , String name,String categorie, String color, String size, float price) {
        this.id=id;
        this.name = name;
        this.categorie = categorie;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getSize() {
        return size;
    }

    public float getPrice() {
        return price;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
