package view;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Boat;
import model.Member;
import model.BoatClub;
import controller.MemberInfo;

public class View {

    public static void main(String[] args) throws Exception {

        MemberInfo memberInfo = new MemberInfo();
        memberInfo.createUser();


        member.addBoat("KAYAK_CANOE", 5);
        member.addBoat("MOTORSAILER", 255);



        boatClub.addMember(member);
        member.removeBoat(1);


        System.out.println("================ CHANGE BOAT INFO ===============");

        member.changeBoatInfo(0,20, "SAILBOAT");
        System.out.println(boatClub.verboseListString());
        System.out.println("===================================\n\n");


























    /*TODO
     * this is used for testing
     * separate later into view and controller and
     * remove main class
     */





//        BoatClub boatClub = new BoatClub();
//        Member member = new Member("andrei", "101010101010");
//        Member member2 = new Member("another member", "199809221000");
//
//        member.addBoat(Boat.BoatType.KAYAK_CANOE, 5);
//        member.addBoat(Boat.BoatType.MOTORSAILER, 255);
//
//        boatClub.addMember(member);
//        boatClub.addMember(member2);
//
//        System.out.println("=========== PRE CHANGE VerboseListString ==============");
//        System.out.println(boatClub.verboseListString());
//        System.out.println("=========== VerboseListString ==============");
//        boatClub.addMember(member);
//
//
//
//        System.out.println("================ CHANGE BOAT INFO ===============");
//
//        member.changeBoatInfo(0,20, Boat.BoatType.SAILBOAT);
//        System.out.println(boatClub.verboseListString());
//        System.out.println("===================================\n\n");
//
//        System.out.println("=========== VerboseListString ==============");
//        System.out.println(boatClub.verboseListString());
//        System.out.println("=========== VerboseListString ==============");
//
//        System.out.println(boatClub.compactListString());
//
//        System.out.println(boatClub.getMemberInfo(0));
//
//        boatClub.changeMemberInfo(0,"Jameson", "199808051234");
//        System.out.println(boatClub.getMemberInfo(0));
//        System.out.println();
//        System.out.println(boatClub.verboseListString());
//        System.out.println(boatClub.compactListString());
//
//        Files.write(Paths.get("ExampleMember.json"),boatClub.getJsonFileMembers().toJSONString().getBytes());
        
        Files.write(Paths.get("ExampleMember.json"),boatClub.getJsonFileMembers().toJSONString().getBytes());
        ObjectMapper objectMapper = new ObjectMapper();        
        BoatClub readFromFile = objectMapper.readValue(new File("ExampleMember.json"), BoatClub.class);
        System.out.print("readFromFIle: \n"+readFromFile.verboseListString());
        
        


//        boolean running = true;
//        System.out.println("Welcome to the Boat management system!");
//
//        UserInterface session = new UserInterface();
//
//        while (running) {
//            System.out.println("Choose: ");
//
//            System.out.print("\n--> Your Choice: ");
//
//            int num = sc.nextInt();
//            session.readChoice(num);
//            if (num == 6) {
//                running = false;
//            }
//            if (num > 6) {
//                throw new InvalidKeyException("Wrong Input!");
//            }
//
//
//        }




}
