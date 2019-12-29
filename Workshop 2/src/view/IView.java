package view;

import model.BoatClub;

import java.util.Scanner;

public interface IView {

    default LanguageOptions startMessage() {
        System.out.println("Choose: ");
        System.out.println("(1) English view");
        System.out.println("(2) Swedish view");
        int choice = new Scanner(System.in).nextInt();
        LanguageOptions languageOptions;
        if (choice == 2) {
            languageOptions = LanguageOptions.SWEDISH;
        } else {
            languageOptions = LanguageOptions.ENGLISH;
        }
        return languageOptions;
    }

    MenuOptions printMenu();

    void addMember(BoatClub boatClub);

    void changeMember(BoatClub boatClub);

    void removeMember(BoatClub boatClub);

    void lookMember(BoatClub boatClub);

    void listCompact(BoatClub boatClub);

    void listVerbose(BoatClub boatClub);

    void addBoat(BoatClub boatClub);

    void changeBoat(BoatClub boatClub);

    void removeBoat(BoatClub boatClub);

    void exitMessage();

}
