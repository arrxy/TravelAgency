package org.example.Passenger;

import org.example.Activity.Activity;
import org.example.Activity.ActivityFactory;
import org.example.exceptionHandler.InsufficientBalanceException;
import org.example.exceptionHandler.PassengerOverflowException;

public class PremiumPassenger extends Passenger implements PassengerSignUp{
    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber);
    }
    @Override
    public void signUpForActivity(Activity a) throws InsufficientBalanceException, PassengerOverflowException {
        Activity activity = ActivityFactory.spinUpActivityOrReturnExisting(a);
        activity.signUp();
    }
}
