package org.travelAgency.Extra;

import org.travelAgency.Activity.Activity;
import org.travelAgency.Passenger.Passenger;
import org.travelAgency.TravelPackage.TravelPackage;
import org.travelAgency.exceptionHandler.InvalidActivityException;

public class EligibilityChecks {
    public static void checkEligibilityForPassengerSignUp(Activity activity, TravelPackage travelPackage, Passenger passenger) throws InvalidActivityException {
        if (!travelPackage.containsActivity(activity)) {
            throw new InvalidActivityException("Invalid Activity For The Selected Package");
        }
        if (!travelPackage.isPassengerEnrolled(passenger)) {
            throw new InvalidActivityException("Passenger not yet enrolled in package");
        }
    }
}
