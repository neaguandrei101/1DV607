package model;

public class Boat {
    private int length;
    private BoatType boatType;

    public enum BoatType {
        Sailboat, Motorsailer, Kayak_Canoe, Other
    }

    public Boat() {
    } // this is bad but it is required by Jackson library

    public Boat(BoatType boatType, int length) {
        this.boatType = boatType;
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

    void setBoatInfo(int length, BoatType boatType) {
        if (getBoatType() == null)
            throw new RuntimeException("There is no Boat!");
        setLength(length);
        setBoatType(boatType);
    }

}
