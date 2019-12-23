package model;

public class Boat {
    private int length;
    private String boatType;

    public Boat() {
    } // this is bad but it is required by RegistryHandler

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
        if (getType() == null)
            throw new RuntimeException("There is no Boat!");
        setLength(changeLength);
        setBoatType(this.newBoatType(changeBoatType));
    }

    //TODO remove string formatting
    @Override
    public String toString() {
        return "Type: " + " " + this.boatType + " , " + "length: " + this.length;
    }

    //TODO remove string formatting
    private String newBoatType(int value) {
        String type = "";
        switch (value) {
            case 1:
                type = "Sailboat";
            case 2:
                type = "Motorsailer";
            case 3:
                type = "Kayak/Canoe";
            default:
                type = "Other";
        }
        return type;
    }

}
