package test.driven.development.repository;

import test.driven.development.model.User;

import java.util.HashMap;
import java.util.Map;

public class UsersRepositoryImpl implements UsersRepository {

    Map<String , User> users=new HashMap<>();
    boolean returnValue=false;
    @Override
    public boolean save(User user) {

        if (users.containsKey(user.getId())){
            users.put(user.getId(),user);
            returnValue=true;
        }
        return returnValue;
    }
}
