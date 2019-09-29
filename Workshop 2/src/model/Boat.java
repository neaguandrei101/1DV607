package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Boat {

    private int boatCounter = 0;
	private int length;
    private String type;

    public Boat() {
    }

    Boat(String type, int length, int boatId) {
        this.length = length; //length in centimeters
        this.type = type;
        this.boatCounter = boatId;
    }

    public int getLength() {
        return length;
    }

    void setLength(int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }
    
    public int getBoatCounter() {
		return boatCounter;
	}

    public void setBoatInfo(int changeLength, String changeBoatType) throws Exception {
    	if(getType()== null)
    		throw new RuntimeException("There is no Boat!");
        setLength(changeLength);
        setType(changeBoatType);
    }

    @Override
    public String toString() {
        return "Type: " + " " + this.type + " , " + "length: " + this.length + " , " + "id: " + this.boatCounter + "\n";
    }
    
}
