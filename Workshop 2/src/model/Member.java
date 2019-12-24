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

    // can't remove
    // this is bad but it is required by RegistryHandler
    public Member() {
    }

    public Member(String name, String personalNumber, int memberId, Boat boat) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.memberId = memberId;
        boatArray.add(boat);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 3)
            this.name = name;
        else
            throw new RuntimeException("Name length to short!");
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public List<Boat> getBoatArray() {
        return boatArray;
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

    public int getMemberId() {
        return this.memberId;
    }

    public void addBoat(Boat boat) {
        this.boatArray.add(boat);
    }

    void removeBoat(int id) {
        try {
            boatArray.remove(id);
        } catch (IndexOutOfBoundsException ex) {
            throw new RuntimeException("Boat Not Found!");
        }
    }

    public Boat getBoatFromMember(int pos) {
        return this.boatArray.get(pos);
    }

    public int getNumberOfBoats() {
        return boatArray.size();
    }

    void changeBoatInfo(int position, int length, int boatType) {
        boatArray.get(position).setBoatInfo(length, boatType);
    }

}
