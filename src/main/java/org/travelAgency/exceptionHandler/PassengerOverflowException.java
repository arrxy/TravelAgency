package org.travelAgency.exceptionHandler;

public class PassengerOverflowException extends TravelAgencyServiceException {

    public PassengerOverflowException(String message, Throwable cause) {
        super(message, cause);
        super.setTitle("Travel Package Already Full");
    }
    public PassengerOverflowException(String message) {
        super(message);
        super.setTitle("Travel Package Already Full");
    }
}
