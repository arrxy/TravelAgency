package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityManager;
import org.travelAgency.Passenger.Passenger;
import org.travelAgency.Passenger.PassengerSignUp;
import org.travelAgency.TravelPackage.TravelPackage;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.InvalidActivityException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public class StandardPassenger extends Passenger implements PassengerSignUp {
    private double balance;
    public double getBalance() {
        return balance;
    }
    public StandardPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }
    private void checkEligibilityForSignUp(Activity a, TravelPackage p) throws InvalidActivityException {
        if (!p.containsActivity(a)) {
            throw new InvalidActivityException("Invalid Activity For The Selected Package");
        }
        if (!p.isPassengerEnrolled(this)) {
            throw new InvalidActivityException("Passenger not yet enrolled in package");
        }
    }
    @Override
    public void signUpForActivity(Activity a, TravelPackage p) throws InsufficientBalanceException, PassengerOverflowException, InvalidActivityException {
        Activity activity = ActivityManager.spinUpActivityOrReturnExisting(a);
        checkEligibilityForSignUp(activity, p);
        double activityPrice = activity.getCost();
        if (balance >= activityPrice) {
            synchronized (this) {
                if (balance >= activityPrice) {
                    activity.signUp();
                    balance -= activityPrice;
                }
            }
        } else {
            throw new InsufficientBalanceException("Insufficient balance for customer");
        }
    }

    public void recharge(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }
    public void print() {
        System.out.println("---------------");
        System.out.println("STANDARD PASSENGER");
        System.out.println("---------------");
        System.out.println("Passenger Name: " + this.name);
        System.out.println("Passenger Number: " + this.passengerNumber);
        System.out.println("Passenger Number: " + this.balance);
    }
}
