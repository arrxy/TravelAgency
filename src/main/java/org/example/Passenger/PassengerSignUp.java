package org.example.Passenger;

import org.example.Activity.Activity;
import org.example.exceptionHandler.InsufficientBalanceException;
import org.example.exceptionHandler.PassengerOverflowException;

public interface PassengerSignUp {
    void signUpForActivity(Activity activity) throws InsufficientBalanceException, PassengerOverflowException;
}
