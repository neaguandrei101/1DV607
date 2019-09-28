package model;

public class Boat {

    private int boatCounter = 0;
    private int length;
    private BoatType type;

    Boat() {
    }

    Boat(BoatType type, int length, int boatId) {
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

    public BoatType getType() {
        return type;
    }

    void setType(BoatType type) {
        this.type = type;
    }

    public void setBoatInfo(int changeLength, BoatType changeBoatType) throws Exception {
    	if(getType()== null)
    		throw new RuntimeException("There is no Boat!");
        setLength(changeLength);
        setType(changeBoatType);
    }

    @Override
    public String toString() {
        return "Type: " + " " + this.type + " , " + "length: " + this.length + " , " + "id: " + this.boatCounter + "\n";
    }

    public enum BoatType {
        SAILBOAT, MOTORSAILER, KAYAK_CANOE, OTHER;
    }

}
