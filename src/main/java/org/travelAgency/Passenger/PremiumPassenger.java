package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;
import org.travelAgency.TravelPackage.TravelPackage;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.InvalidActivityException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public class PremiumPassenger extends Passenger {
    private PassengerSignUp passengerSignUp;
    public PremiumPassenger(String name, int passengerNumber) {

        super(name, passengerNumber);
        passengerSignUp = new PassengerSignUpWithoutBalance();
    }

    public void signUpForActivity(Activity a, TravelPackage p) throws InsufficientBalanceException, PassengerOverflowException, InvalidActivityException {
        passengerSignUp.signUpForActivity(a, p, this);

    }
    public void print() {
        System.out.println("---------------");
        System.out.println("PREMIUM PASSENGER");
        System.out.println("---------------");
        System.out.println("Passenger Name: " + this.name);
        System.out.println("Passenger Number: " + this.passengerNumber);
        System.out.println(" ------- ACTIVITIES ------- ");
        for (ActivityPair activityPair: this.activityList) {
            activityPair.activity.print();
            System.out.println("  PRICE PAID: " + activityPair.price);
        }
        System.out.println(" --------------------- ");
    }
}
