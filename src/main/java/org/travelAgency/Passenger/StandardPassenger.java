package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;
import org.travelAgency.TravelPackage.TravelPackage;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.InvalidActivityException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public class StandardPassenger extends Passenger  {
    private static int discountPercentage = 0;
    PassengerSignUp passengerSignUp;
    public double getBalance() {
        return balance;
    }
    public StandardPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber);
        passengerSignUp = new PassengerSignUpWithBalance();
        this.balance = balance;
    }

    public void signUpForActivity(Activity a, TravelPackage p) throws InsufficientBalanceException, PassengerOverflowException, InvalidActivityException {
        passengerSignUp.signUpForActivity(a, p, this, discountPercentage);
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
        System.out.println("Passenger balance: " + this.balance);
        System.out.println(" ------- ACTIVITIES ------- ");
        for (ActivityPair activityPair: this.activityList) {
            activityPair.activity.print();
            System.out.println("  PRICE PAID: " + activityPair.price);
        }
        System.out.println(" --------------------- ");
    }
}
