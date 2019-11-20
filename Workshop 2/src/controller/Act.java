package controller;

import model.Boat;
import model.BoatClub;
import model.Member;
import model.RegistryHandler;
import view.UI;

import java.io.IOException;
import java.util.Scanner;

public class Act {
    private BoatClub boatClub = null;
    private UI ui;

    public Act(UI ui) {
        this.ui = ui;
    }

    public void readChoice() throws Exception {
        this.ui.console();
        int num = this.ui.scannerInt();
        switch (num) {
            case 1:
                createUser();
                readChoice();
                break;
            case 2:
                deleteUser();
                readChoice();
                break;
            case 3:
                listAllMembers();
                readChoice();
                break;
            case 4:
                changeMemberInfo();
                readChoice();
                break;
            case 5:
                lookAtMemberInfo();
                readChoice();
                break;
            case 6:
                printReadFromRegistryMessage();
                readChoice();
                break;
            case 7:
                RegistryHandler.saveBoatClubToJsonFile("LocalBoatClubRegistry.json", this.boatClub);
                System.out.println("Exiting...");
                break;
            case 8:
                printChangeBoatInfo();
                readChoice();
                break;
            case 9:
                printDeleteBoat();
                readChoice();
                break;
            case 10:
                printAddBoat();
                readChoice();
                break;
            default:
                System.out.println("Wrong input, try again");
                readChoice();
                break;
        }
    }



    private void createUser() {
        System.out.print("Name: ");
        String name = this.ui.scannerString();
        System.out.println("Ex Personal Number '199905239898'");
        System.out.print("Personal Number: ");
        String personalNumber = this.ui.scannerString();
        int id = this.boatClub.generateId();

        System.out.println("You have to add your first boat, enter the boat details: ");
        this.ui.printBoatTypes();
        System.out.println("Type boat type: ");
        String boatType = this.newBoatType(this.ui.scannerInt());

        System.out.println("Boat length in meters: ");
        int boatLength = this.ui.scannerInt();
        Boat boat = new Boat(boatType, boatLength);
        Member member = new Member(name, personalNumber, id, boat);
        this.boatClub.addMember(member);
        System.out.println("\nNew member has been added!");
        System.out.println("========================================");
        System.out.println(member.toString());
        System.out.println("========================================\n\n");
    }

    private void deleteUser() {
        System.out.println("Type member id: ");
        this.boatClub.removeMember(this.ui.scannerInt());
    }

    private void listAllMembers() {
        this.ui.printListTypes();
        System.out.println("Type list type: ");
        switch (this.ui.scannerInt()) {
            case 1:
                System.out.println(this.boatClub.compactListString());
                break;
            case 2:
                System.out.println(this.boatClub.verboseListString());
                break;
        }
    }

    private void printReadFromRegistryMessage() {
        System.out.println("Automatically read from LocalBoatClubRegistry.json, path relative: ");
        try {
            this.boatClub = RegistryHandler.getBoatClubFromJsonFile("LocalBoatClubRegistry.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void lookAtMemberInfo() {
        System.out.println("Type the id of the member you want to look at: ");
        int id = this.ui.scannerInt();
        System.out.println(this.boatClub.getMemberInfo(id));
    }

    private void changeMemberInfo() {
        this.ui.printChangesToMember();
        System.out.println("Your choice : ");

        switch (this.ui.scannerInt()) {
            case 1:
                System.out.println("Enter the members id: ");
                int id = this.ui.scannerInt();
                System.out.println("New name :");
                this.boatClub.changeMemberName(id, this.ui.scannerString());
                break;
            case 2:
                System.out.println("Enter the members id: ");
                int id2 = this.ui.scannerInt();
                System.out.println("New personal number :");
                this.boatClub.changeMemberPersonalNumber(id2, this.ui.scannerString());
                break;
        }
    }

    private void printDeleteBoat() {
        System.out.println("Type the id of the member you want to delete the boat from: ");
        int id = this.ui.scannerInt();
        System.out.println("Type the boat pos: ");
        int position = this.ui.scannerInt();
        this.boatClub.removeBoatFromMember(id, position);
    }

    private void printAddBoat() {
        System.out.println("Type the id of the member you want to add the boat to: ");
        int id = this.ui.scannerInt();
        System.out.println("You have to enter the boat details: ");
        this.ui.printBoatTypes();
        System.out.println("Type boat type: ");
        String boatType = this.newBoatType(this.ui.scannerInt());
        System.out.println("Boat length in meters: ");
        int boatLength = this.ui.scannerInt();
        Boat boat = new Boat(boatType, boatLength);
        this.boatClub.addBoatToMember(id, boat);
    }

    private void printChangeBoatInfo() {
        System.out.println("Type the id of the member you want to change the information: ");
        int id = this.ui.scannerInt();
        System.out.println("Type the boat position: ");
        int pos = this.ui.scannerInt();
        System.out.println("Type new boat type: ");
        this.ui.printBoatTypes();
        String boatType = this.newBoatType(this.ui.scannerInt());
        System.out.println("Type new boat length: ");
        int newLength = this.ui.scannerInt();
        this.boatClub.changeBoatInfoFromMember(id, pos, newLength, boatType);
    }

    private String newBoatType(int value){  //fancy java 12 preview features
        return switch (value) {    //have to learn it somehow
            case 1 : break "Sailboat";
            case 2 : break "Motorsailer";
            case 3 : break"Kayak/Canoe";
            default: break "Other";
        };
    }
}
