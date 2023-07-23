package org.travelAgency.Activity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.travelAgency.Destination.Destination;
import org.travelAgency.Destination.DestinationManager;
import org.travelAgency.Passenger.GoldPassenger;
import org.travelAgency.Passenger.PremiumPassenger;
import org.travelAgency.Passenger.StandardPassenger;
import org.travelAgency.TravelPackage.TravelPackage;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {
    StandardPassenger standardPassenger;
    GoldPassenger goldPassenger;
    PremiumPassenger premiumPassenger;
    Destination destination;
    Activity activity;
    TravelPackage travelPackage;

    @BeforeEach
    void setUp() {
        standardPassenger = new StandardPassenger("ActivityStandardPassenger", 1, 1000.0);
        goldPassenger = new GoldPassenger("ActivityGoldPassenger", 3, 1000.0);
        premiumPassenger = new PremiumPassenger("ActivityPremiumPassenger1", 5);


        destination = new Destination("ActivityDestination");
        destination = DestinationManager.spinUpActivityOrReturnExisting(destination);

        activity = new Activity("ActivityTest", "desc1", 100, 1);
        activity = ActivityManager.spinUpActivityOrReturnExisting(activity);

        travelPackage = new TravelPackage("ActivityTravel", 3);

    }

    @Test
    void signUp() throws PassengerOverflowException {
        int capacity = activity.getCapacity();
        activity.signUp();
        assertEquals(activity.getCapacity(), capacity - 1);
        try {
            activity.signUp();
        } catch (Exception e) {
            String msg = "Activity Full";
            assertTrue(e.getMessage().equals(msg));
        }
    }

    @Test
    void attachToDestination() {
        activity.attachToDestination(destination);
        assertTrue(destination.getActivityList().contains(activity));
    }
}