/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Log;

import DTO.Service.Service;
import DTO.Pet.Pet;
import MyToys.CheckValidation;
import MyToys.Color;

/**
 *
 * @author QUANG HUY
 */
public class Log {
    int id;
    Pet pet;
    Service service;

    public Log() {
    }

    public Log(int id, Pet pet, Service service) {
        this.id = id;
        this.pet = pet;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    public void input(){
        id = CheckValidation.getAnInteger("input history's id:",
                Color.RED + "Please input the number!!!" + Color.RESET);
    }

    public void output() {
        System.out.println("Id's history: " + id);
        service.output();
        System.out.println("Pet use service:");
        pet.output();

    }

}
