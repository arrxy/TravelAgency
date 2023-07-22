package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityManager;
import org.travelAgency.TravelPackage.TravelPackage;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.InvalidActivityException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public class GoldPassenger extends Passenger implements PassengerSignUp {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }

    @Override
    public void signUpForActivity(Activity a, TravelPackage p) throws InsufficientBalanceException, PassengerOverflowException, InvalidActivityException {
        Activity activity = ActivityManager.spinUpActivityOrReturnExisting(a);
        if (!p.containsActivity(a)) {
            throw new InvalidActivityException("Invalid Activity For The Selected Package");
        }
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
    public void print() {
        System.out.println("---------------");
        System.out.println("GOLD PASSENGER");
        System.out.println("---------------");
        System.out.println("Passenger Name: " + this.name);
        System.out.println("Passenger Number: " + this.passengerNumber);
        System.out.println("Passenger Number: " + this.balance);
    }
}
