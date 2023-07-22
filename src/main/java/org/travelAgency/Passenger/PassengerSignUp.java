package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;
import org.travelAgency.TravelPackage.TravelPackage;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.InvalidActivityException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public interface PassengerSignUp {
    void signUpForActivity(Activity activity, TravelPackage travelPackage) throws InsufficientBalanceException, PassengerOverflowException, InvalidActivityException;
}
