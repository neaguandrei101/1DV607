package model;

import java.util.ArrayList;

public class BoatClub {
    /*
     * this class contains all the members
     */
    private ArrayList<Member> membersArray = new ArrayList<>();

    public BoatClub() {

    }

    public void addMember() {
        this.membersArray.add(new Member());
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
    
    public String getMemberInfo(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        Member member = membersArray.get(position);
        stringBuilder.append("Name: ");
        stringBuilder.append(member.getName() + " ,");
        stringBuilder.append("id: ");
        stringBuilder.append(member.getMemberId() + " ,");
        stringBuilder.append("boats: ");
        stringBuilder.append(member.getNumberOfBoats() + "\n");
        return stringBuilder.toString();
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
