package org.example.TravelPackage;

import org.example.Activity.Activity;
import org.example.Destination.Destination;
import org.example.Destination.DestinationFactory;
import org.example.Passenger.Passenger;
import org.example.Passenger.StandardPassenger;
import org.example.exceptionHandler.PassengerOverflowException;

import java.util.*;

public class TravelPackage {
    private String name;
    private int capacity;
    private List<Destination> destinationList;
    private List<Passenger> passengerList;
    private Set<String> activityList;
    private Set<String> destinations;


    public TravelPackage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.destinationList = new ArrayList<>();
        this.passengerList = new ArrayList<>();
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
        for (Activity activity: destination.getActivityList()) {
            activityList.add(activity.getName());
        }
        destinationList.add(DestinationFactory.spinUpActivityOrReturnExisting(destination));
    }


}
