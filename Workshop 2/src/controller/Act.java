package controller;

import model.*;
import view.UI;

import java.io.IOException;
import java.util.Scanner;

public class Act {
    private BoatClub boatClub = new BoatClub();
    private UI ui;
    Scanner scanner = new Scanner(System.in);

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
                readFromRegistry();
                readChoice();
                break;
            case 7:
                RegistryHandler.saveBoatClubToJsonFile("LocalBoatClubRegistry.json", this.boatClub);
                break;
            case 8:
                changeBoatInfo();
                readChoice();
                break;
            case 9:
                deleteBoat();
                readChoice();
                break;
            case 10:
                addBoat();
                readChoice();
                break;
            default:
                this.ui.printWrongInputMessage();
                readChoice();
                break;
        }
    }

    private void createUser() {
        this.ui.printNameMessage();
        String name = this.scanner.next();
        this.ui.printPersonalNumberMessage();
        String personalNumber = this.scanner.next();
        this.ui.printBoatTypesMessage();
        int boatType = this.scanner.nextInt();
        this.ui.printBoatLengthMessage();
        int boatLength = this.scanner.nextInt();
        this.boatClub.addMember(name, personalNumber, boatType, boatLength);
        this.ui.printMemberCreatedMessage();
    }

    private void deleteUser() {
        this.ui.printIdMessage();
        this.boatClub.removeMember(this.scanner.nextInt());
    }

    private void listAllMembers() {
        this.ui.printListTypesMessage();
        switch (this.scanner.nextInt()) {
            case 1:
                this.ui.printCompactList(this.boatClub);
                break;
            case 2:
                this.ui.printVerboseList(this.boatClub);
                break;
        }
    }

    private void readFromRegistry() {
        this.ui.printReadFromRegistryMessage();
        try {
            this.boatClub = RegistryHandler.getBoatClubFromJsonFile("LocalBoatClubRegistry.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void lookAtMemberInfo() {
        this.ui.printLookAtMemberInfoMessage();
        int id = this.scanner.nextInt();
        Member member = this.boatClub.getMemberFromClub(id);
        this.ui.printMemberInfo(member);
    }

    private void changeMemberInfo() {
        this.ui.printChangesToMember();
        switch (this.scanner.nextInt()) {
            case 1:
                this.ui.printIdMessage();
                int id = this.ui.scannerInt();
                this.ui.printNameMessage();
                this.boatClub.changeMemberName(id, this.scanner.next());
                break;
            case 2:
                this.ui.printIdMessage();
                int id2 = this.ui.scannerInt();
                this.ui.printPersonalNumberMessage();
                this.boatClub.changeMemberPersonalNumber(id2, this.ui.scannerString());
                break;
        }
    }

    private void deleteBoat() {
        this.ui.printDeleteBoatMessage();
        int id = this.scanner.nextInt();
        this.ui.printBoatPosMessage();
        int position = this.scanner.nextInt();
        this.boatClub.removeBoatFromMember(id, position);
    }

    private void addBoat() {
        this.ui.printAddBoatMessage();
        int id = this.ui.scannerInt();
        this.ui.printBoatTypesMessage();
        int boatType = this.ui.scannerInt();
        this.ui.printBoatLengthMessage();
        int boatLength = this.ui.scannerInt();
        this.boatClub.addBoatToMember(id, boatType, boatLength);
    }

    private void changeBoatInfo() {
        this.ui.printChangeBoatInfoMessage();
        int id = this.ui.scannerInt();
        this.ui.printBoatPosMessage();
        int pos = this.ui.scannerInt();
        this.ui.printBoatTypesMessage();
        int boatType = this.ui.scannerInt();
        this.ui.printBoatLengthMessage();
        int newLength = this.ui.scannerInt();
        this.boatClub.changeBoatInfoFromMember(id, pos, newLength, boatType);
    }

}
