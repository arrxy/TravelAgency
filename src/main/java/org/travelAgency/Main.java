package org.travelAgency;

import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityManager;
import org.travelAgency.Destination.Destination;
import org.travelAgency.Destination.DestinationManager;
import org.travelAgency.Passenger.GoldPassenger;
import org.travelAgency.Passenger.PremiumPassenger;
import org.travelAgency.Passenger.StandardPassenger;
import org.travelAgency.TravelPackage.TravelPackage;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.InvalidActivityException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public class Main {
    public static void main(String[] args) throws PassengerOverflowException, InsufficientBalanceException, InvalidActivityException {
        StandardPassenger ps1 = new StandardPassenger("ps1", 1, 1000.0);
        StandardPassenger ps2 = new StandardPassenger("ps2", 2, 1000.0);
        GoldPassenger g1 = new GoldPassenger("g1", 3, 1000.0);
        GoldPassenger g2 = new GoldPassenger("g2", 4, 1000.0);

        PremiumPassenger pr1 = new PremiumPassenger("pr1", 5);
        PremiumPassenger pr2 = new PremiumPassenger("pr2", 6);


        Destination d1 = new Destination("Destination1");
        Destination d2 = new Destination("Destination2");
        d1 = DestinationManager.spinUpActivityOrReturnExisting(d1);
        d2 = DestinationManager.spinUpActivityOrReturnExisting(d2);

        Activity a1 = new Activity("activity1", "desc1", 100, 3);
        a1 = ActivityManager.spinUpActivityOrReturnExisting(a1);

        Activity a2 = new Activity("activity2", "desc1", 100, 3);
        a2 = ActivityManager.spinUpActivityOrReturnExisting(a2);

        Activity a3 = new Activity("activity3", "desc1", 100, 3);
        a3 = ActivityManager.spinUpActivityOrReturnExisting(a3);

        Activity a4 = new Activity("activity4", "desc1", 100, 3);
        a4 = ActivityManager.spinUpActivityOrReturnExisting(a4);

        a1.attachToDestination(d1);
        a2.attachToDestination(d2);
        a3.attachToDestination(d2);
        a4.attachToDestination(d2);

        TravelPackage t1 = new TravelPackage("travel", 3);
        t1.addDestination(d1);
        t1.addDestination(d2);

        t1.addPassenger(ps1);
        t1.addPassenger(ps2);
        t1.addPassenger(pr1);

        ps1.signUpForActivity(a1, t1);
        ps1.signUpForActivity(a2, t1);
        pr1.signUpForActivity(a1, t1);
        pr1.signUpForActivity(a2, t1);
        pr1.signUpForActivity(a3, t1);

        t1.printItenary();
        t1.printPassengers();
    }
}