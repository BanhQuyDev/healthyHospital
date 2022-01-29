/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Pet;
import DTO.Owner.Ower;
import MyToys.CheckValidation;
import MyToys.Color;

/**
 *
 * @author QUANG HUY
 */
public class Pet {

    private int id;
    private String name;
    private String birthday;
    private String gender;
    private Ower owner;

    public Pet() {
        id = 0;
        name = "";
        birthday = "";
        gender = "";
        gender = "";
        owner = null;
    }

    public Pet(int id, String name, String birthday, String gender, Ower ower) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.owner = ower;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public Ower getOwer() {
        return owner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOwer(Ower ower) {
        this.owner = ower;
    }

    public void input() {
        id = CheckValidation.getAnInteger("Input pet's id:",
                Color.RED + "Please input the number!!!" + Color.RESET);
        name = CheckValidation.inputPattern("Input pet's name:", "[a-zA-Z ]{1,8}",
                Color.RED + "Please input the text!!!" + Color.RESET);
       birthday = CheckValidation.CheckTime("Input birthday's pet:","");
        gender = CheckValidation.inputPattern("Choose (male/female):",
               "[m[f]]{1}[a[e]]{1}[l[m]]{1}[e[a]]{1}[l]{0,1}[e]{0,1}" ,
                Color.RED + "Please input male or female!!!" + Color.RESET);
    }

    public void output() {
        System.out.printf("|%-12d|%-14s|%-16s|%-12s|\n", id, name, birthday, gender);
        if (owner != null) {
            System.out.println("Pet's owner :");
            System.out.printf("|Id's owner  |Name's owner  |Address's Owner |\n");
            owner.output();
            System.out.println("\n");
        }
    }

  
}
