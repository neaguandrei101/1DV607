package view;

import model.Member;

import java.util.Scanner;

public class UI {
    private Scanner sc = new Scanner(System.in);

    public UI() {
    }

    public int scannerInt() {
        return this.sc.nextInt();
    }

    public String scannerString() {
        return this.sc.next();
    }

    public void console() {
        System.out.println("===================================================");
        System.out.println("Welcome to the Boat management system!");
        System.out.println("Choose: ");
        System.out.println("(1) Register a new Member");
        System.out.println("(2) Delete a Member");
        System.out.println("(3) Show lists of all members in two different ways");
        System.out.println("(4) Change a Member's Information");
        System.out.println("(5) Look at a specific member’s information");
        System.out.println("(6) Read from a Registry.json");
        System.out.println("(7) Exit and save .JSON to default path");
        System.out.println("(8) Change a boat’s information");
        System.out.println("(9) Delete a Boat from a member");
        System.out.println("(10) Add a Boat to a member");
        System.out.print("\n--> Your Choice: ");
    }

    public void printBoatTypes() {
        System.out.println("(1) Sailboat");
        System.out.println("(2) Motorsailer");
        System.out.println("(3) Kayak/Canoe");
        System.out.println("(4) Other");
    }

    public void printChangesToMember() {
        System.out.println("(1) Change name : ");
        System.out.println("(2) Change personal number : ");
        System.out.println("Your choice : ");
    }

    //this is for the addMember
    public void printNameMessage() {
        System.out.print("Name: ");
    }

    public void printPersonalNumberMessage() {
        System.out.println("Ex Personal Number '199905239898'");
        System.out.println("Personal Number: ");
    }

    public void printBoatTypesMessage() {
        System.out.println("You have to enter the boat details: ");
        this.printBoatTypes();
        System.out.println("Type boat type: ");
    }

    public void printBoatLengthMessage() {
        System.out.println("Boat length in meters: ");
    }

    public void printMemberCreatedMessage() {
        System.out.println("New member has been added!");
    }

    //this is for deleteUser()
    public void printIdMessage() {
        System.out.println("Type member id: ");
    }

    //this is for listAllMembers()
    public void printListTypesMessage() {
        System.out.println("(1) Compact List");
        System.out.println("(2) Verbose List");
        System.out.println("Type list type: ");
    }

    //this is for registry in Act
    public void printReadFromRegistryMessage() {
        System.out.println("Automatically read from LocalBoatClubRegistry.json, path relative: ");
    }

    //this is for lookAtMemberInfo()
    public void printLookAtMemberInfoMessage() {
        System.out.println("Type the id of the member you want to look at: ");
    }

    public void printMemberInfo(Member member) {
        System.out.println("Name: " + member.getName() + "\nP. Number: " + member.getPersonalNumber() + "\nID: " + member.getMemberId() + "\nNumber of boats: " + member.getNumberOfBoats());
    }

    //this is for deleteBoat()
    public void printDeleteBoatMessage() {
        System.out.println("Type the id of the member you want to delete the boat from: ");
    }

    public void printBoatPosMessage() {
        System.out.println("Type the boat position: ");
    }

    // this is for addBoat()
    public void printAddBoatMessage() {
        System.out.println("Type the id of the member you want to add the boat to: ");
    }

    //this is for printChangeBoatInfo()
    public void printChangeBoatInfoMessage() {
        System.out.println("Type the id of the member you want to change the information: ");
    }

    //wrong input message
    public void printWrongInputMessage() {
        System.out.println("Wrong input, try again");
    }

}
