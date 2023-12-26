package test.driven.development.repository;

public class EmailNotificationServiceException extends RuntimeException{
    public EmailNotificationServiceException() {
    }

    public EmailNotificationServiceException(String message) {
        super(message);
    }
}
