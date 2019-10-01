package controller;

import model.Boat;
import model.BoatClub;
import model.Member;
import view.View;

import java.security.InvalidKeyException;
import java.util.Scanner;

public class Act {
	private BoatClub boatClub = new BoatClub();
	private View view = new View();

	private static Scanner sc = new Scanner(System.in);

	public Act() {
	}

	public void readChoice() throws Exception {
		this.view.console();
		int num = sc.nextInt();

		boolean on = true;
		while (on) {
			switch (num) {
			case 1:
				createUser();
				on = false;
				readChoice();
				break;
			case 2:
				deleteUser();
				on = false;
				readChoice();
				break;
			case 3:

				on = false;
				break;
			case 4:

				break;
			case 5:

				on = false;
				break;
			case 6:
				System.out.println("Exiting...");
				on = false;
				break;
			default:
				throw new RuntimeException("Invalid Input!");
			}
		}
	}

	public void createUser() throws Exception {
		boolean safe = false;
		Member create = new Member();
		Boat boat = new Boat();

		System.out.print("Name: ");
		create.setName(sc.next());
		System.out.println("Ex Personal Number '199905239898'");
		System.out.print("Personal Number: ");
		String personalNumber = sc.next();
		create.setPersonalNumber(personalNumber);
		create.setMemberId(personalNumber.hashCode());
		
		System.out.println("You have to add your first boat, enter the boat details: ");
		boat.setBoatCounter(0);
		this.view.printBoatTypes();
		System.out.println("Boat Type: ");
		switch (sc.nextInt()) {
		case 1:
			boat.setBoatType("Sailboat");
			break;
		case 2:
			boat.setBoatType("Motorsailer");
			break;
		case 3:
			boat.setBoatType("Kayak/Canoe");
			break;
		case 4:
			boat.setBoatType("Other");
			break;
		}

		System.out.println("Boat length in meters: ");
		int num = sc.nextInt();
		boat.setLength(num);
		create.addBoat(boat);
		safe = true;

		if (safe) {
			this.boatClub.addMember(create);
		} else {
			throw new RuntimeException("Something went wrong in the user creation");
		}
		System.out.println("\nNew member has been added!");
		System.out.println("========================================");
		System.out.println(create.toString());
		System.out.println("========================================\n\n");
	}
	
	public void deleteUser() {
		System.out.println("Type personal number: ");
		this.boatClub.removeMemberByPersonalNumber(sc.next());
	}
}
