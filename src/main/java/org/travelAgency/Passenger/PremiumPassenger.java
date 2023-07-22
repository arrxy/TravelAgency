package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityManager;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public class PremiumPassenger extends Passenger implements PassengerSignUp{
    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber);
    }
    @Override
    public void signUpForActivity(Activity a) throws InsufficientBalanceException, PassengerOverflowException {
        Activity activity = ActivityManager.spinUpActivityOrReturnExisting(a);
        activity.signUp();
    }
}
