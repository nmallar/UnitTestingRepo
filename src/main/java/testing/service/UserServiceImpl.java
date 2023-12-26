package testing.service;

import testing.io.UserDatabase;

import java.util.Map;
import java.util.UUID;

public class UserServiceImpl implements UserService{

    UserDatabase userDatabase;
    public UserServiceImpl(UserDatabase userDatabase){
        this.userDatabase=userDatabase;
    }

    @Override
    public String createUser(Map userDetails) {
        String userId= UUID.randomUUID().toString();
        userDetails.put("userId",userId);
        userDatabase.save(userId,userDetails);
        return userId;
    }

    @Override
    public Map updateUser(String userId, Map userDetails) {
        Map existingUser=userDatabase.find(userId);
        if (existingUser==null) throw new IllegalArgumentException("User not found");

        existingUser.put("firstName",userDetails.get("firstName"));
        existingUser.put("lastName",userDetails.get("lastName"));
        return userDatabase.update(userId,existingUser);
    }

    @Override
    public Map getUserDetails(String userId) {
        return userDatabase.find(userId);
    }

    @Override
    public void deleteUser(String userId) {
        Map existingUser=userDatabase.find(userId);
        if (existingUser==null) throw new IllegalArgumentException("User not found");

        userDatabase.delete(userId);

    }
}
