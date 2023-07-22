package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityFactory;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public class StandardPassenger extends Passenger implements PassengerSignUp {
    private int balance;
    public StandardPassenger(String name, int passengerNumber, int balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }
    @Override
    public void signUpForActivity(Activity a) throws InsufficientBalanceException, PassengerOverflowException {
        Activity activity = ActivityFactory.spinUpActivityOrReturnExisting(a);
        double activityPrice = activity.getCost();
        if (balance > activityPrice) {
            synchronized (this) {
                if (balance > activityPrice) {
                    activity.signUp();
                    balance -= activityPrice;
                }
            }
        } else {
            throw new InsufficientBalanceException("Insufficient balance for customer");
        }

    }
}
