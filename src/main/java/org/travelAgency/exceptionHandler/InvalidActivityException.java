package org.travelAgency.exceptionHandler;

public class InvalidActivityException extends TravelAgencyServiceException {
    public InvalidActivityException(String message, Throwable cause) {
        super(message, cause);
        this.setTitle("Invalid Activity for the Package");
    }

    public InvalidActivityException(String message) {
        super(message);
        this.setTitle("Invalid Activity for the Package");
    }
}
