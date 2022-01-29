/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Log;

import MyToys.Color;
import java.util.ArrayList;

/**
 *
 * @author QUANG HUY
 */
public class LogList {

    ArrayList<Log> list;

    public LogList() {
        list = new ArrayList<>();
    }

    public boolean addLog(Log l) {
        return list.add(l);
    }

    public void displayAll() {
        System.out.println(Color.GREEN + "===========The list of history use service ===========" + Color.RESET);
        if (list.size() == 0) {
            System.out.println(Color.RED + "Don't have history in here.Please add new history !!!" + Color.RESET);

        } else {
            for (Log log : list) {
                int n = list.indexOf(log);
                n++;
                System.out.println("*History use service " + n);
                System.out.print("\n");
                log.output();
                System.out.println("\n");
            }
        }
    }

    public Log search(int id) {
        for (Log log : list) {
            if (log.getId() == id) {
                return log;
            }
        }
        return null;
    }

    public Log searchLog(int id) {
        for (Log log : list) {
            if (log.pet.getId() == id || log.service.getId() == id) {
                return log;
            }
        }
        return null;
    }

    public boolean removeLog(int id) {
        Log p = search(id);
        if (p == null) {
            
            return false;
        }
        return list.remove(p);
    }
}
