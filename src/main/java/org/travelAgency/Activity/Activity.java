package org.travelAgency.Activity;

import org.travelAgency.Destination.Destination;
import org.travelAgency.Destination.DestinationManager;
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


    public Activity(String name, String description, int cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
    }

    public Activity(Activity activity) {
        this.name = activity.name;
        this.description = activity.description;
        this.cost = activity.cost;
        this.capacity = activity.capacity;
        this.destination = activity.destination;
    }

    public void print() {
        System.out.println("- Activity: " + this.getName());
        System.out.println("  Description: " + this.getDescription());
        System.out.println("  Cost: " + this.getCost());
    }
    public void signUp() throws PassengerOverflowException {
        /*
        Double-checking lock for making it thread safe.
        * */
        if (capacity >= 1) {
            synchronized (this) {
                if (capacity >= 1) {
                    capacity -= 1;
                }
            }
        } else {
            throw new PassengerOverflowException("Activity Full");
        }
    }

    public void attachToDestination(Destination d) {
        /*
        Case 1: When Destination is already attached -> return. Don't make any changes
        Case 2: When Destination is null -> Attach current Object to the Destination
        * */
        if (this.destination != null) {
            return;
        }
        Destination destinationFromInp = DestinationManager.spinUpActivityOrReturnExisting(d);
        destinationFromInp.addActivity(this);
        this.destination = DestinationManager.spinUpActivityOrReturnExisting(d);
    }

}
