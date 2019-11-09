package model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {
    private String name;
    private String personalNumber;
    private int memberId;

    @JsonProperty("boatArray")
    List<Boat> boatArray = new ArrayList<>();

    public Member() {}

    String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 3)
            this.name = name;
        else
            throw new RuntimeException("Name length to short!");
    }

    String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) throws RuntimeException {
        boolean valid = true;
        if (personalNumber.length() == 12) {
            for (int i = 0; i < personalNumber.length(); i++) {
                if (Character.isDigit(personalNumber.charAt(i)))
                    continue;
                else
                    valid = false;
            }
            if (valid)
                this.personalNumber = personalNumber;
        } else
            throw new RuntimeException("Invalid Input Personal Number!");
    }

    int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void addBoat(String type, int length) {
        Boat boat = new Boat(type, length);
        this.boatArray.add(boat);
    }

    public void addBoat(Boat boat) {
        this.boatArray.add(boat);
    }

    void removeBoat(int id) {
        try{
            boatArray.remove(id);}
        catch (IndexOutOfBoundsException ex){
            throw new RuntimeException("Boat Not Found!");
        }
    }

    int getNumberOfBoats() {
        return boatArray.size();
    }

    void changeBoatInfo(int position, int length, String boatType) {
        boatArray.get(position).setBoatInfo(length, boatType);
    }

    String boatArrayToString() {
        StringBuilder sb = new StringBuilder();
        for (Boat boat : this.boatArray) {
            sb.append(boat.toString()).append(", pos:").append(this.boatArray.size() - 1).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nP. Number: " + getPersonalNumber() + "\nID: " + getMemberId() + "\nNumber of boats: "+getNumberOfBoats();
    }


}
