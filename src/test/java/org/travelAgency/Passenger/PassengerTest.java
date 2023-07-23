package org.travelAgency.Passenger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityManager;
import org.travelAgency.Destination.Destination;
import org.travelAgency.Destination.DestinationManager;
import org.travelAgency.TravelPackage.TravelPackage;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.InvalidActivityException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {
    StandardPassenger standardPassenger;
    GoldPassenger goldPassenger;
    PremiumPassenger premiumPassenger;
    Destination destination;
    Activity activity;
    TravelPackage travelPackage;

    @BeforeEach
    void setUp() {
        standardPassenger = new StandardPassenger("PassengerTestStandardPassenger", 1, 1000.0);
        goldPassenger = new GoldPassenger("PassengerTestGoldPassenger", 3, 1000.0);
        premiumPassenger = new PremiumPassenger("PassengerTestPremiumPassenger", 5);


        destination = new Destination("PassengerDestination");
        destination = DestinationManager.spinUpActivityOrReturnExisting(destination);

        activity = new Activity("PassengerActivity", "desc1", 100, 1);
        activity = ActivityManager.spinUpActivityOrReturnExisting(activity);

        travelPackage = new TravelPackage("PassengerTravel", 3);

    }

    @Test
    void signUpForActivity() throws InvalidActivityException, InsufficientBalanceException, PassengerOverflowException {
        try {
            goldPassenger.signUpForActivity(activity, travelPackage);
        } catch (Exception e) {
              String msg = "Passenger not yet enrolled in package";
              assertTrue(e.getMessage().equals(msg));
        }
        travelPackage.addPassenger(goldPassenger);
        activity.attachToDestination(destination);
        try {
            goldPassenger.signUpForActivity(activity, travelPackage);
        } catch (Exception e) {
            String msg = "Invalid Activity For The Selected Package";
            assertTrue(e.getMessage().equals(msg));
        }
        travelPackage.addDestination(destination);
        goldPassenger.signUpForActivity(activity, travelPackage);
    }
}