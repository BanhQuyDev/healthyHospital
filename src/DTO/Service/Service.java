/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Service;

import MyToys.CheckValidation;
import MyToys.Color;

/**
 *
 * @author QUANG HUY
 */
public class Service {

    private int id;
    private String name;
    private double price;

    public Service() {
    }

    public Service(int id, String name,double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void input() {
        id = CheckValidation.getAnInteger("Input serivce's id:",
                Color.RED + "Please input the number!!!" + Color.RESET);
        name = CheckValidation.inputPattern("Input serivce's name:", "[a-zA-Z ]{1,8}",
                Color.RED + "Please input the text!!!" + Color.RESET);
        price = CheckValidation.getAnInteger("Input serivce's price:",
                Color.RED + "Please input the number!!!" + Color.RESET);
    }

    public void output() {
        System.out.printf("|%-12d|%-14s|%-15.1f$|\n", id, name, price);
    }
}
