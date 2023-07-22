package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityManager;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public class GoldPassenger extends Passenger implements PassengerSignUp {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public GoldPassenger(String name, int passengerNumber, int balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }

    @Override
    public void signUpForActivity(Activity a) throws InsufficientBalanceException, PassengerOverflowException {
        Activity activity = ActivityManager.spinUpActivityOrReturnExisting(a);
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
    public void recharge(int amount) {
        this.balance += amount;
    }
}
