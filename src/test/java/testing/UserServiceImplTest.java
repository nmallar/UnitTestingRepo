package testing;

import org.junit.jupiter.api.*;
import testing.io.UserDatabase;
import testing.io.UserDatabaseImpl;
import testing.service.UserService;
import testing.service.UserServiceImpl;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceImplTest {


    UserDatabase userDatabase;
    UserService userService;
    String createdUserId;
    @BeforeAll
    void setup(){
        //create and initialize database
        userDatabase=new UserDatabaseImpl();
        userDatabase.init();
        userService=new UserServiceImpl(userDatabase);
    }

    @AfterAll
    void cleanup(){
        //close db connection
        userDatabase.close();
    }

    @Test
    @Order(1)
    @DisplayName("Create User works")
    void testCreateUser_whenProvidedWithValidDetails_returnsUserId(){

        //Arrange
        Map<String, String > user=new HashMap<>();
        user.put("firstName","Mailar");
        user.put("lastName","Nonvinkere");

        //Act
         createdUserId=userService.createUser(user);
        //Assert
        assertNotNull(createdUserId,"User id should not be null");

    }

    @Test
    @Order(2)
    @DisplayName("Update User works")
    void testUpdateUser_whenProvidedWithValidUserId_returnsUserDetails(){
        //Arrange
        Map<String, String > newUser=new HashMap<>();
        newUser.put("firstName","Rani");
        newUser.put("lastName","Nonvinkere");

        //Act
        Map updatedUserDetails=userService.updateUser(createdUserId,newUser);
        //Assert
       assertEquals(updatedUserDetails.get("firstName"),newUser.get("firstName"),
               "Returned value of user's first name is incorrect ");
        assertEquals(updatedUserDetails.get("lastName"),newUser.get("lastName"),
                "Returned value of user's last name is incorrect ");

    }

    @Test
    @Order(3)
    @DisplayName("Find User works")
    void testFindUser_whenProvidedWithValidUserId_returnsUserDetails(){

        //Act

        Map userDetails=userService.getUserDetails(createdUserId);
        //Assert
        assertNotNull(userDetails,"User details should not be null");
        assertEquals(userDetails.get("userId"),createdUserId);

    }

    @Test
    @Order(4)
    @DisplayName("Delete User works")
    void testDeleteUser_whenProvidedWithValidId_returnsUserDetails(){

        //Act
        userService.deleteUser(createdUserId);

        //Assert
        assertNull(userService.getUserDetails(createdUserId),"User should not be found");

    }
}
