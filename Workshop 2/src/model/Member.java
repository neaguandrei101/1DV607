package model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Member {
    private String name;
    private String personalNumber;
    private int memberId;
    
	@JsonProperty("boatArray")
    protected List<Boat> boatArray = new ArrayList<>();

    /* TODO added empty new Boat() in the constructors
     * because when you create a new Member()
     * you are forced to have at least one boat
     * the empty Boat should be filled
     * maybe REMOVE
     */
    public Member(String name, String personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.memberId = personalNumber.hashCode();
      //  this.boatArray.add(new Boat());
    }

    public Member() {}

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() >= 3)
            this.name = name;
        else
            throw new RuntimeException("Name length to short!");
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) throws Exception {
        boolean valid = true;
        if (personalNumber.length() == 12) {
            for (int i = 0; i < personalNumber.length(); i++) {
                if (Character.isDigit(personalNumber.charAt(i)))
                    continue;
                else
                    valid = false;
            }
            if (valid == true)
                this.personalNumber = personalNumber;
            	
        } else
            throw new IndexOutOfBoundsException("Invalid Input!");
    }

    public int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void addBoat(String type, int length) {
        Boat boat = new Boat(type, length, boatArray.size());
        this.boatArray.add(boat);
    }
    
    public void addBoat(Boat boat) {
        this.boatArray.add(boat);
    }

    public void removeBoat(int id) {
        try{
            boatArray.remove(id);}
        catch (IndexOutOfBoundsException ex){
            throw new RuntimeException("Not Found!");
        }
    }

    public int getNumberOfBoats() {
        return boatArray.size();
    }

    public void changeBoatInfo(int position, int length, String boatType) throws Exception {
        boatArray.get(position).setBoatInfo(length, boatType);
    }

    public String printBoatArray() {
        StringBuilder sb = new StringBuilder();
        for (Boat boat : this.boatArray) {
            sb.append(boat.toString());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nP. Number: " + getPersonalNumber() + "\nID: " + getMemberId() + "\nNumber of boats: "+getNumberOfBoats();
    }


}
