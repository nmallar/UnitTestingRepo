package test.driven.development;

public class UserServiceException  extends RuntimeException{
    public UserServiceException() {
    }

    public UserServiceException(String message) {
        super(message);
    }
}
