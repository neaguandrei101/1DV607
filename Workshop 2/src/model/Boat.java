package model;

public class Boat {
	 private String personalNumber;
	    private int boatID;
	    private int length;
	    private BoatType type;

	    public enum BoatType {
	        SAILBOAT, MOTORSAILER, KAYAK_CANOE, OTHER;
	    }

	    Boat () {
	    }

	    Boat(BoatType type, int length, String personalNumber, int boatId ) {
	        this.personalNumber = personalNumber;
	        this.length = length; //length in centimeters
	        this.type = type;
	        this.boatID = boatId;
	    }
	    
	    public int getLength(){
	    	return length ;
	    }
	    
	    public BoatType getType(){
	    	return type ;
	    }

	    void setLength (int length){
	    	this.length = length ;
	    }
	    
	    void setType (BoatType type){
	    	this.type = type;
	    }

	    @Override
	    public String toString() {
	        return "Type: "+ " " + this.type + " , " +"length: " +this.length + " , " + "id: "+ this.boatID + "\n";
	    }

}
