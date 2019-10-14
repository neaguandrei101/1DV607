package controller;

import model.Boat;
import model.BoatClub;
import model.Member;
import model.ReadJSON;
import view.UI;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Act {
	private BoatClub boatClub = ReadJSON.getBoatClubFromJsonFile("ExampleMember.json"); // reads the member list from ExampleMember.json
	private UI UI = new UI();

	private static Scanner sc = new Scanner(System.in);

	public Act() {
	}

	public void readChoice() throws Exception {
		this.UI.console();
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
			Files.write(Paths.get("ExampleMember.json"),boatClub.getJsonFileMembers().toJSONString().getBytes());
			System.out.println("Exiting...");
			break;
		default:
			throw new RuntimeException("Invalid Input!");
		}

	}

	public void createUser() throws Exception {
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
		newMember.setMemberId(personalNumber.hashCode());

		System.out.println("You have to add your first boat, enter the boat details: ");
		firstBoat.setBoatCounter(0);
		this.UI.printBoatTypes();
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
		} else {
			throw new RuntimeException("Something went wrong in the user creation");
		}
		System.out.println("\nNew member has been added!");
		System.out.println("========================================");
		System.out.println(newMember.toString());
		System.out.println("========================================\n\n");
	}

	public void deleteUser() {
		System.out.println("Type personal number: ");
		this.boatClub.removeMemberByPersonalNumber(sc.next());
	}

	public void listtAllMembers() {
		this.UI.printListTypes();
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

	public void lookAtMemberInfo() {
		System.out.println("Enter the member's personal number : ");
		String personalNumber = sc.next();
		System.out.println(this.boatClub.memberInfoByPN(personalNumber));
	}

	public void changeMemberInfo() {
		this.UI.printChangesToMember();
		System.out.println("Your choice : ");
		
		switch (sc.nextInt()) {
		case 1:
			System.out.println("Enter the members personal number");
			String pn = sc.next();
			System.out.println("New name :");
			this.boatClub.changeMemberName(pn, sc.next());
			break;
		case 2:
			System.out.println("Enter the members personal number");
			String pn1 = sc.next();
			System.out.println("New personal number :");
			this.boatClub.changeMemberPersonalNumber(pn1, sc.next());
			break;
		}
	}
}
