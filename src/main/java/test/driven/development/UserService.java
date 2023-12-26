package test.driven.development;

import test.driven.development.model.User;

public interface UserService {

    User createUser(String firstName, String lastName, String email, String password, String repeatPassword);


}
