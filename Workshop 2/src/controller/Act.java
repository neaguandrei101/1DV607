package controller;

import model.Boat;
import model.BoatClub;
import model.Member;

import java.util.Scanner;

public class Act {

    private static Scanner sc = new Scanner(System.in);
    public Act(){

    }

    public static int readChoice(int num) throws Exception {
        boolean on = true;
        while (on) {
            switch (num) {
                case 1:
                    createUser();
                    on = false;
                    break;
                case 2:
                    ;
                    on = false;
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
        return num;
    }

    public static void createUser() throws Exception {
        boolean created = false;

            Member create = new Member();
            BoatClub boatClub = new BoatClub();
            Boat boat = new Boat();

            System.out.print("Name: ");
            create.setPersonalNumber(sc.nextLine());

            System.out.println("Ex Personal Number '199905239898'");
            System.out.print("Personal Number: ");
            create.setPersonalNumber(sc.nextLine());

            System.out.println("Boat Type: ");

            boatClub.addMember(create);

            System.out.println("\nNew member has been added!");
            System.out.println("========================================");
            System.out.println(create.toString());
            System.out.println("========================================\n\n");


        }
    }
