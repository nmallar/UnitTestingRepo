package test.driven.development;

import test.driven.development.model.User;
import test.driven.development.repository.UsersRepository;
import test.driven.development.repository.UsersRepositoryImpl;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    UsersRepository usersRepository;
    EmailVerificationService emailVerificationService;

    public UserServiceImpl(UsersRepository usersRepository, EmailVerificationService emailVerificationService) {
        this.usersRepository = usersRepository;
        this.emailVerificationService = emailVerificationService;
    }



    @Override
    public User createUser(String firstName, String lastName, String email, String password, String repeatPassword) {
        String userId= UUID.randomUUID().toString();

        if (firstName==null || firstName.trim().isEmpty()) {

            throw new IllegalArgumentException("User's first name is empty");
        }

        User user=new User(firstName,lastName,email,userId);

        boolean isUserCreated= false;
        try {
            isUserCreated = usersRepository.save(user);
        } catch (RuntimeException e) {
            throw new UserServiceException(e.getMessage());
        }

        if (!isUserCreated) throw new UserServiceException("could not create user");

        try {
            emailVerificationService.scheduleEmailConfirmation(user);
        } catch (Exception e) {
            throw new UserServiceException(e.getMessage());
        }
        return user;
    }

    public void demo(){
        System.out.println("Demo method");
    }
}
