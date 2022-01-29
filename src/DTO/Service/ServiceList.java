/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Service;

import MyToys.CheckValidation;
import MyToys.Color;
import java.util.ArrayList;

/**
 *
 * @author QUANG HUY
 */
public class ServiceList {

    ArrayList<Service> list;

    public ServiceList() {
        list = new ArrayList<>();
    }

    public boolean addService(Service s) {
        return list.add(s);
    }

    public boolean checkNull() {
        if (list.size() == 0) {
            return false;
        }
        return true;
    }

    public void displayAll() {
        System.out.println(Color.GREEN + "===========The list of Serivce ===========" + Color.RESET);
        if (checkNull() == false) {
            System.out.println(Color.RED + "Don't have service in here.Please add new service !!!" + Color.RESET);

        } else {
            System.out.printf("|Id's service|Name's service|Prices's service|\n");
            System.out.print("\n");
            for (Service service : list) {
                service.output();
                System.out.println("\n");
            }
        }
    }

    public int findService(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Service searchService(int id) {
        for (Service service : list) {
            if (service.getId() == id) {
                return service;
            }
        }
        return null;
    }

    public boolean updateService(int id) {
        Service p = searchService(id);
        if (p == null) {
            return false;
        }
        System.out.println(Color.GREEN + "***Here is the information before updating***" + Color.RESET);
        p.output();
        System.out.print("\n");
        p.setName(CheckValidation.inputPattern("Input new serivce's name:", "[a-zA-Z ]{1,8}",
                Color.RED + "Please input the text!!!" + Color.RESET));
        p.setPrice(CheckValidation.getAnInteger("Input new service's price:", Color.RED + "Please input the number" + Color.RESET));
        return true;
    }

    public boolean removeService(int id) {
        Service p = searchService(id);
        if (p == null) {
            return false;
        }
        return list.remove(p);
    }
}
