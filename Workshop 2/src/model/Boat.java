package model;

public class Boat {

	private int length;
    private String boatType;

    Boat(String boatType, int length) {
        this.boatType = boatType;
        this.length = length;
    }
    public Boat(){

    }

     int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

     String getType() {
        return boatType;
    }

    public void setBoatType(String boatType) {
        this.boatType = boatType;
    }

     void setBoatInfo(int changeLength, String changeBoatType) {
    	if(getType()== null)
    		throw new RuntimeException("There is no Boat!");
        setLength(changeLength);
        setBoatType(changeBoatType);
    }

    @Override
    public String toString() {
        return "Type: " + " " + this.boatType + " , " + "length: " + this.length;
    }
    
}
