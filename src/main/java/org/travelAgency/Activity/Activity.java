package org.travelAgency.Activity;

import org.travelAgency.Destination.Destination;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public Destination getDestination() {
        return destination;
    }


    public Activity(String name, String description, int cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }

    public Activity(Activity activity) {
        this.name = activity.name;
        this.description = activity.description;
        this.cost = activity.cost;
        this.capacity = activity.capacity;
        this.destination = activity.destination;
    }
    public void signUp() throws PassengerOverflowException {
        if (capacity > 1) {
            synchronized (this) {
                if (capacity > 1) {
                    capacity -= 1;
                }
            }
        } else {
            throw new PassengerOverflowException("Activity Full");
        }
    }

}
