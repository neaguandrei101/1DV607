package model;

public class Boat {
    private int length;
    private BoatType boatType;

    public Boat() {
    } // this is bad but it is required by Jackson library

    public Boat(int boatType, int length) {
        this.boatType = this.newBoatType(boatType);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public BoatType getBoatType() {
        return boatType;
    }

    public void setBoatType(BoatType boatType) {
        this.boatType = boatType;
    }

    void setBoatInfo(int changeLength, int changeBoatType) {
        if (getBoatType() == null)
            throw new RuntimeException("There is no Boat!");
        setLength(changeLength);
        setBoatType(this.newBoatType(changeBoatType));
    }

    //TODO replace with ENUM
    private BoatType newBoatType(int value) {
        BoatType type ;
        switch (value) {
            case 1:
                type = BoatType.Sailboat;
            case 2:
                type = BoatType.Motorsailer;
            case 3:
                type = BoatType.Kayak_Canoe;
            default:
                type = BoatType.Other;
        }
        return type;
    }

    public enum BoatType {
        Sailboat, Motorsailer, Kayak_Canoe, Other
    }

}
