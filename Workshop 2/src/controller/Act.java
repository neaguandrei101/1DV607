package controller;

import model.Boat;
import model.BoatClub;
import model.Member;
import model.RegistryHandler;
import view.UI;

import java.util.Scanner;

public class Act {
    private BoatClub boatClub = null;
    private UI ui = new UI();

    private Scanner sc = new Scanner(System.in);

    public Act() {
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
            default:
                System.out.println("Wrong input, try again");
                readChoice();
                break;
        }
    }

    private boolean createUser() throws Exception {
        boolean created = false;
        boolean safe = false;
        Member newMember = new Member();
        Boat firstBoat = new Boat();

        System.out.print("Name: ");
        sc.nextLine();
        newMember.setName(sc.nextLine());
        System.out.println("Ex Personal Number '199905239898'");
        System.out.print("Personal Number: ");
        String personalNumber = sc.next();
        newMember.setPersonalNumber(personalNumber);
        newMember.setMemberId(this.boatClub.generateId());

        System.out.println("You have to add your first boat, enter the boat details: ");
        this.ui.printBoatTypes();
        System.out.println("Type boat type: ");
        switch (sc.nextInt()) {
            case 1:
                firstBoat.setBoatType("Sailboat");
                break;
            case 2:
                firstBoat.setBoatType("Motorsailer");
                break;
            case 3:
                firstBoat.setBoatType("Kayak/Canoe");
                break;
            case 4:
                firstBoat.setBoatType("Other");
                break;
        }

        System.out.println("Boat length in meters: ");
        int num = sc.nextInt();
        firstBoat.setLength(num);
        newMember.addBoat(firstBoat);
        safe = true;

        if (safe) {
            this.boatClub.addMember(newMember);
            created = true;
        } else {
            throw new RuntimeException("Something went wrong in the user creation");
        }
        System.out.println("\nNew member has been added!");
        System.out.println("========================================");
        System.out.println(newMember.toString());
        System.out.println("========================================\n\n");
        return created;
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
        this.boatClub = RegistryHandler.getBoatClubFromJsonFile("LocalBoatClubRegistry.json");
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
                newBoatType="Sailboat";
                break;
            case 2:
                newBoatType="Motorsailer";
                break;
            case 3:
                newBoatType="Kayak/Canoe";
                break;
            case 4:
                newBoatType="Other";
                break;
        }
        System.out.println("Type new boat length: ");
        int newLength = sc.nextInt();
        this.boatClub.changeBoatInfoFromMember(id,pos,newLength,newBoatType);
    }
}
