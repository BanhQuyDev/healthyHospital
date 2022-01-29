/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Owner;

import MyToys.CheckValidation;
import MyToys.Color;
import java.util.ArrayList;

/**
 *
 * @author QUANG HUY
 */
public class OwnerList {

    ArrayList<Ower> List;

    public OwnerList() {
        List = new ArrayList<>();
    }
    
    public boolean addOwner(Ower o) {
        return List.add(o);
    }
    public boolean checkNull(){
        if(List.isEmpty()){
            return false;
        }
        return true;
    }
    public void displayAll() {
        System.out.println(Color.GREEN + "===========The list of Owner information===========" + Color.RESET);       
        if (checkNull() == false) {
            System.out.println(Color.RED + "Don't have owner in here.Please add new owner !!!" + Color.RESET);
        } else {
            System.out.printf("|Id's owner  |Name's owner  |Address's Owner |\n");
            System.out.print("\n");
            for (Ower ower : List) {
                ower.output();
                System.out.println("\n");
            }
        }

    }

    public int findOwner(int id) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getId() == id) {
                return i;
            }     
        }
        return -1;
    }

    public Ower searchOwner(int id) {
        for (Ower ower : List) {
            if (ower.getId() == id) {
                return ower;
            }
        }
        return null;
    }

    public boolean updateOwner(int id) {
        Ower p = searchOwner(id);
        if (p == null) {
            return false;
        }
        System.out.println(Color.GREEN + "***Here is the information before updating***" + Color.RESET);
        p.output();
        System.out.print("\n");
        p.setName(CheckValidation.inputPattern("Input new owner's name:", "[a-zA-Z ]{1,8}",
                Color.RED + "Please input the text!!!" + Color.RESET));
        p.setAddress(CheckValidation.getAnString("Input new owner's address:",
                Color.RED + "Please input the text!!!" + Color.RESET));
        return true;
    }

    public boolean removeOwner(int id) {
        Ower p = searchOwner(id);
        if (p == null) {
            return false;
        }
        return List.remove(p);
    }
}
