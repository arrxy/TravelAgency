package org.example.exceptionHandler;

public class InsufficientBalanceException extends TravelAgencyServiceException {

    public InsufficientBalanceException(String message, Throwable cause) {
        super(message, cause);
        this.setTitle("Insufficient balance for customer");
    }

    public InsufficientBalanceException(String message) {
        super(message);
        this.setTitle("Insufficient balance for customer");
    }
}
