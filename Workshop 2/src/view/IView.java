package view;

import model.BoatClub;

import java.util.Scanner;

public interface IView {

    default MenuLanguage startMessage() {
        System.out.println("Choose: ");
        System.out.println("(1) English view");
        System.out.println("(2) Swedish view");
        int choice = new Scanner(System.in).nextInt();
        MenuLanguage menuLanguage = null;
        if (choice == 2) {
            menuLanguage = MenuLanguage.SWEDISH;
        } else {
            menuLanguage = MenuLanguage.ENGLISH;
        }
        return menuLanguage;
    }

    Menu printMenu();

    void addMember(BoatClub boatClub);

    void changeMember(BoatClub boatClub);

    void removeMember(BoatClub boatClub);

    void lookMember(BoatClub boatClub);

    void listCompact(BoatClub boatClub);

    void listVerbose(BoatClub boatClub);

    void addBoat(BoatClub boatClub);

    void changeBoat(BoatClub boatClub);

    void removeBoat(BoatClub boatClub);

}
