package view;

import model.Boat;
import model.BoatClub;
import model.Member;

import java.util.Iterator;
import java.util.Scanner;

public class EnglishView implements IView {
    private final String[] boats = new String[]{"Sailboat", "Motorsailer", "Kayak/Canoe", "Other"};
    private final String lengthUnit = "feet";
    private Scanner scanner = new Scanner(System.in);

    public MenuOptions printMenu() {
        System.out.println("Choose: ");
        System.out.println("(1) Add a new Member");
        System.out.println("(2) Change a Member");
        System.out.println("(3) Delete a Member");
        System.out.println("(4) Look at a specific Member’s information");
        System.out.println("(5) Print a compact list");
        System.out.println("(6) Print a verbose list");
        System.out.println("(7) Add a Boat to a Member");
        System.out.println("(8) Change a Boat’s information");
        System.out.println("(9) Delete a Boat from a Member");
        System.out.println("(10) Read from Registry.json");
        System.out.println("(11) Save to Registry.json");
        System.out.print("\n--> Your Choice: ");
        int choice = this.scanner.nextInt();
        MenuOptions menuOptions;
        switch (choice) {
            case 1:
                menuOptions = MenuOptions.ADD_MEMBER;
                break;
            case 2:
                menuOptions = MenuOptions.CHANGE_MEMBER;
                break;
            case 3:
                menuOptions = MenuOptions.REMOVE_MEMBER;
                break;
            case 4:
                menuOptions = MenuOptions.LOOK_MEMBER;
                break;
            case 5:
                menuOptions = MenuOptions.LIST_COMPACT;
                break;
            case 6:
                menuOptions = MenuOptions.LIST_VERBOSE;
                break;
            case 7:
                menuOptions = MenuOptions.ADD_BOAT;
                break;
            case 8:
                menuOptions = MenuOptions.CHANGE_BOAT;
                break;
            case 9:
                menuOptions = MenuOptions.REMOVE_BOAT;
                break;
            case 10:
                menuOptions = MenuOptions.READ_REGISTRY;
                break;
            default:
                menuOptions = MenuOptions.EXIT;
                break;
        }
        return menuOptions;
    }

    public void addMember(BoatClub boatClub) {
        System.out.println("Name: ");
        String name = this.scanner.next();
        System.out.println("Ex Personal Number '199905239898'" + "\nPersonal Number: ");
        String personalNumber = this.scanner.next();
        System.out.println("You have to enter the boat details: ");
        Boat.BoatType boatType = this.printAndGetBoatTypes();
        System.out.println("Boat length in " + lengthUnit + ":");
        int boatLength = this.scanner.nextInt();
        boatClub.addMember(name, personalNumber, boatType, boatLength);
        System.out.println("A new member has been added!");
    }

    public void changeMember(BoatClub boatClub) {
        System.out.println("(1) Change name : ");
        System.out.println("(2) Change personal number : ");
        System.out.println("Your choice : ");
        int choice = this.scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Type member id: ");
                int id = this.scanner.nextInt();
                System.out.print("Name: ");
                String name = this.scanner.next();
                boatClub.changeMemberName(id, name);
                break;
            case 2:
                System.out.println("Type member id: ");
                int id2 = this.scanner.nextInt();
                System.out.println("Ex Personal Number '199905239898'");
                System.out.println("Personal Number: ");
                String personalNumber = this.scanner.next();
                boatClub.changeMemberName(id2, personalNumber);
                break;
        }
        System.out.println("Member information changed.");
    }

    public void removeMember(BoatClub boatClub) {
        System.out.println("Type member id: ");
        int id = this.scanner.nextInt();
        boatClub.removeMember(id);
        System.out.println("Member removed.");
    }

    public void lookMember(BoatClub boatClub) {
        System.out.println("Type the id of the member you want to look at: ");
        int id = this.scanner.nextInt();
        Member member = boatClub.getMemberFromClub(id);
        System.out.println("Name: " + member.getName() + "\nPersonal Number: " + member.getPersonalNumber() + "\nID: "
                + member.getMemberId() + "\nNumber of boats: " + member.getNumberOfBoats());
    }

    public void listCompact(BoatClub boatClub) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Iterator<Member> it = boatClub.getMembersIterator(); it.hasNext(); ) {
            Member member = it.next();
            stringBuilder.append("Name: ");
            stringBuilder.append(member.getName()).append(" ,");
            stringBuilder.append("id: ");
            stringBuilder.append(member.getMemberId()).append(" ,");
            stringBuilder.append("boats: ");
            stringBuilder.append(member.getNumberOfBoats()).append("\n");
        }
        System.out.println(stringBuilder);
    }

    public void listVerbose(BoatClub boatClub) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Iterator<Member> it = boatClub.getMembersIterator(); it.hasNext(); ) {
            Member member = it.next();
            stringBuilder.append("Name: ");
            stringBuilder.append(member.getName()).append(" ,");
            stringBuilder.append("Personal number: ");
            stringBuilder.append(member.getPersonalNumber()).append(" ,");
            stringBuilder.append("id: ");
            stringBuilder.append(member.getMemberId()).append("\n");
            stringBuilder.append("boat list: \n");
            for (Boat boat : member.getBoatArray()) {
                stringBuilder.append("Type: " + " ").append(this.boatTypeTranslator(boat.getBoatType())).append(" , ")
                        .append("length in ").append(lengthUnit).append(":").append(boat.getLength())
                        .append(", pos:").append(member.getBoatArray().indexOf(boat)).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }

    public void addBoat(BoatClub boatClub) {
        System.out.println("Type the id of the member you want to add the boat to: ");
        int id = this.scanner.nextInt();
        System.out.println("You have to enter the boat details: ");
        Boat.BoatType boatType = this.printAndGetBoatTypes();
        System.out.println("Boat length in " + lengthUnit + ":");
        int boatLength = this.scanner.nextInt();
        boatClub.addBoatToMember(id, boatType, boatLength);
        System.out.println("A new boat has been added!");
    }

    public void changeBoat(BoatClub boatClub) {
        System.out.println("Type the id of the member you want to change the boat information: ");
        int id = this.scanner.nextInt();
        System.out.println("Type the boat position: ");
        int pos = this.scanner.nextInt();
        System.out.println("You have to enter the boat details: ");
        Boat.BoatType boatType = this.printAndGetBoatTypes();
        System.out.println("Boat length in " + lengthUnit + ":");
        int boatLength = this.scanner.nextInt();
        boatClub.changeBoatInfoFromMember(id, pos, boatLength, boatType);
    }

    public void removeBoat(BoatClub boatClub) {
        System.out.println("Type the id of the member you want to delete the boat from: ");
        int id = this.scanner.nextInt();
        System.out.println("Type the boat position: ");
        int pos = this.scanner.nextInt();
        boatClub.removeBoatFromMember(id, pos);
    }

    public void exitMessage() {
        System.out.println("Exiting and saving Registry");
    }

    //helper method for view, use to print the boat types available
    private Boat.BoatType printAndGetBoatTypes() {
        System.out.println("(1) " + boats[0]);
        System.out.println("(2) " + boats[1]);
        System.out.println("(3) " + boats[2]);
        System.out.println("(4) " + boats[3]);
        int choice = this.scanner.nextInt();
        Boat.BoatType boatType;
        switch (choice) {
            case 1:
                boatType = Boat.BoatType.Sailboat;
                break;
            case 2:
                boatType = Boat.BoatType.Motorsailer;
                break;
            case 3:
                boatType = Boat.BoatType.Kayak_Canoe;
                break;
            default:
                boatType = Boat.BoatType.Other;
                break;
        }
        return boatType;
    }

    //helper method that translates the BoatType into english
    private String boatTypeTranslator(Boat.BoatType boatType) {
        String type;
        switch (boatType) {
            case Sailboat:
                type = boats[0];
                break;
            case Motorsailer:
                type = boats[1];
                break;
            case Kayak_Canoe:
                type = boats[2];
                break;
            default:
                type = boats[3];
                break;
        }
        return type;
    }

}
