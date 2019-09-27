package view;


import java.util.Scanner;

import model.Boat;
import model.Member;
import model.BoatClub;

public class View {
	/*TODO
	 * this is used for testing
	 * separate later into view and controller and
	 * remove main class
	 */

	public static void main(String[] args) throws Exception {
		   Scanner sc = new Scanner(System.in);
		   BoatClub boatClub = new BoatClub();

		        System.out.print("Name: ");
		        String name = sc.nextLine();
		      
		        System.out.print("Personal Number: ");
		        String personalNumber = sc.nextLine();
		        Member member = new Member(name, personalNumber);
		        
		        member.addBoat(Boat.BoatType.KAYAK_CANOE, 5, personalNumber);
		        member.addBoat(Boat.BoatType.KAYAK_CANOE, 5, personalNumber);

		        System.out.println("\nNew member has been added!");
		        boatClub.addMember(member);
		        System.out.println("========================================");
		        System.out.println(boatClub.verboseListString());

		        sc.close();

	}

}
