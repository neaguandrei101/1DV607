package view;

import model.Boat;
import model.BoatClub;
import model.Member;
import java.util.Iterator;
import java.util.Scanner;

public class SwedishView implements IView {
    private final String[] boats = new String[]{"Segelbåt", "Motorseglare", "Kanot/Kajak", "Övrigt"};
    private final String lengthUnit = "meter";
    private Scanner scanner = new Scanner(System.in);

    public MenuOptions printMenu() {
        System.out.println("Välja: ");
        System.out.println("(a) Skriv ut en kompakt lista");
        System.out.println("(b) Skriv ut en ordlista");
        System.out.println("(c) Lägg till en medlem");
        System.out.println("(d) Byta en medlem");
        System.out.println("(e) Radera en medlem");
        System.out.println("(f) Titta på en specifik medlems information");
        System.out.println("(g) Lägg till en båt till en medlem");
        System.out.println("(h) Ändra båtens information");
        System.out.println("(i) Radera en båt från en medlem");
        System.out.println("(j) Läs från registret.json");
        System.out.print("\n--> Ditt val: ");
        char choice = this.scanner.next().charAt(0);
        MenuOptions menuOptions;
        switch (choice) {
            case 'a':
                menuOptions = MenuOptions.LIST_COMPACT;
                break;
            case 'b':
                menuOptions = MenuOptions.LIST_VERBOSE;
                break;
            case 'c':
                menuOptions = MenuOptions.ADD_MEMBER;
                break;
            case 'd':
                menuOptions = MenuOptions.CHANGE_MEMBER;
                break;
            case 'e':
                menuOptions = MenuOptions.REMOVE_MEMBER;
                break;
            case 'f':
                menuOptions = MenuOptions.LOOK_MEMBER;
                break;
            case 'g':
                menuOptions = MenuOptions.ADD_BOAT;
                break;
            case 'h':
                menuOptions = MenuOptions.CHANGE_BOAT;
                break;
            case 'i':
                menuOptions = MenuOptions.REMOVE_BOAT;
                break;
            case 'j':
                menuOptions = MenuOptions.READ_REGISTRY;
                break;
            default:
                menuOptions = MenuOptions.EXIT;
                break;
        }
        return menuOptions;
    }

    public void addMember(BoatClub boatClub) {
        System.out.println("Ex Personnummer '199905239898'" + "\nPersonnummer: ");
        String personalNumber = this.scanner.next();
        System.out.println("Namn: ");
        String name = this.scanner.next();
        System.out.println("Du måste ange båtinformationen: ");
        Boat.BoatType boatType = this.printAndGetBoatTypes();
        System.out.println("Båtlängd i " + lengthUnit + ":");
        int boatLength = this.scanner.nextInt();
        boatClub.addMember(name, personalNumber, boatType, boatLength);
        System.out.println("En ny medlem har lagts till!");
    }

    public void changeMember(BoatClub boatClub) {
        System.out.println("(a) Byt namn : ");
        System.out.println("(b) Byt ppersonnummer : ");
        System.out.println("Ditt val : ");
        char choice = this.scanner.next().charAt(0);
        switch (choice) {
            case 'a':
                System.out.print("Namn: ");
                String name = this.scanner.next();
                System.out.println("Skriv medlem id: ");
                int id = this.scanner.nextInt();
                boatClub.changeMemberName(id, name);
                break;
            case 'b':
                System.out.println("Ex Personnummer '199905239898'");
                System.out.println("Personnummer: ");
                String personalNumber = this.scanner.next();
                System.out.println("Skriv medlem id: ");
                int id2 = this.scanner.nextInt();
                boatClub.changeMemberName(id2, personalNumber);
                break;
        }
        System.out.println("Medlemsinformation ändrades.");
    }

    public void removeMember(BoatClub boatClub) {
        System.out.println("Skriv medlem id: ");
        int id = this.scanner.nextInt();
        boatClub.removeMember(id);
        System.out.println("Medlem togs bort.");
    }

    public void lookMember(BoatClub boatClub) {
        System.out.println("Skriv in id för medlemmen du vill titta på: ");
        int id = this.scanner.nextInt();
        Member member = boatClub.getMemberFromClub(id);

        System.out.println("Personnummer: " + member.getPersonalNumber() + "\nNamn: " + member.getName() + "\nID: "
                + member.getMemberId() + "\nAntal båtar: " + member.getNumberOfBoats());
    }

    public void listCompact(BoatClub boatClub) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Iterator<Member> it = boatClub.getMembersIterator(); it.hasNext(); ) {
            Member member = it.next();
            stringBuilder.append("Id: ");
            stringBuilder.append(member.getMemberId()).append(" ,");
            stringBuilder.append("namn: ");
            stringBuilder.append(member.getName()).append(" ,");
            stringBuilder.append("båtar: ");
            stringBuilder.append(member.getNumberOfBoats()).append("\n");
        }
        System.out.println(stringBuilder);
    }

    public void listVerbose(BoatClub boatClub) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Iterator<Member> it = boatClub.getMembersIterator(); it.hasNext(); ) {
            Member member = it.next();
            stringBuilder.append("Personummer: ");
            stringBuilder.append(member.getPersonalNumber()).append(" ,");
            stringBuilder.append("Namn: ");
            stringBuilder.append(member.getName()).append(" ,");
            stringBuilder.append("id: ");
            stringBuilder.append(member.getMemberId()).append("\n");
            stringBuilder.append("båtlista: \n");
            for (Boat boat : member.getBoatArray()) {
                stringBuilder.append("Typ: " + " ").append(this.boatTypeTranslator(boat.getBoatType())).append(" , ")
                        .append("längd in ").append(lengthUnit).append(":").append(boat.getLength())
                        .append(", pos:").append(member.getBoatArray().indexOf(boat)).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }

    public void addBoat(BoatClub boatClub) {
        System.out.println("Skriv id för medlemmen du vill lägga båten till: ");
        int id = this.scanner.nextInt();
        System.out.println("Du måste ange båten detaljer: ");
        Boat.BoatType boatType = this.printAndGetBoatTypes();
        System.out.println("Båtlängd i " + lengthUnit + ":");
        int boatLength = this.scanner.nextInt();
        boatClub.addBoatToMember(id, boatType, boatLength);
        System.out.println("En ny båt har lagts till!");
    }

    public void changeBoat(BoatClub boatClub) {
        System.out.println("Skriv id för medlemmen du vill ändra båtinformation: ");
        int id = this.scanner.nextInt();
        System.out.println("Skriv båtens position: ");
        int pos = this.scanner.nextInt();
        System.out.println("Båtlängd i " + lengthUnit + ":");
        int boatLength = this.scanner.nextInt();
        System.out.println("Du måste ange båten detaljer: ");
        Boat.BoatType boatType = this.printAndGetBoatTypes();
        boatClub.changeBoatInfoFromMember(id, pos, boatLength, boatType);
    }

    public void removeBoat(BoatClub boatClub) {
        System.out.println("Skriv id för medlemmen du vill radera båten från: ");
        int id = this.scanner.nextInt();
        System.out.println("Skriv båtens position: ");
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