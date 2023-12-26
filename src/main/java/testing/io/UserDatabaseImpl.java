package testing.io;

import java.util.HashMap;
import java.util.Map;

public class UserDatabaseImpl implements UserDatabase{

    Map<String , Map> users;
    @Override
    public void init() {
        users= new HashMap<>();

    }

    @Override
    public void close() {
    users=null;
    }

    @Override
    public Map save(String userId, Map userDetails) {
        return users.put(userId, userDetails);
    }

    @Override
    public Map update(String userId, Map user) {
        return users.replace(userId,user);
    }

    @Override
    public Map find(String userId) {
        return users.get(userId);
    }

    @Override
    public void delete(String userId) {
    users.remove(userId);
    }
}
