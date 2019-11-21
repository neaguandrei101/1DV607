package model;

public class Boat {
    private int length;
    private String boatType;

    public Boat() {} // this is bad but it is required by RegistryHandler

    public Boat(int boatType, int length) {
        this.boatType = this.newBoatType(boatType);
        this.length = length;
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

    void setBoatInfo(int changeLength, int changeBoatType) {
        if(getType()== null)
            throw new RuntimeException("There is no Boat!");
        setLength(changeLength);
        setBoatType(this.newBoatType(changeBoatType));
    }

    @Override
    public String toString() {
        return "Type: " + " " + this.boatType + " , " + "length: " + this.length;
    }

    private String newBoatType(int value){  //fancy java 12 preview features
        return switch (value) {    //have to learn it somehow
            case 1 : break "Sailboat";
            case 2 : break "Motorsailer";
            case 3 : break"Kayak/Canoe";
            default: break "Other";
        };
    }

}
