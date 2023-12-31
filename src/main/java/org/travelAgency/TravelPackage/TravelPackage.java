package org.travelAgency.TravelPackage;

import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityManager;
import org.travelAgency.Destination.Destination;
import org.travelAgency.Destination.DestinationManager;
import org.travelAgency.Passenger.Passenger;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

import java.util.*;

public class TravelPackage {
    private String name;
    private int capacity;
    private Set<Destination> destinationList;
    private Set<Passenger> passengerList;

    // SETS TO MAKE THE CHECKS FASTER
    private Set<String> activityList;
    private Set<String> destinations;


    public TravelPackage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.destinationList = new HashSet<>();
        this.passengerList = new HashSet<>();
        this.activityList = new HashSet<>();
        this.destinations = new HashSet<>();
    }

    public void addPassenger(Passenger passenger) throws PassengerOverflowException {
        if (passengerList.size() < capacity) {
            synchronized (this) {
                if (passengerList.size() < capacity) {
                    this.passengerList.add(passenger);
                }
            }
        } else {
            throw new PassengerOverflowException("passenger List is Full");
        }
    }

    public void addDestination(Destination destination) {
        if (destinations.contains(destination.getName())) {
            return;
        }
        destination = DestinationManager.spinUpActivityOrReturnExisting(destination);
        for (Activity activity: destination.getActivityList()) {
            this.activityList.add(activity.getName());
        }
        this.destinationList.add(destination);
        this.destinations.add(destination.getName());
    }

    /*
    * CHECK FUNCTIONS
    * */
    public boolean containsActivity(Activity activity) {
        activity = ActivityManager.spinUpActivityOrReturnExisting(activity);
        return this.activityList.contains(activity.getName());
    }

    public boolean isPassengerEnrolled(Passenger p) {
        return this.passengerList.contains(p);
    }

    /*
    * PRINT FUNCTIONS
    * */
    public void printPackageDetails() {
        System.out.println("    --- PACKAGE DETAILS --- ");
        System.out.println("Name: " + this.name);
        System.out.println("Capacity: " + this.capacity);
        System.out.println("Current Enrolled: " + this.passengerList.size());
    }

    public void printItenary() {
        System.out.println("DESTINATIONS");
        for (Destination destination: this.destinationList) {
            destination.print();
        }
    }

    public void printPassengers() {
        System.out.println("PASSENGERS");
        for (Passenger passenger: this.passengerList) {
            passenger.print();
        }
    }
}
