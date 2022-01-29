/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Pet;

import MyToys.Color;
import MyToys.CheckValidation;

/**
 *
 * @author QUANG HUY
 */
public class PetList {

    Pet list[];
    final int MAX = 100;
    int n;

    public PetList() {
        list = new Pet[MAX];
        n = 0;
    }

    public boolean addPet(Pet p) {
        if (n >= MAX) {
            return false;
        }
        list[n] = p;
        n++;
        return true;
    }

    public boolean checkNull() {
        if (n == 0) {
            return false;
        }
        return true;
    }

    public void displayAll() {
        System.out.println(Color.GREEN + "===========The list of Pet information===========" + Color.RESET);
        if (checkNull() == false) {
            System.out.println(Color.RED + "Don't have pet in here.Please add new pet !!!" + Color.RESET);

        } else {
            System.out.printf("|Id's pet    |Name's pet    |Birthday's pet  |Gender's pet|\n");
            System.out.print("\n");
            for (int i = 0; i < n; i++) {
                list[i].output();
                System.out.println("\n");
            }
        }
    }

    public int findPet(int id) {
        for (int i = 0; i < n; i++) {
            if (list[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Pet searchPet(int id) {
        for (int i = 0; i < n; i++) {
            if (list[i].getId() == id) {
                return list[i];
            }
        }
        return null;
    }

    public boolean updatePet(int id) {
        Pet p = searchPet(id);
        if (p == null) {
            return false;
        }
        System.out.println(Color.GREEN + "***Here is the information before updating***" + Color.RESET);
        p.output();
        System.out.print("\n");
        p.setName(CheckValidation.inputPattern("Input new pet's name:", "[a-zA-Z ]{1,8}",
                Color.RED + "Please input the text!!!" + Color.RESET));
        p.setBirthday(CheckValidation.CheckTime("Input birthday's pet:", ""));
        p.setGender(CheckValidation.inputPattern("Choose new gender(male/female):",
                "[m[f]]{1}[a[e]]{1}[l[m]]{1}[e[a]]{1}[l]{0,1}[e]{0,1}",
                Color.RED + "Please input male or female!!!" + Color.RESET));
        return true;
    }

    public boolean deletePet(int id) {
        int i = findPet(id);
        if (i == -1) {
            return false;
        }
        for (int j = i; j < n; j++) {
            list[j] = list[j + 1];
            n--;
        }
        return true;
    }

}
