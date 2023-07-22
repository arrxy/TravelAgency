package org.example.exceptionHandler;

public class TravelAgencyServiceException extends Exception {
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public TravelAgencyServiceException(String message, Throwable cause) {
        super(message, cause);
        this.setTitle("TravelAgency Service Exception");
    }
    public TravelAgencyServiceException(String message) {
        super(message);
        this.setTitle("TravelAgency Service Exception");
    }

}
