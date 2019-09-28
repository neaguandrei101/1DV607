package view;


import java.security.InvalidKeyException;
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
        Member member2 = new Member("another member", "199809221000");
        System.out.println("\nNew member has been added!");


        member.addBoat(Boat.BoatType.KAYAK_CANOE, 5);
        member.addBoat(Boat.BoatType.MOTORSAILER, 255);

        boatClub.addMember(member);
        boatClub.addMember(member2);

        System.out.println("=========== PRE CHANGE eListString ==============");
        System.out.println(boatClub.verboseListString());
        System.out.println("=========== VerboseListString ==============");

        //	member.removeBoat(0);

        boatClub.addMember(member);



        System.out.println("================ CHANGE BOAT INFO ===============");

        member.changeBoatInfo(0,20, Boat.BoatType.SAILBOAT);
        System.out.println(boatClub.verboseListString());
        System.out.println("===================================\n\n");

        System.out.println("=========== VerboseListString ==============");
        System.out.println(boatClub.verboseListString());
        System.out.println("=========== VerboseListString ==============");

        System.out.println(boatClub.compactListString());

        System.out.println(boatClub.getMemberInfo(0));


        //boatClub.removeMember(0);

        // boatClub.removeMember(0);

        sc.close();

        boatClub.changeMemberInfo(0,"Jameson", "199808051234");
        System.out.println(boatClub.getMemberInfo(0));
        System.out.println();
        System.out.println(boatClub.verboseListString());
        System.out.println(boatClub.compactListString());

//        boolean running = true;
//        System.out.println("Welcome to the Boat management system!");
//
//        UserInterface session = new UserInterface();
//
//        while (running) {
//            System.out.println("Choose: ");
//            System.out.println("(1) Register a new Member");
//            System.out.println("(2) Delete a Member");
//            System.out.println("(3) Show lists of all members in two different ways");
//            System.out.println("(4) Change a Member's Information");
//            System.out.println("(5) Look at a specific member’s information");
//            System.out.println("(6) Exit");
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

}
