package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;
import org.travelAgency.TravelPackage.TravelPackage;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.InvalidActivityException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public abstract class PassengerSignUp {
    public void signUpForActivity(Activity a, TravelPackage p, Passenger passenger, int discountPercent) throws InvalidActivityException, PassengerOverflowException, InsufficientBalanceException {}
    public void signUpForActivity(Activity a, TravelPackage p, Passenger passenger) throws InvalidActivityException, PassengerOverflowException {}

}
