package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    protected String name;
    protected int passengerNumber;
    public double balance;
    protected List<ActivityPair> activityList;

    public Passenger (String name, int passengerNumber) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.activityList = new ArrayList<>();
    }

    public void print() {
        System.out.println("Passenger Name: " + this.name);
        System.out.println("Passenger Number: " + this.passengerNumber);
    }

    protected static class ActivityPair {
        Activity activity;
        double price;
        ActivityPair(Activity activity, double price) {
            this.activity = activity;
            this.price = price;
        }
    }
}
