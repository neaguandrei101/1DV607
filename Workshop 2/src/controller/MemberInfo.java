package controller;

import model.Boat;
import model.BoatClub;
import model.Member;

import java.util.Scanner;

public class MemberInfo {

    private Scanner sc = new Scanner(System.in);
    public MemberInfo(){

    }

    public int readChoice(int num) throws Exception {
        boolean on = true;
        while (on) {
            switch (num) {
                case 1:
                //    createUser();
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

    public void createUser() throws Exception {
        boolean created = false;

            Member create = new Member();
            BoatClub boatClub = new BoatClub();
            Boat boat = new Boat();

            System.out.print("Name: ");
            create.setPersonalNumber(sc.nextLine());

            System.out.println("Ex Personal Number '199905239898'");
            System.out.print("Personal Number: ");
            create.setPersonalNumber(sc.nextLine());

            System.out.println("Example = 'MOTORSAILER' , Length =  '250'");
            System.out.println("(1) for 'SAILBOAT'");
            System.out.println("(2) for 'MOTORSAILER'");
            System.out.println("(3) for 'KAYAK_CANOE'");
            System.out.println("(4) for 'KAYAK_CANOE'");
            System.out.print("Your Choice -->");


            Object type1 = sc.nextLine();
            if (type1.equals("SAILBOAT")){
                boat.setType(type1);
            }



            create.addBoat(boat.setType(sc.nextLine().));

            boatClub.addMember(create);

            System.out.println("\nNew member has been added!");
            System.out.println("========================================");
            System.out.println(create.toString());
            System.out.println("========================================\n\n");


        }
    }
