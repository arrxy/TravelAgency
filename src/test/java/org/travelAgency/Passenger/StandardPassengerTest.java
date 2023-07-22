package org.travelAgency.Passenger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityManager;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

import static org.junit.jupiter.api.Assertions.*;

class StandardPassengerTest {
    private StandardPassenger standardPassenger;
    @BeforeEach
    void setUp() {
        standardPassenger = new StandardPassenger("test", 25, 1000);
    }

    @AfterEach
    void tearDown() {
        standardPassenger = null;
    }

    @Test
    void signUpForActivity() throws InsufficientBalanceException, PassengerOverflowException {
        standardPassenger.signUpForActivity(new Activity("StandardTestActivity0", "test Desc", 500, 1));
        assertEquals(500, standardPassenger.getBalance());
        try {
            standardPassenger.signUpForActivity(new Activity("StandardTestActivity1", "test Desc", 1000, 1));
        } catch (Exception e) {
            String message = "Insufficient balance for customer";
            assert (message.equals(e.getMessage()));
        }
        try {
            standardPassenger.signUpForActivity(new Activity("StandardTestActivity2", "test Desc", 0, 0));
        } catch (Exception e) {
            String message = "Activity Full";
            assert (message.equals(e.getMessage()));
        }
    }

    @Test
    void recharge() {
        double init = standardPassenger.getBalance();
        standardPassenger.recharge(1000);
        assertEquals(1000, standardPassenger.getBalance() - init);
    }
}