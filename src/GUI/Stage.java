/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Log.Log;
import DTO.Log.LogList;
import DTO.Owner.Ower;
import DTO.Owner.OwnerList;
import DTO.Pet.Pet;
import DTO.Pet.PetList;
import DTO.Service.Service;
import DTO.Service.ServiceList;
import MyToys.Color;
import MyToys.CheckValidation;

/**
 *
 * @author QUANG HUY
 */
public class Stage {

    public static ServiceList service = new ServiceList();
    public static OwnerList owner = new OwnerList();
    public static PetList pet = new PetList();
    public static LogList log = new LogList();

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println(Color.ANSI_GREEN_BACKGROUND + "============Hospital Management============" + Color.RESET);
            System.out.println("1.Manage pet list");
            System.out.println("2.Manage owner list");
            System.out.println("3.Manage service list");
            System.out.println("4.Choose pet for owner");
            System.out.println("5.History use service of pet");
            System.out.println("6.Exit");
            choice = CheckValidation.inputInt("Input your choice:", 1, 6, Color.RED + "Please input 1->6" + Color.RESET);

            switch (choice) {
                case 1:
                    thePetList();
                    break;
                case 2:
                    theOwnerList();
                    break;
                case 3:
                    theServiceList();
                    break;
                case 4:
                    chooseOwnerForPet();
                    break;
                case 5: //History use service of pet
                    theHistoryList();
                    break;
                default:
                    break;
            }

        } while (choice <= 5);
    }

    //==================choose Owner For Pett============= 
    public static void chooseOwnerForPet() {
        if (pet.checkNull() == false || owner.checkNull() == false) {
            System.out.println(Color.RED + "Don't have pet and owner in here!!!" + Color.RESET);
            return;
        }
        do {
            int inputIdPet = CheckValidation.getAnInteger("Input pet's id: ",
                    Color.RED + "Please input the number!!!" + Color.RESET);
            if (pet.searchPet(inputIdPet) == null) {
                System.out.println(Color.RED + "Pet doesn't exist.Please input another pet's id" + Color.RESET);
            } else {
                do {
                    int inputIdOwner = CheckValidation.getAnInteger("Input owner's id: ",
                            Color.RED + "Please input the number!!!" + Color.RESET);
                    if (owner.searchOwner(inputIdOwner) == null) {
                        System.out.println(Color.RED + "Owner doesn't exist.Please input another owner's id" + Color.RESET);
                    } else {
                        if (pet.searchPet(inputIdPet).getOwer() == null) {
                            pet.searchPet(inputIdPet).setOwer(owner.searchOwner(inputIdOwner));
                            pet.searchPet(inputIdPet).output();
                        } else {
                            System.err.println("Pet had owner !!!");
                        }
                        break;
                    }
                } while (true);
                break;
            }
        } while (true);
    }
//==============================History menu========================= 

    public static void theHistoryList() {
        if (pet.checkNull() == false || service.checkNull() == false) {
            System.out.println(Color.RED + "Don't have pet and service in here!!!" + Color.RESET);
            return;
        }
        int choice = 0;
        do {
            System.out.println(Color.PURPLE_BACKGROUND + "===========History use service===========" + Color.RESET);
            System.out.println("1.Add history use service");
            System.out.println("2.Display all history");
            System.out.println("3.Update the history");
            System.out.println("4.Remove the history");
            System.out.println("5.Back to main menu ");
            choice = CheckValidation.inputInt("Input Choice:", 1, 5, Color.RED + "Please input 1->5" + Color.RESET);
            switch (choice) {
                case 1:
                    Log l = new Log();
                    do {
                        l.input();
                        if (log.search(l.getId()) != null) {
                            System.out.println(Color.RED + "Id is duplicated!!!" + Color.RESET);
                        }
                    } while (log.search(l.getId()) != null);
                    do {
                        int inputIdPet = CheckValidation.getAnInteger("Input the pet id you want to use the service: ",
                                Color.RED + "Please input the number!!!" + Color.RESET);
                        if (pet.searchPet(inputIdPet) == null) {
                            System.err.println("Pet doesn't exist. Please input another pet's id");
                        } else {
                            l.setPet(pet.searchPet(inputIdPet));
                            do {
                                int inputIdService = CheckValidation.getAnInteger("Input the service id you want to use: ",
                                        Color.RED + "Please input the number!!!" + Color.RESET);
                                if (service.searchService(inputIdService) == null) {
                                    System.err.println("Service doesn't exist.Please input another service's id");
                                } else {
                                    l.setService(service.searchService(inputIdService));
                                    break;
                                }
                            } while (true);
                            if (log.addLog(l)) {
                                System.out.println(Color.GREEN + "Added successfully" + Color.RESET);
                            } else {
                                System.err.println("Add failed!!!");
                            }
                            break;
                        }
                    } while (true);
                    break;
                case 2:
                    log.displayAll();
                    break;
                case 3:
                    Log u = new Log();
                    do {
                        int idUpdate1 = CheckValidation.getAnInteger("Input id history to edit: ", Color.RED + "Please input number!!!" + Color.RESET);
                        if (log.removeLog(idUpdate1)) {
                            do {
                                int inputNewIdPet = CheckValidation.getAnInteger("Input new id's pet: ",
                                        Color.RED + "Please input the number!!!" + Color.RESET);
                                if (pet.searchPet(inputNewIdPet) == null) {
                                    System.err.println("Pet doesn't exist. Please input another pet's id");
                                } else {
                                    u.setPet(pet.searchPet(inputNewIdPet));
                                    break;
                                }
                            } while (true);
                            do {
                                int inputNewIdService = CheckValidation.getAnInteger("Input new service's id:",
                                        Color.RED + "Please input the number!!!" + Color.RESET);
                                if (service.searchService(inputNewIdService) == null) {
                                    System.err.println("Service doesn't exist.Please input another service's id");
                                } else {
                                    u.setService(service.searchService(inputNewIdService));
                                    break;
                                }
                            } while (true);
                            if (log.addLog(u)) {
                                System.out.println(Color.GREEN + "Updated successfully" + Color.RESET);
                            } else {
                                System.err.println("Updated  failed!!!");
                            }
                            break;
                        } else {
                            System.err.println("Id doesn't exist.Please input another history's id");
                        }
                    } while (true);
                    break;
                case 4:
                    int idDelete;
                    do {
                        idDelete = CheckValidation.getAnInteger("Input id to delete:", Color.RED + "Please input number!!!" + Color.RESET);
                        if (log.removeLog(idDelete) == false) {
                            System.err.println("Id doesn't exist.Please input another history's id");
                        } else {
                            System.out.println(Color.GREEN + "Removed successfully" + Color.RESET);
                            break;
                        }
                    } while (true);
                    break;               
            }
        } while (choice <= 4);
    }
//==============================Service menu=========================

    public static void theServiceList() {
        int choice = 0;
        do {
            System.out.println("\n");
            System.out.println(Color.WHITE_BACKGROUND + "===========Service List Management===========" + Color.RESET);
            System.out.println("1.Add service");
            System.out.println("2.Display all service");
            System.out.println("3.Update service");
            System.out.println("4.Delete service");
            System.out.println("5.Back to main menu ");
            choice = CheckValidation.inputInt("Input Choice:", 1, 5, Color.RED + "Please input 1->5" + Color.RESET);
            switch (choice) {
                case 1:
                    Service s = new Service();
                    do {
                        s.input();
                        if (service.findService(s.getId()) != -1) {
                            System.out.println(Color.RED + "Id is duplicated!!!" + Color.RESET);
                        }
                    } while (service.findService(s.getId()) != -1);

                    if (service.addService(s)) {
                        System.out.println(Color.GREEN + "Added successfully" + Color.RESET);
                    } else {
                        System.err.println("Add fail!!!");
                    }
                    break;
                case 2:
                    service.displayAll();
                    break;
                case 3:
                    if (service.checkNull() == false) {
                        System.err.println("Don't have service in here!!!");
                    } else {
                        int idUpdate;
                        do {
                            idUpdate = CheckValidation.getAnInteger("Input id to edit: ", Color.RED + "Please input number!!!" + Color.RESET);
                            if (service.updateService(idUpdate) == false) {
                                System.err.println("Id doesn't exist.Please input another id");
                            } else {
                                System.out.println(Color.GREEN + "Update successfully" + Color.RESET);
                                break;
                            }
                        } while (true);
                    }
                    break;
                case 4:
                    if (service.checkNull() == false) {
                        System.err.println("Don't have service in here!!!");
                    } else {
                        int idDelete;
                        do {
                            idDelete = CheckValidation.getAnInteger("Input id to delete:", Color.RED + "Please input number!!!" + Color.RESET);
                            if (service.removeService(idDelete) == false) {
                                System.err.println("Id doesn't exist.Please input another id");
                            } else {
                                System.out.println(Color.GREEN + "Removed successfully" + Color.RESET);
                                break;
                            }
                        } while (true);
                    }
                    break;
            }
        } while (choice <= 4);
    }
//==============================Ower menu============================

    public static void theOwnerList() {
        int choice = 0;
        do {
            System.out.println("\n");
            System.out.println(Color.CYAN_BACKGROUND + "===========Owner List Management===========" + Color.RESET);
            System.out.println("1.Add Owner");
            System.out.println("2.Display all owner");
            System.out.println("3.Update owner");
            System.out.println("4.Delete owner");
            System.out.println("5.Back to main menu ");
            choice = CheckValidation.inputInt("Input Choice:", 1, 5, Color.RED + "Please input 1->5" + Color.RESET);
            switch (choice) {
                case 1:
                    Ower o = new Ower();
                    do {
                        o.input();
                        if (owner.findOwner(o.getId()) != -1) {
                            System.out.println(Color.RED + "Id is duplicated!!!" + Color.RESET);
                        }
                    } while (owner.findOwner(o.getId()) != -1);

                    if (owner.addOwner(o)) {
                        System.out.println(Color.GREEN + "Added successfully" + Color.RESET);
                    } else {
                        System.err.println("Add fail!!!");
                    }
                    break;
                case 2:
                    owner.displayAll();
                    break;
                case 3:
                    if (owner.checkNull() == false) {
                        System.err.println("Don't have owner in here!!!");
                    } else {
                        int idUpdate;
                        do {
                            idUpdate = CheckValidation.getAnInteger("Input id to edit: ", Color.RED + "Please input number!!!" + Color.RESET);
                            if (owner.updateOwner(idUpdate) == false) {
                                System.err.println("Id doesn't exist.Please input another id");
                            } else {
                                System.out.println(Color.GREEN + "Update successfully" + Color.RESET);
                                break;
                            }
                        } while (true);
                    }
                    break;
                case 4:
                    if (owner.checkNull() == false) {
                        System.err.println("Don't have owner in here!!!");
                    } else {
                        int idDelete;
                        do {
                            idDelete = CheckValidation.getAnInteger("Input id to delete:", Color.RED + "Please input number!!!" + Color.RESET);
                            if (owner.removeOwner(idDelete) == false) {
                                System.err.println("Id doesn't exist.Please input another id");
                            } else {
                                System.out.println(Color.GREEN + "Removed successfully" + Color.RESET);
                                break;
                            }
                        } while (true);
                    }
                    break;
            }
        } while (choice <= 4);

    }
//==============================Pet menu============================

    public static void thePetList() {
        int choice = 0;
        do {
            System.out.println("\n");
            System.out.println(Color.ANSI_YELLOW_BACKGROUND + "============Pet List Management============" + Color.RESET);
            System.out.println("1.Add pet");
            System.out.println("2.Display all pet");
            System.out.println("3.Update pet");
            System.out.println("4.Delete pet");
            System.out.println("5.Back to main menu ");
            choice = CheckValidation.inputInt("Input Choice:", 1, 5, Color.RED + "Please input 1->5" + Color.RESET);
            switch (choice) {
                case 1:
                    Pet p = new Pet();
                    do {
                        p.input();
                        if (pet.findPet(p.getId()) != -1) {
                            System.out.println(Color.RED + "Id is duplicated!!!" + Color.RESET);
                        }
                    } while (pet.findPet(p.getId()) != -1);

                    if (pet.addPet(p)) {
                        System.out.println(Color.GREEN + "Added successfully" + Color.RESET);
                    } else {
                        System.err.println("Add fail!!!");
                    }
                    break;
                case 2:
                    pet.displayAll();
                    break;
                case 3:
                    if (pet.checkNull() == false) {
                        System.err.println("Don't have pet in here !!!");
                    } else {
                        int idUpdate;
                        do {
                            idUpdate = CheckValidation.getAnInteger("Input id to edit: ", Color.RED + "Please input number!!!" + Color.RESET);
                            if (pet.updatePet(idUpdate) == false) {
                                System.err.println("Id doesn't exist.Please input another id");
                            } else {
                                System.out.println(Color.GREEN + "Update successfully" + Color.RESET);
                                break;
                            }
                        } while (true);
                    }
                    break;
                case 4:
                    if (pet.checkNull() == false) {
                        System.err.println("Don't have pet in here !!!");
                    } else {
                        int idDelete;
                        do {
                            idDelete = CheckValidation.getAnInteger("Input id to delete:", Color.RED + "Please input number!!!" + Color.RESET);
                            if (pet.deletePet(idDelete) == false) {
                                System.err.println("Id doesn't exist.Please input another id");
                            } else {
                                System.out.println(Color.GREEN + "Removed successfully" + Color.RESET);
                                break;
                            }
                        } while (true);
                    }
                    break;
            }
        } while (choice <= 4);
    }
}
