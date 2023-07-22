package org.travelAgency.Passenger;

import org.travelAgency.Activity.Activity;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

public interface PassengerSignUp {
    void signUpForActivity(Activity activity) throws InsufficientBalanceException, PassengerOverflowException;
}
