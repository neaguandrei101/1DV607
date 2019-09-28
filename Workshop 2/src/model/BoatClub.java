package model;

import java.util.ArrayList;
import java.util.Scanner;

public class BoatClub {
    /*
     * this class contains all the members
     */
    private ArrayList<Member> membersArray = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

    public BoatClub() {

    }

    public void addMember(Member member) {
        this.membersArray.add(member);
    }

    public void removeMember(int id) {
        try {
            membersArray.remove(id);
        } catch (IndexOutOfBoundsException ex) {
            throw new RuntimeException("Not Found!");
        }
    }

    public void changeMemberInfo(int position, String changeName, String changePersonalNumber) throws Exception {
        Member change = membersArray.get(position);

        String var_changeName = changeName;
        String var_changePersonalNumber = changePersonalNumber;

        change.setName(var_changeName);
        change.setPersonalNumber(var_changePersonalNumber);
    }


    public String getMemberInfo(int position) {

        Member member = membersArray.get(position);
        return member.toString();
    }

    public String compactListString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Member member : membersArray) {
            stringBuilder.append("Name: ");
            stringBuilder.append(member.getName() + " ,");
            stringBuilder.append("id: ");
            stringBuilder.append(member.getMemberId() + " ,");
            stringBuilder.append("boats: ");
            stringBuilder.append(member.getNumberOfBoats() + "\n");
        }
        return stringBuilder.toString();
    }

    public String verboseListString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Member member : membersArray) {
            stringBuilder.append("Name: ");
            stringBuilder.append(member.getName() + " ,");
            stringBuilder.append("id: ");
            stringBuilder.append(member.getMemberId() + "\n");
            stringBuilder.append("boat list: \n");
            stringBuilder.append(member.printBoatArray());
        }
        return stringBuilder.toString();
    }
}
