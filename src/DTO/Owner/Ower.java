/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Owner;
import MyToys.CheckValidation;
import MyToys.Color;

/**
 *
 * @author QUANG HUY
 */
public class Ower {

    private int id;
    private String name;
    private String address;

    public Ower(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Ower() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void input() {
        id = CheckValidation.getAnInteger("input Owner's id:",
              Color.RED + "Please input the number!!!" + Color.RESET);
       name = CheckValidation.inputPattern("Input Owner's name:", "[a-zA-Z ]{1,8}",
                Color.RED + "Please input the text!!!" + Color.RESET);
       address = CheckValidation.getAnString("Input Owner's address:",
                Color.RED + "Please input the text!!!" + Color.RESET);
    }
    public void output(){       
      System.out.printf("|%-12d|%-14s|%-16s|\n", id, name,address);
        
    }
}
