package view;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Member;
import model.ReadJSON;
import model.BoatClub;
import controller.Act;

public class UI {
	public UI() {
	}

	public void console() throws Exception {
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
		System.out.println("(9) Delete a Boat");
		System.out.print("\n--> Your Choice: ");
	}

	public void printBoatTypes() {
		
		System.out.println("(1) Sailboat");
		System.out.println("(2) Motorsailer");
		System.out.println("(3) Kayak/Canoe");
		System.out.println("(4) Other");
	}
	
	public void printListTypes() {
		System.out.println("(1) Compact List");
		System.out.println("(2) Verbose List");
	}
	
	public void printChangesToMember() {
		System.out.println("(1) Change name : ");
		System.out.println("(2) Change perosnal number : ");
	}



	
	

	// TODO revert to check
	// Files.write(Paths.get("ExampleMember.json"),boatClub.getJsonFileMembers().toJSONString().getBytes());

	// System.out.print("readFromFIle: \n" + new
	// ReadJSON().getBoatClubFromJsonFile("ExampleMember.json").verboseListString());

//        boolean running = true;
//        System.out.println("Welcome to the Boat management system!");
//
//        Files.write(Paths.get("ExampleMember.json"), boatClub.getJsonFileMembers().toJSONString().getBytes());
//        ObjectMapper objectMapper = new ObjectMapper();
//        BoatClub readFromFile = objectMapper.readValue(new File("ExampleMember.json"), BoatClub.class);
//        System.out.print("readFromFIle: \n" + readFromFile.verboseListString());

}
