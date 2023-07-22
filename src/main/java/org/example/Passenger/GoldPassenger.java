package org.example.Passenger;

import org.example.Activity.Activity;
import org.example.Activity.ActivityFactory;
import org.example.exceptionHandler.InsufficientBalanceException;
import org.example.exceptionHandler.PassengerOverflowException;

public class GoldPassenger extends Passenger implements PassengerSignUp {
    private double balance;

    public GoldPassenger(String name, int passengerNumber, int balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }

    @Override
    public void signUpForActivity(Activity a) throws InsufficientBalanceException, PassengerOverflowException {
        Activity activity = ActivityFactory.spinUpActivityOrReturnExisting(a);
        double discountFactor = 0.9;
        double activityPrice = activity.getCost() * discountFactor;
        if (balance > activityPrice) {
            synchronized (StandardPassenger.class) {
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
