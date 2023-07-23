package org.travelAgency.TravelPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityManager;
import org.travelAgency.Destination.Destination;
import org.travelAgency.Destination.DestinationManager;
import org.travelAgency.Passenger.GoldPassenger;
import org.travelAgency.Passenger.PremiumPassenger;
import org.travelAgency.Passenger.StandardPassenger;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

import static org.junit.jupiter.api.Assertions.*;

class TravelPackageTest {
    StandardPassenger standardPassenger;
    GoldPassenger goldPassenger;
    PremiumPassenger premiumPassenger;
    Destination destination;
    Activity activity;
    TravelPackage travelPackage;

    @BeforeEach
    void setUp() {
        standardPassenger = new StandardPassenger("TravelStandardPassenger0", 1, 1000.0);
        goldPassenger = new GoldPassenger("TravelGoldPassenger1", 1, 1000.0);

        travelPackage = new TravelPackage("Travel", 1);

    }

    @Test
    void addPassenger() throws PassengerOverflowException {
        travelPackage.addPassenger(standardPassenger);
        assertTrue(travelPackage.isPassengerEnrolled(standardPassenger));
        try {
            travelPackage.addPassenger(goldPassenger);
        } catch (Exception e) {
            String msg = "passenger List is Full";
            assertTrue(msg.equals(e.getMessage()));
        }
        assertFalse(travelPackage.isPassengerEnrolled(goldPassenger));
    }
}