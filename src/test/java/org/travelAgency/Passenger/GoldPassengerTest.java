package org.travelAgency.Passenger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.travelAgency.Activity.Activity;
import org.travelAgency.exceptionHandler.InsufficientBalanceException;
import org.travelAgency.exceptionHandler.PassengerOverflowException;

import static org.junit.jupiter.api.Assertions.*;

class GoldPassengerTest {

    private GoldPassenger goldPassenger;
    @BeforeEach
    void setUp() {
        goldPassenger = new GoldPassenger("test", 25, 1000);
    }

    @AfterEach
    void tearDown() {
        goldPassenger = null;
    }

    @Test
    void signUpForActivity() throws InsufficientBalanceException, PassengerOverflowException {
//        goldPassenger.signUpForActivity(new Activity("GoldTestActivity0", "test Desc", 1000, 1));
//        assertEquals(100, goldPassenger.getBalance());
//        try {
//            goldPassenger.signUpForActivity(new Activity("GoldTestActivity1", "test Desc", 1000, 1));
//        } catch (Exception e) {
//            String message = "Insufficient balance for customer";
//            assert (message.equals(e.getMessage()));
//        }
//        try {
//            goldPassenger.signUpForActivity(new Activity("GoldTestActivity2", "test Desc", 0, 0));
//        } catch (Exception e) {
//            String message = "Activity Full";
//            assert (message.equals(e.getMessage()));
//        }
    }

    @Test
    void recharge() {
        double init = goldPassenger.getBalance();
        goldPassenger.recharge(1000);
        assertEquals(1000, goldPassenger.getBalance() - init);
    }
}