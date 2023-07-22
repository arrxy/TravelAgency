package org.travelAgency;

import org.junit.jupiter.api.Test;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkFlowTest {

    @Test
    void testWorkFLow() throws InsufficientBalanceException, PassengerOverflowException, InvalidActivityException {
        StandardPassenger standardPassenger1 = new StandardPassenger("standardPassenger1", 1, 1000.0);
        StandardPassenger standardPassenger2 = new StandardPassenger("standardPassenger2", 2, 1000.0);

        GoldPassenger goldPassenger1 = new GoldPassenger("goldPassenger1", 3, 1000.0);
        GoldPassenger goldPassenger2 = new GoldPassenger("goldPassenger2", 4, 1000.0);

        PremiumPassenger premiumPassenger1 = new PremiumPassenger("premiumPassenger1", 5);
        PremiumPassenger premiumPassenger2 = new PremiumPassenger("premiumPassenger2", 6);


        Destination destination1 = new Destination("Destination1");
        Destination destination2 = new Destination("Destination2");
        destination1 = DestinationManager.spinUpActivityOrReturnExisting(destination1);
        destination2 = DestinationManager.spinUpActivityOrReturnExisting(destination2);

        Activity activity1 = new Activity("activity1", "desc1", 100, 3);
        activity1 = ActivityManager.spinUpActivityOrReturnExisting(activity1);

        Activity activity2 = new Activity("activity2", "desc1", 100, 3);
        activity2 = ActivityManager.spinUpActivityOrReturnExisting(activity2);

        Activity activity3 = new Activity("activity3", "desc1", 2000, 3);
        activity3 = ActivityManager.spinUpActivityOrReturnExisting(activity3);

        Activity activity4 = new Activity("activity4", "desc1", 2000, 3);
        activity4 = ActivityManager.spinUpActivityOrReturnExisting(activity4);

        activity1.attachToDestination(destination1);
        activity2.attachToDestination(destination2);
        activity3.attachToDestination(destination2);

        TravelPackage travelPackage = new TravelPackage("travel", 3);
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);

        travelPackage.addPassenger(standardPassenger1);
        travelPackage.addPassenger(standardPassenger2);
        travelPackage.addPassenger(premiumPassenger1);

        standardPassenger1.signUpForActivity(activity1, travelPackage);
        standardPassenger1.signUpForActivity(activity2, travelPackage);
        /*
        * TESTING FOR REMAINING BALANCE AFTER SUBSCRIBING TO ACTIVITY
        * */
        assertEquals(standardPassenger1.getBalance(), 800);

        /*
        * TESTING FOR INSUFFICIENT BALANCE WITH CUSTOMER
        * */

        try {
            standardPassenger1.signUpForActivity(activity3, travelPackage);
        } catch (Exception e) {
            String msg = "Insufficient balance for customer";
            assert(e.getMessage().equals(msg));
        }


        premiumPassenger1.signUpForActivity(activity1, travelPackage);
        premiumPassenger1.signUpForActivity(activity2, travelPackage);

        /*
        * ADDING TEST CASE FOR A PASSENGER SIGNING UP FOR ACTIVITY NOT INCLUDED IN PACKAGE
        * */

        try {
            premiumPassenger1.signUpForActivity(activity4, travelPackage);
        } catch (Exception e) {
            String msg = "Invalid Activity For The Selected Package";
            assert(e.getMessage().equals(msg));
        }

        /*
        * TEST FOR A PASSENGER SIGNING UP FOR ACTIVITY BUT NOT YET ENROLLED TO A TRAVEL PACKAGE
        * */

        StandardPassenger orphanPassenger = new StandardPassenger("testOrphan", 6, 100);
        try {
            orphanPassenger.signUpForActivity(activity1, travelPackage);
        } catch (Exception e) {
            String msg = "Passenger not yet enrolled in package";
            assert(e.getMessage().equals(msg));
        }

    }

}
