package test.driven.development;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import test.driven.development.model.User;
import test.driven.development.repository.EmailNotificationServiceException;
import test.driven.development.repository.UsersRepository;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Class")
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UsersRepository usersRepository;

    @Mock
    EmailVerificationServiceImpl emailVerificationService;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;

    @BeforeEach
    void init(){


        firstName="Mailar";
        lastName="Nonvinkere";
        email="xya@gmail.com";
        password="12345678";
        repeatPassword="12345678";
    }

    @Test
    @DisplayName("User object created")
    void testCreateUser_whenUserDetailsProvided_returnsUserObject(){

        //Arrange

        Mockito.when(usersRepository.save(Mockito.any(User.class))).thenReturn(true);
        //Act

        User user=userService.createUser(firstName,lastName,email,password,repeatPassword);

        //Assert
        assertNotNull(user,"The createUser() should not return null");
        assertEquals(user.getFirstName(),firstName,"User's firstName is incorrect");
        assertEquals(user.getLastName(),lastName,"User's last name is not correct");
        assertEquals(user.getEmail(),email,"User's email id is not correct");
        assertNotNull(user.getId(),"User's id is missing");
        Mockito.verify(usersRepository,Mockito.times(1)).save(Mockito.any(User.class));
    }

    @Test
    @DisplayName("Empty first name causes correct exception")
    void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException(){

        //Arrange

       firstName="";

        String expectedExceptionMessage="User's first name is empty";

        //Act and Assert

        IllegalArgumentException exception=Assertions.assertThrows(IllegalArgumentException.class ,()->{
            userService.createUser(firstName,lastName,email,password,repeatPassword);
        },"Empty first name should have cause Illegal Argument Exception");

        //Assert
        assertEquals(expectedExceptionMessage,exception.getMessage(),"Exception error is not correct");
    }
    @DisplayName("If save method cause  Runtime exception then UserServiceException is thrown")
    @Test
    void testCreateUser_whenSaveMethodThrowsException_thenThrowUserServiceException(){
        //Arrange
        Mockito.when(usersRepository.save(Mockito.any(User.class))).thenThrow(RuntimeException.class);

        //Act
        assertThrows(UserServiceException.class,()->{
            userService.createUser(firstName,lastName,email,password,repeatPassword);
        },"Should have thrown UserServiceException instead");


        //Assert
    }

    @Test
    void testCreateUser_whenEmailNotificationExceptionThrown_thenThrowUserServiceException(){
        //Arrange
        Mockito.when(usersRepository.save(Mockito.any(User.class))).thenReturn(true);
       // Mockito.when(emailVerificationService.scheduleEmailConfirmation(Mockito.any(User.class))).thenThrow(RuntimeException);

        Mockito.doThrow(EmailNotificationServiceException.class)
                .when(emailVerificationService)
                .scheduleEmailConfirmation(Mockito.any(User.class));

//        Mockito.doNothing()
//                .when(emailVerificationService)
//                .scheduleEmailConfirmation(Mockito.any(User.class));


        assertThrows(UserServiceException.class, ()->{
            userService.createUser(firstName,lastName,email,password,repeatPassword);
        },"Should have thrown userService exception");

        Mockito.verify(emailVerificationService,Mockito.times(1))
                .scheduleEmailConfirmation(Mockito.any(User.class));

    }

    @Test
    void testCreateUser_whenUserCreated_scheduleEmailConfirmation(){
        //Arrange

        Mockito.when(usersRepository.save(Mockito.any(User.class))).thenReturn(true);

        Mockito.doCallRealMethod().when(emailVerificationService)
                .scheduleEmailConfirmation(Mockito.any(User.class));

        //Act
        userService.createUser(firstName,lastName   ,email,password,repeatPassword);

        //Assert
        Mockito.verify(emailVerificationService,Mockito.times(1))
                .scheduleEmailConfirmation(Mockito.any(User.class));
    }

}
