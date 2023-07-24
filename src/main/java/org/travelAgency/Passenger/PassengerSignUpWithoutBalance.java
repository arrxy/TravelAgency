package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityManager;
import org.travelAgency.Extra.EligibilityChecks;
import org.travelAgency.TravelPackage.TravelPackage;
import org.travelAgency.exceptionHandler.InvalidActivityException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public class PassengerSignUpWithoutBalance extends PassengerSignUp {
    public void signUpForActivity(Activity a, TravelPackage p, Passenger passenger) throws InvalidActivityException, PassengerOverflowException {
        Activity activity = ActivityManager.spinUpActivityOrReturnExisting(a);
        EligibilityChecks.checkEligibilityForPassengerSignUp(activity, p, passenger);
        activity.signUp();
        passenger.activityList.add(new Passenger.ActivityPair(activity, 0.0));
    }
}
