package view;

import model.Boat;
import model.BoatClub;
import model.Member;
import java.util.Iterator;
import java.util.Scanner;

public class SwedishView implements IView {
    private final String[] boats = new String[]{"Segelbåt", "Motorseglare", "Kanot/Kajak", "Övrigt"};
    private final String lengthUnit = "meter";
    Scanner scanner = new Scanner(System.in);

    public Menu printMenu() {
        System.out.println("Choose: ");
        System.out.println("(a) Print a compact list");
        System.out.println("(b) Print a verbose list");
        System.out.println("(c) Add a new Member");
        System.out.println("(d) Change a Member");
        System.out.println("(e) Delete a Member");
        System.out.println("(f) Look at a specific Member’s information");
        System.out.println("(g) Add a boat to a Member");
        System.out.println("(h) Change a Boat’s information");
        System.out.println("(i) Delete a Boat from a Member");
        System.out.println("(j) Read from Registry.json");
        System.out.print("\n--> Your Choice: ");
        char choice = this.scanner.next().charAt(0);
        Menu menu;
        switch (choice) {
            case 'a':
                menu = Menu.LIST_COMPACT;
                break;
            case 'b':
                menu = Menu.LIST_VERBOSE;
                break;
            case 'c':
                menu = Menu.ADD_MEMBER;
                break;
            case 'd':
                menu = Menu.CHANGE_MEMBER;
                break;
            case 'e':
                menu = Menu.REMOVE_MEMBER;
                break;
            case 'f':
                menu = Menu.LOOK_MEMBER;
                break;
            case 'g':
                menu = Menu.ADD_BOAT;
                break;
            case 'h':
                menu = Menu.CHANGE_BOAT;
                break;
            case 'i':
                menu = Menu.REMOVE_BOAT;
                break;
            case 'j':
                menu = Menu.READ_REGISTRY;
                break;
            default:
                menu = Menu.EXIT;
                break;
        }
        return menu;
    }

    public void addMember(BoatClub boatClub) {
        System.out.println("Ex Personnummer '199905239898'" + "\nPersonnummer: ");
        String personalNumber = this.scanner.next();
        System.out.println("Namn: ");
        String name = this.scanner.next();
        System.out.println("You have to enter the boat details: ");
        Boat.BoatType boatType = this.printAndGetBoatTypes();
        System.out.println("Boat length in " + lengthUnit + ":");
        int boatLength = this.scanner.nextInt();
        boatClub.addMember(name, personalNumber, boatType, boatLength);
        System.out.println("A new member has been added!");
    }

    public void changeMember(BoatClub boatClub) {
        System.out.println("(a) Change name : ");
        System.out.println("(b) Change personal number : ");
        System.out.println("Your choice : ");
        char choice = this.scanner.next().charAt(0);
        switch (choice) {
            case 'a':
                System.out.print("Name: ");
                String name = this.scanner.next();
                System.out.println("Type member id: ");
                int id = this.scanner.nextInt();
                boatClub.changeMemberName(id, name);
                break;
            case 'b':
                System.out.println("Ex Personal Number '199905239898'");
                System.out.println("Personal Number: ");
                String personalNumber = this.scanner.next();
                System.out.println("Type member id: ");
                int id2 = this.scanner.nextInt();
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

        System.out.println("Personal Number: " + member.getPersonalNumber() + "\nName: " + member.getName() + "\nID: "
                + member.getMemberId() + "\nNumber of boats: " + member.getNumberOfBoats());
    }

    public void listCompact(BoatClub boatClub) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Iterator<Member> it = boatClub.getMembersIterator(); it.hasNext(); ) {
            Member member = it.next();
            stringBuilder.append("Id: ");
            stringBuilder.append(member.getMemberId()).append(" ,");
            stringBuilder.append("name: ");
            stringBuilder.append(member.getName()).append(" ,");
            stringBuilder.append("boats: ");
            stringBuilder.append(member.getNumberOfBoats()).append("\n");
        }
        System.out.println(stringBuilder);
    }

    public void listVerbose(BoatClub boatClub) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Iterator<Member> it = boatClub.getMembersIterator(); it.hasNext(); ) {
            Member member = it.next();
            stringBuilder.append("Personal number: ");
            stringBuilder.append(member.getPersonalNumber()).append(" ,");
            stringBuilder.append("Name: ");
            stringBuilder.append(member.getName()).append(" ,");
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
        System.out.println("Boat length in " + lengthUnit + ":");
        int boatLength = this.scanner.nextInt();
        System.out.println("You have to enter the boat details: ");
        Boat.BoatType boatType = this.printAndGetBoatTypes();
        boatClub.changeBoatInfoFromMember(id, pos, boatLength, boatType);
    }

    public void removeBoat(BoatClub boatClub) {
        System.out.println("Type the id of the member you want to delete the boat from: ");
        int id = this.scanner.nextInt();
        System.out.println("Type the boat position: ");
        int pos = this.scanner.nextInt();
        boatClub.removeBoatFromMember(id, pos);
    }

    //helper method for view, use to print the boat types available
    private Boat.BoatType printAndGetBoatTypes() {
        System.out.println("(a) " + boats[0]);
        System.out.println("(b) " + boats[1]);
        System.out.println("(c) " + boats[2]);
        System.out.println("(d) " + boats[3]);
        char choice = this.scanner.next().charAt(0);
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

    //helper method that translates the BoatType into swedish
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
