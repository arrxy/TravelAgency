package org.travelAgency.Passenger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.travelAgency.Activity.Activity;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

import static org.junit.jupiter.api.Assertions.*;

class PremiumPassengerTest {

    private PremiumPassenger premiumPassenger;
    @BeforeEach
    void setUp() {
        premiumPassenger = new PremiumPassenger("test", 25);
    }


    @Test
    void signUpForActivity() throws InsufficientBalanceException, PassengerOverflowException {
        try {
            premiumPassenger.signUpForActivity(new Activity("PremiumTestActivity0", "test Desc", 0, 0));
        } catch (Exception e) {
            String message = "Activity Full";
            assert (message.equals(e.getMessage()));
        }
    }

}