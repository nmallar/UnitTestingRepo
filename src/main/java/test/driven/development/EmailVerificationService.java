package test.driven.development;

import test.driven.development.model.User;

public interface EmailVerificationService {
    void scheduleEmailConfirmation(User user);


}
