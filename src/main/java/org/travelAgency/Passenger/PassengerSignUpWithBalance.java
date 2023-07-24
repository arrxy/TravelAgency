package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityManager;
import org.travelAgency.Extra.EligibilityChecks;
import org.travelAgency.TravelPackage.TravelPackage;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.InvalidActivityException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public class PassengerSignUpWithBalance extends PassengerSignUp {
    public void signUpForActivity(Activity a, TravelPackage travelPackage, Passenger passenger, int discount) throws InvalidActivityException, PassengerOverflowException, InsufficientBalanceException {
        Activity activity = ActivityManager.spinUpActivityOrReturnExisting(a);
        EligibilityChecks.checkEligibilityForPassengerSignUp(activity, travelPackage, passenger);
        double discountFactor = 1 - ((discount * 1.0)/100);
        double activityPrice = activity.getCost() * discountFactor;
        if (passenger.balance > activityPrice) {
            synchronized (StandardPassenger.class) {
                if (passenger.balance > activityPrice) {
                    activity.signUp();
                    passenger.balance -= activityPrice;
                    passenger.activityList.add(new Passenger.ActivityPair(activity, activityPrice));
                }
            }
        } else {
            throw new InsufficientBalanceException("Insufficient balance for customer");
        }
    }
}
