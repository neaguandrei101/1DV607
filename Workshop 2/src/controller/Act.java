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

    private Scanner sc = new Scanner(System.in);

    public Act(UI ui) {
        this.ui = ui;
    }

    public void readChoice() throws Exception {
        this.ui.console();
        int num = sc.nextInt();
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
                listtAllMembers();
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
        String name = sc.next();
        System.out.println("Ex Personal Number '199905239898'");
        System.out.print("Personal Number: ");
        String personalNumber = sc.next();
        int id = this.boatClub.generateId();

        System.out.println("You have to add your first boat, enter the boat details: ");
        this.ui.printBoatTypes();
        System.out.println("Type boat type: ");
        String boatType = null;
        switch (sc.nextInt()) {
            case 1:
                boatType = "Sailboat";
                break;
            case 2:
                boatType = "Motorsailer";
                break;
            case 3:
                boatType = "Kayak/Canoe";
                break;
            case 4:
                boatType = "Other";
                break;
        }
        System.out.println("Boat length in meters: ");
        int boatLength = sc.nextInt();
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
        this.boatClub.removeMember(sc.nextInt());
    }

    private void listtAllMembers() {
        this.ui.printListTypes();
        System.out.println("Type list type: ");
        switch (sc.nextInt()) {
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
        int id = sc.nextInt();
        System.out.println(this.boatClub.getMemberInfo(id));
    }

    private void changeMemberInfo() {
        this.ui.printChangesToMember();
        System.out.println("Your choice : ");

        switch (sc.nextInt()) {
            case 1:
                System.out.println("Enter the members id: ");
                int id = sc.nextInt();
                System.out.println("New name :");
                this.boatClub.changeMemberName(id, sc.next());
                break;
            case 2:
                System.out.println("Enter the members id: ");
                int id2 = sc.nextInt();
                System.out.println("New personal number :");
                this.boatClub.changeMemberPersonalNumber(id2, sc.next());
                break;
        }
    }

    private void printDeleteBoat() {
        System.out.println("Type the id of the member you want to delete the boat from: ");
        int id = sc.nextInt();
        System.out.println("Type the boat pos: ");
        int position = sc.nextInt();
        this.boatClub.removeBoatFromMember(id, position);
    }

    private void printAddBoat() {
        System.out.println("Type the id of the member you want to add the boat to: ");
        int id = sc.nextInt();
        System.out.println("You have to enter the boat details: ");
        this.ui.printBoatTypes();
        System.out.println("Type boat type: ");
        String boatType = null;
        switch (sc.nextInt()) {
            case 1:
                boatType = "Sailboat";
                break;
            case 2:
                boatType = "Motorsailer";
                break;
            case 3:
                boatType = "Kayak/Canoe";
                break;
            case 4:
                boatType = "Other";
                break;
        }
        System.out.println("Boat length in meters: ");
        int boatLength = sc.nextInt();
        Boat boat = new Boat(boatType, boatLength);
        this.boatClub.addBoatToMember(id, boat);
    }

    private void printChangeBoatInfo() {
        System.out.println("Type the id of the member you want to change the information: ");
        int id = sc.nextInt();
        System.out.println("Type the boat position: ");
        int pos = sc.nextInt();
        String newBoatType = null;
        System.out.println("Type new boat type: ");
        this.ui.printBoatTypes();
        switch (sc.nextInt()) {
            case 1:
                newBoatType = "Sailboat";
                break;
            case 2:
                newBoatType = "Motorsailer";
                break;
            case 3:
                newBoatType = "Kayak/Canoe";
                break;
            case 4:
                newBoatType = "Other";
                break;
        }
        System.out.println("Type new boat length: ");
        int newLength = sc.nextInt();
        this.boatClub.changeBoatInfoFromMember(id, pos, newLength, newBoatType);
    }
}
