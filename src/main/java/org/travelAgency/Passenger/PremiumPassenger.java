package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityManager;
import org.travelAgency.Passenger.Passenger;
import org.travelAgency.Passenger.PassengerSignUp;
import org.travelAgency.TravelPackage.TravelPackage;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.InvalidActivityException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public class PremiumPassenger extends Passenger implements PassengerSignUp {
    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber);
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
        activity.signUp();
    }
    public void print() {
        System.out.println("---------------");
        System.out.println("PREMIUM PASSENGER");
        System.out.println("---------------");
        System.out.println("Passenger Name: " + this.name);
        System.out.println("Passenger Number: " + this.passengerNumber);
    }
}
