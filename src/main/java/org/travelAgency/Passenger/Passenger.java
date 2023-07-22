package org.travelAgency.Passenger;

public class Passenger {
    protected String name;
    protected int passengerNumber;

    public Passenger (String name, int passengerNumber) {
        this.name = name;
        this.passengerNumber = passengerNumber;
    }

    public void print() {
        System.out.println("Passenger Name: " + this.name);
        System.out.println("Passenger Number: " + this.passengerNumber);
    }
}
