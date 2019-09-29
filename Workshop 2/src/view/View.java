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

public class View {

        public void console() throws Exception {

            Scanner sc = new Scanner(System.in);
            boolean running = true;
            System.out.println("Welcome to the Boat management system!");

            while (running) {
                System.out.println("Choose: ");
                System.out.println("(1) Register a new Member");
                System.out.println("(2) Delete a Member");
                System.out.println("(3) Show lists of all members in two different ways");
                System.out.println("(4) Change a Member's Information");
                System.out.println("(5) Look at a specific member’s information");
                System.out.println("(6) Exit");
                System.out.print("\n--> Your Choice: ");

                int num = sc.nextInt();
                Act.readChoice(num);
                if (num == 6) {
                    running = false;
                }
                if (num > 6) {
                    throw new InvalidKeyException("Wrong Input!");
                }
            }
        }

//        Act memberInfo = new Act();
//        memberInfo.createUser();

//        member.addBoat("KAYAK_CANOE", 5);
//        member.addBoat("MOTORSAILER", 255);
//
//        boatClub.addMember(member);
//        member.removeBoat(1);
//
//
//        System.out.println("================ CHANGE BOAT INFO ===============");
//        member.changeBoatInfo(0,20, "SAILBOAT");
//        System.out.println(boatClub.verboseListString());
//        System.out.println("===================================\n\n");

        /*TODO
         * this is used for testing
         * separate later into view and controller and
         * remove main class
         */


//        BoatClub boatClub = new BoatClub();
//        Member member = new Member("andrei", "101010101010");
//        Member member2 = new Member("another member", "199809221000");
//
//        member.addBoat("KAYAK_CANOE", 5);
//        member.addBoat("MOTORSAILER", 255);
//
//        boatClub.addMember(member);
//       boatClub.addMember(member2);
//
//        System.out.println("=========== PRE CHANGE VerboseListString ==============");
//        System.out.println(boatClub.verboseListString());
//        System.out.println("=========== VerboseListString ==============");
//        boatClub.addMember(member);
//
//        System.out.println("================ CHANGE BOAT INFO ===============");
//
//        member.changeBoatInfo(0, 20, "SAILBOAT");
//        System.out.println(boatClub.verboseListString());
//       System.out.println("===================================\n\n");
//
//       System.out.println("=========== VerboseListString ==============");
//       System.out.println(boatClub.verboseListString());
//        System.out.println("=========== VerboseListString ==============");
//
//       System.out.println(boatClub.compactListString());
//
//        System.out.println(boatClub.getMemberInfo(0));
//
//        boatClub.changeMemberInfo(0, "Jameson", "199808051234");
//        System.out.println(boatClub.getMemberInfo(0));
//        System.out.println();
//        System.out.println(boatClub.verboseListString());
//        System.out.println(boatClub.compactListString());
//
//        Files.write(Paths.get("ExampleMember.json"), boatClub.getJsonFileMembers().toJSONString().getBytes());
//       System.out.println(boatClub.compactListString());

		// TODO revert to check
		//Files.write(Paths.get("ExampleMember.json"),boatClub.getJsonFileMembers().toJSONString().getBytes());

		
		System.out.print("readFromFIle: \n" + new ReadJSON().getBoatClubFromJsonFile("ExampleMember.json").verboseListString());

//        boolean running = true;
//        System.out.println("Welcome to the Boat management system!");
//
//        Files.write(Paths.get("ExampleMember.json"), boatClub.getJsonFileMembers().toJSONString().getBytes());
//        ObjectMapper objectMapper = new ObjectMapper();
//        BoatClub readFromFile = objectMapper.readValue(new File("ExampleMember.json"), BoatClub.class);
//        System.out.print("readFromFIle: \n" + readFromFile.verboseListString());




}

}